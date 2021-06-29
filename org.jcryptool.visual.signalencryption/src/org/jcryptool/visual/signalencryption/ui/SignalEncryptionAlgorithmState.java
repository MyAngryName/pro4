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
    
    private static List<String> aliceMessageSend;
    private static List<String> bobMessageSend;
    
    private static ArrayList<String> aliceMessageRcv;
    private static ArrayList<String> bobMessageRcv;
    
    
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
    
    private static int indexCounterVariables = 0;
    private static int indexCounterSecond = 0;
    private static int indexCounterThird = 0;
    
    private static int aliceCounterEncrypted = 0;
    private static int aliceCounterMessages = 0;
    private static int aliceCounterMessagesRcv = 0;
    
    private static int bobCounterEncrypted = 0;
    private static int bobCounterMessagesSend = 0;
    private static int bobCounterMessagesRcv = 0;
    

    
    private static PreKeySignalMessage tmpPreKeySignalMessage;
    private static SignalMessage tmpSignalMessage;
    
    private static String message;
        
    public SignalEncryptionAlgorithmState() {
        currentState = STATE.PARAMETER.setInitialState(this);

    }
    public enum STATE {
        PARAMETER {

            @Override
            protected void switchState(SignalEncryptionAlgorithmState parent) {
                signalEncryptionAlgorithm = new SignalEncryptionAlgorithm(STATE.PARAMETER);

                indexCounterVariables = 0;
                indexCounterSecond = 0;
                
                indexCounterThird = 0;
                aliceCounterMessages = 0;
                aliceCounterEncrypted = 0;
                aliceCounterMessagesRcv = 0;
                
                bobCounterEncrypted = 0;
                bobCounterMessagesSend = 0;
                bobCounterMessagesRcv = 0;
                
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
                
                
                aliceMessageSend = new ArrayList<String>();
                bobMessageSend = new  ArrayList<String>();
                
                aliceMessageRcv = new ArrayList<String>();
                bobMessageRcv = new  ArrayList<String>();
                
                createText();
            }
            @Override
            protected void createText() {
                
                aliceRatchetPrivateKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRatchetPrivateKey().serialize()));
                aliceRatchetPublicKey.add(indexCounterVariables,ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRatchetPublicKey().serialize()));
                aliceRootKey.add(indexCounterVariables,ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRootKey().getKeyBytes()));
                aliceSendingChainKey.add(indexCounterVariables,"Keine Sitzung begonnen");
                aliceSenderMsgKey.add(indexCounterVariables,"Keine Sitzung begonnen");
                aliceReceivingChainKey.add(indexCounterVariables,"Keine Sitzung begonnen");
                
                bobRatchetPrivateKey.add(indexCounterVariables,"Keine Sitzung begonnen");
                bobRatchetPublicKey.add(indexCounterVariables,ToHex.toString(signalEncryptionAlgorithm.getSession().getBobPreKeyBundle().getSignedPreKey().serialize()));
                bobRootKey.add(indexCounterVariables,"Keine Sitzung begonnen");
                bobSendingChainKey.add(indexCounterVariables,"Keine Sitzung begonnen");
                bobReceivingChainKey.add(indexCounterVariables,"Keine Sitzung begonnen");
                bobSenderMsgKey.add(indexCounterVariables,"Keine Sitzung begonnen");
                
                updateText();
            }
            @Override
            protected void updateText() {
                System.out.println(indexCounterVariables);
                varAliceRatchetPrivateKey = aliceRatchetPrivateKey.get(indexCounterVariables);
                varAliceRatchetPublicKey = aliceRatchetPublicKey.get(indexCounterVariables);
                varAliceRootKey = aliceRootKey.get(indexCounterVariables);
                varAliceSendingChainKey = aliceSendingChainKey.get(indexCounterVariables);
                varAliceSenderMsgKey = aliceSenderMsgKey.get(indexCounterVariables);
                varAliceReceivingChainKey = aliceReceivingChainKey.get(indexCounterVariables);
                
                varBobRatchetPrivateKey = bobRatchetPrivateKey.get(indexCounterVariables);
                varBobRatchetPublicKey = bobRatchetPublicKey.get(indexCounterVariables);
                varBobRootKey = bobRootKey.get(indexCounterVariables);
                varBobSendingChainKey = bobSendingChainKey.get(indexCounterVariables);
                varBobReceivingChainKey = bobReceivingChainKey.get(indexCounterVariables);
                varBobSenderMsgKey = bobSenderMsgKey.get(indexCounterVariables);
            }
            
            @Override 
            STATE back(SignalEncryptionAlgorithmState parent) {
                indexCounterVariables--;
                PARAMETER.updateText();
                return PARAMETER;
            }            
            @Override
            STATE next(SignalEncryptionAlgorithmState parent) {
                indexCounterVariables++;
                PRE_KEY_SIGNAL_MESSAGE.switchState(parent);
                return PRE_KEY_SIGNAL_MESSAGE;
            }
        }, PRE_KEY_SIGNAL_MESSAGE {
            @Override
            protected void switchState(SignalEncryptionAlgorithmState parent) {
                try {
                    message = aliceMessageSend.get(aliceCounterMessages);
                    aliceEncryptedMessage.add(aliceCounterEncrypted, signalEncryptionAlgorithm.getAliceSessionCipher().encrypt(message.getBytes("UTF-8")));
                } catch (UnsupportedEncodingException | UntrustedIdentityException e) {
                    updateText();
                }
                try {
                    tmpPreKeySignalMessage = new PreKeySignalMessage(aliceEncryptedMessage.get(aliceCounterEncrypted).serialize());
                    alicePreKeySignalMessage =  tmpPreKeySignalMessage;
                } catch (InvalidMessageException | InvalidVersionException e) {
                    updateText();
                }
                createText();
            }
            @Override
            protected void createText() {
                System.out.println(indexCounterVariables);
                aliceRatchetPrivateKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRatchetPrivateKey().serialize()));
                aliceRatchetPublicKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRatchetPublicKey().serialize()));
                aliceRootKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRootKey().getKeyBytes()));
                aliceSendingChainKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getChainKey().getKey()));
                aliceSenderMsgKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getMessageKeys().getCipherKey().getEncoded()));
                aliceReceivingChainKey.add(indexCounterVariables, "No Session initialized");
                
                bobRatchetPrivateKey.add(indexCounterVariables, "No Session initialized");
                bobRatchetPublicKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getSession().getBobPreKeyBundle().getSignedPreKey().serialize()));
                bobRootKey.add(indexCounterVariables, "No Session initialized");
                bobSendingChainKey.add(indexCounterVariables, "No Session initialized");
                bobReceivingChainKey.add(indexCounterVariables, "No Session initialized");
                bobSenderMsgKey.add(indexCounterVariables, "No Session initialized");
                updateText();
            }
            @Override
            protected void updateText() {
                varAliceRatchetPrivateKey = aliceRatchetPrivateKey.get(indexCounterVariables);
                varAliceRatchetPublicKey = aliceRatchetPublicKey.get(indexCounterVariables);
                varAliceRootKey = aliceRootKey.get(indexCounterVariables);
                varAliceSendingChainKey = aliceSendingChainKey.get(indexCounterVariables);
                varAliceSenderMsgKey = aliceSenderMsgKey.get(indexCounterVariables);
                varAliceReceivingChainKey = aliceReceivingChainKey.get(indexCounterVariables);
                
                varBobRatchetPrivateKey = bobRatchetPrivateKey.get(indexCounterVariables);
                varBobRatchetPublicKey = bobRatchetPublicKey.get(indexCounterVariables);
                varBobRootKey = bobRootKey.get(indexCounterVariables);
                varBobSendingChainKey = bobSendingChainKey.get(indexCounterVariables);
                varBobReceivingChainKey = bobReceivingChainKey.get(indexCounterVariables);
                varBobSenderMsgKey = bobSenderMsgKey.get(indexCounterVariables);
            }
            @Override
            STATE back(SignalEncryptionAlgorithmState parent) {
                indexCounterVariables--;
                PARAMETER.updateText();
                return PARAMETER;
            }
            @Override 
            STATE next(SignalEncryptionAlgorithmState parent) {
                indexCounterVariables++;
                aliceCounterMessages++;
                aliceCounterEncrypted++;
                RECEIVE_PRE_KEY_SIGNAL_MESSAGE.switchState(parent);
                return RECEIVE_PRE_KEY_SIGNAL_MESSAGE;
            }

        }, RECEIVE_PRE_KEY_SIGNAL_MESSAGE {
            @Override
            protected void switchState(SignalEncryptionAlgorithmState parent) {
                try {
                    bobMessageRcv.add(bobCounterMessagesRcv, new String(signalEncryptionAlgorithm.getBobSessionCipher().decrypt(alicePreKeySignalMessage)));
                } catch (DuplicateMessageException | LegacyMessageException | InvalidMessageException
                        | InvalidKeyIdException | InvalidKeyException | UntrustedIdentityException e) {
                    updateText();
                }
                createText();
            }
            @Override
            protected void createText() {
                aliceRatchetPrivateKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRatchetPrivateKey().serialize()));
                aliceRatchetPublicKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRatchetPublicKey().serialize()));
                aliceRootKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRootKey().getKeyBytes()));
                aliceSendingChainKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getChainKey().getKey()));
                aliceSenderMsgKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getMessageKeys().getCipherKey().getEncoded()));
                aliceReceivingChainKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getChainKey().getKey()));
                
                bobRatchetPrivateKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getRatchetPrivateKey().serialize()));
                bobRatchetPublicKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getRatchetPublicKey().serialize()));
                bobRootKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getRootKey().getKeyBytes()));
                bobSendingChainKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getChainKey().getKey()));
                bobReceivingChainKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getChainKey().getKey()));
                bobSenderMsgKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getMessageKeys().getCipherKey().getEncoded()));
                updateText();
            }
            @Override
            protected void updateText() {
                System.out.println(indexCounterVariables);
                varAliceRatchetPrivateKey = aliceRatchetPrivateKey.get(indexCounterVariables);
                varAliceRatchetPublicKey = aliceRatchetPublicKey.get(indexCounterVariables);
                varAliceRootKey = aliceRootKey.get(indexCounterVariables);
                varAliceSendingChainKey = aliceSendingChainKey.get(indexCounterVariables);
                varAliceSenderMsgKey = aliceSenderMsgKey.get(indexCounterVariables);
                varAliceReceivingChainKey = aliceReceivingChainKey.get(indexCounterVariables);
                
                varBobRatchetPrivateKey = bobRatchetPrivateKey.get(indexCounterVariables);
                varBobRatchetPublicKey = bobRatchetPublicKey.get(indexCounterVariables);
                varBobRootKey = bobRootKey.get(indexCounterVariables);
                varBobSendingChainKey = bobSendingChainKey.get(indexCounterVariables);
                varBobReceivingChainKey = bobReceivingChainKey.get(indexCounterVariables);
                varBobSenderMsgKey = bobSenderMsgKey.get(indexCounterVariables);
                
            }
            @Override
            STATE back(SignalEncryptionAlgorithmState parent) {
                indexCounterVariables--;
                aliceCounterMessages--;
                aliceCounterEncrypted--;
                PRE_KEY_SIGNAL_MESSAGE.updateText();
                return PRE_KEY_SIGNAL_MESSAGE;
            }
            @Override 
            STATE next(SignalEncryptionAlgorithmState parent) {
                indexCounterVariables++;
                indexCounterSecond++;
                bobCounterMessagesRcv++;
                BOB_SEND_MSG.switchState(parent);
                return RECEIVE_PRE_KEY_SIGNAL_MESSAGE;
            }
        }, BOB_SEND_MSG{
            
            @Override
            protected void switchState(SignalEncryptionAlgorithmState parent) {
                try {
                    message = bobMessageSend.get(bobCounterMessagesSend);
                    bobEncryptedMessage.add(bobCounterEncrypted,signalEncryptionAlgorithm.getBobSessionCipher().encrypt(message.getBytes("UTF-8")));
                } catch (UnsupportedEncodingException | UntrustedIdentityException e) {
                    updateText();
                }
                try {
                    tmpSignalMessage = new SignalMessage(bobEncryptedMessage.get(bobCounterEncrypted).serialize());
                    bobSignalMessage.add(bobCounterEncrypted, tmpSignalMessage);
                } catch (InvalidMessageException | LegacyMessageException e) {
                    updateText();
                }
                createText();
            }

            @Override
            protected void updateText() {
                varAliceRatchetPrivateKey = aliceRatchetPrivateKey.get(indexCounterVariables);
                varAliceRatchetPublicKey = aliceRatchetPublicKey.get(indexCounterVariables);
                varAliceRootKey = aliceRootKey.get(indexCounterVariables);
                varAliceSendingChainKey = aliceSendingChainKey.get(indexCounterVariables);
                varAliceSenderMsgKey = aliceSenderMsgKey.get(indexCounterVariables);
                varAliceReceivingChainKey = aliceReceivingChainKey.get(indexCounterVariables);
                
                varBobRatchetPrivateKey = bobRatchetPrivateKey.get(indexCounterVariables);
                varBobRatchetPublicKey = bobRatchetPublicKey.get(indexCounterVariables);
                varBobRootKey = bobRootKey.get(indexCounterVariables);
                varBobSendingChainKey = bobSendingChainKey.get(indexCounterVariables);
                varBobReceivingChainKey = bobReceivingChainKey.get(indexCounterVariables);
                varBobSenderMsgKey = bobSenderMsgKey.get(indexCounterVariables);
                
            }

            @Override
            protected void createText() {
                aliceRatchetPrivateKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRatchetPrivateKey().serialize()));
                aliceRatchetPublicKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRatchetPublicKey().serialize()));
                aliceRootKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRootKey().getKeyBytes()));
                aliceSendingChainKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getChainKey().getKey()));
                aliceSenderMsgKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getMessageKeys().getCipherKey().getEncoded()));
                aliceReceivingChainKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getChainKey().getKey()));
                
                bobRatchetPrivateKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getRatchetPrivateKey().serialize()));
                bobRatchetPublicKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getRatchetPublicKey().serialize()));
                bobRootKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getRootKey().getKeyBytes()));
                bobSendingChainKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getChainKey().getKey()));
                bobReceivingChainKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getChainKey().getKey()));
                bobSenderMsgKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getMessageKeys().getCipherKey().getEncoded()));
            }

            @Override
            STATE next(SignalEncryptionAlgorithmState parent) {
                indexCounterVariables++;
                indexCounterSecond++;
                indexCounterThird++;
                
                bobCounterMessagesSend++;
                ALICE_RCV_MSG.switchState(parent);
                return ALICE_RCV_MSG;
            }

            @Override
            STATE back(SignalEncryptionAlgorithmState parent) {
                indexCounterVariables--;
                indexCounterSecond--;
                indexCounterThird--;
                
                bobCounterMessagesRcv--;
                //aliceCounterEncrypted--;
                if(indexCounterVariables == 2) {
                    RECEIVE_PRE_KEY_SIGNAL_MESSAGE.updateText();
                    return RECEIVE_PRE_KEY_SIGNAL_MESSAGE;
                } else {
                    BOB_RCV_MSG.updateText();
                    aliceCounterEncrypted--;
                    
                    return BOB_RCV_MSG;
                }

            }
            
        }, ALICE_RCV_MSG{

            @Override
            protected void switchState(SignalEncryptionAlgorithmState parent) {
                try {
                    aliceMessageRcv.add(aliceCounterMessagesRcv, new String(signalEncryptionAlgorithm.getAliceSessionCipher().decrypt(bobSignalMessage.get(bobCounterEncrypted))));
                } catch (InvalidMessageException | DuplicateMessageException | LegacyMessageException
                        | NoSessionException | UntrustedIdentityException e) {
                    updateText();
                }
                createText();                
            }

            @Override
            protected void updateText() {
                varAliceRatchetPrivateKey = aliceRatchetPrivateKey.get(indexCounterVariables);
                varAliceRatchetPublicKey = aliceRatchetPublicKey.get(indexCounterVariables);
                varAliceRootKey = aliceRootKey.get(indexCounterVariables);
                varAliceSendingChainKey = aliceSendingChainKey.get(indexCounterVariables);
                varAliceSenderMsgKey = aliceSenderMsgKey.get(indexCounterVariables);
                varAliceReceivingChainKey = aliceReceivingChainKey.get(indexCounterVariables);
                
                varBobRatchetPrivateKey = bobRatchetPrivateKey.get(indexCounterVariables);
                varBobRatchetPublicKey = bobRatchetPublicKey.get(indexCounterVariables);
                varBobRootKey = bobRootKey.get(indexCounterVariables);
                varBobSendingChainKey = bobSendingChainKey.get(indexCounterVariables);
                varBobReceivingChainKey = bobReceivingChainKey.get(indexCounterVariables);
                varBobSenderMsgKey = bobSenderMsgKey.get(indexCounterVariables);                
            }

            @Override
            protected void createText() {
                aliceRatchetPrivateKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRatchetPrivateKey().serialize()));
                aliceRatchetPublicKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRatchetPublicKey().serialize()));
                aliceRootKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRootKey().getKeyBytes()));
                aliceSendingChainKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getChainKey().getKey()));
                aliceSenderMsgKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getMessageKeys().getCipherKey().getEncoded()));
                aliceReceivingChainKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getChainKey().getKey()));
                
                bobRatchetPrivateKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getRatchetPrivateKey().serialize()));
                bobRatchetPublicKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getRatchetPublicKey().serialize()));
                bobRootKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getRootKey().getKeyBytes()));
                bobSendingChainKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getChainKey().getKey()));
                bobReceivingChainKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getChainKey().getKey()));
                bobSenderMsgKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getMessageKeys().getCipherKey().getEncoded()));             
            }

            @Override
            STATE next(SignalEncryptionAlgorithmState parent) {
                indexCounterVariables++;
                indexCounterSecond++;
                indexCounterThird++;
                bobCounterEncrypted++;
                aliceCounterMessagesRcv++;
                ALICE_SEND_MSG.switchState(parent);
                return ALICE_SEND_MSG;
            }

            @Override
            STATE back(SignalEncryptionAlgorithmState parent) {
                indexCounterVariables--;
                indexCounterSecond--;
                indexCounterThird--;
                
                bobCounterMessagesSend--;
                BOB_SEND_MSG.updateText();
                return BOB_SEND_MSG;
            }
            
        }, ALICE_SEND_MSG{

            @Override
            protected void switchState(SignalEncryptionAlgorithmState parent) {
                try {
                    message = aliceMessageSend.get(aliceCounterMessages);
                    aliceEncryptedMessage.add(aliceCounterEncrypted,signalEncryptionAlgorithm.getAliceSessionCipher().encrypt(message.getBytes("UTF-8")));
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
                varAliceRatchetPrivateKey = aliceRatchetPrivateKey.get(indexCounterVariables);
                varAliceRatchetPublicKey = aliceRatchetPublicKey.get(indexCounterVariables);
                varAliceRootKey = aliceRootKey.get(indexCounterVariables);
                varAliceSendingChainKey = aliceSendingChainKey.get(indexCounterVariables);
                varAliceSenderMsgKey = aliceSenderMsgKey.get(indexCounterVariables);
                varAliceReceivingChainKey = aliceReceivingChainKey.get(indexCounterVariables);
                
                varBobRatchetPrivateKey = bobRatchetPrivateKey.get(indexCounterVariables);
                varBobRatchetPublicKey = bobRatchetPublicKey.get(indexCounterVariables);
                varBobRootKey = bobRootKey.get(indexCounterVariables);
                varBobSendingChainKey = bobSendingChainKey.get(indexCounterVariables);
                varBobReceivingChainKey = bobReceivingChainKey.get(indexCounterVariables);
                varBobSenderMsgKey = bobSenderMsgKey.get(indexCounterVariables);                
            }

            @Override
            protected void createText() {
                aliceRatchetPrivateKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRatchetPrivateKey().serialize()));
                aliceRatchetPublicKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRatchetPublicKey().serialize()));
                aliceRootKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRootKey().getKeyBytes()));
                aliceSendingChainKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getChainKey().getKey()));
                aliceSenderMsgKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getMessageKeys().getCipherKey().getEncoded()));
                aliceReceivingChainKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getChainKey().getKey()));
                
                bobRatchetPrivateKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getRatchetPrivateKey().serialize()));
                bobRatchetPublicKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getRatchetPublicKey().serialize()));
                bobRootKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getRootKey().getKeyBytes()));
                bobSendingChainKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getChainKey().getKey()));
                bobReceivingChainKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getChainKey().getKey()));
                bobSenderMsgKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getMessageKeys().getCipherKey().getEncoded()));           
            }

            @Override
            STATE next(SignalEncryptionAlgorithmState parent) {
                indexCounterVariables++;
                indexCounterSecond++;
                indexCounterThird++;
                
                aliceCounterMessages++;
                
                BOB_RCV_MSG.switchState(parent);
                return BOB_RCV_MSG;
            }

            @Override
            STATE back(SignalEncryptionAlgorithmState parent) {
                indexCounterVariables--;
                indexCounterSecond--;
                indexCounterThird--;
                
                bobCounterEncrypted--;
                aliceCounterMessagesRcv--;
                ALICE_RCV_MSG.updateText();
                return ALICE_RCV_MSG;
            }
            
        }, BOB_RCV_MSG{

            @Override
            protected void switchState(SignalEncryptionAlgorithmState parent) {
                try {
                    bobMessageSend.add(bobCounterMessagesRcv , new String(signalEncryptionAlgorithm.getBobSessionCipher().decrypt(aliceSignalMessage.get(aliceCounterEncrypted))));
                } catch (InvalidMessageException | DuplicateMessageException | LegacyMessageException
                        | NoSessionException | UntrustedIdentityException e) {
                    updateText();
                }
                createText();                   
            }

            @Override
            protected void updateText() {
                varAliceRatchetPrivateKey = aliceRatchetPrivateKey.get(indexCounterVariables);
                varAliceRatchetPublicKey = aliceRatchetPublicKey.get(indexCounterVariables);
                varAliceRootKey = aliceRootKey.get(indexCounterVariables);
                varAliceSendingChainKey = aliceSendingChainKey.get(indexCounterVariables);
                varAliceSenderMsgKey = aliceSenderMsgKey.get(indexCounterVariables);
                varAliceReceivingChainKey = aliceReceivingChainKey.get(indexCounterVariables);
                
                varBobRatchetPrivateKey = bobRatchetPrivateKey.get(indexCounterVariables);
                varBobRatchetPublicKey = bobRatchetPublicKey.get(indexCounterVariables);
                varBobRootKey = bobRootKey.get(indexCounterVariables);
                varBobSendingChainKey = bobSendingChainKey.get(indexCounterVariables);
                varBobReceivingChainKey = bobReceivingChainKey.get(indexCounterVariables);
                varBobSenderMsgKey = bobSenderMsgKey.get(indexCounterVariables);                
            }

            @Override
            protected void createText() {
                aliceRatchetPrivateKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRatchetPrivateKey().serialize()));
                aliceRatchetPublicKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRatchetPublicKey().serialize()));
                aliceRootKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRootKey().getKeyBytes()));
                aliceSendingChainKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getChainKey().getKey()));
                aliceSenderMsgKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getMessageKeys().getCipherKey().getEncoded()));
                aliceReceivingChainKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getChainKey().getKey()));
                
                bobRatchetPrivateKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getRatchetPrivateKey().serialize()));
                bobRatchetPublicKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getRatchetPublicKey().serialize()));
                bobRootKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getRootKey().getKeyBytes()));
                bobSendingChainKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getChainKey().getKey()));
                bobReceivingChainKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getChainKey().getKey()));
                bobSenderMsgKey.add(indexCounterVariables, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getMessageKeys().getCipherKey().getEncoded()));             
            }

            @Override
            STATE next(SignalEncryptionAlgorithmState parent) {
                indexCounterVariables++;
                indexCounterSecond++;
                indexCounterThird++;
                
                bobCounterMessagesRcv++;
                aliceCounterEncrypted++;
                BOB_SEND_MSG.switchState(parent);
                return BOB_SEND_MSG;
            }

            @Override
            STATE back(SignalEncryptionAlgorithmState parent) {
                indexCounterVariables--;
                indexCounterSecond--;
                indexCounterThird--;
                aliceCounterMessages--;
                
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
    public void generateBoth() {
        currentState = STATE.PARAMETER.setInitialState(this);
    }
    public void generateAlice() {
        if(currentState == STATE.PARAMETER) {
            signalEncryptionAlgorithm.generateAlice(currentState);
            currentState.createText();  
         }
    }
    public void generateBob() {
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
    public String getBobMessage(int i) {
        return bobMessageRcv.get(i);
    }
    public String getAliceMessage(int i) {
        return aliceMessageRcv.get(i);
    }
    public String getBobEncryptedMessage(int i) {
        if(currentState == STATE.PARAMETER) {
            return "Nothing here";
        }else {
            return ToHex.toString(bobEncryptedMessage.get(i).serialize());
        }
    }
    public String getAliceEncryptedMessage(int i) {
        if(currentState == STATE.PARAMETER) {
            return "Nothing here";
        }else {
            return ToHex.toString(aliceEncryptedMessage.get(i).serialize());
        }
    }
    public void saveMessageAlice(String msg) {
        aliceMessageSend.add(msg);
    }
    public void saveMessageBob(String msg) {
        bobMessageSend.add(msg);

    }
    public void resetCounter() {
        indexCounterVariables = 0;
        indexCounterSecond = 0;
        
        indexCounterThird = 0;
        aliceCounterMessages = 0;
        aliceCounterEncrypted = 0;
        aliceCounterMessagesRcv = 0;
        
        bobCounterEncrypted = 0;
        bobCounterMessagesSend = 0;
        bobCounterMessagesRcv = 0;
    }

}
