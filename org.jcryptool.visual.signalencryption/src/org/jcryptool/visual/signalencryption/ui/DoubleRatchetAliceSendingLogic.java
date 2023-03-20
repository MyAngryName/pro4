package org.jcryptool.visual.signalencryption.ui;

import org.jcryptool.core.logging.utils.LogUtil;
import org.jcryptool.visual.signalencryption.SignalEncryptionPlugin;
import org.jcryptool.visual.signalencryption.ui.DoubleRatchetBobSendingLogic.BobSendingStep;
import org.jcryptool.visual.signalencryption.exceptions.SignalAlgorithmException;
import org.jcryptool.visual.signalencryption.util.ToHex;

public class DoubleRatchetAliceSendingLogic {

	private DoubleRatchetStep currentStep = AliceSendingStep.STEP_0;

	public DoubleRatchetAliceSendingLogic(DoubleRatchetView swtParent) {
		currentStep = AliceSendingStep.STEP_0.setInitialState(swtParent);
	}

	public enum AliceSendingStep implements DoubleRatchetStep {
		/**
		 * Initial, blank step. Showing Alice's view
		 */
		STEP_0 {
			@Override
			protected void switchState(DoubleRatchetView swtParent) {
				swtParent.showAliceView();
				var bobContent = swtParent.getBobReceivingContent();
				var aliceContent = swtParent.getAliceSendingContent();
				// Hide these Elements
				swtParent.grp_bobAlgorithm.setVisible(false);
				bobContent.grp_bobReceivingChain.setVisible(false);
				bobContent.grp_bobRootChain.setVisible(false);
				bobContent.grp_bobDiffieHellman.setVisible(false);
				bobContent.txt_bobReceivingChain1.setVisible(false);
				bobContent.txt_bobReceivingChain2.setVisible(false);
				bobContent.txt_bobReceivingChain3.setVisible(false);
				bobContent.txt_bobReceivingChain4.setVisible(false);
				bobContent.txt_bobReceivingChain5.setVisible(false);
				bobContent.txt_bobRootChain1.setVisible(false);
				bobContent.txt_bobRootChain2.setVisible(false);
				bobContent.txt_bobRootChain3.setVisible(false);
				bobContent.txt_bobDiffieHellman1.setVisible(false);
				bobContent.txt_bobDiffieHellman2.setVisible(false);
				bobContent.txt_bobDiffieHellman3.setVisible(false);
				bobContent.cmp_bobArrowSpace1.setVisible(false);
				bobContent.cmp_bobArrowSpace2.setVisible(false);
				bobContent.grp_bobDecryptedMessage.setVisible(false);

				swtParent.grp_aliceAlgorithm.setVisible(false);
				aliceContent.grp_aliceMessagebox.setVisible(false);
				aliceContent.grp_aliceDiffieHellman.setVisible(false);
				aliceContent.grp_aliceRootChain.setVisible(false);
				aliceContent.grp_aliceSendingChain.setVisible(false);
				aliceContent.txt_aliceDiffieHellman1.setVisible(false);
				aliceContent.txt_aliceDiffieHellman2.setVisible(false);
				aliceContent.txt_aliceDiffieHellman3.setVisible(false);
				aliceContent.txt_aliceRootChain1.setVisible(false);
				aliceContent.txt_aliceRootChain2.setVisible(false);
				aliceContent.txt_aliceRootChain3.setVisible(false);
				aliceContent.txt_aliceSendingChain1.setVisible(false);
				aliceContent.txt_aliceSendingChain2.setVisible(false);
				aliceContent.txt_aliceSendingChain3.setVisible(false);
				aliceContent.txt_aliceSendingChain4.setVisible(false);
				aliceContent.txt_aliceSendingChain5.setVisible(false);
				aliceContent.txt_aliceCipherText.setVisible(false);
				aliceContent.cmp_aliceArrowSpace1.setVisible(false);
				aliceContent.cmp_aliceArrowSpace2.setVisible(false);
				aliceContent.grp_aliceMessagebox.setVisible(false);
				aliceContent.arr_aliceSendingChainArrow1.setVisible(false);
				aliceContent.arr_aliceSendingChainArrow2.setVisible(false);
				aliceContent.arr_aliceSendingChainArrow3.setVisible(false);

				// Hide Steps
				aliceContent.txt_aliceSendingStep1.setVisible(false);
				aliceContent.txt_aliceSendingStep2.setVisible(false);
				aliceContent.txt_aliceSendingStep3.setVisible(false);
				aliceContent.txt_aliceSendingStep4.setVisible(false);
				aliceContent.txt_aliceSendingStep5.setVisible(false);
				bobContent.txt_bobReceivingStep5.setVisible(false);
				bobContent.txt_bobReceivingStep6.setVisible(false);
				bobContent.txt_bobReceivingStep7.setVisible(false);
				bobContent.txt_bobReceivingStep8.setVisible(false);
				bobContent.txt_bobReceivingStep9.setVisible(false);

				// Initial value only valid for initial message
				if (AlgorithmState.get().getCommunication().isBeginning()) {
					aliceContent.txt_aliceSendingStep0.setText(Messages.SignalEncryption_aliceDescriptionText0);
					// TODO replace state
					// AlgorithmState.get().setState(STATE.PRE_KEY_SIGNAL_MESSAGE);
				} else {
					// AlgorithmState.get().setState(STATE.ALICE_SEND_MSG);
					aliceContent.txt_aliceSendingStep0.setText("Alice sendet eine Nachricht an Bob");
				}
			}

			@Override
			public DoubleRatchetStep next(DoubleRatchetView swtParent) {
				STEP_1.switchState(swtParent);
				return STEP_1;
			}

			@Override
			public DoubleRatchetStep back(DoubleRatchetView swtParent) {
				if (AlgorithmState.get().getCommunication().isBeginning()) {
					return STEP_0;
				} else {
					swtParent.switchSenderReceiver();
					AlgorithmState.get().getCommunication().prev();
					BobSendingStep.STEP_9.switchState(swtParent);
					return BobSendingStep.STEP_9;
				}
			}
		},
		/**
		 * Show Diffie-Hellman calculation.
		 */
		STEP_1 {

			@Override
			protected void switchState(DoubleRatchetView swtParent) {
				var aliceContent = swtParent.getAliceSendingContent();
				// On this transition, update all key details as well
				updateSenderKeyDisplayInformation(swtParent);

				// Show these elements
				swtParent.grp_aliceAlgorithm.setVisible(true);
				aliceContent.grp_aliceDiffieHellman.setVisible(true);
				aliceContent.txt_aliceDiffieHellman1.setVisible(true);
				aliceContent.txt_aliceDiffieHellman2.setVisible(true);
				aliceContent.txt_aliceDiffieHellman3.setVisible(true);
				aliceContent.txt_aliceSendingStep1.setVisible(true);

				// Hide these Elements
				aliceContent.grp_aliceRootChain.setVisible(false);
				aliceContent.txt_aliceRootChain1.setVisible(false);
				aliceContent.txt_aliceRootChain2.setVisible(false);
				aliceContent.txt_aliceRootChain3.setVisible(false);
				aliceContent.grp_aliceRootChain.setVisible(false);
				aliceContent.cmp_aliceArrowSpace1.setVisible(false);
				aliceContent.txt_aliceSendingStep2.setVisible(false);
				aliceContent.grp_aliceSendingChain.setVisible(false);
				aliceContent.txt_aliceSendingChain1.setVisible(false);
				aliceContent.cmp_aliceArrowSpace2.setVisible(false);

				// Pick up user input text
				aliceContent.txt_aliceCipherText.setText(AlgorithmState.get().getAliceEncryptedMessage());
			}

			@Override
			public DoubleRatchetStep next(DoubleRatchetView swtParent) {
				STEP_2.switchState(swtParent);
				return STEP_2;
			}

			@Override
			public DoubleRatchetStep back(DoubleRatchetView swtParent) {
				STEP_0.switchState(swtParent);
				return STEP_0;

			}
		},
		/**
		 * Show the root chain calculation.
		 */
		STEP_2 {

			@Override
			protected void switchState(DoubleRatchetView swtParent) {
				var aliceContent = swtParent.getAliceSendingContent();

				// Show these labels
				aliceContent.grp_aliceRootChain.setVisible(true);
				aliceContent.txt_aliceRootChain1.setVisible(true);
				aliceContent.txt_aliceRootChain2.setVisible(true);
				aliceContent.txt_aliceRootChain3.setVisible(true);
				aliceContent.grp_aliceRootChain.setVisible(true);
				aliceContent.grp_aliceSendingChain.setVisible(true);
				aliceContent.txt_aliceSendingChain1.setVisible(true);
				aliceContent.arr_aliceSendingChainArrow4.setVisible(true);
				aliceContent.cmp_aliceArrowSpace2.setVisible(true);
				aliceContent.cmp_aliceArrowSpace1.setVisible(true);
				aliceContent.txt_aliceSendingStep2.setVisible(true);

				// Hide these Elements
				aliceContent.txt_aliceSendingChain2.setVisible(false);
				aliceContent.txt_aliceSendingChain3.setVisible(false);
				aliceContent.txt_aliceSendingChain4.setVisible(false);
				aliceContent.txt_aliceSendingChain5.setVisible(false);
				aliceContent.arr_aliceSendingChainArrow1.setVisible(false);
				aliceContent.arr_aliceSendingChainArrow2.setVisible(false);
				aliceContent.arr_aliceSendingChainArrow3.setVisible(false);
				aliceContent.txt_aliceSendingStep3.setVisible(false);
			}

			@Override
			public DoubleRatchetStep next(DoubleRatchetView swtParent) {
				STEP_3.switchState(swtParent);
				return STEP_3;
			}

			@Override
			public DoubleRatchetStep back(DoubleRatchetView swtParent) {
				STEP_1.switchState(swtParent);
				return STEP_1;
			}
		},
		/**
		 * Show the sending chain calculation.
		 */
		STEP_3 {

			@Override
			protected void switchState(DoubleRatchetView swtParent) {
				var aliceContent = swtParent.getAliceSendingContent();
				var bobContent = swtParent.getBobReceivingContent();

				// Show these labels
				aliceContent.txt_aliceSendingChain2.setVisible(true);
				aliceContent.txt_aliceSendingChain3.setVisible(true);
				aliceContent.txt_aliceSendingChain4.setVisible(true);
				aliceContent.txt_aliceSendingChain5.setVisible(true);
				aliceContent.arr_aliceSendingChainArrow1.setVisible(true);
				aliceContent.arr_aliceSendingChainArrow2.setVisible(true);
				aliceContent.arr_aliceSendingChainArrow3.setVisible(true);
				aliceContent.txt_aliceSendingStep3.setVisible(true);

				// Hide these Elements
				aliceContent.grp_aliceMessagebox.setVisible(false);
				aliceContent.txt_aliceSendingStep4.setVisible(false);

				bobContent.grp_bobReceivingChain.setVisible(false);

			}

			@Override
			public DoubleRatchetStep next(DoubleRatchetView swtParent) {
				STEP_4.switchState(swtParent);
				return STEP_4;
			}

			@Override
			public DoubleRatchetStep back(DoubleRatchetView swtParent) {
				STEP_2.switchState(swtParent);
				return STEP_2;
			}
		},
		/**
		 * Show the message input box. Set previously entered text if entered. The
		 * <b>message encryption</b> happens when going forward from here. If already
		 * encrypted, the message box may not be changed anymore.
		 */
		STEP_4 {

			@Override
			protected void switchState(DoubleRatchetView swtParent) {
				var aliceContent = swtParent.getAliceSendingContent();
				var bobContent = swtParent.getBobReceivingContent();

				// Show these labels
				aliceContent.grp_aliceSendingChain.setVisible(true);
				aliceContent.grp_aliceMessagebox.setVisible(true);
				aliceContent.txt_aliceSendingStep4.setVisible(true);
				aliceContent.txt_alicePlainText.setVisible(true);

				// Hide these Elements
				swtParent.grp_bobAlgorithm.setVisible(false);
				aliceContent.txt_aliceCipherText.setVisible(false);
				bobContent.txt_bobCipherText.setVisible(false);
				bobContent.grp_bobMessagebox.setVisible(false);
				aliceContent.txt_aliceSendingStep5.setVisible(false);
				bobContent.txt_bobReceivingStep5.setVisible(false);

				if (AlgorithmState.get().allowMessageEntering()) {
					aliceContent.txt_alicePlainText.setEnabled(true);
				} else {
					aliceContent.txt_alicePlainText.setEnabled(false);

				}
				// Set the text for the user message input.
				// Since the MessageContext uses the default message upon construction,
				// it is correctly display on first hitting this state.
				// Afterwards, if a user goes forward/backwards, this ensures that always the
				// correct message is set.
				String userInput = AlgorithmState.get().getCommunication().current().getMessage();
				aliceContent.txt_alicePlainText.setText(userInput);
			}

			@Override
			public DoubleRatchetStep next(DoubleRatchetView swtParent) {
				var communication = AlgorithmState.get().getCommunication();

				if (!communication.current().isAlreadyEncrypted()) {
					encryptMessage(swtParent);
				}

				// TODO: Update keys on first tab
				STEP_5.switchState(swtParent);
				return STEP_5;
			}

			@Override
			public DoubleRatchetStep back(DoubleRatchetView swtParent) {
				// Save state of the input field if it has not been encrypted yet.
				if (AlgorithmState.get().allowMessageEntering()) {
					var currentInput = swtParent.getAliceSendingContent().txt_alicePlainText.getText();
					AlgorithmState.get().getCommunication().current().setMessage(currentInput);
				}
				// TODO: Update keys on first tab
				STEP_3.switchState(swtParent);
				return STEP_3;
			}
		},
		/**
		 * Showing the final, encrypted message and "send" it to Bob. Showing Alice's
		 * view (important if going backwards).
		 */
		STEP_5 {

			@Override
			protected void switchState(DoubleRatchetView swtParent) {
				var aliceContent = swtParent.getAliceSendingContent();
				var bobContent = swtParent.getBobReceivingContent();
				// Show these elements
				swtParent.grp_bobAlgorithm.setVisible(true);
				aliceContent.txt_aliceCipherText.setVisible(true);
				bobContent.txt_bobCipherText.setVisible(true);
				bobContent.grp_bobMessagebox.setVisible(true);
				aliceContent.txt_aliceSendingStep5.setVisible(true);
				bobContent.txt_bobReceivingStep5.setVisible(true);

				swtParent.showAliceView();

				// Hide these Elements
				bobContent.grp_bobDiffieHellman.setVisible(false);
				bobContent.txt_bobDiffieHellman1.setVisible(false);
				bobContent.txt_bobDiffieHellman2.setVisible(false);
				bobContent.txt_bobDiffieHellman3.setVisible(false);
				bobContent.txt_bobReceivingStep6.setVisible(false);

				// State
				aliceContent.txt_alicePlainText.setEnabled(false);
				var communication = AlgorithmState.get().getCommunication();
				var ciphertextOptional = communication.current().getCiphertextMessage();
				var ciphertextAsBytes = ciphertextOptional.orElse("An error occured".getBytes());
				var ciphertextAsString = ToHex.toHexString(ciphertextAsBytes);
				aliceContent.txt_aliceCipherText.setText(ciphertextAsString);
				bobContent.txt_bobCipherText.setText(ciphertextAsString);

				// After encrypting the message, we have access to the receiving keys
				updateReceivingKeyDisplayInformation(swtParent);

				// TODO: Rework this state as it is basically pointless.
				if (communication.isBeginning()) {
					// TODO replace State
					// AlgorithmState.get().setState(AlgorithmState.STATE.ALICE_SEND_MSG);
				}
			}

			@Override
			public DoubleRatchetStep next(DoubleRatchetView swtParent) {
				// TODO: Update keys on first tab
				STEP_6.switchState(swtParent);
				return STEP_6;
			}

			@Override
			public DoubleRatchetStep back(DoubleRatchetView swtParent) {
				// TODO: Update keys on first tab
				STEP_4.switchState(swtParent);
				return STEP_4;
			}
		},
		/**
		 * Switch to Bob's view and "receive" the encrypted message. Show the encrypted
		 * message text box and the Diffie-Hellman calculation.
		 */
		STEP_6 {

			@Override
			protected void switchState(DoubleRatchetView swtParent) {
				swtParent.showBobView();
				var bobContent = swtParent.getBobReceivingContent();

				// Show these labels
				bobContent.grp_bobDiffieHellman.setVisible(true);
				bobContent.txt_bobDiffieHellman1.setVisible(true);
				bobContent.txt_bobDiffieHellman2.setVisible(true);
				bobContent.txt_bobDiffieHellman3.setVisible(true);
				bobContent.txt_bobReceivingStep6.setVisible(true);

				// Hide these Elements
				bobContent.grp_bobRootChain.setVisible(false);
				bobContent.txt_bobRootChain1.setVisible(false);
				bobContent.txt_bobRootChain2.setVisible(false);
				bobContent.txt_bobRootChain3.setVisible(false);
				bobContent.cmp_bobArrowSpace1.setVisible(false);
				bobContent.cmp_bobArrowSpace2.setVisible(false);
				bobContent.grp_bobReceivingChain.setVisible(false);
				bobContent.txt_bobReceivingChain1.setVisible(false);
				bobContent.arr_bobReceivingChainArrow4.setVisible(false);
				bobContent.txt_bobReceivingStep7.setVisible(false);

				// Initial value only valid for initial message
				if (AlgorithmState.get().getCommunication().isBeginning()) {
					bobContent.txt_bobReceivingStep0.setText(Messages.SignalEncryption_bobDescriptionText0);
				} else {
					bobContent.txt_bobReceivingStep0.setText("Bob wartet auf eine Nachricht von Alice");
				}
			}

			@Override
			public DoubleRatchetStep next(DoubleRatchetView swtParent) {
				STEP_7.switchState(swtParent);
				return STEP_7;
			}

			@Override
			public DoubleRatchetStep back(DoubleRatchetView swtParent) {
				STEP_5.switchState(swtParent);
				return STEP_5;
			}
		},
		/**
		 * Show the root chain calculation.
		 */
		STEP_7 {

			@Override
			protected void switchState(DoubleRatchetView swtParent) {
				var bobContent = swtParent.getBobReceivingContent();

				// Show these labels
				bobContent.grp_bobRootChain.setVisible(true);
				bobContent.txt_bobRootChain1.setVisible(true);
				bobContent.txt_bobRootChain2.setVisible(true);
				bobContent.txt_bobRootChain3.setVisible(true);
				bobContent.cmp_bobArrowSpace1.setVisible(true);
				bobContent.cmp_bobArrowSpace2.setVisible(true);
				bobContent.txt_bobReceivingChain1.setVisible(true);
				bobContent.arr_bobReceivingChainArrow4.setVisible(true);
				bobContent.grp_bobReceivingChain.setVisible(true);
				bobContent.txt_bobReceivingStep7.setVisible(true);

				// Hide these Elements
				bobContent.txt_bobReceivingChain2.setVisible(false);
				bobContent.txt_bobReceivingChain3.setVisible(false);
				bobContent.txt_bobReceivingChain4.setVisible(false);
				bobContent.txt_bobReceivingChain5.setVisible(false);
				bobContent.arr_bobReceivingChainArrow1.setVisible(false);
				bobContent.arr_bobReceivingChainArrow2.setVisible(false);
				bobContent.arr_bobReceivingChainArrow3.setVisible(false);
				bobContent.txt_bobReceivingStep8.setVisible(false);

			}

			@Override
			public DoubleRatchetStep next(DoubleRatchetView swtParent) {
				STEP_8.switchState(swtParent);
				return STEP_8;
			}

			@Override
			public DoubleRatchetStep back(DoubleRatchetView swtParent) {
				STEP_6.switchState(swtParent);
				return STEP_6;
			}
		},
		/**
		 * Show the receiving chain calculation.
		 */
		STEP_8 {

			@Override
			protected void switchState(DoubleRatchetView swtParent) {
				var bobContent = swtParent.getBobReceivingContent();

				// Show these labels
				bobContent.grp_bobReceivingChain.setVisible(true);
				bobContent.txt_bobReceivingChain1.setVisible(true);
				bobContent.txt_bobReceivingChain2.setVisible(true);
				bobContent.txt_bobReceivingChain3.setVisible(true);
				bobContent.txt_bobReceivingChain4.setVisible(true);
				bobContent.txt_bobReceivingChain5.setVisible(true);
				bobContent.arr_bobReceivingChainArrow1.setVisible(true);
				bobContent.arr_bobReceivingChainArrow2.setVisible(true);
				bobContent.arr_bobReceivingChainArrow3.setVisible(true);
				bobContent.txt_bobReceivingStep8.setVisible(true);

				// Hide these Elements
				bobContent.grp_bobDecryptedMessage.setVisible(false);
				bobContent.txt_bobReceivingStep9.setVisible(false);
			}

			@Override
			public DoubleRatchetStep next(DoubleRatchetView swtParent) {
				STEP_9.switchState(swtParent);
				return STEP_9;
			}

			@Override
			public DoubleRatchetStep back(DoubleRatchetView swtParent) {
				STEP_7.switchState(swtParent);
				return STEP_7;
			}
		},
		/**
		 * Show the decrypted message.
		 */
		STEP_9 {

			@Override
			protected void switchState(DoubleRatchetView swtParent) {
				var bobContent = swtParent.getBobReceivingContent();
				var aliceContent = swtParent.getAliceSendingContent();
				swtParent.showBobView();
				// Show these Elements
				swtParent.grp_bobAlgorithm.setVisible(true);
				swtParent.grp_bobSteps.setVisible(true);
				bobContent.grp_bobReceivingChain.setVisible(true);
				bobContent.grp_bobRootChain.setVisible(true);
				bobContent.grp_bobDiffieHellman.setVisible(true);
				bobContent.txt_bobReceivingChain1.setVisible(true);
				bobContent.txt_bobReceivingChain2.setVisible(true);
				bobContent.txt_bobReceivingChain3.setVisible(true);
				bobContent.txt_bobReceivingChain4.setVisible(true);
				bobContent.txt_bobReceivingChain5.setVisible(true);
				bobContent.txt_bobRootChain1.setVisible(true);
				bobContent.txt_bobRootChain2.setVisible(true);
				bobContent.txt_bobRootChain3.setVisible(true);
				bobContent.txt_bobDiffieHellman1.setVisible(true);
				bobContent.txt_bobDiffieHellman2.setVisible(true);
				bobContent.txt_bobDiffieHellman3.setVisible(true);
				bobContent.cmp_bobArrowSpace1.setVisible(true);
				bobContent.cmp_bobArrowSpace2.setVisible(true);
				bobContent.grp_bobDecryptedMessage.setVisible(true);

				swtParent.grp_aliceAlgorithm.setVisible(true);
				swtParent.grp_aliceSteps.setVisible(true);
				aliceContent.grp_aliceDiffieHellman.setVisible(true);
				aliceContent.grp_aliceRootChain.setVisible(true);
				aliceContent.grp_aliceSendingChain.setVisible(true);
				aliceContent.txt_aliceDiffieHellman1.setVisible(true);
				aliceContent.txt_aliceDiffieHellman2.setVisible(true);
				aliceContent.txt_aliceDiffieHellman3.setVisible(true);
				aliceContent.txt_aliceRootChain1.setVisible(true);
				aliceContent.txt_aliceRootChain2.setVisible(true);
				aliceContent.txt_aliceRootChain3.setVisible(true);
				aliceContent.txt_aliceSendingChain1.setVisible(true);
				aliceContent.txt_aliceSendingChain2.setVisible(true);
				aliceContent.txt_aliceSendingChain3.setVisible(true);
				aliceContent.txt_aliceSendingChain4.setVisible(true);
				aliceContent.txt_aliceSendingChain5.setVisible(true);
				aliceContent.txt_aliceCipherText.setVisible(true);
				aliceContent.cmp_aliceArrowSpace1.setVisible(true);
				aliceContent.cmp_aliceArrowSpace2.setVisible(true);
				aliceContent.grp_aliceMessagebox.setVisible(true);
				aliceContent.arr_aliceSendingChainArrow1.setVisible(true);
				aliceContent.arr_aliceSendingChainArrow2.setVisible(true);
				aliceContent.arr_aliceSendingChainArrow3.setVisible(true);

				// Show Steps
				aliceContent.txt_aliceSendingStep1.setVisible(true);
				aliceContent.txt_aliceSendingStep2.setVisible(true);
				aliceContent.txt_aliceSendingStep3.setVisible(true);
				aliceContent.txt_aliceSendingStep4.setVisible(true);
				aliceContent.txt_aliceSendingStep5.setVisible(true);
				bobContent.txt_bobReceivingStep5.setVisible(true);
				bobContent.txt_bobReceivingStep6.setVisible(true);
				bobContent.txt_bobReceivingStep7.setVisible(true);
				bobContent.txt_bobReceivingStep8.setVisible(true);
				bobContent.txt_bobReceivingStep9.setVisible(true);

				// If going back to initial message, this may be required to update
				if (AlgorithmState.get().getCommunication().isBeginning()) {
					bobContent.txt_bobReceivingStep0.setText(Messages.SignalEncryption_bobDescriptionText0);
					aliceContent.txt_aliceSendingStep0.setText(Messages.SignalEncryption_aliceDescriptionText0);
				}
				// Show these labels
				bobContent.txt_bobPlainText.setVisible(true);
				bobContent.txt_bobReceivingStep9.setVisible(true);
				var decryptedMessage = AlgorithmState.get().getCommunication().current().getDecryptedMessage();
				if (decryptedMessage.isPresent()) {
					bobContent.txt_bobPlainText.setText(decryptedMessage.get());
				} else {
					LogUtil.logError(new SignalAlgorithmException(), true);
				}
				// On this transition, update all key steps as well
				updateSenderKeyDisplayInformation(swtParent);
				updateReceivingKeyDisplayInformation(swtParent);
			}

			@Override
			public DoubleRatchetStep next(DoubleRatchetView swtParent) {
				swtParent.switchSenderReceiver();
				AlgorithmState.get().getCommunication().next();
				BobSendingStep.STEP_0.switchState(swtParent);
				return BobSendingStep.STEP_0;
			}

			@Override
			public DoubleRatchetStep back(DoubleRatchetView swtParent) {
				STEP_8.switchState(swtParent);
				return STEP_8;
			}
		};

		protected abstract void switchState(DoubleRatchetView swtParent);

		public AliceSendingStep setInitialState(DoubleRatchetView swtParent) {
			STEP_0.switchState(swtParent);
			return STEP_0;
		}
	}

	public void stepForward(DoubleRatchetView swtParent) {
		currentStep = currentStep.next(swtParent);
	}

	public void stepBack(DoubleRatchetView swtParent) {
		currentStep = currentStep.back(swtParent);
	}

	public void reset(DoubleRatchetView swtParent) {
		currentStep = AliceSendingStep.STEP_0.setInitialState(swtParent);
	}

	public DoubleRatchetStep getCurrentStep() {
		return currentStep;
	}

	/**
	 * Get user input from UI and give it to the encryption algorithm.
	 */
	private static void encryptMessage(DoubleRatchetView view) {
		var message = view.getAliceSendingContent().txt_alicePlainText.getText();
		var communication = AlgorithmState.get().getCommunication();
		try {
			communication.encrypt(message);
		} catch (SignalAlgorithmException e) {
			LogUtil.logError(SignalEncryptionPlugin.PLUGIN_ID, "Sorry, that shouldn't have happened, must restart", e,
					true);
			view.resetAll();
		}
	}

	private static void updateSenderKeyDisplayInformation(DoubleRatchetView view) {
		var aliceContent = view.getAliceSendingContent();
		var algState = AlgorithmState.get();
		PopupUtil.updatePopupFor(aliceContent.txt_aliceSendingChain5, algState.getSendingChainKey());
		PopupUtil.updatePopupFor(aliceContent.txt_aliceSendingChain4, algState.getSenderMsgKey());
		PopupUtil.updatePopupFor(aliceContent.txt_aliceRootChain3, algState.getaliceRootKey());
		PopupUtil.updatePopupFor(aliceContent.txt_aliceDiffieHellman3, algState.getAliceRatchetPrivateKey());
		PopupUtil.updatePopupFor(aliceContent.txt_aliceDiffieHellman2, algState.getAliceRatchetPublicKey());

		var bobContent = view.getBobReceivingContent();
		PopupUtil.updatePopupFor(bobContent.txt_bobRootChain3, algState.getBobRootKey());
		PopupUtil.updatePopupFor(bobContent.txt_bobDiffieHellman3, algState.getBobRatchetPrivateKey());
		PopupUtil.updatePopupFor(bobContent.txt_bobDiffieHellman2, algState.getBobRatchetPublicKey());
	}

	private static void updateReceivingKeyDisplayInformation(DoubleRatchetView view) {
		var bobContent = view.getBobReceivingContent();
		var algState = AlgorithmState.get();
		PopupUtil.updatePopupFor(bobContent.txt_bobReceivingChain5, algState.getReceivingChainKey());

		PopupUtil.updatePopupFor(bobContent.txt_bobReceivingChain4, algState.getReceiverMsgKey());

	}
}
