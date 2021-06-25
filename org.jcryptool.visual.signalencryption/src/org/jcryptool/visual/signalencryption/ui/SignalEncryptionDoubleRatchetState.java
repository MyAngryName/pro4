package org.jcryptool.visual.signalencryption.ui;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.jcryptool.visual.signalencryption.ui.SignalEncryptionAlgorithmState.STATE;

public class SignalEncryptionDoubleRatchetState {
    
    private STATE currentState = STATE.STEP_0;
    
    public SignalEncryptionDoubleRatchetState(SignalEncryptionViewDoubleRatchet swtParent) {
        currentState = STATE.STEP_0.setInitialState(swtParent, this);
    } 
    
    public enum STATE {
        STEP_0{
            @Override
            protected void switchState(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                
                // Hide these Elements
                swtParent.grp_bobAlgorithm.setVisible(false);
                swtParent.grp_bobSendingChain.setVisible(false);
                swtParent.grp_bobReceivingChain.setVisible(false);
                swtParent.grp_bobRootChain.setVisible(false);
                swtParent.grp_bobDiffieHellman.setVisible(false);
                swtParent.lb_bobSendingChain1.setVisible(false);
                swtParent.lb_bobSendingChain2.setVisible(false);
                swtParent.lb_bobSendingChain3.setVisible(false);
                swtParent.lb_bobSendingChain4.setVisible(false);
                swtParent.lb_bobSendingChain5.setVisible(false);
                swtParent.lb_bobReceivingChain1.setVisible(false);
                swtParent.lb_bobReceivingChain2.setVisible(false);
                swtParent.lb_bobReceivingChain3.setVisible(false);
                swtParent.lb_bobReceivingChain4.setVisible(false);
                swtParent.lb_bobReceivingChain5.setVisible(false);
                swtParent.lb_bobRootChain1.setVisible(false);
                swtParent.lb_bobRootChain2.setVisible(false);
                swtParent.lb_bobRootChain3.setVisible(false);
                swtParent.lb_bobDiffieHellman1.setVisible(false);
                swtParent.lb_bobDiffieHellman2.setVisible(false);
                swtParent.lb_bobDiffieHellman3.setVisible(false);
                swtParent.grp_aliceAlgorithm.setVisible(false);
                swtParent.grp_aliceDiffieHellman.setVisible(false);
                swtParent.grp_aliceRootChain.setVisible(false);
                swtParent.grp_aliceSendingChain.setVisible(false);
                swtParent.grp_aliceReceivingChain.setVisible(false);
                swtParent.lb_aliceDiffieHellman1.setVisible(false);
                swtParent.lb_aliceDiffieHellman2.setVisible(false);
                swtParent.lb_aliceDiffieHellman3.setVisible(false);
                swtParent.lb_aliceRootChain1.setVisible(false);
                swtParent.lb_aliceRootChain2.setVisible(false);
                swtParent.lb_aliceRootChain3.setVisible(false);
                swtParent.lb_aliceSendingChain1.setVisible(false);
                swtParent.lb_aliceSendingChain2.setVisible(false);
                swtParent.lb_aliceSendingChain3.setVisible(false);
                swtParent.lb_aliceSendingChain4.setVisible(false);
                swtParent.lb_aliceSendingChain5.setVisible(false);
                swtParent.lb_aliceReceivingChain1.setVisible(false);
                swtParent.lb_aliceReceivingChain2.setVisible(false);
                swtParent.lb_aliceReceivingChain3.setVisible(false);
                swtParent.lb_aliceReceivingChain4.setVisible(false);
                swtParent.lb_aliceReceivingChain5.setVisible(false);
                swtParent.txt_step1.setVisible(false);
                swtParent.txt_step2.setVisible(false);
                swtParent.txt_step3.setVisible(false);
                swtParent.txt_step4.setVisible(false);
                swtParent.txt_aliceStep5.setVisible(false);
                swtParent.txt_bobStep5.setVisible(false);
                swtParent.txt_step6.setVisible(false);
                swtParent.txt_step7.setVisible(false);
                swtParent.txt_step8.setVisible(false);
                swtParent.txt_step9.setVisible(false);
                swtParent.txt_aliceCipherText.setVisible(false);
                swtParent.txt_bobPlainText.setVisible(false);
            }

            @Override
            STATE next(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                STEP_1.switchState(swtParent, parent);
                return STEP_1;
            }

            @Override
            STATE back(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                return STEP_0;
            }
            
        }, STEP_1 {

            @Override
            protected void switchState(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                // Show these labels
                swtParent.grp_aliceAlgorithm.setVisible(true);
                swtParent.grp_aliceDiffieHellman.setVisible(true);
                swtParent.lb_aliceDiffieHellman1.setVisible(true);
                swtParent.lb_aliceDiffieHellman2.setVisible(true);
                swtParent.lb_aliceDiffieHellman3.setVisible(true);
                swtParent.txt_step1.setVisible(true);
                
                
                // Hide these Elements
                swtParent.grp_aliceRootChain.setVisible(false);
                swtParent.lb_aliceRootChain1.setVisible(false);
                swtParent.lb_aliceRootChain2.setVisible(false);
                swtParent.lb_aliceRootChain3.setVisible(false);
                swtParent.grp_aliceRootChain.setVisible(false);
                
                swtParent.txt_step2.setVisible(false);
                
                //swtParent.signalEncryptionState.saveMessageAlice("Hello World");
                swtParent.txt_aliceCipherText.setText(swtParent.signalEncryptionState.getAliceEncryptedMessage());

            }

            @Override
            STATE next(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                STEP_2.switchState(swtParent, parent);
                return STEP_2;
            }

            @Override
            STATE back(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                STEP_0.switchState(swtParent, parent);
                return STEP_0;
            }
            
        }, STEP_2 {

            @Override
            protected void switchState(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                
                // Show these labels
                swtParent.grp_aliceRootChain.setVisible(true);
                swtParent.lb_aliceRootChain1.setVisible(true);
                swtParent.lb_aliceRootChain2.setVisible(true);
                swtParent.lb_aliceRootChain3.setVisible(true);
                swtParent.grp_aliceRootChain.setVisible(true);
                
                swtParent.txt_step2.setVisible(true);

                
                // Hide these Elements
                swtParent.grp_aliceSendingChain.setVisible(false);
                
                swtParent.lb_aliceSendingChain1.setVisible(false);
                swtParent.lb_aliceSendingChain2.setVisible(false);
                swtParent.lb_aliceSendingChain3.setVisible(false);
                swtParent.lb_aliceSendingChain4.setVisible(false);
                swtParent.lb_aliceSendingChain5.setVisible(false);

                swtParent.txt_step3.setVisible(false);
                
                // State

            }

            @Override
            STATE next(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                STEP_3.switchState(swtParent, parent);
                return STEP_3;
            }

            @Override
            STATE back(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                STEP_1.switchState(swtParent, parent);
                return STEP_1;
            }
            
        }, STEP_3{

            @Override
            protected void switchState(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {


                // Show these labels

                swtParent.grp_aliceSendingChain.setVisible(true);
                
                swtParent.lb_aliceSendingChain1.setVisible(true);
                swtParent.lb_aliceSendingChain2.setVisible(true);
                swtParent.lb_aliceSendingChain3.setVisible(true);
                swtParent.lb_aliceSendingChain4.setVisible(true);
                swtParent.lb_aliceSendingChain5.setVisible(true);

                swtParent.txt_step3.setVisible(true);
                
                
                
                // Hide these Elements            
                swtParent.grp_aliceReceivingChain.setVisible(false);
                
                swtParent.lb_aliceReceivingChain1.setVisible(false);
                swtParent.lb_aliceReceivingChain2.setVisible(false);
                swtParent.lb_aliceReceivingChain3.setVisible(false);
                swtParent.lb_aliceReceivingChain4.setVisible(false);
                swtParent.lb_aliceReceivingChain5.setVisible(false);
                
                swtParent.grp_bobSendingChain.setVisible(false);

                swtParent.txt_step4.setVisible(false);
            }

            @Override
            STATE next(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                STEP_4.switchState(swtParent, parent);
                return STEP_4;
            }

            @Override
            STATE back(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                STEP_2.switchState(swtParent, parent);
                return STEP_2;
            }
            
        }, STEP_4 {

            @Override
            protected void switchState(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                
                // Show these labels
                swtParent.grp_aliceReceivingChain.setVisible(true);
                swtParent.grp_bobSendingChain.setVisible(true);
                
                swtParent.showAliceMessageBox();
                
                swtParent.txt_step4.setVisible(true);
                                
                // Hide these Elements
                swtParent.txt_aliceCipherText.setVisible(false);
                swtParent.txt_bobCipherText.setVisible(false);
                swtParent.grp_bobAlgorithm.setVisible(false);
                swtParent.txt_aliceStep5.setVisible(false);
                swtParent.txt_bobStep5.setVisible(false);
                
                

            }

            @Override
            STATE next(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                swtParent.signalEncryptionState.saveMessageAlice(swtParent.txt_alicePlainText.getText());
                swtParent.signalEncryptionState.stepForward(swtParent.signalEncryptionState);
                STEP_5.switchState(swtParent, parent);
                return STEP_5;
            }

            @Override
            STATE back(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                swtParent.signalEncryptionState.stepBack(swtParent.signalEncryptionState);
                STEP_3.switchState(swtParent, parent);
                return STEP_3;
            }
            
        }, STEP_5 {

            @Override
            protected void switchState(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                
                // Show these labels

                swtParent.grp_bobAlgorithm.setVisible(true);
                swtParent.showBobMessageBox();
                swtParent.txt_aliceCipherText.setVisible(true);
                swtParent.txt_bobCipherText.setVisible(true);
                swtParent.txt_aliceStep5.setVisible(true);
                swtParent.txt_bobStep5.setVisible(true);
                
                // Hide these Elements
                swtParent.grp_bobDiffieHellman.setVisible(false);
                swtParent.lb_bobDiffieHellman1.setVisible(false);
                swtParent.lb_bobDiffieHellman2.setVisible(false);
                swtParent.lb_bobDiffieHellman3.setVisible(false);
                swtParent.txt_step6.setVisible(false);
               
                // State
                swtParent.txt_aliceCipherText.setText(swtParent.signalEncryptionState.getAliceEncryptedMessage());
                swtParent.txt_bobCipherText.setText(swtParent.signalEncryptionState.getAliceEncryptedMessage());

            }

            @Override
            STATE next(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                swtParent.signalEncryptionState.stepForward(swtParent.signalEncryptionState);
                STEP_6.switchState(swtParent, parent);
                return STEP_6;
            }

            @Override
            STATE back(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                swtParent.signalEncryptionState.stepBack(swtParent.signalEncryptionState);
                STEP_4.switchState(swtParent, parent);
                return STEP_4;
            }
            
        }, STEP_6 {

            @Override
            protected void switchState(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                
                // Show these labels
                swtParent.grp_bobDiffieHellman.setVisible(true);
                swtParent.lb_bobDiffieHellman1.setVisible(true);
                swtParent.lb_bobDiffieHellman2.setVisible(true);
                swtParent.lb_bobDiffieHellman3.setVisible(true);
                swtParent.txt_step6.setVisible(true);
                
                // Hide these Elements
                swtParent.grp_bobRootChain.setVisible(false);
                swtParent.lb_bobRootChain1.setVisible(false);
                swtParent.lb_bobRootChain2.setVisible(false);
                swtParent.lb_bobRootChain3.setVisible(false);
                swtParent.txt_step7.setVisible(false);
                
                swtParent.txt_bobPlainText.setText(swtParent.signalEncryptionState.getBobMessage());
                swtParent.txt_bobPlainText.setVisible(true);

            }

            @Override
            STATE next(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                swtParent.signalEncryptionState.stepForward(swtParent.signalEncryptionState);
                STEP_7.switchState(swtParent, parent);
                return STEP_7;
            }

            @Override
            STATE back(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                swtParent.signalEncryptionState.stepBack(swtParent.signalEncryptionState);
                STEP_5.switchState(swtParent, parent);
                return STEP_5;
            }
            
        }, STEP_7 {

            @Override
            protected void switchState(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                

                // Show these labels
                swtParent.grp_bobRootChain.setVisible(true);
                swtParent.lb_bobRootChain1.setVisible(true);
                swtParent.lb_bobRootChain2.setVisible(true);
                swtParent.lb_bobRootChain3.setVisible(true);
                swtParent.txt_step7.setVisible(true);
                
                // Hide these Elements
                swtParent.grp_bobReceivingChain.setVisible(false);
                swtParent.lb_bobReceivingChain1.setVisible(false);
                swtParent.lb_bobReceivingChain2.setVisible(false);
                swtParent.lb_bobReceivingChain3.setVisible(false);
                swtParent.lb_bobReceivingChain4.setVisible(false);
                swtParent.lb_bobReceivingChain5.setVisible(false);
                swtParent.txt_step8.setVisible(false);
                

            }

            @Override
            STATE next(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                STEP_8.switchState(swtParent, parent);
                return STEP_8;
            }

            @Override
            STATE back(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                STEP_6.switchState(swtParent, parent);
                return STEP_6;
            }
            
        }, STEP_8 {

            @Override
            protected void switchState(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {

                // Show these labels
                swtParent.grp_bobReceivingChain.setVisible(true);
                swtParent.lb_bobReceivingChain1.setVisible(true);
                swtParent.lb_bobReceivingChain2.setVisible(true);
                swtParent.lb_bobReceivingChain3.setVisible(true);
                swtParent.lb_bobReceivingChain4.setVisible(true);
                swtParent.lb_bobReceivingChain5.setVisible(true);

                swtParent.txt_step8.setVisible(true);
                
                // Hide these Elements
                swtParent.txt_step9.setVisible(false);
                swtParent.txt_bobPlainText.setVisible(false);
            }

            @Override
            STATE next(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                STEP_9.switchState(swtParent, parent);
                return STEP_9;
            }

            @Override
            STATE back(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                STEP_7.switchState(swtParent, parent);
                return STEP_7;
            }
            
        }, STEP_9 {

            @Override
            protected void switchState(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                
                // Show these labels
                swtParent.txt_bobPlainText.setVisible(true);
                swtParent.txt_step9.setVisible(true);
                


            }

            @Override
            STATE next(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                return STEP_9;
            }

            @Override
            STATE back(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                STEP_8.switchState(swtParent, parent);
                return STEP_8;
            }
            
        };
//        , STEP_10 {
//
//            @Override
//            protected void switchState(SignalEncryptionViewDoubleRatchet swtParent) {
//                
//             
//
//            }
//
//            @Override
//            STATE next(SignalEncryptionViewDoubleRatchet swtParent) {
//                return STEP_10;
//            }
//
//            @Override
//            STATE back(SignalEncryptionViewDoubleRatchet swtParent) {
//                STEP_9.switchState(swtParent);
//                return STEP_9;
//            }
//            
//        };
        
        protected abstract void switchState(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent);
        abstract STATE next(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent);
        abstract STATE back(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent);
        public STATE setInitialState(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
            STEP_0.switchState(swtParent, parent);
            return STEP_0;
        }
    }
    public void stepForward(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
        currentState = currentState.next(swtParent, parent);
    }
    public void stepBack(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
        currentState = currentState.back(swtParent, parent);
    }
    public void reset(SignalEncryptionViewDoubleRatchet swtParent) {
        currentState = STATE.STEP_0.setInitialState(swtParent, this);
    }
    public STATE getCurrentState() {
        return currentState;
    }
}
