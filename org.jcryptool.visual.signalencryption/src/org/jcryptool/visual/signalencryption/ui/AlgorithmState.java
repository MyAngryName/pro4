package org.jcryptool.visual.signalencryption.ui;

import org.jcryptool.visual.signalencryption.util.ToHex;

import java.util.Optional;

import org.jcryptool.core.logging.utils.LogUtil;
import org.jcryptool.visual.signalencryption.communication.MessageContext;
import org.jcryptool.visual.signalencryption.communication.SignalCommunication;

public class AlgorithmState {

	private static AlgorithmState instance;
	private STATE currentState = STATE.INITIALIZING;

	private EncryptionAlgorithm signalEncryptionAlgorithm;
	private SignalCommunication communication;

	private AlgorithmState() {
		communication = new SignalCommunication();
	}

	public static AlgorithmState get() {
		if (instance == null) {
			instance = new AlgorithmState();
		}
		return instance;
	}

	public static void destroy() {
		instance = null;
	}

	public enum STATE {
		INITIALIZING, PRE_KEY_SIGNAL_MESSAGE, BOB_SEND_MSG, ALICE_SEND_MSG;
	}

	public void generateBothPartiesKeys() {
		generateAliceKeys();
		generateBobKeys();
	}

	public void generateAliceKeys() {
		if (currentState == STATE.INITIALIZING) {
			signalEncryptionAlgorithm.generateAlice(currentState);
			// TODO Set keys in UI
		}
	}

	public void generateBobKeys() {
		if (currentState == STATE.INITIALIZING) {
			signalEncryptionAlgorithm.generateBob(currentState);
			// TODO Set keys in UI
		}
	}

	public EncryptionAlgorithm getSignalEncryptionAlgorithm() {
		return signalEncryptionAlgorithm;
	}

	public String getAliceRatchetPrivateKey() {
		return current().getAliceRatchetPrivateKey();
	}

	public String getAliceRatchetPublicKey() {
		return current().getAliceRatchetPublicKey();
	}

	public String getaliceRootKey() {
		return current().getaliceRootKey();
	}

	public String getBobRatchetPrivateKey() {
		return current().getBobRatchetPrivateKey();
	}

	public String getBobRatchetPublicKey() {
		return current().getBobRatchetPublicKey();
	}

	public String getBobRootKey() {
		return current().getBobRootKey();
	}

	public boolean allowMessageEntering() {
		return !communication.current().isAlreadyEncrypted();
	}

	public String getSendingChainKey() {
		return current().getSendingChainKey();
	}

	public String getSenderMsgKey() {
		return current().getSenderMsgKey();
	}

	public String getReceivingChainKey() {
		return safelyGetOptional(current().getReceivingChainKey());
	}

	public String getReceiverMsgKey() {
		return safelyGetOptional(current().getReceiverMsgKey());
	}

	public String getAliceEncryptedMessage() {
		if (currentState == STATE.INITIALIZING) {
			return "Nothing here";
		} else {
			return ToHex.toHexString(communication.current().getCiphertextMessage().orElse(new byte[] {}));
		}
	}

	private static <T> T safelyGetOptional(Optional<T> target) {
		if (!target.isPresent()) {
			LogUtil.logError(new IllegalStateException("An internal value was empty."), true);
		}
		return target.get();
	}

	private MessageContext current() {
		return getCommunication().current();
	}

	public SignalCommunication getCommunication() {
		return communication;
	}

}
