package org.jcryptool.visual.signalencryption.ui;

import org.jcryptool.visual.signalencryption.util.ToHex;

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
        INITIALIZING,
        PRE_KEY_SIGNAL_MESSAGE,
        BOB_SEND_MSG,
        ALICE_SEND_MSG;
    }
    
    public void generateBothPartiesKeys() {
        generateAliceKeys();
        generateBobKeys();
    }

    public void generateAliceKeys() {
        if(currentState == STATE.INITIALIZING) {
            signalEncryptionAlgorithm.generateAlice(currentState);
            // TODO Set keys in UI
         }
    }
    public void generateBobKeys() {
        if(currentState == STATE.INITIALIZING) {
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
    public String getAliceSendingChainKey() {
        return current().getAliceSendingChainKey();
    }
    public String getAliceSenderMsgKey() {
        return current().getAliceSenderMsgKey();
    }
    public String getAliceReceivingChainKey() {
        return current().getAliceReceivingChainKey();
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
    public String getBobSendingChainKey() {
        return current().getBobSendingChainKey();
    }
    public String getBobReceivingChainKey() {
        return current().getBobReceivingChainKey();
    }
    public String getBobSenderMsgKey() {
        return current().getBobSenderMsgKey();
    }
    
    public boolean allowMessageEntering() {
        return !communication.current().isAlreadyEncrypted();
    }
    
    public String getAliceEncryptedMessage() {
        if(currentState == STATE.INITIALIZING) {
            return "Nothing here";
        }else {
            return ToHex.toString(communication.current().getCiphertextMessage().orElse(new byte[] {}));
        }
    }
    
    private MessageContext current() {
        return getCommunication().current();
    }
    
    //public void setState(STATE state) {
    //    switch (state) {
    //    case INITIALIZING:
    //        currentContext = communication.getInitialisingContext();
    //        break;
    //    case PRE_KEY_SIGNAL_MESSAGE:
    //        currentContext = communication.getPreKeySignalMessageContext();
    //        break;
    //    default:
    //        currentContext = communication.current();
    //        break;
    //    }
    //}
    
    public SignalCommunication getCommunication() {
        return communication;
    }
    
    

}
