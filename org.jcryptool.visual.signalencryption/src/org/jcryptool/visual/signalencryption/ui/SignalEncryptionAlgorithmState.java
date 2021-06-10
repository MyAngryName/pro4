package org.jcryptool.visual.signalencryption.ui;

import org.jcryptool.visual.signalencryption.util.ToHex;
import org.whispersystems.libsignal.DuplicateMessageException;
import org.whispersystems.libsignal.InvalidKeyException;
import org.whispersystems.libsignal.InvalidKeyIdException;
import org.whispersystems.libsignal.InvalidMessageException;
import org.whispersystems.libsignal.InvalidVersionException;
import org.whispersystems.libsignal.LegacyMessageException;
import org.whispersystems.libsignal.NoSessionException;
import org.whispersystems.libsignal.SessionCipher;
import org.whispersystems.libsignal.UntrustedIdentityException;
import org.whispersystems.libsignal.protocol.CiphertextMessage;
import org.whispersystems.libsignal.protocol.PreKeySignalMessage;
import org.whispersystems.libsignal.protocol.SignalMessage;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.jcryptool.visual.signalencryption.algorithm.AliceBobSessionBuilder;
import org.jcryptool.visual.signalencryption.algorithm.Keys;
import org.jcryptool.visual.signalencryption.ui.SignalEncryptionAlgorithm;


public class SignalEncryptionAlgorithmState {
    
    private STATE currentState = STATE.PARAMETER;
    
    private static List<String> aliceRatchetPublicKey;
    private static List<String> aliceRatchetPrivateKey;
    
    private static List<String> bobRatchetPublicKey;
    private static List<String> bobRatchetPrivateKey;
    
    private static List<String> aliceSharedKey;
    private static List<String> bobSharedKey;
    
    private static List<String> aliceRootKey;
    private static List<String> bobRootKey;
    
    private static List<String> aliceSendingChainKey;
    private static List<String> bobSendingChainKey;
    
    private static List<String> aliceReceivingChainKey;
    private static List<String> bobReceivingChainKey;
    
    private static List<String> aliceSenderMsgKey;
    private static List<String> bobSenderMsgKey;
    
    private static SignalEncryptionAlgorithm signalEncryptionAlgorithm;
    private static SignalEncryptionAlgorithm currentSignalEncryptionAlgorithm;
    
    private static CiphertextMessage alicePreKeyCiphertextMessage;
    private static PreKeySignalMessage alicePreKeySignalMessage;
    
    private static List<CiphertextMessage> aliceEncryptedMessage;
    private static List<CiphertextMessage> bobEncryptedMessage;
    private static List<SignalMessage> bobSignalMessage;
    
    private static List<SignalMessage> aliceSignalMessage;
    
    private static List<String> aliceMessage;
    private static List<String> bobMessage;
    
    
    private static String varAliceRatchetPrivateKey;
    private static String varAliceRatchetPublicKey;
    private static String varAliceRootKey;
    private static String varAliceSendingChainKey;
    private static String varAliceSenderMsgKey;
    private static String varAliceReceivingChainKey;
    
    private static String varBobRatchetPrivateKey;
    private static String varBobRatchetPublicKey;
    private static String varBobRootKey;
    private static String varBobSendingChainKey;
    private static String varBobReceivingChainKey;
    private static String varBobSenderMsgKey;
    
    private static int indexCounterFirst = 0;
    private static int indexCounterSecond = 0;
    private static int indexCounterThird = 0;

    
    private static PreKeySignalMessage tmpPreKeySignalMessage;
    private static SignalMessage tmpSignalMessage;
        
    public SignalEncryptionAlgorithmState() {
        currentState = STATE.PARAMETER.setInitialState(this);
    }
    public enum STATE {
        PARAMETER {
            @Override
            protected void switchState(SignalEncryptionAlgorithmState parent) {
                signalEncryptionAlgorithm = new SignalEncryptionAlgorithm(STATE.PARAMETER);
                aliceRatchetPublicKey = new ArrayList<>();
                aliceRatchetPrivateKey = new ArrayList<>();
                
                bobRatchetPublicKey = new ArrayList<String>();
                bobRatchetPrivateKey = new ArrayList<String>();
                
                aliceSharedKey = new ArrayList<String>();
                bobSharedKey = new ArrayList<String>();
                
                aliceRootKey = new ArrayList<String>();
                bobRootKey = new ArrayList<String>();
                
                aliceSendingChainKey = new ArrayList<String>();
                bobSendingChainKey = new ArrayList<String>();
                
                aliceReceivingChainKey = new ArrayList<String>();
                bobReceivingChainKey = new ArrayList<String>();
                
                aliceSenderMsgKey = new ArrayList<String>();
                bobSenderMsgKey = new ArrayList<String>();
                
                aliceEncryptedMessage = new ArrayList<CiphertextMessage>();
                
                bobEncryptedMessage = new ArrayList<CiphertextMessage>();
                bobSignalMessage = new  ArrayList<SignalMessage>();
                
                aliceSignalMessage = new ArrayList<SignalMessage>();
                aliceMessage = new ArrayList<String>();
                bobMessage = new  ArrayList<String>();
                
                indexCounterFirst = 0;
                indexCounterSecond = 0;
                indexCounterThird = 0;
                
                createText();
            }
            @Override
            protected void createText() {
                aliceRatchetPrivateKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRatchetPrivateKey().serialize()));
                aliceRatchetPublicKey.add(indexCounterFirst,ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRatchetPublicKey().serialize()));
                aliceRootKey.add(indexCounterFirst,ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRootKey().getKeyBytes()));
                aliceSendingChainKey.add(indexCounterFirst,"Keine Sitzung begonnen");
                aliceSenderMsgKey.add(indexCounterFirst,"Keine Sitzung begonnen");
                aliceReceivingChainKey.add(indexCounterFirst,"Keine Sitzung begonnen");
                
                bobRatchetPrivateKey.add(indexCounterFirst,"Keine Sitzung begonnen");
                bobRatchetPublicKey.add(indexCounterFirst,ToHex.toString(signalEncryptionAlgorithm.getSession().getBobPreKeyBundle().getSignedPreKey().serialize()));
                bobRootKey.add(indexCounterFirst,"Keine Sitzung begonnen");
                bobSendingChainKey.add(indexCounterFirst,"Keine Sitzung begonnen");
                bobReceivingChainKey.add(indexCounterFirst,"Keine Sitzung begonnen");
                bobSenderMsgKey.add(indexCounterFirst,"Keine Sitzung begonnen");
                updateText();
            }
            @Override
            protected void updateText() {
                varAliceRatchetPrivateKey = aliceRatchetPrivateKey.get(indexCounterFirst);
                varAliceRatchetPublicKey = aliceRatchetPublicKey.get(indexCounterFirst);
                varAliceRootKey = aliceRootKey.get(indexCounterFirst);
                varAliceSendingChainKey = aliceSendingChainKey.get(indexCounterFirst);
                varAliceSenderMsgKey = aliceSenderMsgKey.get(indexCounterFirst);
                varAliceReceivingChainKey = aliceReceivingChainKey.get(indexCounterFirst);
                
                varBobRatchetPrivateKey = bobRatchetPrivateKey.get(indexCounterFirst);
                varBobRatchetPublicKey = bobRatchetPublicKey.get(indexCounterFirst);
                varBobRootKey = bobRootKey.get(indexCounterFirst);
                varBobSendingChainKey = bobSendingChainKey.get(indexCounterFirst);
                varBobReceivingChainKey = bobReceivingChainKey.get(indexCounterFirst);
                varBobSenderMsgKey = bobSenderMsgKey.get(indexCounterFirst);
            }
            
            @Override 
            STATE back(SignalEncryptionAlgorithmState parent) {
                return PARAMETER;
            }            
            @Override
            STATE next(SignalEncryptionAlgorithmState parent) {
                indexCounterFirst++;
                PRE_KEY_SIGNAL_MESSAGE.switchState(parent);
                return PRE_KEY_SIGNAL_MESSAGE;
            }
        }, PRE_KEY_SIGNAL_MESSAGE {
            @Override
            protected void switchState(SignalEncryptionAlgorithmState parent) {
                try {
                    aliceEncryptedMessage.add(signalEncryptionAlgorithm.getAliceSessionCipher().encrypt("Hello world!".getBytes("UTF-8")));
                } catch (UnsupportedEncodingException | UntrustedIdentityException e) {
                    updateText();
                }
                try {
                    tmpPreKeySignalMessage = new PreKeySignalMessage(aliceEncryptedMessage.get(indexCounterSecond).serialize());
                    alicePreKeySignalMessage =  tmpPreKeySignalMessage;
                } catch (InvalidMessageException | InvalidVersionException e) {
                    updateText();
                }
                createText();
            }
            @Override
            protected void createText() {
                aliceRatchetPrivateKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRatchetPrivateKey().serialize()));
                aliceRatchetPublicKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRatchetPublicKey().serialize()));
                aliceRootKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRootKey().getKeyBytes()));
                aliceSendingChainKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getChainKey().getKey()));
                aliceSenderMsgKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getMessageKeys().getCipherKey().getEncoded()));
                aliceReceivingChainKey.add(indexCounterFirst, "No Session initialized");
                
                bobRatchetPrivateKey.add(indexCounterFirst, "No Session initialized");
                bobRatchetPublicKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getSession().getBobPreKeyBundle().getSignedPreKey().serialize()));
                bobRootKey.add(indexCounterFirst, "No Session initialized");
                bobSendingChainKey.add(indexCounterFirst, "No Session initialized");
                bobReceivingChainKey.add(indexCounterFirst, "No Session initialized");
                bobSenderMsgKey.add(indexCounterFirst, "No Session initialized");
                updateText();
            }
            @Override
            protected void updateText() {
                varAliceRatchetPrivateKey = aliceRatchetPrivateKey.get(indexCounterFirst);
                varAliceRatchetPublicKey = aliceRatchetPublicKey.get(indexCounterFirst);
                varAliceRootKey = aliceRootKey.get(indexCounterFirst);
                varAliceSendingChainKey = aliceSendingChainKey.get(indexCounterFirst);
                varAliceSenderMsgKey = aliceSenderMsgKey.get(indexCounterFirst);
                varAliceReceivingChainKey = aliceReceivingChainKey.get(indexCounterFirst);
                
                varBobRatchetPrivateKey = bobRatchetPrivateKey.get(indexCounterFirst);
                varBobRatchetPublicKey = bobRatchetPublicKey.get(indexCounterFirst);
                varBobRootKey = bobRootKey.get(indexCounterFirst);
                varBobSendingChainKey = bobSendingChainKey.get(indexCounterFirst);
                varBobReceivingChainKey = bobReceivingChainKey.get(indexCounterFirst);
                varBobSenderMsgKey = bobSenderMsgKey.get(indexCounterFirst);
            }
            @Override
            STATE back(SignalEncryptionAlgorithmState parent) {
                indexCounterFirst--;
                PARAMETER.updateText();
                return PARAMETER;
            }
            @Override 
            STATE next(SignalEncryptionAlgorithmState parent) {
                indexCounterFirst++;
                RECEIVE_PRE_KEY_SIGNAL_MESSAGE.switchState(parent);
                return RECEIVE_PRE_KEY_SIGNAL_MESSAGE;
            }

        }, RECEIVE_PRE_KEY_SIGNAL_MESSAGE {
            @Override
            protected void switchState(SignalEncryptionAlgorithmState parent) {
                try {
                    bobMessage.add(indexCounterSecond, new String(signalEncryptionAlgorithm.getBobSessionCipher().decrypt(alicePreKeySignalMessage)));
                } catch (DuplicateMessageException | LegacyMessageException | InvalidMessageException
                        | InvalidKeyIdException | InvalidKeyException | UntrustedIdentityException e) {
                    updateText();
                }
                createText();
            }
            @Override
            protected void createText() {
                aliceRatchetPrivateKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRatchetPrivateKey().serialize()));
                aliceRatchetPublicKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRatchetPublicKey().serialize()));
                aliceRootKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRootKey().getKeyBytes()));
                aliceSendingChainKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getChainKey().getKey()));
                aliceSenderMsgKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getMessageKeys().getCipherKey().getEncoded()));
                aliceReceivingChainKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getChainKey().getKey()));
                
                bobRatchetPrivateKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getRatchetPrivateKey().serialize()));
                bobRatchetPublicKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getRatchetPublicKey().serialize()));
                bobRootKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getRootKey().getKeyBytes()));
                bobSendingChainKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getChainKey().getKey()));
                bobReceivingChainKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getChainKey().getKey()));
                bobSenderMsgKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getMessageKeys().getCipherKey().getEncoded()));
                updateText();
            }
            @Override
            protected void updateText() {
                varAliceRatchetPrivateKey = aliceRatchetPrivateKey.get(indexCounterFirst);
                varAliceRatchetPublicKey = aliceRatchetPublicKey.get(indexCounterFirst);
                varAliceRootKey = aliceRootKey.get(indexCounterFirst);
                varAliceSendingChainKey = aliceSendingChainKey.get(indexCounterFirst);
                varAliceSenderMsgKey = aliceSenderMsgKey.get(indexCounterFirst);
                varAliceReceivingChainKey = aliceReceivingChainKey.get(indexCounterFirst);
                
                varBobRatchetPrivateKey = bobRatchetPrivateKey.get(indexCounterFirst);
                varBobRatchetPublicKey = bobRatchetPublicKey.get(indexCounterFirst);
                varBobRootKey = bobRootKey.get(indexCounterFirst);
                varBobSendingChainKey = bobSendingChainKey.get(indexCounterFirst);
                varBobReceivingChainKey = bobReceivingChainKey.get(indexCounterFirst);
                varBobSenderMsgKey = bobSenderMsgKey.get(indexCounterFirst);
                
            }
            @Override
            STATE back(SignalEncryptionAlgorithmState parent) {
                indexCounterFirst--;
                PRE_KEY_SIGNAL_MESSAGE.updateText();
                return PRE_KEY_SIGNAL_MESSAGE;
            }
            @Override 
            STATE next(SignalEncryptionAlgorithmState parent) {
                indexCounterFirst++;
                indexCounterSecond++;
                return RECEIVE_PRE_KEY_SIGNAL_MESSAGE;
            }
        }, BOB_SEND_MSG{
            
            @Override
            protected void switchState(SignalEncryptionAlgorithmState parent) {
                try {
                    bobEncryptedMessage.add(indexCounterSecond,signalEncryptionAlgorithm.getBobSessionCipher().encrypt("Hello world!".getBytes("UTF-8")));
                } catch (UnsupportedEncodingException | UntrustedIdentityException e) {
                    updateText();
                }
                try {
                    tmpSignalMessage = new SignalMessage(bobEncryptedMessage.get(indexCounterSecond).serialize());
                    bobSignalMessage.add(indexCounterSecond, tmpSignalMessage);
                } catch (InvalidMessageException | LegacyMessageException e) {
                    updateText();
                }
                createText();
            }

            @Override
            protected void updateText() {
                
                varAliceRatchetPrivateKey = aliceRatchetPrivateKey.get(indexCounterFirst);
                varAliceRatchetPublicKey = aliceRatchetPublicKey.get(indexCounterFirst);
                varAliceRootKey = aliceRootKey.get(indexCounterFirst);
                varAliceSendingChainKey = aliceSendingChainKey.get(indexCounterFirst);
                varAliceSenderMsgKey = aliceSenderMsgKey.get(indexCounterFirst);
                varAliceReceivingChainKey = aliceReceivingChainKey.get(indexCounterFirst);
                
                varBobRatchetPrivateKey = bobRatchetPrivateKey.get(indexCounterFirst);
                varBobRatchetPublicKey = bobRatchetPublicKey.get(indexCounterFirst);
                varBobRootKey = bobRootKey.get(indexCounterFirst);
                varBobSendingChainKey = bobSendingChainKey.get(indexCounterFirst);
                varBobReceivingChainKey = bobReceivingChainKey.get(indexCounterFirst);
                varBobSenderMsgKey = bobSenderMsgKey.get(indexCounterFirst);
                
            }

            @Override
            protected void createText() {
                aliceRatchetPrivateKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRatchetPrivateKey().serialize()));
                aliceRatchetPublicKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRatchetPublicKey().serialize()));
                aliceRootKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRootKey().getKeyBytes()));
                aliceSendingChainKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getChainKey().getKey()));
                aliceSenderMsgKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getMessageKeys().getCipherKey().getEncoded()));
                aliceReceivingChainKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getChainKey().getKey()));
                
                bobRatchetPrivateKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getRatchetPrivateKey().serialize()));
                bobRatchetPublicKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getRatchetPublicKey().serialize()));
                bobRootKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getRootKey().getKeyBytes()));
                bobSendingChainKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getChainKey().getKey()));
                bobReceivingChainKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getChainKey().getKey()));
                bobSenderMsgKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getMessageKeys().getCipherKey().getEncoded()));
            }

            @Override
            STATE next(SignalEncryptionAlgorithmState parent) {
                indexCounterFirst++;
                indexCounterSecond++;
                indexCounterThird++;
                ALICE_RCV_MSG.switchState(parent);
                return ALICE_RCV_MSG;
            }

            @Override
            STATE back(SignalEncryptionAlgorithmState parent) {
                indexCounterFirst--;
                indexCounterSecond--;
                indexCounterThird--;
                if(indexCounterFirst == 2) {
                    RECEIVE_PRE_KEY_SIGNAL_MESSAGE.updateText();
                    return RECEIVE_PRE_KEY_SIGNAL_MESSAGE;
                } else {
                    BOB_RCV_MSG.updateText();
                    return BOB_RCV_MSG;
                }

            }
            
        }, ALICE_RCV_MSG{

            @Override
            protected void switchState(SignalEncryptionAlgorithmState parent) {
                try {
                    aliceMessage.add(indexCounterSecond, new String(signalEncryptionAlgorithm.getAliceSessionCipher().decrypt(bobSignalMessage.get(indexCounterThird))));
                } catch (InvalidMessageException | DuplicateMessageException | LegacyMessageException
                        | NoSessionException | UntrustedIdentityException e) {
                    updateText();
                }
                createText();                
            }

            @Override
            protected void updateText() {
                varAliceRatchetPrivateKey = aliceRatchetPrivateKey.get(indexCounterFirst);
                varAliceRatchetPublicKey = aliceRatchetPublicKey.get(indexCounterFirst);
                varAliceRootKey = aliceRootKey.get(indexCounterFirst);
                varAliceSendingChainKey = aliceSendingChainKey.get(indexCounterFirst);
                varAliceSenderMsgKey = aliceSenderMsgKey.get(indexCounterFirst);
                varAliceReceivingChainKey = aliceReceivingChainKey.get(indexCounterFirst);
                
                varBobRatchetPrivateKey = bobRatchetPrivateKey.get(indexCounterFirst);
                varBobRatchetPublicKey = bobRatchetPublicKey.get(indexCounterFirst);
                varBobRootKey = bobRootKey.get(indexCounterFirst);
                varBobSendingChainKey = bobSendingChainKey.get(indexCounterFirst);
                varBobReceivingChainKey = bobReceivingChainKey.get(indexCounterFirst);
                varBobSenderMsgKey = bobSenderMsgKey.get(indexCounterFirst);                
            }

            @Override
            protected void createText() {
                aliceRatchetPrivateKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRatchetPrivateKey().serialize()));
                aliceRatchetPublicKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRatchetPublicKey().serialize()));
                aliceRootKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRootKey().getKeyBytes()));
                aliceSendingChainKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getChainKey().getKey()));
                aliceSenderMsgKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getMessageKeys().getCipherKey().getEncoded()));
                aliceReceivingChainKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getChainKey().getKey()));
                
                bobRatchetPrivateKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getRatchetPrivateKey().serialize()));
                bobRatchetPublicKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getRatchetPublicKey().serialize()));
                bobRootKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getRootKey().getKeyBytes()));
                bobSendingChainKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getChainKey().getKey()));
                bobReceivingChainKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getChainKey().getKey()));
                bobSenderMsgKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getMessageKeys().getCipherKey().getEncoded()));             
            }

            @Override
            STATE next(SignalEncryptionAlgorithmState parent) {
                indexCounterFirst++;
                indexCounterSecond++;
                indexCounterThird++;
                ALICE_SEND_MSG.switchState(parent);
                return ALICE_SEND_MSG;
            }

            @Override
            STATE back(SignalEncryptionAlgorithmState parent) {
                indexCounterFirst--;
                indexCounterSecond--;
                indexCounterThird--;
                BOB_SEND_MSG.updateText();
                return BOB_SEND_MSG;
            }
            
        }, ALICE_SEND_MSG{

            @Override
            protected void switchState(SignalEncryptionAlgorithmState parent) {
                try {
                    aliceEncryptedMessage.add(indexCounterSecond,signalEncryptionAlgorithm.getAliceSessionCipher().encrypt("Hello world!".getBytes("UTF-8")));
                } catch (UnsupportedEncodingException | UntrustedIdentityException e) {
                    updateText();
                }
                try {
                    tmpSignalMessage = new SignalMessage(aliceEncryptedMessage.get(indexCounterThird).serialize());
                    aliceSignalMessage.add(indexCounterSecond, tmpSignalMessage);
                } catch (InvalidMessageException | LegacyMessageException e) {
                    updateText();
                }
                createText();                
            }

            @Override
            protected void updateText() {
                varAliceRatchetPrivateKey = aliceRatchetPrivateKey.get(indexCounterFirst);
                varAliceRatchetPublicKey = aliceRatchetPublicKey.get(indexCounterFirst);
                varAliceRootKey = aliceRootKey.get(indexCounterFirst);
                varAliceSendingChainKey = aliceSendingChainKey.get(indexCounterFirst);
                varAliceSenderMsgKey = aliceSenderMsgKey.get(indexCounterFirst);
                varAliceReceivingChainKey = aliceReceivingChainKey.get(indexCounterFirst);
                
                varBobRatchetPrivateKey = bobRatchetPrivateKey.get(indexCounterFirst);
                varBobRatchetPublicKey = bobRatchetPublicKey.get(indexCounterFirst);
                varBobRootKey = bobRootKey.get(indexCounterFirst);
                varBobSendingChainKey = bobSendingChainKey.get(indexCounterFirst);
                varBobReceivingChainKey = bobReceivingChainKey.get(indexCounterFirst);
                varBobSenderMsgKey = bobSenderMsgKey.get(indexCounterFirst);                
            }

            @Override
            protected void createText() {
                aliceRatchetPrivateKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRatchetPrivateKey().serialize()));
                aliceRatchetPublicKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRatchetPublicKey().serialize()));
                aliceRootKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRootKey().getKeyBytes()));
                aliceSendingChainKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getChainKey().getKey()));
                aliceSenderMsgKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getMessageKeys().getCipherKey().getEncoded()));
                aliceReceivingChainKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getChainKey().getKey()));
                
                bobRatchetPrivateKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getRatchetPrivateKey().serialize()));
                bobRatchetPublicKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getRatchetPublicKey().serialize()));
                bobRootKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getRootKey().getKeyBytes()));
                bobSendingChainKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getChainKey().getKey()));
                bobReceivingChainKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getChainKey().getKey()));
                bobSenderMsgKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getMessageKeys().getCipherKey().getEncoded()));           
            }

            @Override
            STATE next(SignalEncryptionAlgorithmState parent) {
                indexCounterFirst++;
                indexCounterSecond++;
                indexCounterThird++;
                BOB_RCV_MSG.switchState(parent);
                return BOB_RCV_MSG;
            }

            @Override
            STATE back(SignalEncryptionAlgorithmState parent) {
                indexCounterFirst--;
                indexCounterSecond--;
                indexCounterThird--;
                ALICE_RCV_MSG.updateText();
                return ALICE_RCV_MSG;
            }
            
        }, BOB_RCV_MSG{

            @Override
            protected void switchState(SignalEncryptionAlgorithmState parent) {
                try {
                    bobMessage.add(indexCounterSecond, new String(signalEncryptionAlgorithm.getBobSessionCipher().decrypt(aliceSignalMessage.get(indexCounterThird))));
                } catch (InvalidMessageException | DuplicateMessageException | LegacyMessageException
                        | NoSessionException | UntrustedIdentityException e) {
                    updateText();
                }
                createText();                   
            }

            @Override
            protected void updateText() {
                varAliceRatchetPrivateKey = aliceRatchetPrivateKey.get(indexCounterFirst);
                varAliceRatchetPublicKey = aliceRatchetPublicKey.get(indexCounterFirst);
                varAliceRootKey = aliceRootKey.get(indexCounterFirst);
                varAliceSendingChainKey = aliceSendingChainKey.get(indexCounterFirst);
                varAliceSenderMsgKey = aliceSenderMsgKey.get(indexCounterFirst);
                varAliceReceivingChainKey = aliceReceivingChainKey.get(indexCounterFirst);
                
                varBobRatchetPrivateKey = bobRatchetPrivateKey.get(indexCounterFirst);
                varBobRatchetPublicKey = bobRatchetPublicKey.get(indexCounterFirst);
                varBobRootKey = bobRootKey.get(indexCounterFirst);
                varBobSendingChainKey = bobSendingChainKey.get(indexCounterFirst);
                varBobReceivingChainKey = bobReceivingChainKey.get(indexCounterFirst);
                varBobSenderMsgKey = bobSenderMsgKey.get(indexCounterFirst);                
            }

            @Override
            protected void createText() {
                aliceRatchetPrivateKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRatchetPrivateKey().serialize()));
                aliceRatchetPublicKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRatchetPublicKey().serialize()));
                aliceRootKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRootKey().getKeyBytes()));
                aliceSendingChainKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getChainKey().getKey()));
                aliceSenderMsgKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getMessageKeys().getCipherKey().getEncoded()));
                aliceReceivingChainKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getChainKey().getKey()));
                
                bobRatchetPrivateKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getRatchetPrivateKey().serialize()));
                bobRatchetPublicKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getRatchetPublicKey().serialize()));
                bobRootKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getRootKey().getKeyBytes()));
                bobSendingChainKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getChainKey().getKey()));
                bobReceivingChainKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getChainKey().getKey()));
                bobSenderMsgKey.add(indexCounterFirst, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getMessageKeys().getCipherKey().getEncoded()));             
            }

            @Override
            STATE next(SignalEncryptionAlgorithmState parent) {
                indexCounterFirst++;
                indexCounterSecond++;
                indexCounterThird++;
                BOB_SEND_MSG.switchState(parent);
                return BOB_SEND_MSG;
            }

            @Override
            STATE back(SignalEncryptionAlgorithmState parent) {
                indexCounterFirst--;
                indexCounterSecond--;
                indexCounterThird--;
                ALICE_SEND_MSG.updateText();
                return ALICE_SEND_MSG;
            }
            
        };
        protected abstract void switchState(SignalEncryptionAlgorithmState parent);
        protected abstract void updateText();
        protected abstract void createText();
        abstract STATE next(SignalEncryptionAlgorithmState parent);
        abstract STATE back(SignalEncryptionAlgorithmState parent);
        
        public STATE setInitialState(SignalEncryptionAlgorithmState parent) {
            PARAMETER.switchState(parent);
            return PARAMETER;
        }
    }

    public STATE getCurrentState() {
        return currentState;
    }
    public void stepForward(SignalEncryptionAlgorithmState parent) {
        currentState = currentState.next(parent);
    }
    public void stepBack(SignalEncryptionAlgorithmState parent) {
        currentState = currentState.back(parent);
    }
    public void resetBoth() {
        currentState = STATE.PARAMETER.setInitialState(this);
    }
    public void resetAlice() {
        if(currentState == STATE.PARAMETER) {
            signalEncryptionAlgorithm.generateAlice(currentState);
            currentState.createText();  
         }
    }
    public void resetBob() {
        if(currentState == STATE.PARAMETER) {
            signalEncryptionAlgorithm.generateBob(currentState);
            currentState.createText();
        }
    }
    public SignalEncryptionAlgorithm getSignalEncryptionAlgorithm() {
        return signalEncryptionAlgorithm;
    }
    public String getAliceRatchetPrivateKey() {
        return varAliceRatchetPrivateKey;
    }
    public String getAliceRatchetPublicKey() {
        return varAliceRatchetPublicKey;
    }
    public String getaliceRootKey() {
        return varAliceRootKey;
    }
    public String getAliceSendingChainKey() {
        return varAliceSendingChainKey;
    }
    public String getAliceSenderMsgKey() {
        return varAliceSenderMsgKey;
    }
    public String getAliceReceivingChainKey() {
        return varAliceReceivingChainKey;
    }
    public String getBobRatchetPrivateKey() {
        return varBobRatchetPrivateKey;
    }
    public String getBobRatchetPublicKey() {
        return varBobRatchetPublicKey;
    }
    public String getBobRootKey() {
        return varBobRootKey;
    }
    public String getBobSendingChainKey() {
        return varBobSendingChainKey;
    }
    public String getBobReceivingChainKey() {
        return varBobReceivingChainKey;
    }
    public String getBobSenderMsgKey() {
        return varBobSenderMsgKey;
    }
    public String getBobMessage() {
        return bobMessage.get(indexCounterFirst);
    }
    public String getAliceMessage() {
        return aliceMessage.get(indexCounterFirst);
    }
    public String getBobEncryptedMessage() {
        return ToHex.toString(bobEncryptedMessage.get(indexCounterSecond).serialize());
    }
    public String getAliceEncryptedMessage() {
        return ToHex.toString(aliceEncryptedMessage.get(indexCounterSecond).serialize());
    }

}
