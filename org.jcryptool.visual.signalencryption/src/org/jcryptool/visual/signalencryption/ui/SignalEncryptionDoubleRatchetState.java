package org.jcryptool.visual.signalencryption.ui;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class SignalEncryptionDoubleRatchetState {
    
    public enum STATE {
        STEP_0{
            @Override
            protected void switchState(SignalEncryptionViewDoubleRatchet parent) {
                
                // Hide these Elements
                parent.grp_bobAlgorithm.setVisible(false);
                parent.grp_bobSendingChain.setVisible(false);
                parent.grp_bobReceivingChain.setVisible(false);
                parent.grp_bobRootChain.setVisible(false);
                parent.grp_bobDiffieHellman.setVisible(false);
                parent.lb_bobSendingChain1.setVisible(false);
                parent.lb_bobSendingChain2.setVisible(false);
                parent.lb_bobSendingChain3.setVisible(false);
                parent.lb_bobSendingChain4.setVisible(false);
                parent.lb_bobSendingChain5.setVisible(false);
                parent.lb_bobReceivingChain1.setVisible(false);
                parent.lb_bobReceivingChain2.setVisible(false);
                parent.lb_bobReceivingChain3.setVisible(false);
                parent.lb_bobReceivingChain4.setVisible(false);
                parent.lb_bobReceivingChain5.setVisible(false);
                parent.lb_bobRootChain1.setVisible(false);
                parent.lb_bobRootChain2.setVisible(false);
                parent.lb_bobRootChain3.setVisible(false);
                parent.lb_bobDiffieHellman1.setVisible(false);
                parent.lb_bobDiffieHellman2.setVisible(false);
                parent.lb_bobDiffieHellman3.setVisible(false);
                parent.grp_aliceAlgorithm.setVisible(false);
                parent.grp_aliceDiffieHellman.setVisible(false);
                parent.grp_aliceRootChain.setVisible(false);
                parent.grp_aliceSendingChain.setVisible(false);
                parent.grp_aliceReceivingChain.setVisible(false);
                parent.lb_aliceDiffieHellman1.setVisible(false);
                parent.lb_aliceDiffieHellman2.setVisible(false);
                parent.lb_aliceDiffieHellman3.setVisible(false);
                parent.lb_aliceRootChain1.setVisible(false);
                parent.lb_aliceRootChain2.setVisible(false);
                parent.lb_aliceRootChain3.setVisible(false);
                parent.lb_aliceSendingChain1.setVisible(false);
                parent.lb_aliceSendingChain2.setVisible(false);
                parent.lb_aliceSendingChain3.setVisible(false);
                parent.lb_aliceSendingChain4.setVisible(false);
                parent.lb_aliceSendingChain5.setVisible(false);
                parent.lb_aliceReceivingChain1.setVisible(false);
                parent.lb_aliceReceivingChain2.setVisible(false);
                parent.lb_aliceReceivingChain3.setVisible(false);
                parent.lb_aliceReceivingChain4.setVisible(false);
                parent.lb_aliceReceivingChain5.setVisible(false);
                parent.txt_step1.setVisible(false);
                parent.txt_step2.setVisible(false);
                parent.txt_step3.setVisible(false);
                parent.txt_step4.setVisible(false);
                parent.txt_aliceStep5.setVisible(false);
                parent.txt_bobStep5.setVisible(false);
                parent.txt_step6.setVisible(false);
                parent.txt_step7.setVisible(false);
                parent.txt_step8.setVisible(false);
                parent.txt_step9.setVisible(false);
                parent.txt_aliceCipherText.setVisible(false);
                parent.txt_bobPlainText.setVisible(false);
            }

            @Override
            STATE next(SignalEncryptionViewDoubleRatchet parent) {
                STEP_1.switchState(parent);
                return STEP_1;
            }

            @Override
            STATE back(SignalEncryptionViewDoubleRatchet parent) {
                return STEP_0;
            }
            
        }, STEP_1 {

            @Override
            protected void switchState(SignalEncryptionViewDoubleRatchet parent) {
                // Show these labels
                parent.grp_aliceAlgorithm.setVisible(true);
                parent.grp_aliceDiffieHellman.setVisible(true);
                parent.lb_aliceDiffieHellman1.setVisible(true);
                parent.lb_aliceDiffieHellman2.setVisible(true);
                parent.lb_aliceDiffieHellman3.setVisible(true);
                parent.txt_step1.setVisible(true);
                
                
                // Hide these Elements
                parent.grp_aliceRootChain.setVisible(false);
                parent.lb_aliceRootChain1.setVisible(false);
                parent.lb_aliceRootChain2.setVisible(false);
                parent.lb_aliceRootChain3.setVisible(false);
                parent.grp_aliceRootChain.setVisible(false);
                
                parent.txt_step2.setVisible(false);
            }

            @Override
            STATE next(SignalEncryptionViewDoubleRatchet parent) {
                parent.signalEncryptionState.stepForward(parent.signalEncryptionState);
                STEP_2.switchState(parent);
                return STEP_2;
            }

            @Override
            STATE back(SignalEncryptionViewDoubleRatchet parent) {
                parent.signalEncryptionState.stepBack(parent.signalEncryptionState);
                STEP_0.switchState(parent);
                return STEP_0;
            }
            
        }, STEP_2 {

            @Override
            protected void switchState(SignalEncryptionViewDoubleRatchet parent) {
                
                // Show these labels




                parent.grp_aliceRootChain.setVisible(true);
                parent.lb_aliceRootChain1.setVisible(true);
                parent.lb_aliceRootChain2.setVisible(true);
                parent.lb_aliceRootChain3.setVisible(true);
                parent.grp_aliceRootChain.setVisible(true);
                
                parent.txt_step2.setVisible(true);

                
                // Hide these Elements
                parent.grp_aliceSendingChain.setVisible(false);
                
                parent.lb_aliceSendingChain1.setVisible(false);
                parent.lb_aliceSendingChain2.setVisible(false);
                parent.lb_aliceSendingChain3.setVisible(false);
                parent.lb_aliceSendingChain4.setVisible(false);
                parent.lb_aliceSendingChain5.setVisible(false);

                parent.txt_step3.setVisible(false);
            }

            @Override
            STATE next(SignalEncryptionViewDoubleRatchet parent) {
                parent.signalEncryptionState.stepForward(parent.signalEncryptionState);
                STEP_3.switchState(parent);
                return STEP_3;
            }

            @Override
            STATE back(SignalEncryptionViewDoubleRatchet parent) {
                parent.signalEncryptionState.stepBack(parent.signalEncryptionState);
                STEP_1.switchState(parent);
                return STEP_1;
            }
            
        }, STEP_3{

            @Override
            protected void switchState(SignalEncryptionViewDoubleRatchet parent) {


                // Show these labels

                parent.grp_aliceSendingChain.setVisible(true);
                
                parent.lb_aliceSendingChain1.setVisible(true);
                parent.lb_aliceSendingChain2.setVisible(true);
                parent.lb_aliceSendingChain3.setVisible(true);
                parent.lb_aliceSendingChain4.setVisible(true);
                parent.lb_aliceSendingChain5.setVisible(true);

                parent.txt_step3.setVisible(true);
                
                
                
                // Hide these Elements            
                parent.grp_aliceReceivingChain.setVisible(false);
                
                parent.lb_aliceReceivingChain1.setVisible(false);
                parent.lb_aliceReceivingChain2.setVisible(false);
                parent.lb_aliceReceivingChain3.setVisible(false);
                parent.lb_aliceReceivingChain4.setVisible(false);
                parent.lb_aliceReceivingChain5.setVisible(false);
                
                parent.grp_bobSendingChain.setVisible(false);

                parent.txt_step4.setVisible(false);
            }

            @Override
            STATE next(SignalEncryptionViewDoubleRatchet parent) {
                STEP_4.switchState(parent);
                return STEP_4;
            }

            @Override
            STATE back(SignalEncryptionViewDoubleRatchet parent) {
                STEP_2.switchState(parent);
                return STEP_2;
            }
            
        }, STEP_4 {

            @Override
            protected void switchState(SignalEncryptionViewDoubleRatchet parent) {
                
                // Show these labels
                parent.grp_aliceReceivingChain.setVisible(true);
                parent.grp_bobSendingChain.setVisible(true);
                
                parent.showAliceMessageBox();
                
                parent.txt_step4.setVisible(true);
                                
                // Hide these Elements
                parent.txt_aliceCipherText.setVisible(false);
                parent.txt_bobCipherText.setVisible(false);
                parent.grp_bobAlgorithm.setVisible(false);
                parent.txt_aliceStep5.setVisible(false);
                parent.txt_bobStep5.setVisible(false);
            }

            @Override
            STATE next(SignalEncryptionViewDoubleRatchet parent) {
                STEP_5.switchState(parent);
                return STEP_5;
            }

            @Override
            STATE back(SignalEncryptionViewDoubleRatchet parent) {
                STEP_3.switchState(parent);
                return STEP_3;
            }
            
        }, STEP_5 {

            @Override
            protected void switchState(SignalEncryptionViewDoubleRatchet parent) {
                
                // Show these labels

                parent.grp_bobAlgorithm.setVisible(true);
                parent.showBobMessageBox();
                parent.txt_aliceCipherText.setVisible(true);
                parent.txt_bobCipherText.setVisible(true);
                parent.txt_aliceStep5.setVisible(true);
                parent.txt_bobStep5.setVisible(true);
                
                // Hide these Elements
                parent.grp_bobDiffieHellman.setVisible(false);
                parent.lb_bobDiffieHellman1.setVisible(false);
                parent.lb_bobDiffieHellman2.setVisible(false);
                parent.lb_bobDiffieHellman3.setVisible(false);
                parent.txt_step6.setVisible(false);
               
                
            }

            @Override
            STATE next(SignalEncryptionViewDoubleRatchet parent) {
                STEP_6.switchState(parent);
                return STEP_6;
            }

            @Override
            STATE back(SignalEncryptionViewDoubleRatchet parent) {
                STEP_4.switchState(parent);
                return STEP_4;
            }
            
        }, STEP_6 {

            @Override
            protected void switchState(SignalEncryptionViewDoubleRatchet parent) {
                
                // Show these labels
                parent.grp_bobDiffieHellman.setVisible(true);
                parent.lb_bobDiffieHellman1.setVisible(true);
                parent.lb_bobDiffieHellman2.setVisible(true);
                parent.lb_bobDiffieHellman3.setVisible(true);
                parent.txt_step6.setVisible(true);
                
                // Hide these Elements
                parent.grp_bobRootChain.setVisible(false);
                parent.lb_bobRootChain1.setVisible(false);
                parent.lb_bobRootChain2.setVisible(false);
                parent.lb_bobRootChain3.setVisible(false);
                parent.txt_step7.setVisible(false);

            }

            @Override
            STATE next(SignalEncryptionViewDoubleRatchet parent) {
                STEP_7.switchState(parent);
                return STEP_7;
            }

            @Override
            STATE back(SignalEncryptionViewDoubleRatchet parent) {
                STEP_5.switchState(parent);
                return STEP_5;
            }
            
        }, STEP_7 {

            @Override
            protected void switchState(SignalEncryptionViewDoubleRatchet parent) {
                

                // Show these labels
                parent.grp_bobRootChain.setVisible(true);
                parent.lb_bobRootChain1.setVisible(true);
                parent.lb_bobRootChain2.setVisible(true);
                parent.lb_bobRootChain3.setVisible(true);
                parent.txt_step7.setVisible(true);
                
                // Hide these Elements
                parent.grp_bobReceivingChain.setVisible(false);
                parent.lb_bobReceivingChain1.setVisible(false);
                parent.lb_bobReceivingChain2.setVisible(false);
                parent.lb_bobReceivingChain3.setVisible(false);
                parent.lb_bobReceivingChain4.setVisible(false);
                parent.lb_bobReceivingChain5.setVisible(false);
                parent.txt_step8.setVisible(false);
                

            }

            @Override
            STATE next(SignalEncryptionViewDoubleRatchet parent) {
                STEP_8.switchState(parent);
                return STEP_8;
            }

            @Override
            STATE back(SignalEncryptionViewDoubleRatchet parent) {
                STEP_6.switchState(parent);
                return STEP_6;
            }
            
        }, STEP_8 {

            @Override
            protected void switchState(SignalEncryptionViewDoubleRatchet parent) {

                // Show these labels
                parent.grp_bobReceivingChain.setVisible(true);
                parent.lb_bobReceivingChain1.setVisible(true);
                parent.lb_bobReceivingChain2.setVisible(true);
                parent.lb_bobReceivingChain3.setVisible(true);
                parent.lb_bobReceivingChain4.setVisible(true);
                parent.lb_bobReceivingChain5.setVisible(true);

                parent.txt_step8.setVisible(true);
                
                // Hide these Elements
                parent.txt_step9.setVisible(false);
                parent.txt_bobPlainText.setVisible(false);
            }

            @Override
            STATE next(SignalEncryptionViewDoubleRatchet parent) {
                STEP_9.switchState(parent);
                return STEP_9;
            }

            @Override
            STATE back(SignalEncryptionViewDoubleRatchet parent) {
                STEP_7.switchState(parent);
                return STEP_7;
            }
            
        }, STEP_9 {

            @Override
            protected void switchState(SignalEncryptionViewDoubleRatchet parent) {
                
                // Show these labels
                parent.txt_bobPlainText.setVisible(true);
                parent.txt_step9.setVisible(true);

            }

            @Override
            STATE next(SignalEncryptionViewDoubleRatchet parent) {
                return STEP_9;
            }

            @Override
            STATE back(SignalEncryptionViewDoubleRatchet parent) {
                STEP_8.switchState(parent);
                return STEP_8;
            }
            
        };
//        , STEP_10 {
//
//            @Override
//            protected void switchState(SignalEncryptionViewDoubleRatchet parent) {
//                
//             
//
//            }
//
//            @Override
//            STATE next(SignalEncryptionViewDoubleRatchet parent) {
//                return STEP_10;
//            }
//
//            @Override
//            STATE back(SignalEncryptionViewDoubleRatchet parent) {
//                STEP_9.switchState(parent);
//                return STEP_9;
//            }
//            
//        };
        
        protected abstract void switchState(SignalEncryptionViewDoubleRatchet parent);
        abstract STATE next(SignalEncryptionViewDoubleRatchet parent);
        abstract STATE back(SignalEncryptionViewDoubleRatchet parent);
        public STATE setInitialState(SignalEncryptionViewDoubleRatchet parent) {
            STEP_0.switchState(parent);
            return STEP_0;
        }
    }
}
