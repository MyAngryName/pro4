package org.jcryptool.visual.signalencryption.ui;

import org.jcryptool.visual.signalencryption.util.ToHex;

import java.util.Optional;

import org.jcryptool.core.logging.utils.LogUtil;
import org.jcryptool.visual.signalencryption.algorithm.SessionManager.Captures;
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
		signalEncryptionAlgorithm.generateBoth(currentState);
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

	public boolean allowMessageEntering() {
		return !communication.current().isAlreadyEncrypted();
	}


	public String getAliceEncryptedMessage() {
		if (currentState == STATE.INITIALIZING) {
			return "Nothing here";
		} else {
			return ToHex.toHex(communication.current().getCiphertextMessage().orElse(new byte[] {}));
		}
	}

	public SignalCommunication getCommunication() {
		return communication;
	}

}
