package org.jcryptool.visual.signalencryption.ui;

import org.jcryptool.visual.signalencryption.util.ToHex;
import org.whispersystems.libsignal.DuplicateMessageException;
import org.whispersystems.libsignal.InvalidKeyException;
import org.whispersystems.libsignal.InvalidKeyIdException;
import org.whispersystems.libsignal.InvalidMessageException;
import org.whispersystems.libsignal.InvalidVersionException;
import org.whispersystems.libsignal.LegacyMessageException;
import org.whispersystems.libsignal.SessionCipher;
import org.whispersystems.libsignal.UntrustedIdentityException;
import org.whispersystems.libsignal.protocol.CiphertextMessage;
import org.whispersystems.libsignal.protocol.PreKeySignalMessage;

import java.io.UnsupportedEncodingException;

import org.jcryptool.visual.signalencryption.algorithm.AliceBobSessionBuilder;
import org.jcryptool.visual.signalencryption.algorithm.Keys;
import org.jcryptool.visual.signalencryption.ui.SignalEncryptionAlgorithm;


public class SignalEncryptionState {
    
    private STATE currentState = STATE.PARAMETER;
    
    private static String aliceRatchetPublicKey;
    private static String aliceRatchetPrivateKey;
    
    private static String bobRatchetPublicKey;
    private static String bobRatchetPrivateKey;
    
    private static String aliceSharedKey;
    private static String bobSharedKey;
    
    private static String aliceRootKey;
    private static String bobRootKey;
    
    private static String aliceSendingChainKey;
    private static String bobSendingChainKey;
    
    private static String aliceReceivingChainKey;
    private static String bobReceivingChainKey;
    
    private static String aliceSenderMsgKey;
    private static String bobSenderMsgKey;
    
    private static String parameterAliceRatchetPublicKey;
    private static String parameterAliceRatchetPrivateKey;
    private static String parameterAliceSendingChainKey;
    private static String parameterAliceSharedKey;
    private static String parameterAliceRootKey;
    private static String parameterAliceSenderMsgKey;
    private static String parameterAliceReceivingChainKey;


    
    private static String parameterBobRatchetPrivateKey;
    private static String parameterBobRatchetPublicKey;
    private static String parameterBobSharedKey;
    private static String parameterBobRootKey;
    private static String parameterBobSendingChainKey;
    private static String parameterBobReceivingChainKey;
    private static String parameterBobSenderMsgKey;
    
    private static String preKeyAliceRatchetPublicKey;
    private static String preKeyAliceRatchetPrivateKey;
    private static String preKeyAliceSendingChainKey;
    private static String preKeyAliceSharedKey;
    private static String preKeyAliceRootKey;
    private static String preKeyAliceSenderMsgKey;
    private static String preKeyAliceReceivingChainKey;


    
    private static String preKeyBobRatchetPrivateKey;
    private static String preKeyBobRatchetPublicKey;
    private static String preKeyBobSharedKey;
    private static String preKeyBobRootKey;
    private static String preKeyBobSendingChainKey;
    private static String preKeyBobReceivingChainKey;
    private static String preKeyBobSenderMsgKey;
    
    private static SignalEncryptionAlgorithm signalEncryptionAlgorithm;
    private static SignalEncryptionAlgorithm currentSignalEncryptionAlgorithm;

    
    private static CiphertextMessage aliceEncryptedMessage;
    private static PreKeySignalMessage alicePreKeySignalMessage;
        
    
    public enum STATE {
        PARAMETER {
            @Override
            protected void switchState(SignalEncryptionState parent) {
                signalEncryptionAlgorithm = new SignalEncryptionAlgorithm(STATE.PARAMETER);
                
                parameterAliceRatchetPrivateKey = ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRatchetPrivateKey().serialize());
                parameterAliceRatchetPublicKey= ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRatchetPublicKey().serialize());
                parameterAliceRootKey = ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRootKey().getKeyBytes());
                parameterAliceSendingChainKey = ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getChainKey().getKey());
                parameterAliceSenderMsgKey = ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getMessageKeys().getCipherKey().getEncoded());
                parameterAliceReceivingChainKey = "No Session initialized";
                
                parameterBobRatchetPrivateKey = "No Session initialized";
                parameterBobRatchetPublicKey = ToHex.toString(signalEncryptionAlgorithm.getSession().getBobPreKeyBundle().getSignedPreKey().serialize());
                parameterBobRootKey = "No Session initialized";
                parameterBobSendingChainKey = "No Session initialized";
                parameterBobReceivingChainKey = "No Session initialized";
                parameterBobSenderMsgKey = "No Session initialized";
                generate();
            }
            @Override
            protected void generate() {
                aliceRatchetPrivateKey = parameterAliceRatchetPrivateKey;
                aliceRatchetPublicKey = parameterAliceRatchetPublicKey;
                aliceRootKey = parameterAliceRootKey;
                aliceSendingChainKey = parameterAliceSendingChainKey;
                aliceSenderMsgKey = parameterAliceSenderMsgKey;
                aliceReceivingChainKey = parameterAliceReceivingChainKey;
                
                bobRatchetPrivateKey = parameterBobRatchetPrivateKey;
                bobRatchetPublicKey = parameterBobRatchetPublicKey;
                bobRootKey = parameterBobRootKey;
                bobSendingChainKey = parameterBobSendingChainKey;
                bobReceivingChainKey = parameterBobReceivingChainKey;
                bobSenderMsgKey = parameterBobSenderMsgKey;
            }
            @Override 
            STATE back(SignalEncryptionState parent) {
                return PARAMETER;
            }            
            @Override
            STATE next(SignalEncryptionState parent) {
                PRE_KEY_SIGNAL_MESSAGE.switchState(parent);
                return PRE_KEY_SIGNAL_MESSAGE;
            }
        }, PRE_KEY_SIGNAL_MESSAGE {
            @Override
            protected void switchState(SignalEncryptionState parent) {
                try {
                    aliceEncryptedMessage = signalEncryptionAlgorithm.getAliceSessionCipher().encrypt("Hello world!".getBytes("UTF-8"));
                } catch (UnsupportedEncodingException | UntrustedIdentityException e) {
                    e.printStackTrace();
                }
                try {
                    alicePreKeySignalMessage = new PreKeySignalMessage(aliceEncryptedMessage.serialize());
                } catch (InvalidMessageException | InvalidVersionException e) {
                    e.printStackTrace();
                }
                
                
                generate();
                
            }
            @Override
            protected void generate() {
                aliceRatchetPrivateKey = parameterAliceRatchetPrivateKey;
                aliceRatchetPublicKey = parameterAliceRatchetPublicKey;
                aliceRootKey = parameterAliceRootKey;
                aliceSendingChainKey = parameterAliceSendingChainKey;
                aliceSenderMsgKey = parameterAliceSenderMsgKey;
                aliceReceivingChainKey = parameterAliceReceivingChainKey;
                
                bobRatchetPrivateKey = parameterBobRatchetPrivateKey;
                bobRatchetPublicKey = parameterBobRatchetPublicKey;
                bobRootKey = parameterBobRootKey;
                bobSendingChainKey = parameterBobSendingChainKey;
                bobReceivingChainKey = parameterBobReceivingChainKey;
                bobSenderMsgKey = parameterBobSenderMsgKey;
            }
            @Override
            STATE back(SignalEncryptionState parent) {
                PARAMETER.generate();
                return PARAMETER;
            }
            @Override 
            STATE next(SignalEncryptionState parent) {
                RECEIVE_PRE_KEY_SIGNAL_MESSAGE.switchState(parent);
                return RECEIVE_PRE_KEY_SIGNAL_MESSAGE;
            } 
        }, RECEIVE_PRE_KEY_SIGNAL_MESSAGE {
            @Override
            protected void switchState(SignalEncryptionState parent) {
                try {
                    signalEncryptionAlgorithm.getBobSessionCipher().decrypt(alicePreKeySignalMessage);
                } catch (DuplicateMessageException | LegacyMessageException | InvalidMessageException
                        | InvalidKeyIdException | InvalidKeyException | UntrustedIdentityException e) {
                    e.printStackTrace();
                }
                preKeyAliceRatchetPrivateKey = ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRatchetPrivateKey().serialize());
                preKeyAliceRatchetPublicKey = ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRatchetPublicKey().serialize());
                preKeyAliceRootKey = ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRootKey().getKeyBytes());
                preKeyAliceSendingChainKey = ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getChainKey().getKey());
                preKeyAliceSenderMsgKey = ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getMessageKeys().getCipherKey().getEncoded());
                preKeyAliceReceivingChainKey = ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getChainKey().getKey());
                
                preKeyBobRatchetPrivateKey = ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getRatchetPrivateKey().serialize());
                preKeyBobRatchetPublicKey = ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getRatchetPublicKey().serialize());
                preKeyBobRootKey = ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getRootKey().getKeyBytes());
                preKeyBobSendingChainKey = ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getChainKey().getKey());
                preKeyBobReceivingChainKey = ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getChainKey().getKey());
                preKeyBobSenderMsgKey = ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getMessageKeys().getCipherKey().getEncoded());
                generate();
            }
            @Override
            protected void generate() {
                aliceRatchetPrivateKey = preKeyAliceRatchetPrivateKey;
                aliceRatchetPublicKey = preKeyAliceRatchetPublicKey;
                aliceRootKey = preKeyAliceRootKey;
                aliceSendingChainKey = preKeyAliceSendingChainKey;
                aliceSenderMsgKey = preKeyAliceSenderMsgKey;
                aliceReceivingChainKey = preKeyAliceReceivingChainKey;
                
                bobRatchetPrivateKey = preKeyBobRatchetPrivateKey;
                bobRatchetPublicKey = preKeyBobRatchetPublicKey;
                bobRootKey = preKeyBobRootKey;
                bobSendingChainKey = preKeyBobSendingChainKey;
                bobReceivingChainKey = preKeyBobReceivingChainKey;
                bobSenderMsgKey = preKeyBobSenderMsgKey;
                
            }
            @Override
            STATE back(SignalEncryptionState parent) {
                PRE_KEY_SIGNAL_MESSAGE.generate();
                return PRE_KEY_SIGNAL_MESSAGE;
            }
            @Override 
            STATE next(SignalEncryptionState parent) {
                return RECEIVE_PRE_KEY_SIGNAL_MESSAGE;
            }
        };
        protected abstract void switchState(SignalEncryptionState parent);
        protected abstract void generate();
        abstract STATE next(SignalEncryptionState parent);
        abstract STATE back(SignalEncryptionState parent);
        
        public STATE setInitialState(SignalEncryptionState parent) {
            PARAMETER.switchState(parent);
            return PARAMETER;
        }
    }
    public SignalEncryptionState() {
        this.currentState = STATE.PARAMETER.setInitialState(this);
    }
    public STATE getCurrentState() {
        return currentState;
    }
    public void currenStateNext(SignalEncryptionState parent) {
        currentState = currentState.next(parent);
    }
    public void currentStateBack(SignalEncryptionState parent) {
        currentState = currentState.back(parent);
    }
    public void generateBoth() {
        currentState = STATE.PARAMETER.setInitialState(this);
    }
    public void generateAlice() {
        if(currentState == STATE.PARAMETER) {
            signalEncryptionAlgorithm.generateAlice(currentState);
            currentState.generate();
        }

    }
    public void generateBob() {
        if(currentState == STATE.PARAMETER) {
            signalEncryptionAlgorithm.generateBob(currentState);
            currentState.generate();
        }
    }
    public SignalEncryptionAlgorithm getSignalEncryptionAlgorithm() {
        return signalEncryptionAlgorithm;
    }
    public String getAliceRatchetPrivateKey() {
        return aliceRatchetPrivateKey;
    }
    public String getAliceRatchetPublicKey() {
        return aliceRatchetPrivateKey;
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

}
