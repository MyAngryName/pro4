package org.jcryptool.visual.signalencryption.communication;

import java.util.Optional;

import org.jcryptool.visual.signalencryption.algorithm.JCrypToolCapturer;
import org.jcryptool.visual.signalencryption.algorithm.SessionManager;
import org.jcryptool.visual.signalencryption.ui.Messages;
import org.whispersystems.libsignal.SignalProtocolAddress;
import org.whispersystems.libsignal.ecc.ECPrivateKey;
import org.whispersystems.libsignal.ecc.ECPublicKey;
import org.whispersystems.libsignal.ratchet.ChainKey;
import org.whispersystems.libsignal.ratchet.MessageKeys;
import org.whispersystems.libsignal.ratchet.RootKey;

import static org.jcryptool.visual.signalencryption.communication.CommunicationEntity.ALICE;
import static org.jcryptool.visual.signalencryption.communication.CommunicationEntity.BOB;
import static org.jcryptool.visual.signalencryption.util.ToHex.toHexString;

/**
 * Dataclass for Double-Ratchet and message information for one message
 * exchange.
 * 
 * Contains relevant key information and allows the storage of the raw input
 * message, the ciphertext (encrypted message) and the decrypted message.
 */
public class MessageContext {

	private static final String MESSAGE_NO_SESSION = "Keine Sitzung begonnen";
	private static final String UNKNOWN = "Unknown";

	private final CommunicationEntity sendingEntity;
	private String message;
	private String decryptedMessage;
	private byte[] ciphertextMessage;

	private final DiffieHellmanRatchetKeys aliceDiffieHellmanKeys;
	private final RootChainKeys aliceRootChain;
	private final SendReceiveChainKeys aliceSendReceiveChain;
	
	private final DiffieHellmanRatchetKeys bobDiffieHellmanKeys;
	private final RootChainKeys bobRootChain;
	private final SendReceiveChainKeys bobSendReceiveChain;

	/**
	 * Dataclass for Double-Ratchet value, key and message information for one message exchange.
	 * 
	 * @param isAliceSending         Whether Alice is sending (true) or Bob is
	 *                               sending (false).
	 * @param message                A plain String message, can be changed as long
	 *                               as the encrypted value is not set.
	 * @param aliceDiffieHellmanKeys Alice' keys/information in the DH ratchet step
	 * @param bob DiffieHellmanKeys  Bob's keys/information in the DH ratchet step
	 * @param aliceRootChain         Alice' keys/information in the root chain
	 * @param bobRootChain           Bob's keys/information in the root chain
	 * @param aliceSendReceiveChain Alice' keys/information in the send or receive chain (does not matter which)
	 * @param bobSendReceiveChain   Bob's keys/information in the send or receive chain (does not matter which)
	 * @param
	 */
	private MessageContext(
			CommunicationEntity sendingEntity,
			String message,
			DiffieHellmanRatchetKeys aliceDiffieHellmanKeys,
			DiffieHellmanRatchetKeys bobDiffieHellmanKeys,
			RootChainKeys aliceRootChain,
			RootChainKeys bobRootChain,
			SendReceiveChainKeys aliceSendReceiveChain,
			SendReceiveChainKeys bobSendReceiveChain
	) {
		this.sendingEntity = sendingEntity;
		this.message = message;
		this.aliceDiffieHellmanKeys = aliceDiffieHellmanKeys;
		this.bobDiffieHellmanKeys = bobDiffieHellmanKeys;
		this.aliceRootChain = aliceRootChain;
		this.bobRootChain = bobRootChain;
		this.aliceSendReceiveChain = aliceSendReceiveChain;
		this.bobSendReceiveChain = bobSendReceiveChain;
	}

	public static MessageContext createWithKeysFromSessionStore(SessionManager sessionManager,
			SignalProtocolAddress aliceAddress, SignalProtocolAddress bobAddress, CommunicationEntity sendingEntity) {
		var aliceSessionRecord = sessionManager.getAliceSessionStore().loadSession(bobAddress);
		var aliceSessionState = aliceSessionRecord.getSessionState();
		var aliceRootKey = aliceSessionState.getRootKey();
		var aliceRatchetPublicKey = aliceSessionState.getSenderRatchetKey();
		var aliceRatchetPrivateKey = aliceSessionState.getSenderRatchetKeyPair().getPrivateKey();

		var bobSessionRecord = sessionManager.getBobSessionStore().loadSession(aliceAddress);
		var bobSessionState = bobSessionRecord.getSessionState();
		var bobRootKey = bobSessionState.getRootKey();
		var bobRatchetPublicKey = bobSessionState.getSenderRatchetKey();
		var bobRatchetPrivateKey = bobSessionState.getSenderRatchetKeyPair().getPrivateKey();

		ChainKey sendingChainKey;

		if (sendingEntity == ALICE) {
			sendingChainKey = aliceSessionState.getSenderChainKey();
		} else {
			sendingChainKey = bobSessionState.getSenderChainKey();
		}
		var capturer = new JCrypToolCapturer();
		MessageKeys sendingMsgKeys = sendingChainKey.getMessageKeys(capturer, capturer.sendChain);

		return new MessageContext.Builder(sendingEntity).aliceRatchetPublicKey(aliceRatchetPublicKey)
				.aliceRatchetPrivateKey(aliceRatchetPrivateKey).aliceRootKey(aliceRootKey)
				.bobRatchetPublicKey(bobRatchetPublicKey).bobRatchetPrivateKey(bobRatchetPrivateKey)
				.bobRootKey(bobRootKey).sendingChainKey(sendingChainKey).senderMsgKey(sendingMsgKeys).build();

	}

	public boolean isAlreadyEncrypted() {
		return getCiphertextMessage().isPresent();
	}

	public boolean isAliceSending() {
		return sendingEntity == ALICE;
	}

	public boolean isBobSending() {
		return sendingEntity == BOB;
	}

	/**
	 * Update the object with a new message.
	 * 
	 * @param message the string to set.
	 * 
	 * @throws IllegalStateException if the message for this object is already
	 *                               encrypted.
	 * @see #isAlreadyEncrypted()
	 */
	public void setMessage(String message) {
		if (isAlreadyEncrypted()) {
			throw new IllegalStateException("setMessage() cannot be called after already having encrypted it.");
		}
		this.message = message;

	}

	public Optional<byte[]> getCiphertextMessage() {
		if (ciphertextMessage == null) {
			return Optional.empty();
		} else {
			return Optional.of(ciphertextMessage);
		}
	}

	/**
	 * Set the encrypted message and its decrypted counterpart in one go.
	 * 
	 * Make sure to actually encrypt/decrypt and not just pass the undecrypted
	 * message again, since that would be cheating.
	 * 
	 * Since the encryption can't be rolled back, a change to the message afterwards
	 * brings it in an inconsistent state. That's why
	 * {@link #setEncryptedMessageAndSeal(byte[], String)} will throw an exception
	 * if it is called more than once.
	 * 
	 * @param encryptedMessage
	 * @param decryptedMessage
	 * 
	 * @throws An {@link IllegalStateException} if already encrypted.
	 * @see #isAlreadyEncrypted()
	 */
	public void setEncryptedMessageAndSeal(byte[] encryptedMessage, String decryptedMessage) {
		if (isAlreadyEncrypted()) {
			throw new IllegalStateException("This message is already encrypted");
		}
		this.ciphertextMessage = encryptedMessage;
		this.decryptedMessage = decryptedMessage;
	}

	public void setReceivingKeys(ChainKey receivingChainKey, MessageKeys receiverMsgKeys) {
		 setReceivingKeys(
				 toHexString(receivingChainKey.getNextChainKey().getKey()),
				 toHexString(receiverMsgKeys.getCipherKey().getEncoded())
		);
	}

	public void setReceivingKeys(String receivingChainKey, String receiverMsgKeys) {
		if (sendingEntity == ALICE) {
		 bobSendReceiveChain.chainKey = receivingChainKey;
		 bobSendReceiveChain.output = receiverMsgKeys;
		} else {
		 aliceSendReceiveChain.chainKey = receivingChainKey;
		 aliceSendReceiveChain.output = receiverMsgKeys;
		}
	}

	public Optional<String> getDecryptedMessage() {
		return Optional.of(decryptedMessage);
	}
	
	
	/////////////////////////
	// Diffie-Hellman Getters
	/////////////////////////
	public String diffieHellmanSenderPublicKey() {
		return sendingEntity == ALICE ? aliceDiffieHellmanKeys.theirPublicKey : bobDiffieHellmanKeys.theirPublicKey;
	}
	
	public String diffieHellmanSenderAgreedKey() {
		return sendingEntity == ALICE ? aliceDiffieHellmanKeys.agreedKey: bobDiffieHellmanKeys.agreedKey;
	}

	public String diffieHellmanSenderPrivateKey() {
		return sendingEntity == ALICE ? aliceDiffieHellmanKeys.agreedKey: bobDiffieHellmanKeys.agreedKey;
	}
	public String diffieHellmanReceiverPublicKey() {
		return sendingEntity == BOB ? aliceDiffieHellmanKeys.theirPublicKey : bobDiffieHellmanKeys.theirPublicKey;
	}
	
	public String diffieHellmanReceiverAgreedKey() {
		return sendingEntity == BOB ? aliceDiffieHellmanKeys.agreedKey: bobDiffieHellmanKeys.agreedKey;
	}

	public String diffieHellmanReceiverPrivateKey() {
		return sendingEntity == BOB ? aliceDiffieHellmanKeys.agreedKey: bobDiffieHellmanKeys.agreedKey;
	}
	
	/////////////////////////
	// RootChain Getters
	/////////////////////////
	public String senderRootChainKey() {
		return sendingEntity == ALICE ? aliceRootChain.rootKey: bobRootChain.rootKey;
	}
	
	public String senderRootInput() {
		return sendingEntity == ALICE ? aliceRootChain.input: bobRootChain.input;
	}

	public String senderRootOutput() {
		return sendingEntity == ALICE ? aliceRootChain.output: bobRootChain.output;
	}
	
	public String senderRootNewRootChainKey() {
		return sendingEntity == ALICE ? aliceRootChain.newRootKey: bobRootChain.newRootKey;
	}
	
	public String receiverRootChainKey() {
		return sendingEntity == BOB ? aliceRootChain.rootKey: bobRootChain.rootKey;
	}
	
	public String receiverRootInput() {
		return sendingEntity == BOB ? aliceRootChain.input: bobRootChain.input;
	}

	public String receiverRootOutput() {
		return sendingEntity == BOB ? aliceRootChain.output: bobRootChain.output;
	}
	public String receiverRootNewRootChainKey() {
		return sendingEntity == BOB ? aliceRootChain.newRootKey: bobRootChain.newRootKey;
	}
	
	/////////////////////////
	// SendReceiveChain Getters
	/////////////////////////
	public String senderChainChainKey() {
		return sendingEntity == ALICE ? aliceSendReceiveChain.chainKey : bobSendReceiveChain.chainKey;
	}
	public String senderChainInput() {
		return sendingEntity == ALICE ? aliceSendReceiveChain.input : bobSendReceiveChain.input;
	}
	public String senderChainMessageKey() {
		return sendingEntity == ALICE ? aliceSendReceiveChain.output: bobSendReceiveChain.output;
	}
	public String senderChainNewChainKey() {
		return sendingEntity == ALICE ? aliceSendReceiveChain.newChainKey: bobSendReceiveChain.newChainKey;
	}
	public String receiverChainChainKey() {
		return sendingEntity == BOB ? aliceSendReceiveChain.chainKey : bobSendReceiveChain.chainKey;
	}
	public String receiverChainInput() {
		return sendingEntity == BOB ? aliceSendReceiveChain.input : bobSendReceiveChain.input;
	}
	public String receiverChainMessageKey() {
		return sendingEntity == BOB ? aliceSendReceiveChain.output: bobSendReceiveChain.output;
	}
	public String receiverChainNewChainKey() {
		return sendingEntity == BOB ? aliceSendReceiveChain.newChainKey: bobSendReceiveChain.newChainKey;
	}

	

	public String getMessage() {
		return message.toString();
	}

	public static class Builder {
		private CommunicationEntity sendingEntity = ALICE;
		private String message = Messages.SignalEncryption_aliceDefaultMessage;
		private String aliceRatchetPrivateKey = MESSAGE_NO_SESSION;
		private String aliceRatchetPublicKey = MESSAGE_NO_SESSION;
		private String aliceRootKey = MESSAGE_NO_SESSION;
		private String bobRatchetPrivateKey = MESSAGE_NO_SESSION;
		private String bobRatchetPublicKey = MESSAGE_NO_SESSION;
		private String bobRootKey = MESSAGE_NO_SESSION;
		private String sendingChainKey = MESSAGE_NO_SESSION;
		private String senderMsgKey = MESSAGE_NO_SESSION;

		private static final String DEFAULT_MESSAGE_ALICE = Messages.SignalEncryption_aliceDefaultMessage;
		private static final String DEFAULT_MESSAGE_BOB = Messages.SignalEncryption_bobDefaultMessage;

		public Builder(CommunicationEntity sendingEntity) {
			this.sendingEntity = sendingEntity;
			this.message = sendingEntity == ALICE ? DEFAULT_MESSAGE_ALICE : DEFAULT_MESSAGE_BOB;
		}

		public Builder aliceRatchetPrivateKey(ECPrivateKey key) {
			this.aliceRatchetPrivateKey = toHexString(key.serialize());
			return this;
		}

		public Builder aliceRatchetPublicKey(ECPublicKey key) {
			this.aliceRatchetPrivateKey = toHexString(key.serialize());
			return this;
		}

		public Builder aliceRootKey(RootKey key) {
			this.aliceRootKey = toHexString(key.getKeyBytes());
			return this;
		}

		public Builder bobRatchetPrivateKey(ECPrivateKey key) {
			this.bobRatchetPrivateKey = toHexString(key.serialize());
			return this;
		}

		public Builder bobRatchetPublicKey(ECPublicKey key) {
			this.bobRatchetPublicKey = toHexString(key.serialize());
			return this;
		}

		public Builder bobRootKey(RootKey key) {
			this.bobRootKey = toHexString(key.getKeyBytes());
			return this;
		}

		public Builder sendingChainKey(ChainKey key) {
			this.sendingChainKey = toHexString(key.getNextChainKey().getKey());
			return this;
		}

		public Builder senderMsgKey(MessageKeys key) {
			this.senderMsgKey = toHexString(key.getCipherKey().getEncoded());
			return this;
		}

		public MessageContext build() {
			return new MessageContext(
					sendingEntity,
					message,
					new DiffieHellmanRatchetKeys(aliceRatchetPublicKey, UNKNOWN, aliceRatchetPrivateKey),
					new DiffieHellmanRatchetKeys(bobRatchetPublicKey, UNKNOWN, bobRatchetPrivateKey),
					new RootChainKeys(aliceRootKey, UNKNOWN, UNKNOWN, UNKNOWN),
					new RootChainKeys(bobRootKey, UNKNOWN, UNKNOWN, UNKNOWN),
					new SendReceiveChainKeys(sendingChainKey, UNKNOWN, senderMsgKey, UNKNOWN),
					new SendReceiveChainKeys(UNKNOWN, UNKNOWN, UNKNOWN, UNKNOWN)
			);
		}

	}
	
	public static class DiffieHellmanRatchetKeys {
		final String theirPublicKey;
		final String agreedKey;
		final String ourPrivateKey;
		
		public DiffieHellmanRatchetKeys(String theirPublicKey, String agreedKey, String ourPrivateKey) {
			this.theirPublicKey = theirPublicKey;
			this.agreedKey = agreedKey;
			this.ourPrivateKey = ourPrivateKey;
		}
	}
	
	public static class RootChainKeys{
		final String rootKey;
		final String input;
		final String output;
		final String newRootKey;
		
		public RootChainKeys(String rootKey, String input, String output, String newRootKey) {
			this.rootKey = rootKey;
			this.input = input;
			this.output = output;
			this.newRootKey = newRootKey;
		}
	}
	
	public static class SendReceiveChainKeys{
		String chainKey;
		String input;
		String output;
		String newChainKey;
		
		public SendReceiveChainKeys(String chainKey, String input, String output, String newChainKey) {
			this.chainKey = chainKey;
			this.input = input;
			this.output = output;
			this.newChainKey = newChainKey;
		}
	}

}
