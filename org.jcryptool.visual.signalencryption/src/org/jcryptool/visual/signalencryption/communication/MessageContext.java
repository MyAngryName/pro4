package org.jcryptool.visual.signalencryption.communication;

import java.util.Map;
import java.util.Optional;

import org.jcryptool.visual.signalencryption.algorithm.JCrypToolCapturer;
import org.jcryptool.visual.signalencryption.algorithm.SessionManager;
import org.jcryptool.visual.signalencryption.ui.Messages;
import org.whispersystems.libsignal.SignalProtocolAddress;
import org.whispersystems.libsignal.SessionCipher;
import org.whispersystems.libsignal.SessionCipher.EncryptCallbackHandler;
import org.whispersystems.libsignal.ratchet.MessageKeys;

import static org.jcryptool.visual.signalencryption.communication.CommunicationEntity.ALICE;
import static org.jcryptool.visual.signalencryption.communication.CommunicationEntity.BOB;
import static org.jcryptool.visual.signalencryption.util.ToHex.toHex;

/**
 * Dataclass for Double-Ratchet and message information for one message
 * exchange.
 * 
 * Contains relevant key information and allows the storage of the raw input
 * message, the ciphertext (encrypted message) and the decrypted message.
 */
public class MessageContext {

	private static final int EC_PUBLIC_KEY_SIZE = 32;

	private final CommunicationEntity sendingEntity;
	private final EncryptCallbackHandler encryptHandler;

	private String message;
	private String decryptedMessage;
	private byte[] ciphertextMessage;
	
	private final JCrypToolCapturer sendingCapture;
	private final JCrypToolCapturer receivingCapture;

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
			JCrypToolCapturer sendingCapture,
			JCrypToolCapturer receivingCapture,
			EncryptCallbackHandler encryptHandler
	) {
		this.sendingEntity = sendingEntity;
		this.message = message;
		this.sendingCapture = sendingCapture;
		this.receivingCapture = receivingCapture;
		this.encryptHandler = encryptHandler;
	}

	public static MessageContext createWithKeysFromSessionStore(
			SessionManager sessionManager,
			SignalProtocolAddress aliceAddress,
			SignalProtocolAddress bobAddress,
			CommunicationEntity sendingEntity,
			JCrypToolCapturer sendingCapture
		) {
		return new MessageContext.Builder(sendingEntity)
				.sendingCapture(sendingCapture)
				.build();
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
	
	public EncryptCallbackHandler getEncryptHandler() {
		return encryptHandler;
	}
	
	public JCrypToolCapturer getReceivingCapture() {
		return receivingCapture;
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

	public Optional<String> getDecryptedMessage() {
		return Optional.of(decryptedMessage);
	}
	
	
	/////////////////////////
	// Diffie-Hellman Getters
	/////////////////////////
	public String diffieHellmanSenderPublicKey() {
		// For some reason Signal preprends a 05 for this key (33) bytes, so we ignore that here.
		return toHex(sendingCapture.publicDiffieHellmanRatchetKey.serialize(), 1, EC_PUBLIC_KEY_SIZE);
	}
	
	public String diffieHellmanSenderOutput() {
		return toHex(sendingCapture.diffieHellmanRatchetOutput);
	}

	public String diffieHellmanSenderPrivateKey() {
		return toHex(sendingCapture.privateDiffieHellmanRatchetKey.serialize());
	}
	public String diffieHellmanReceiverPublicKey() {
		// For some reason Signal preprends a 05 for this key (33) bytes, so we ignore that here.
		return toHex(receivingCapture.publicDiffieHellmanRatchetKey.serialize(), 1, EC_PUBLIC_KEY_SIZE);
	}
	
	public String diffieHellmanReceiverOutput() {
		return toHex(receivingCapture.diffieHellmanRatchetOutput);
	}

	public String diffieHellmanReceiverPrivateKey() {
		return toHex(receivingCapture.publicDiffieHellmanRatchetKey.serialize());
	}
	
	/////////////////////////
	// RootChain Getters
	/////////////////////////
	public String senderRootChainKey() {
		return toHex(sendingCapture.rootChainKey);
	}
	
	public String senderRootConstantInput() {
		return toHex(sendingCapture.rootChainConstantInput);
	}

	public Map<String, String> senderRootOutput() {
		return Map.of(
				"New Root-Key", toHex(sendingCapture.rootKdfOutput.getRootKey()),
				"Chain-Key", toHex(sendingCapture.rootKdfOutput.getChainKey())
		);
	}
	
	public String senderRootNewRootChainKey() {
		return toHex(sendingCapture.newRootChain);
	}
	
	public String receiverRootChainKey() {
		return toHex(receivingCapture.rootChainKey);
	}
	
	public String receiverRootConstantInput() {
		return toHex(receivingCapture.rootChainConstantInput);
	}

	public Map<String, String> receiverRootOutput() {
		return Map.of(
				"New Root-Key", toHex(receivingCapture.rootKdfOutput.getRootKey()),
				"Chain-Key", toHex(receivingCapture.rootKdfOutput.getChainKey())
		);
	}
	
	public String receiverRootNewRootChainKey() {
		return toHex(receivingCapture.newRootChain);
	}
	
	/////////////////////////
	// SendReceiveChain Getters
	/////////////////////////
	public String senderChainChainKey() {
		return toHex(sendingCapture.sendChain.chainKey);
	}
	public String senderChainConstantInput() {
		return toHex(sendingCapture.sendChain.chainConstantInput);
	}
	public String senderChainOutput() {
		return toHex(sendingCapture.sendChain.kdfOutput);
	}
	public Map<String, String> senderChainMessageKey() {
		return resolveMessageKey(sendingCapture.sendChain.messageKey);
	}
	public String senderChainNewChainKey() {
		return toHex(sendingCapture.sendChain.newChainKey);
	}
	public String receiverChainChainKey() {
		return toHex(receivingCapture.receiveChain.chainKey);
	}
	public String receiverChainConstantInput() {
		return toHex(receivingCapture.receiveChain.chainConstantInput);
	}
	
	public String receiverChainOutput() {
		return toHex(receivingCapture.receiveChain.kdfOutput);
	}

	public Map<String, String> receiverChainMessageKey() {
		return resolveMessageKey(receivingCapture.receiveChain.messageKey);
	}
	public String receiverChainNewChainKey() {
		return toHex(receivingCapture.receiveChain.newChainKey);
	}

	private Map<String, String> resolveMessageKey(MessageKeys key) {
		return Map.of(
				"AES-128", toHex(key.getCipherKey().getEncoded()),
				"Counter", Integer.toString(key.getCounter()),
				"IV", toHex(key.getIv().getIV()),
				"macKey", toHex(key.getMacKey().getEncoded())
		);

	}
	

	public String getMessage() {
		return message.toString();
	}

	public static class Builder {
		private CommunicationEntity sendingEntity = ALICE;
		private String message = Messages.SignalEncryption_aliceDefaultMessage;
		private SessionCipher aliceCipher;
		private SessionCipher bobCipher;
		private JCrypToolCapturer sendingCapture;
		private JCrypToolCapturer receivingCapture = new JCrypToolCapturer();
		private EncryptCallbackHandler encryptHandler;

		private static final String DEFAULT_MESSAGE_ALICE = Messages.SignalEncryption_aliceDefaultMessage;
		private static final String DEFAULT_MESSAGE_BOB = Messages.SignalEncryption_bobDefaultMessage;

		public Builder(CommunicationEntity sendingEntity) {
			this.sendingEntity = sendingEntity;
			this.message = sendingEntity == ALICE ? DEFAULT_MESSAGE_ALICE : DEFAULT_MESSAGE_BOB;
		}
		
		public Builder sendingCapture(JCrypToolCapturer sendingCapture) {
			this.sendingCapture = sendingCapture;
			return this;
		}
		
		public Builder receivingCapture(JCrypToolCapturer receivingCapture) {
			this.receivingCapture = receivingCapture;
			return this;
		}
		
		public Builder aliceSessionCipher(SessionCipher aliceSessionCipher) {
			this.aliceCipher = aliceSessionCipher;
			return this;
		}
		
		public Builder bobSessionCipher(SessionCipher bobSessionCipher) {
			this.bobCipher = bobSessionCipher;
			return this;
		}
		
		// public Builder encryptHandler(EncryptCallbackHandler encryptHandler) {
		// 	this.encryptHandler = encryptHandler;
		// 	return this;
		// }

		public MessageContext build() {
			// Don't call build() without setting these values
			assert sendingCapture != null && aliceCipher != null && bobCipher != null;
			
			EncryptCallbackHandler encryptHandler;
			if (sendingEntity == ALICE) {
				encryptHandler = aliceCipher.encrypt(sendingCapture);
			} else {
				encryptHandler = bobCipher.encrypt(sendingCapture);
			}
			
			return new MessageContext(sendingEntity, message, sendingCapture, receivingCapture, encryptHandler);
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