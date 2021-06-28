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
    private static int counter = 0;
    private static int counterAliceEncryptedMessage = 0;
    private static int counterBobMessage = 0;
    private static int globalCounter = 0;
    private static Singleton singelton;
    private SignalEncryptionViewDoubleRatchet GlobalSwtParent;
    
    public SignalEncryptionDoubleRatchetState(SignalEncryptionViewDoubleRatchet swtParent) {
        currentState = STATE.STEP_0.setInitialState(swtParent, this);
        this.GlobalSwtParent = swtParent;
    } 
    
    public enum STATE {
        STEP_0{
            @Override
            protected void switchState(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                
                // Hide these Elements
                swtParent.grp_bobAlgorithm.setVisible(false);
                swtParent.grp_bobSendingReceivingChain.setVisible(false);
                swtParent.grp_bobRootChain.setVisible(false);
                swtParent.grp_bobDiffieHellman.setVisible(false);
                swtParent.txt_bobSendingChain1.setVisible(false);
                swtParent.txt_bobSendingChain2.setVisible(false);
                swtParent.txt_bobSendingChain3.setVisible(false);
                swtParent.txt_bobSendingChain4.setVisible(false);
                swtParent.txt_bobSendingChain5.setVisible(false);
                swtParent.txt_bobReceivingChain1.setVisible(false);
                swtParent.txt_bobReceivingChain2.setVisible(false);
                swtParent.txt_bobReceivingChain3.setVisible(false);
                swtParent.txt_bobReceivingChain4.setVisible(false);
                swtParent.txt_bobReceivingChain5.setVisible(false);
                swtParent.txt_bobRootChain1.setVisible(false);
                swtParent.txt_bobRootChain2.setVisible(false);
                swtParent.txt_bobRootChain3.setVisible(false);
                swtParent.txt_bobDiffieHellman1.setVisible(false);
                swtParent.txt_bobDiffieHellman2.setVisible(false);
                swtParent.txt_bobDiffieHellman3.setVisible(false);
                swtParent.grp_aliceAlgorithm.setVisible(false);
                swtParent.grp_aliceDiffieHellman.setVisible(false);
                swtParent.grp_aliceRootChain.setVisible(false);
                swtParent.grp_aliceSendingReceivingChain.setVisible(false);
                swtParent.txt_aliceDiffieHellman1.setVisible(false);
                swtParent.txt_aliceDiffieHellman2.setVisible(false);
                swtParent.txt_aliceDiffieHellman3.setVisible(false);
                swtParent.txt_aliceRootChain1.setVisible(false);
                swtParent.txt_aliceRootChain2.setVisible(false);
                swtParent.txt_aliceRootChain3.setVisible(false);
                swtParent.txt_aliceSendingChain1.setVisible(false);
                swtParent.txt_aliceSendingChain2.setVisible(false);
                swtParent.txt_aliceSendingChain3.setVisible(false);
                swtParent.txt_aliceSendingChain4.setVisible(false);
                swtParent.txt_aliceSendingChain5.setVisible(false);
                swtParent.txt_aliceReceivingChain1.setVisible(false);
                swtParent.txt_aliceReceivingChain2.setVisible(false);
                swtParent.txt_aliceReceivingChain3.setVisible(false);
                swtParent.txt_aliceReceivingChain4.setVisible(false);
                swtParent.txt_aliceReceivingChain5.setVisible(false);
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
                swtParent.cmp_aliceArrowSpace1.setVisible(false);
                swtParent.cmp_aliceArrowSpace2.setVisible(false);
                swtParent.grp_aliceMessagebox.setVisible(false);
                swtParent.arr_aliceSendingChainArrow1.setVisible(false);
                swtParent.arr_aliceSendingChainArrow2.setVisible(false);
                swtParent.arr_aliceSendingChainArrow3.setVisible(false);
                swtParent.cmp_bobArrowSpace1.setVisible(false);
                swtParent.cmp_bobArrowSpace2.setVisible(false);
                
                
                counter = 0;
                counterAliceEncryptedMessage = 0;
                counterBobMessage = 0;
                globalCounter = 0;
                
                singelton = singelton.getInstance();
            }

            @Override
            STATE next(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                globalCounter++;
                singelton.unlock(parent, globalCounter);
                STEP_1.switchState(swtParent, parent);
                return STEP_1;
            }

            @Override
            STATE back(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                singelton.lock(parent, globalCounter);
                globalCounter--;
                return STEP_0;
            }

            @Override
            void updateText(SignalEncryptionViewDoubleRatchet swtParent) {
                // TODO Auto-generated method stub
                
            }

            @Override
            void saveText() {
                // TODO Auto-generated method stub
                
            }

            
        }, STEP_1 {

            @Override
            protected void switchState(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                // Show these labels
                swtParent.grp_aliceAlgorithm.setVisible(true);
                swtParent.grp_aliceDiffieHellman.setVisible(true);
                swtParent.txt_aliceDiffieHellman1.setVisible(true);
                swtParent.txt_aliceDiffieHellman2.setVisible(true);
                swtParent.txt_aliceDiffieHellman3.setVisible(true);
                swtParent.txt_step1.setVisible(true);
                
                
                // Hide these Elements
                swtParent.grp_aliceRootChain.setVisible(false);
                swtParent.txt_aliceRootChain1.setVisible(false);
                swtParent.txt_aliceRootChain2.setVisible(false);
                swtParent.txt_aliceRootChain3.setVisible(false);
                swtParent.grp_aliceRootChain.setVisible(false);
                swtParent.cmp_aliceArrowSpace1.setVisible(false);
                swtParent.txt_step2.setVisible(false);
                swtParent.grp_aliceSendingReceivingChain.setVisible(false);
                swtParent.txt_aliceSendingChain1.setVisible(false);
                swtParent.cmp_aliceArrowSpace2.setVisible(false);

                
                swtParent.txt_aliceCipherText.setText(swtParent.signalEncryptionState.getAliceEncryptedMessage(counterAliceEncryptedMessage));

            }

            @Override
            STATE next(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                globalCounter++;
                singelton.unlock(parent, globalCounter);
                STEP_2.switchState(swtParent, parent);
                return STEP_2;
            }

            @Override
            STATE back(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                singelton.lock(parent, globalCounter);
                globalCounter--;
                STEP_0.switchState(swtParent, parent);
                return STEP_0;
            }

            @Override
            void updateText(SignalEncryptionViewDoubleRatchet swtParent) {
                // TODO Auto-generated method stub
                
            }

            @Override
            void saveText() {
                // TODO Auto-generated method stub
                
            }

            
        }, STEP_2 {

            @Override
            protected void switchState(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                
                // Show these labels
                swtParent.grp_aliceRootChain.setVisible(true);
                swtParent.txt_aliceRootChain1.setVisible(true);
                swtParent.txt_aliceRootChain2.setVisible(true);
                swtParent.txt_aliceRootChain3.setVisible(true);
                swtParent.grp_aliceRootChain.setVisible(true);                
                swtParent.grp_aliceSendingReceivingChain.setVisible(true);
                swtParent.txt_aliceSendingChain1.setVisible(true);
                swtParent.arr_aliceSendingChainArrow4.setVisible(true);
                swtParent.cmp_aliceArrowSpace2.setVisible(true);
                
                swtParent.txt_step2.setVisible(true);
                swtParent.cmp_aliceArrowSpace1.setVisible(true);
                
                // Hide these Elements
                swtParent.txt_aliceReceivingChain1.setVisible(false);
                swtParent.txt_aliceSendingChain2.setVisible(false);
                swtParent.txt_aliceSendingChain3.setVisible(false);
                swtParent.txt_aliceSendingChain4.setVisible(false);
                swtParent.txt_aliceSendingChain5.setVisible(false);
                swtParent.txt_step3.setVisible(false);
                swtParent.arr_aliceSendingChainArrow1.setVisible(false);
                swtParent.arr_aliceSendingChainArrow2.setVisible(false);
                swtParent.arr_aliceSendingChainArrow3.setVisible(false);
                
                // State

            }

            @Override
            STATE next(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                globalCounter++;
                singelton.unlock(parent, globalCounter);
                STEP_3.switchState(swtParent, parent);
                return STEP_3;
            }

            @Override
            STATE back(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                singelton.lock(parent, globalCounter);
                globalCounter--;
                STEP_1.switchState(swtParent, parent);
                return STEP_1;
            }

            @Override
            void updateText(SignalEncryptionViewDoubleRatchet swtParent) {
                // TODO Auto-generated method stub
                
            }

            @Override
            void saveText() {
                // TODO Auto-generated method stub
                
            }
            
        }, STEP_3{

            @Override
            protected void switchState(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {


                // Show these labels


                swtParent.txt_aliceSendingChain2.setVisible(true);
                swtParent.txt_aliceSendingChain3.setVisible(true);
                swtParent.txt_aliceSendingChain4.setVisible(true);
                swtParent.txt_aliceSendingChain5.setVisible(true);
                swtParent.txt_step3.setVisible(true);
                swtParent.arr_aliceSendingChainArrow1.setVisible(true);
                swtParent.arr_aliceSendingChainArrow2.setVisible(true);
                swtParent.arr_aliceSendingChainArrow3.setVisible(true);
                
                
                
                // Hide these Elements

                swtParent.txt_aliceReceivingChain2.setVisible(false);
                swtParent.txt_aliceReceivingChain3.setVisible(false);
                swtParent.txt_aliceReceivingChain4.setVisible(false);
                swtParent.txt_aliceReceivingChain5.setVisible(false);                
                swtParent.grp_bobSendingReceivingChain.setVisible(false);
                swtParent.grp_aliceMessagebox.setVisible(false);
                swtParent.txt_step4.setVisible(false);
            }

            @Override
            STATE next(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                globalCounter++;
                singelton.unlock(parent, globalCounter);
                STEP_4.switchState(swtParent, parent);
                return STEP_4;
            }

            @Override
            STATE back(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                singelton.lock(parent, globalCounter);
                globalCounter--;
                STEP_2.switchState(swtParent, parent);
                return STEP_2;
            }

            @Override
            void updateText(SignalEncryptionViewDoubleRatchet swtParent) {
                // TODO Auto-generated method stub
                
            }

            @Override
            void saveText() {
                // TODO Auto-generated method stub
                
            }

            
        }, STEP_4 {

            @Override
            protected void switchState(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                
                // Show these labels
                swtParent.grp_aliceSendingReceivingChain.setVisible(true);
                swtParent.grp_aliceMessagebox.setVisible(true);
                swtParent.txt_step4.setVisible(true);
                                
                // Hide these Elements
                swtParent.txt_aliceCipherText.setVisible(false);
                swtParent.txt_bobCipherText.setVisible(false);
                swtParent.grp_bobAlgorithm.setVisible(false);
                swtParent.txt_aliceStep5.setVisible(false);
                swtParent.txt_bobStep5.setVisible(false);
                swtParent.grp_bobMessagebox.setVisible(false);
                
                

            }

            @Override
            STATE next(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                globalCounter++;
                singelton.unlock(parent, globalCounter);
                swtParent.signalEncryptionState.saveMessageAlice(swtParent.txt_alicePlainText.getText());
                swtParent.signalEncryptionState.stepForward(swtParent.signalEncryptionState);
                STEP_5.switchState(swtParent, parent);
                return STEP_5;
            }

            @Override
            STATE back(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                singelton.lock(parent, globalCounter);
                globalCounter--;
                swtParent.signalEncryptionState.stepBack(swtParent.signalEncryptionState);
                STEP_3.switchState(swtParent, parent);
                return STEP_3;
            }

            @Override
            void updateText(SignalEncryptionViewDoubleRatchet swtParent) {
                // TODO Auto-generated method stub
                
            }

            @Override
            void saveText() {
                // TODO Auto-generated method stub
                
            }

            
        }, STEP_5 {

            @Override
            protected void switchState(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                
                // Show these labels

                swtParent.grp_bobAlgorithm.setVisible(true);
                swtParent.txt_aliceCipherText.setVisible(true);
                swtParent.txt_bobCipherText.setVisible(true);
                swtParent.txt_aliceStep5.setVisible(true);
                swtParent.txt_bobStep5.setVisible(true);
                swtParent.grp_bobMessagebox.setVisible(true);

                swtParent.showAliceView();
                
                // Hide these Elements
                swtParent.grp_bobDiffieHellman.setVisible(false);
                swtParent.txt_bobDiffieHellman1.setVisible(false);
                swtParent.txt_bobDiffieHellman2.setVisible(false);
                swtParent.txt_bobDiffieHellman3.setVisible(false);
                swtParent.txt_step6.setVisible(false);
               
                // State
                swtParent.txt_aliceCipherText.setText(swtParent.signalEncryptionState.getAliceEncryptedMessage(counterAliceEncryptedMessage));
                swtParent.txt_bobCipherText.setText(swtParent.signalEncryptionState.getAliceEncryptedMessage(counterAliceEncryptedMessage));

            }

            @Override
            STATE next(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                globalCounter++;
                singelton.unlock(parent, globalCounter);
                swtParent.signalEncryptionState.stepForward(swtParent.signalEncryptionState);
                counterAliceEncryptedMessage++;
                STEP_6.switchState(swtParent, parent);
                return STEP_6;
            }

            @Override
            STATE back(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                singelton.lock(parent, globalCounter);
                globalCounter--;
                swtParent.signalEncryptionState.stepBack(swtParent.signalEncryptionState);
                STEP_4.switchState(swtParent, parent);
                return STEP_4;
            }

            @Override
            void updateText(SignalEncryptionViewDoubleRatchet swtParent) {
                // TODO Auto-generated method stub
                
            }

            @Override
            void saveText() {
                // TODO Auto-generated method stub
                
            }

            
        }, STEP_6 {

            @Override
            protected void switchState(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                
                // Show these labels
                swtParent.grp_bobDiffieHellman.setVisible(true);
                swtParent.txt_bobDiffieHellman1.setVisible(true);
                swtParent.txt_bobDiffieHellman2.setVisible(true);
                swtParent.txt_bobDiffieHellman3.setVisible(true);
                swtParent.txt_step6.setVisible(true);
                swtParent.showBobView();
                
                // Hide these Elements
                swtParent.grp_bobRootChain.setVisible(false);
                swtParent.txt_bobRootChain1.setVisible(false);
                swtParent.txt_bobRootChain2.setVisible(false);
                swtParent.txt_bobRootChain3.setVisible(false);
                swtParent.txt_step7.setVisible(false);
                swtParent.cmp_bobArrowSpace1.setVisible(false);
                
                swtParent.txt_bobPlainText.setText(swtParent.signalEncryptionState.getBobMessage(counterBobMessage));

            }

            @Override
            STATE next(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                globalCounter++;
                singelton.unlock(parent, globalCounter);
                counterBobMessage++;
                STEP_7.switchState(swtParent, parent);
                return STEP_7;
            }

            @Override
            STATE back(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                singelton.lock(parent, globalCounter);
                globalCounter--;
                counterAliceEncryptedMessage--;
                STEP_5.switchState(swtParent, parent);
                return STEP_5;
            }

            @Override
            void updateText(SignalEncryptionViewDoubleRatchet swtParent) {
                // TODO Auto-generated method stub
                
            }

            @Override
            void saveText() {
                // TODO Auto-generated method stub
                
            }

            
        }, STEP_7 {

            @Override
            protected void switchState(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                

                // Show these labels
                swtParent.grp_bobRootChain.setVisible(true);
                swtParent.txt_bobRootChain1.setVisible(true);
                swtParent.txt_bobRootChain2.setVisible(true);
                swtParent.txt_bobRootChain3.setVisible(true);
                swtParent.txt_step7.setVisible(true);
                swtParent.cmp_bobArrowSpace1.setVisible(true);
                
                // Hide these Elements
                swtParent.grp_bobSendingReceivingChain.setVisible(false);
                swtParent.txt_bobReceivingChain1.setVisible(false);
                swtParent.txt_bobReceivingChain2.setVisible(false);
                swtParent.txt_bobReceivingChain3.setVisible(false);
                swtParent.txt_bobReceivingChain4.setVisible(false);
                swtParent.txt_bobReceivingChain5.setVisible(false);
                swtParent.txt_step8.setVisible(false);
                

            }

            @Override
            STATE next(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                globalCounter++;
                singelton.unlock(parent, globalCounter);
                STEP_8.switchState(swtParent, parent);
                return STEP_8;
            }

            @Override
            STATE back(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                singelton.lock(parent, globalCounter);
                globalCounter--;
                counterBobMessage--;
                STEP_6.switchState(swtParent, parent);
                return STEP_6;
            }

            @Override
            void updateText(SignalEncryptionViewDoubleRatchet swtParent) {
                // TODO Auto-generated method stub
                
            }

            @Override
            void saveText() {
                // TODO Auto-generated method stub
                
            }

            
        }, STEP_8 {

            @Override
            protected void switchState(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {

                // Show these labels
                swtParent.grp_bobSendingReceivingChain.setVisible(true);
                swtParent.txt_bobReceivingChain1.setVisible(true);
                swtParent.txt_bobReceivingChain2.setVisible(true);
                swtParent.txt_bobReceivingChain3.setVisible(true);
                swtParent.txt_bobReceivingChain4.setVisible(true);
                swtParent.txt_bobReceivingChain5.setVisible(true);
                swtParent.txt_step8.setVisible(true);
                
                // Hide these Elements
                swtParent.txt_step9.setVisible(false);
                swtParent.txt_bobPlainText.setVisible(false);
            }

            @Override
            STATE next(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                globalCounter++;
                singelton.unlock(parent, globalCounter);
                STEP_9.switchState(swtParent, parent);
                return STEP_9;
            }

            @Override
            STATE back(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                singelton.lock(parent, globalCounter);
                globalCounter--;
                STEP_7.switchState(swtParent, parent);
                return STEP_7;
            }

            @Override
            void updateText(SignalEncryptionViewDoubleRatchet swtParent) {
                // TODO Auto-generated method stub
                
            }

            @Override
            void saveText() {
                // TODO Auto-generated method stub
                
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

                globalCounter++;
                singelton.unlock(parent, globalCounter);
                swtParent.txt_bobPlainText.setText(swtParent.MessageboxPlainText);
                swtParent.txt_alicePlainText.setText(swtParent.MessageboxPlainText);
                counter = 0;
                BOB_SEND_MSG.switchState(swtParent, parent);
                return BOB_SEND_MSG;
            }

            @Override
            STATE back(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                singelton.lock(parent, globalCounter);
                globalCounter--;
                STEP_8.switchState(swtParent, parent);
                return STEP_8;
            }

            @Override
            void updateText(SignalEncryptionViewDoubleRatchet swtParent) {
                // TODO Auto-generated method stub
                
            }

            @Override
            void saveText() {
                // TODO Auto-generated method stub
                
            }

            
        }, BOB_SEND_MSG{

            @Override
            protected void switchState(SignalEncryptionViewDoubleRatchet swtParent,
                    SignalEncryptionDoubleRatchetState parent) {
                
            }

            @Override
            STATE next(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                globalCounter++;
                singelton.unlock(parent, globalCounter);
                swtParent.signalEncryptionState.saveMessageBob(swtParent.txt_bobPlainText.getText());
                swtParent.signalEncryptionState.stepForward(swtParent.signalEncryptionState);
                
                counter++;
                ALICE_RCV_MSG.switchState(swtParent, parent);
                return ALICE_RCV_MSG;
            }

            @Override
            STATE back(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                singelton.lock(parent, globalCounter);
                globalCounter--;
                if(counter <= 0) {
                    swtParent.signalEncryptionState.stepBack(swtParent.signalEncryptionState);
                    STEP_9.switchState(swtParent, parent);
                    return STEP_9;
                }else {
                    swtParent.signalEncryptionState.stepBack(swtParent.signalEncryptionState);
                    counter--;
                    BOB_RCV_MSG.switchState(swtParent, parent);
                    return BOB_RCV_MSG;
                }
                
            }

            @Override
            void updateText(SignalEncryptionViewDoubleRatchet swtParent) {
                // TODO Auto-gesingelton.unlock(parent, globalCounter);nerated method stub
                
            }

            @Override
            void saveText() {
                // TODO Auto-generated method stub
                
            }

            
        }, ALICE_RCV_MSG{

            @Override
            protected void switchState(SignalEncryptionViewDoubleRatchet swtParent,
                    SignalEncryptionDoubleRatchetState parent) {
                // TODO Auto-generated method stub
                
            }

            @Override
            STATE next(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                globalCounter++;
                singelton.unlock(parent, globalCounter);
                swtParent.signalEncryptionState.stepForward(swtParent.signalEncryptionState);
                counter++;
                ALICE_SEND_MSG.switchState(swtParent, parent);
                return ALICE_SEND_MSG;
            }

            @Override
            STATE back(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                singelton.lock(parent, globalCounter);
                globalCounter--;
                swtParent.signalEncryptionState.stepBack(swtParent.signalEncryptionState);
                counter--;
                return BOB_SEND_MSG;
            }

            @Override
            void updateText(SignalEncryptionViewDoubleRatchet swtParent) {
                // TODO Auto-generated method stub
                
            }

            @Override
            void saveText() {
                // TODO Auto-generated method stub
                
            }

            
        }, ALICE_SEND_MSG{

            @Override
            protected void switchState(SignalEncryptionViewDoubleRatchet swtParent,
                    SignalEncryptionDoubleRatchetState parent) {
                // TODO Auto-generated method stub
                
            }

            @Override
            STATE next(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                globalCounter++;
                singelton.unlock(parent, globalCounter);
                swtParent.signalEncryptionState.stepForward(swtParent.signalEncryptionState);
                counter++;
                BOB_RCV_MSG.switchState(swtParent, parent);
                return BOB_RCV_MSG;
            }

            @Override
            STATE back(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                singelton.lock(parent, globalCounter);
                globalCounter--;
                swtParent.signalEncryptionState.stepBack(swtParent.signalEncryptionState);
                counter--;
                return ALICE_RCV_MSG;
            }

            @Override
            void updateText(SignalEncryptionViewDoubleRatchet swtParent) {
                // TODO Auto-generated method stub
                
            }

            @Override
            void saveText() {
                // TODO Auto-generated method stub
                
            }

        }, BOB_RCV_MSG{

            @Override
            protected void switchState(SignalEncryptionViewDoubleRatchet swtParent,
                    SignalEncryptionDoubleRatchetState parent) {
                
                
            }

            @Override
            STATE next(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                globalCounter++;
                singelton.unlock(parent, globalCounter);
                swtParent.signalEncryptionState.stepForward(swtParent.signalEncryptionState);
                counter++;
                BOB_SEND_MSG.switchState(swtParent, parent);
                return BOB_SEND_MSG;
            }

            @Override
            STATE back(SignalEncryptionViewDoubleRatchet swtParent, SignalEncryptionDoubleRatchetState parent) {
                singelton.lock(parent, globalCounter);
                globalCounter--;
                swtParent.signalEncryptionState.stepBack(swtParent.signalEncryptionState);
                counter--;
                return ALICE_SEND_MSG;
            }

            @Override
            void updateText(SignalEncryptionViewDoubleRatchet swtParent) {
                // TODO Auto-generated method stub
                
            }

            @Override
            void saveText() {
                // TODO Auto-generated method stub
                
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
        abstract void updateText(SignalEncryptionViewDoubleRatchet swtParent);
        abstract void saveText();
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
    public void setLock() {
        GlobalSwtParent.txt_bobPlainText.setEditable(false);
        GlobalSwtParent.txt_alicePlainText.setEditable(false);
    }
    public void setUnlock() {
        GlobalSwtParent.txt_bobPlainText.setEditable(true);
        GlobalSwtParent.txt_alicePlainText.setEditable(true);
    }
    public SignalEncryptionViewDoubleRatchet getSwtParent() {
        return GlobalSwtParent;
    }
}
