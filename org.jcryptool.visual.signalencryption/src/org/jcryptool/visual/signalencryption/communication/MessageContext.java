package org.jcryptool.visual.signalencryption.communication;

import java.util.Optional;

import org.jcryptool.visual.signalencryption.algorithm.SessionManager;
import org.jcryptool.visual.signalencryption.ui.Messages;
import org.whispersystems.libsignal.SignalProtocolAddress;
import org.whispersystems.libsignal.ecc.ECPrivateKey;
import org.whispersystems.libsignal.ecc.ECPublicKey;
import org.whispersystems.libsignal.protocol.SignalMessage;
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

	private final CommunicationEntity sendingEntity;
	private String message;
	private SignalMessage rawMessage;
	private String decryptedMessage;
	private byte[] ciphertextMessage;

	private final String aliceRatchetPublicKey;
	private final String aliceRatchetPrivateKey;

	private final String bobRatchetPublicKey;
	private final String bobRatchetPrivateKey;

	private final String aliceRootKey;
	private final String bobRootKey;

	private final String sendingChainKey;
	private final String senderMsgKey;

	private String receivingChainKey;
	private String receiverMsgKey;

	/**
	 * Dataclass for Double-Ratchet and message information for one message
	 * exchange.
	 * 
	 * @param isAliceSending         Whether Alice is sending (true) or Bob is
	 *                               sending (false).
	 * @param message                A plain String message, can be changed as long
	 *                               as the encrypted value is not set.
	 * @param aliceRatchetPrivateKey Key as hex string.
	 * @param aliceRatchetPublicKey  Key as hex string.
	 * @param aliceRootKey           Key as hex string.
	 * @param aliceSendingChainKey   Key as hex string.
	 * @param aliceSenderMsgKey      Key as hex string.
	 * @param bobRatchetPrivateKey   Key as hex string.
	 * @param bobRatchetPublicKey    Key as hex string.
	 * @param bobRootKey             Key as hex string.
	 * @param bobSendingChainKey     Key as hex string.
	 * @param bobSenderMsgKey        Key as hex string.
	 */
	private MessageContext(CommunicationEntity sendingEntity, String message, String aliceRatchetPrivateKey,
			String aliceRatchetPublicKey, String aliceRootKey, String bobRatchetPrivateKey, String bobRatchetPublicKey,
			String bobRootKey, String sendingChainKey, String senderMsgKey) {
		this.sendingEntity = sendingEntity;
		this.message = message;

		this.aliceRatchetPrivateKey = aliceRatchetPrivateKey;
		this.aliceRatchetPublicKey = aliceRatchetPublicKey;
		this.aliceRootKey = aliceRootKey;

		this.bobRatchetPrivateKey = bobRatchetPrivateKey;
		this.bobRatchetPublicKey = bobRatchetPublicKey;
		this.bobRootKey = bobRootKey;

		this.sendingChainKey = sendingChainKey;
		this.senderMsgKey = senderMsgKey;
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
		MessageKeys sendingMsgKeys = sendingChainKey.getMessageKeys();

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
		this.receivingChainKey = toHexString(receivingChainKey.getNextChainKey().getKey());
		this.receiverMsgKey = toHexString(receiverMsgKeys.getCipherKey().getEncoded());
	}

	public void setReceivingKeys(String receivingChainKey, String receiverMsgKeys) {
		this.receivingChainKey = receivingChainKey;
		this.receiverMsgKey = receiverMsgKeys;
	}

	public Optional<String> getDecryptedMessage() {
		return Optional.of(decryptedMessage);
	}

	public String getAliceRatchetPrivateKey() {
		return aliceRatchetPrivateKey;
	}

	public String getAliceRatchetPublicKey() {
		return aliceRatchetPublicKey;
	}

	public String getaliceRootKey() {
		return aliceRootKey;
	}

	public String getSendingChainKey() {
		return sendingChainKey;
	}

	public String getSenderMsgKey() {
		return senderMsgKey;
	}

	public String getBobRatchetPrivateKey() {
		return bobRatchetPrivateKey;
	}

	public String getBobRatchetPublicKey() {
		return bobRatchetPublicKey;
	}

	public String getBobRootKey() {
		return bobRootKey;
	}

	public Optional<String> getReceivingChainKey() {
		return Optional.of(receivingChainKey);
	}

	public Optional<String> getReceiverMsgKey() {
		return Optional.of(receiverMsgKey);
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
			return new MessageContext(sendingEntity, message, aliceRatchetPrivateKey, aliceRatchetPublicKey,
					aliceRootKey, bobRatchetPrivateKey, bobRatchetPublicKey, bobRootKey, sendingChainKey, senderMsgKey);
		}

	}

}
