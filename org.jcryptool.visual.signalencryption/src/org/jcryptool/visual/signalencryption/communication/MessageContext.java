package org.jcryptool.visual.signalencryption.communication;

import java.util.Optional;

import org.jcryptool.visual.signalencryption.ui.Messages;
import org.whispersystems.libsignal.protocol.CiphertextMessage;

/**
 * Dataclass for Double-Ratchet and message information for one message
 * exchange.
 * 
 * Contains relevant key information and allows the storage of the raw input
 * message, the ciphertext (encrypted message) and the decrypted message.
 */
public class MessageContext {

    private static final String MESSAGE_NO_SESSION = "Keine Sitzung begonnen";

    private boolean isAliceSending;
    private String message;
    private String decryptedMessage;
    private byte[] ciphertextMessage;

    private String aliceRatchetPublicKey;
    private String aliceRatchetPrivateKey;

    private String bobRatchetPublicKey;
    private String bobRatchetPrivateKey;

    private String aliceRootKey;
    private String bobRootKey;

    private String aliceSendingChainKey;
    private String bobSendingChainKey;

    private String aliceReceivingChainKey;
    private String bobReceivingChainKey;

    private String aliceSenderMsgKey;
    private String bobSenderMsgKey;

    /**
     * Dataclass for Double-Ratchet and message information for one message
     * exchange.
     * 
     * @param isAliceSending         Whether Alice is sending (true) or Bob is
     *                               sending (false).
     * @param message                A plain String message, can be changed as long
     *                               as the encrypted value is not set.
     * @param aliceRatchetPrivateKey Key as hex string.
     * @param aliceRatchedPublicKey  Key as hex string.
     * @param aliceRootKey           Key as hex string.
     * @param aliceSendingChainKey   Key as hex string.
     * @param aliceReceivingChainKey Key as hex string.
     * @param aliceSenderMsgKey      Key as hex string.
     * @param bobRatchetPrivateKey   Key as hex string.
     * @param bobRatchetPublicKey    Key as hex string.
     * @param bobRootKey             Key as hex string.
     * @param bobSendingChainKey     Key as hex string.
     * @param bobReceivingChainKey   Key as hex string.
     * @param bobSenderMsgKey        Key as hex string.
     */
    private MessageContext(boolean isAliceSending, String message, String aliceRatchetPrivateKey,
            String aliceRatchedPublicKey, String aliceRootKey, String aliceSendingChainKey,
            String aliceReceivingChainKey, String aliceSenderMsgKey, String bobRatchetPrivateKey,
            String bobRatchetPublicKey, String bobRootKey, String bobSendingChainKey,
            String bobReceivingChainKey, String bobSenderMsgKey

    ) {
        this.isAliceSending = isAliceSending;
        this.message = message;

        this.aliceRatchetPrivateKey = aliceRatchetPrivateKey;
        this.aliceRatchetPublicKey = aliceRatchedPublicKey;
        this.aliceRootKey = aliceRootKey;
        this.aliceSendingChainKey = aliceSendingChainKey;
        this.aliceReceivingChainKey = aliceReceivingChainKey;
        this.aliceSenderMsgKey = aliceSenderMsgKey;

        this.bobRatchetPrivateKey = bobRatchetPrivateKey;
        this.bobRatchetPublicKey = bobRatchetPublicKey;
        this.bobSendingChainKey = bobSendingChainKey;
        this.bobReceivingChainKey = bobReceivingChainKey;
        this.bobRootKey = bobRootKey;
        this.bobSenderMsgKey = bobSenderMsgKey;
    }

    public boolean isAlreadyEncrypted() {
        return getCiphertextMessage().isPresent();
    }

    public boolean isAliceSending() {
        return isAliceSending;
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
            throw new IllegalStateException(
                    "setMessage() cannot be called after already having encrypted it.");
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

    public String getAliceRatchetPrivateKey() {
        return aliceRatchetPrivateKey;
    }

    public String getAliceRatchetPublicKey() {
        return aliceRatchetPublicKey;
    }

    public String getaliceRootKey() {
        return aliceRootKey;
    }

    public String getAliceSendingChainKey() {
        return aliceSendingChainKey;
    }

    public String getAliceSenderMsgKey() {
        return aliceSenderMsgKey;
    }

    public String getAliceReceivingChainKey() {
        return aliceReceivingChainKey;
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

    public String getBobSendingChainKey() {
        return bobSendingChainKey;
    }

    public String getBobReceivingChainKey() {
        return bobReceivingChainKey;
    }

    public String getBobSenderMsgKey() {
        return bobSenderMsgKey;
    }

    public String getMessage() {
        return message.toString();
    }

    public static class Builder {
        private boolean sendingFlagAlreadyFlipped;
        private boolean isAliceSending = true;
        private String message = Messages.SignalEncryption_aliceDefaultMessage;
        private String aliceRatchetPrivateKey = MESSAGE_NO_SESSION;
        private String aliceRatchedPublicKey = MESSAGE_NO_SESSION;
        private String aliceRootKey = MESSAGE_NO_SESSION;
        private String aliceSendingChainKey = MESSAGE_NO_SESSION;
        private String aliceReceivingChainKey = MESSAGE_NO_SESSION;
        private String aliceSenderMsgKey = MESSAGE_NO_SESSION;
        private String bobRatchetPrivateKey = MESSAGE_NO_SESSION;
        private String bobRatchedPublicKey = MESSAGE_NO_SESSION;
        private String bobRootKey = MESSAGE_NO_SESSION;
        private String bobSendingChainKey = MESSAGE_NO_SESSION;
        private String bobReceivingChainKey = MESSAGE_NO_SESSION;
        private String bobSenderMsgKey = MESSAGE_NO_SESSION;

        private static final String DEFAULT_MESSAGE_ALICE = Messages.SignalEncryption_aliceDefaultMessage;
        private static final String DEFAULT_MESSAGE_BOB = Messages.SignalEncryption_bobDefaultMessage;

        public Builder() {

        }

        public Builder aliceIsSending() {
            if (sendingFlagAlreadyFlipped) {
                throw new IllegalArgumentException(
                        "Both aliceIsSending and bobIsSending has been called in the builder.");
            }
            sendingFlagAlreadyFlipped = true;
            isAliceSending = true;
            message = DEFAULT_MESSAGE_ALICE;
            return this;
        }

        public Builder bobIsSending() {
            if (sendingFlagAlreadyFlipped) {
                throw new IllegalArgumentException(
                        "Both aliceIsSending and bobIsSending has been called in the builder.");
            }
            sendingFlagAlreadyFlipped = true;
            isAliceSending = false;
            message = DEFAULT_MESSAGE_BOB;
            return this;
        }

        public Builder aliceRatchetPrivateKey(String key) {
            this.aliceRatchetPrivateKey = key;
            return this;
        }

        public Builder aliceRatchetPublicKey(String key) {
            this.aliceRatchetPrivateKey = key;
            return this;
        }

        public Builder aliceRootKey(String key) {
            this.aliceRootKey = key;
            return this;
        }

        public Builder aliceSendingChainKey(String key) {
            this.aliceSendingChainKey = key;
            return this;
        }

        public Builder aliceReceivingChainKey(String key) {
            this.aliceReceivingChainKey = key;
            return this;
        }

        public Builder aliceSenderMsgKey(String key) {
            this.aliceSenderMsgKey = key;
            return this;
        }

        public Builder bobRatchetPrivateKey(String key) {
            this.bobRatchetPrivateKey = key;
            return this;
        }

        public Builder bobRatchetPublicKey(String key) {
            this.bobRatchetPrivateKey = key;
            return this;
        }

        public Builder bobRootKey(String key) {
            this.bobRootKey = key;
            return this;
        }

        public Builder bobSendingChainKey(String key) {
            this.bobSendingChainKey = key;
            return this;
        }

        public Builder bobReceivingChainKey(String key) {
            this.bobReceivingChainKey = key;
            return this;
        }

        public Builder bobSenderMsgKey(String key) {
            this.bobSenderMsgKey = key;
            return this;
        }

        public MessageContext build() {
            return new MessageContext(isAliceSending, message, aliceRatchetPrivateKey,
                    aliceRatchedPublicKey, aliceRootKey, aliceSendingChainKey,
                    aliceReceivingChainKey, aliceSenderMsgKey, bobRatchetPrivateKey,
                    bobRatchedPublicKey, bobRootKey, bobSendingChainKey, bobReceivingChainKey,
                    bobSenderMsgKey);
        }

    }

}
