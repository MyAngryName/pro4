package org.jcryptool.visual.signalencryption.ui;

import org.jcryptool.core.logging.utils.LogUtil;
import org.jcryptool.visual.signalencryption.SignalEncryptionPlugin;
import org.jcryptool.visual.signalencryption.exceptions.SignalAlgorithmException;
import org.jcryptool.visual.signalencryption.ui.DoubleRatchetAliceSendingLogic.AliceSendingStep;
import org.jcryptool.visual.signalencryption.util.ToHex;

public class DoubleRatchetBobSendingLogic {

    private DoubleRatchetStep currentStep = BobSendingStep.STEP_0;

    public DoubleRatchetBobSendingLogic(DoubleRatchetView swtParent) {
        currentStep = BobSendingStep.STEP_0.setInitialState(swtParent);
    }

    public enum BobSendingStep implements DoubleRatchetStep {
        /**
         * Initial, blank step. Showing Bob's view
         */
        STEP_0 {
            @Override
            protected void switchState(DoubleRatchetView swtParent) {
                swtParent.showBobView();
                var bobContent = swtParent.getBobSendingContent();
                var aliceContent = swtParent.getAliceReceivingContent();
                // Hide these Elements
                swtParent.grp_aliceAlgorithm.setVisible(false);
                aliceContent.grp_aliceReceivingChain.setVisible(false);
                aliceContent.grp_aliceRootChain.setVisible(false);
                aliceContent.grp_aliceDiffieHellman.setVisible(false);
                aliceContent.txt_aliceReceivingChain1.setVisible(false);
                aliceContent.txt_aliceReceivingChain2.setVisible(false);
                aliceContent.txt_aliceReceivingChain3.setVisible(false);
                aliceContent.txt_aliceReceivingChain4.setVisible(false);
                aliceContent.txt_aliceReceivingChain5.setVisible(false);
                aliceContent.txt_aliceRootChain1.setVisible(false);
                aliceContent.txt_aliceRootChain2.setVisible(false);
                aliceContent.txt_aliceRootChain3.setVisible(false);
                aliceContent.txt_aliceDiffieHellman1.setVisible(false);
                aliceContent.txt_aliceDiffieHellman2.setVisible(false);
                aliceContent.txt_aliceDiffieHellman3.setVisible(false);
                aliceContent.cmp_aliceArrowSpace1.setVisible(false);
                aliceContent.cmp_aliceArrowSpace2.setVisible(false);
                aliceContent.grp_aliceDecryptedMessage.setVisible(false);

                swtParent.grp_bobAlgorithm.setVisible(false);
                bobContent.grp_bobDiffieHellman.setVisible(false);
                bobContent.grp_bobRootChain.setVisible(false);
                bobContent.grp_bobSendingChain.setVisible(false);
                bobContent.txt_bobDiffieHellman1.setVisible(false);
                bobContent.txt_bobDiffieHellman2.setVisible(false);
                bobContent.txt_bobDiffieHellman3.setVisible(false);
                bobContent.txt_bobRootChain1.setVisible(false);
                bobContent.txt_bobRootChain2.setVisible(false);
                bobContent.txt_bobRootChain3.setVisible(false);
                bobContent.txt_bobSendingChain1.setVisible(false);
                bobContent.txt_bobSendingChain2.setVisible(false);
                bobContent.txt_bobSendingChain3.setVisible(false);
                bobContent.txt_bobSendingChain4.setVisible(false);
                bobContent.txt_bobSendingChain5.setVisible(false);
                bobContent.txt_bobCipherText.setVisible(false);
                bobContent.cmp_bobArrowSpace1.setVisible(false);
                bobContent.cmp_bobArrowSpace2.setVisible(false);
                bobContent.grp_bobMessagebox.setVisible(false);
                bobContent.arr_bobSendingChainArrow1.setVisible(false);
                bobContent.arr_bobSendingChainArrow2.setVisible(false);
                bobContent.arr_bobSendingChainArrow3.setVisible(false);

                // Hide Steps
                bobContent.txt_bobSendingStep1.setVisible(false);
                bobContent.txt_bobSendingStep2.setVisible(false);
                bobContent.txt_bobSendingStep3.setVisible(false);
                bobContent.txt_bobSendingStep4.setVisible(false);
                bobContent.txt_bobSendingStep5.setVisible(false);
                aliceContent.txt_aliceReceivingStep5.setVisible(false);
                aliceContent.txt_aliceReceivingStep6.setVisible(false);
                aliceContent.txt_aliceReceivingStep7.setVisible(false);
                aliceContent.txt_aliceReceivingStep8.setVisible(false);
                aliceContent.txt_aliceReceivingStep9.setVisible(false);
            }

            @Override
            public DoubleRatchetStep next(DoubleRatchetView swtParent) {
                STEP_1.switchState(swtParent);
                return STEP_1;
            }

            @Override
            public DoubleRatchetStep back(DoubleRatchetView swtParent) {
                swtParent.switchSenderReceiver();
                AlgorithmState.get().getCommunication().prev();
                AliceSendingStep.STEP_9.switchState(swtParent);
                return AliceSendingStep.STEP_9;
            }
        },
        /**
         * Show Diffie-Hellman calculation.
         */
        STEP_1 {

            @Override
            protected void switchState(DoubleRatchetView swtParent) {
                var bobContent = swtParent.getBobSendingContent();
                // On this transition, update all key details as well
                updateSendingKeyDisplayInformation(swtParent);

                // Show these elements
                swtParent.grp_bobAlgorithm.setVisible(true);
                swtParent.grp_bobSteps.setVisible(true);
                bobContent.grp_bobDiffieHellman.setVisible(true);
                bobContent.txt_bobDiffieHellman1.setVisible(true);
                bobContent.txt_bobDiffieHellman2.setVisible(true);
                bobContent.txt_bobDiffieHellman3.setVisible(true);
                bobContent.txt_bobSendingStep1.setVisible(true);

                // Hide these Elements
                bobContent.grp_bobRootChain.setVisible(false);
                bobContent.txt_bobRootChain1.setVisible(false);
                bobContent.txt_bobRootChain2.setVisible(false);
                bobContent.txt_bobRootChain3.setVisible(false);
                bobContent.grp_bobRootChain.setVisible(false);
                bobContent.cmp_bobArrowSpace1.setVisible(false);
                bobContent.txt_bobSendingStep2.setVisible(false);
                bobContent.grp_bobSendingChain.setVisible(false);
                bobContent.txt_bobSendingChain1.setVisible(false);
                bobContent.cmp_bobArrowSpace2.setVisible(false);

                // Pick up user input text
                bobContent.txt_bobCipherText
                        .setText(AlgorithmState.get().getAliceEncryptedMessage());
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
                var bobContent = swtParent.getBobSendingContent();

                // Show these labels
                bobContent.grp_bobRootChain.setVisible(true);
                bobContent.txt_bobRootChain1.setVisible(true);
                bobContent.txt_bobRootChain2.setVisible(true);
                bobContent.txt_bobRootChain3.setVisible(true);
                bobContent.grp_bobRootChain.setVisible(true);
                bobContent.grp_bobSendingChain.setVisible(true);
                bobContent.txt_bobSendingChain1.setVisible(true);
                bobContent.arr_bobSendingChainArrow4.setVisible(true);
                bobContent.cmp_bobArrowSpace2.setVisible(true);
                bobContent.cmp_bobArrowSpace1.setVisible(true);
                bobContent.txt_bobSendingStep2.setVisible(true);

                // Hide these Elements
                bobContent.txt_bobSendingChain2.setVisible(false);
                bobContent.txt_bobSendingChain3.setVisible(false);
                bobContent.txt_bobSendingChain4.setVisible(false);
                bobContent.txt_bobSendingChain5.setVisible(false);
                bobContent.arr_bobSendingChainArrow1.setVisible(false);
                bobContent.arr_bobSendingChainArrow2.setVisible(false);
                bobContent.arr_bobSendingChainArrow3.setVisible(false);
                bobContent.txt_bobSendingStep3.setVisible(false);
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
                var bobContent = swtParent.getBobSendingContent();
                var aliceContent = swtParent.getAliceReceivingContent();

                // Show these labels
                bobContent.txt_bobSendingChain2.setVisible(true);
                bobContent.txt_bobSendingChain3.setVisible(true);
                bobContent.txt_bobSendingChain4.setVisible(true);
                bobContent.txt_bobSendingChain5.setVisible(true);
                bobContent.arr_bobSendingChainArrow1.setVisible(true);
                bobContent.arr_bobSendingChainArrow2.setVisible(true);
                bobContent.arr_bobSendingChainArrow3.setVisible(true);
                bobContent.txt_bobSendingStep3.setVisible(true);

                // Hide these Elements
                bobContent.grp_bobMessagebox.setVisible(false);
                bobContent.txt_bobSendingStep4.setVisible(false);

                aliceContent.grp_aliceReceivingChain.setVisible(false);

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
         * Show the message input box. Set previously entered text if entered.
         * The <b>message encryption</b> happens when going forward from here.
         * If already encrypted, the message box may not be changed anymore.
         */
        STEP_4 {

            @Override
            protected void switchState(DoubleRatchetView swtParent) {
                var bobContent = swtParent.getBobSendingContent();
                var aliceContent = swtParent.getAliceReceivingContent();

                // Show these labels
                bobContent.grp_bobSendingChain.setVisible(true);
                bobContent.grp_bobMessagebox.setVisible(true);
                bobContent.txt_bobSendingStep4.setVisible(true);
                bobContent.txt_bobPlainText.setVisible(true);

                // Hide these Elements
                swtParent.grp_aliceAlgorithm.setVisible(false);
                bobContent.txt_bobCipherText.setVisible(false);
                aliceContent.txt_aliceCipherText.setVisible(false);
                aliceContent.grp_aliceMessagebox.setVisible(false);
                bobContent.txt_bobSendingStep5.setVisible(false);
                aliceContent.txt_aliceReceivingStep5.setVisible(false);

                if (AlgorithmState.get().allowMessageEntering()) {
                    bobContent.txt_bobPlainText.setEnabled(true);
                } else {
                    bobContent.txt_bobPlainText.setEnabled(false);
                }

                // Set the text for the user message input.
                // Since the MessageContext uses the default message upon construction,
                // it is correctly display on first hitting this state.
                // Afterwards, if a user goes forward/backwards, this ensures that always the
                // correct message is set.
                String userInput = AlgorithmState.get().getCommunication().current().getMessage();
                bobContent.txt_bobPlainText.setText(userInput);
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
                    var currentInput = swtParent.getBobSendingContent().txt_bobPlainText.getText();
                    AlgorithmState.get().getCommunication().current().setMessage(currentInput);
                }
                // TODO: Update keys on first tab
                STEP_3.switchState(swtParent);
                return STEP_3;
            }

        },
        /**
         * Showing the final, encrypted message and "send" it to Alice.
         * Showing Bob's view (important if going backwards).
         */
        STEP_5 {

            @Override
            protected void switchState(DoubleRatchetView swtParent) {
                var bobContent = swtParent.getBobSendingContent();
                var aliceContent = swtParent.getAliceReceivingContent();
                // Show these elements
                swtParent.grp_aliceAlgorithm.setVisible(true);
                bobContent.txt_bobCipherText.setVisible(true);
                aliceContent.txt_aliceCipherText.setVisible(true);
                aliceContent.grp_aliceMessagebox.setVisible(true);
                bobContent.txt_bobSendingStep5.setVisible(true);
                aliceContent.txt_aliceReceivingStep5.setVisible(true);

                swtParent.showBobView();

                // Hide these Elements
                aliceContent.grp_aliceDiffieHellman.setVisible(false);
                aliceContent.txt_aliceDiffieHellman1.setVisible(false);
                aliceContent.txt_aliceDiffieHellman2.setVisible(false);
                aliceContent.txt_aliceDiffieHellman3.setVisible(false);
                aliceContent.txt_aliceReceivingStep6.setVisible(false);

                // State
                bobContent.txt_bobPlainText.setEnabled(false);
                var communication = AlgorithmState.get().getCommunication();
                var ciphertextOptional = communication.current().getCiphertextMessage();
                var ciphertextAsBytes = ciphertextOptional.orElse("An error occured".getBytes());
                var ciphertextAsString = ToHex.toHexString(ciphertextAsBytes);
                aliceContent.txt_aliceCipherText.setText(ciphertextAsString);
                bobContent.txt_bobCipherText.setText(ciphertextAsString);
                
                updateReceivingKeyDisplayInformation(swtParent);

                // TODO: Rework this state as it is basically pointless.
                if (communication.isBeginning()) {
                    // TODO replace state
                    //AlgorithmState.get().setState(AlgorithmState.STATE.BOB_SEND_MSG);
                }
            }

            @Override
            public DoubleRatchetStep next(DoubleRatchetView swtParent) {
                STEP_6.switchState(swtParent);
                return STEP_6;
            }

            @Override
            public DoubleRatchetStep back(DoubleRatchetView swtParent) {
                STEP_4.switchState(swtParent);
                return STEP_4;
            }
        },
        /**
         * Switch to Alice's view and "receive" the encrypted message.
         * Show the encrypted message text box and the Diffie-Hellman calculation.
         */
        STEP_6 {

            @Override
            protected void switchState(DoubleRatchetView swtParent) {
                swtParent.showAliceView();
                var aliceContent = swtParent.getAliceReceivingContent();

                // Show these labels
                aliceContent.grp_aliceDiffieHellman.setVisible(true);
                aliceContent.txt_aliceDiffieHellman1.setVisible(true);
                aliceContent.txt_aliceDiffieHellman2.setVisible(true);
                aliceContent.txt_aliceDiffieHellman3.setVisible(true);
                aliceContent.txt_aliceReceivingStep6.setVisible(true);

                // Hide these Elements
                aliceContent.grp_aliceRootChain.setVisible(false);
                aliceContent.txt_aliceRootChain1.setVisible(false);
                aliceContent.txt_aliceRootChain2.setVisible(false);
                aliceContent.txt_aliceRootChain3.setVisible(false);
                aliceContent.cmp_aliceArrowSpace1.setVisible(false);
                aliceContent.cmp_aliceArrowSpace2.setVisible(false);
                aliceContent.grp_aliceReceivingChain.setVisible(false);
                aliceContent.txt_aliceReceivingChain1.setVisible(false);
                aliceContent.arr_aliceReceivingChainArrow4.setVisible(false);
                aliceContent.txt_aliceReceivingStep7.setVisible(false);
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
                var aliceContent = swtParent.getAliceReceivingContent();

                // Show these labels
                aliceContent.grp_aliceRootChain.setVisible(true);
                aliceContent.txt_aliceRootChain1.setVisible(true);
                aliceContent.txt_aliceRootChain2.setVisible(true);
                aliceContent.txt_aliceRootChain3.setVisible(true);
                aliceContent.cmp_aliceArrowSpace1.setVisible(true);
                aliceContent.cmp_aliceArrowSpace2.setVisible(true);
                aliceContent.txt_aliceReceivingChain1.setVisible(true);
                aliceContent.arr_aliceReceivingChainArrow4.setVisible(true);
                aliceContent.grp_aliceReceivingChain.setVisible(true);
                aliceContent.txt_aliceReceivingStep7.setVisible(true);

                // Hide these Elements
                aliceContent.txt_aliceReceivingChain2.setVisible(false);
                aliceContent.txt_aliceReceivingChain3.setVisible(false);
                aliceContent.txt_aliceReceivingChain4.setVisible(false);
                aliceContent.txt_aliceReceivingChain5.setVisible(false);
                aliceContent.arr_aliceReceivingChainArrow1.setVisible(false);
                aliceContent.arr_aliceReceivingChainArrow2.setVisible(false);
                aliceContent.arr_aliceReceivingChainArrow3.setVisible(false);
                aliceContent.txt_aliceReceivingStep8.setVisible(false);

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
                var aliceContent = swtParent.getAliceReceivingContent();

                // Show these labels
                aliceContent.grp_aliceReceivingChain.setVisible(true);
                aliceContent.txt_aliceReceivingChain1.setVisible(true);
                aliceContent.txt_aliceReceivingChain2.setVisible(true);
                aliceContent.txt_aliceReceivingChain3.setVisible(true);
                aliceContent.txt_aliceReceivingChain4.setVisible(true);
                aliceContent.txt_aliceReceivingChain5.setVisible(true);
                aliceContent.arr_aliceReceivingChainArrow1.setVisible(true);
                aliceContent.arr_aliceReceivingChainArrow2.setVisible(true);
                aliceContent.arr_aliceReceivingChainArrow3.setVisible(true);
                aliceContent.txt_aliceReceivingStep8.setVisible(true);

                // Hide these Elements
                aliceContent.grp_aliceDecryptedMessage.setVisible(false);
                aliceContent.txt_aliceReceivingStep9.setVisible(false);
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
                var bobContent = swtParent.getBobSendingContent();
                var aliceContent = swtParent.getAliceReceivingContent();
                swtParent.showAliceView();
                // Show these Elements
                swtParent.grp_aliceAlgorithm.setVisible(true);
                swtParent.grp_aliceSteps.setVisible(true);
                aliceContent.grp_aliceReceivingChain.setVisible(true);
                aliceContent.grp_aliceRootChain.setVisible(true);
                aliceContent.grp_aliceDiffieHellman.setVisible(true);
                aliceContent.txt_aliceReceivingChain1.setVisible(true);
                aliceContent.txt_aliceReceivingChain2.setVisible(true);
                aliceContent.txt_aliceReceivingChain3.setVisible(true);
                aliceContent.txt_aliceReceivingChain4.setVisible(true);
                aliceContent.txt_aliceReceivingChain5.setVisible(true);
                aliceContent.txt_aliceRootChain1.setVisible(true);
                aliceContent.txt_aliceRootChain2.setVisible(true);
                aliceContent.txt_aliceRootChain3.setVisible(true);
                aliceContent.txt_aliceDiffieHellman1.setVisible(true);
                aliceContent.txt_aliceDiffieHellman2.setVisible(true);
                aliceContent.txt_aliceDiffieHellman3.setVisible(true);
                aliceContent.cmp_aliceArrowSpace1.setVisible(true);
                aliceContent.cmp_aliceArrowSpace2.setVisible(true);
                aliceContent.grp_aliceDecryptedMessage.setVisible(true);

                swtParent.grp_bobAlgorithm.setVisible(true);
                swtParent.grp_bobSteps.setVisible(true);
                bobContent.grp_bobDiffieHellman.setVisible(true);
                bobContent.grp_bobRootChain.setVisible(true);
                bobContent.grp_bobSendingChain.setVisible(true);
                bobContent.txt_bobDiffieHellman1.setVisible(true);
                bobContent.txt_bobDiffieHellman2.setVisible(true);
                bobContent.txt_bobDiffieHellman3.setVisible(true);
                bobContent.txt_bobRootChain1.setVisible(true);
                bobContent.txt_bobRootChain2.setVisible(true);
                bobContent.txt_bobRootChain3.setVisible(true);
                bobContent.txt_bobSendingChain1.setVisible(true);
                bobContent.txt_bobSendingChain2.setVisible(true);
                bobContent.txt_bobSendingChain3.setVisible(true);
                bobContent.txt_bobSendingChain4.setVisible(true);
                bobContent.txt_bobSendingChain5.setVisible(true);
                bobContent.txt_bobCipherText.setVisible(true);
                bobContent.cmp_bobArrowSpace1.setVisible(true);
                bobContent.cmp_bobArrowSpace2.setVisible(true);
                bobContent.grp_bobMessagebox.setVisible(true);
                bobContent.arr_bobSendingChainArrow1.setVisible(true);
                bobContent.arr_bobSendingChainArrow2.setVisible(true);
                bobContent.arr_bobSendingChainArrow3.setVisible(true);

                // Show Steps
                bobContent.txt_bobSendingStep1.setVisible(true);
                bobContent.txt_bobSendingStep2.setVisible(true);
                bobContent.txt_bobSendingStep3.setVisible(true);
                bobContent.txt_bobSendingStep4.setVisible(true);
                bobContent.txt_bobSendingStep5.setVisible(true);
                aliceContent.txt_aliceReceivingStep5.setVisible(true);
                aliceContent.txt_aliceReceivingStep6.setVisible(true);
                aliceContent.txt_aliceReceivingStep7.setVisible(true);
                aliceContent.txt_aliceReceivingStep8.setVisible(true);
                aliceContent.txt_aliceReceivingStep8.setVisible(true);

                // Show these labels
                aliceContent.txt_alicePlainText.setVisible(true);
                aliceContent.txt_aliceReceivingStep9.setVisible(true);
                var decryptedMessage = AlgorithmState.get().getCommunication().current()
                        .getDecryptedMessage();
                if (decryptedMessage.isPresent()) {
                    aliceContent.txt_alicePlainText.setText(decryptedMessage.get());
                } else {
                    LogUtil.logError(new SignalAlgorithmException(), true);
                }
                // On this transition, update all key details as well
                updateSendingKeyDisplayInformation(swtParent);
                updateReceivingKeyDisplayInformation(swtParent);
            }

            @Override
            public DoubleRatchetStep next(DoubleRatchetView swtParent) {
                swtParent.switchSenderReceiver();
                AlgorithmState.get().getCommunication().next();
                AliceSendingStep.STEP_0.switchState(swtParent);
                return AliceSendingStep.STEP_0;
            }

            @Override
            public DoubleRatchetStep back(DoubleRatchetView swtParent) {
                STEP_8.switchState(swtParent);
                return STEP_8;
            }
        };

        protected abstract void switchState(DoubleRatchetView swtParent);

        public BobSendingStep setInitialState(DoubleRatchetView swtParent) {
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
        currentStep = BobSendingStep.STEP_0.setInitialState(swtParent);
    }

    public DoubleRatchetStep getCurrentState() {
        return currentStep;
    }

    /**
     * Get user input from UI and give it to the encryption algorithm.
     */
    private static void encryptMessage(DoubleRatchetView view) {
        var message = view.getBobSendingContent().txt_bobPlainText.getText();
        var communication = AlgorithmState.get().getCommunication();
        try {
            communication.encrypt(message);
        } catch (SignalAlgorithmException e) {
            LogUtil.logError(SignalEncryptionPlugin.PLUGIN_ID,
                    "Sorry, that shouldn't have happened, must restart", e, true);
            view.resetAll();
        }
    }
    
    private static void updateSendingKeyDisplayInformation(DoubleRatchetView view) {
        var bobContent = view.getBobSendingContent();
        var ctx = AlgorithmState.get().getCommunication().current();
        PopupUtil.updatePopupFor(bobContent.txt_bobSendingChain5, ctx.senderChainChainKey());
        PopupUtil.updatePopupFor(bobContent.txt_bobSendingChain5, ctx.senderChainMessageKey());
        PopupUtil.updatePopupFor(bobContent.txt_bobRootChain3, ctx.senderRootChainKey());
		PopupUtil.updatePopupFor(bobContent.txt_bobDiffieHellman3, ctx.diffieHellmanSenderPrivateKey());
		PopupUtil.updatePopupFor(bobContent.txt_bobDiffieHellman2, ctx.diffieHellmanSenderAgreedKey());
		PopupUtil.updatePopupFor(bobContent.txt_bobDiffieHellman2, ctx.diffieHellmanSenderPublicKey());
        var aliceContent = view.getAliceReceivingContent();
		PopupUtil.updatePopupFor(aliceContent.txt_aliceRootChain3, ctx.receiverRootChainKey());
		PopupUtil.updatePopupFor(aliceContent.txt_aliceDiffieHellman3, ctx.diffieHellmanReceiverPrivateKey());
		PopupUtil.updatePopupFor(aliceContent.txt_aliceDiffieHellman2, ctx.diffieHellmanReceiverAgreedKey());
		PopupUtil.updatePopupFor(aliceContent.txt_aliceDiffieHellman1, ctx.diffieHellmanReceiverPublicKey());
    }
	private static void updateReceivingKeyDisplayInformation(DoubleRatchetView view) {
		var aliceContent = view.getAliceReceivingContent();
		var ctx = AlgorithmState.get().getCommunication().current();
		PopupUtil.updatePopupFor(aliceContent.txt_aliceReceivingChain5, ctx.receiverChainChainKey());
		PopupUtil.updatePopupFor(aliceContent.txt_aliceReceivingChain4, ctx.receiverChainMessageKey());
	}
}
