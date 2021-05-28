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


public class SignalEncryptionState {
    
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
    
    private static int indexCounterKeys ;
    private static int indexCounterEncryptedMsg ;
    private static int indexCounterThird ;
    private static int indexCounterMsg ;
    
    private static List<String> alicePlainTextMessages;
    private static List<String> bobPlainTextMessages;

    private static SignalMessage tmpSignalMessage;
        
    public SignalEncryptionState() {
        currentState = STATE.PARAMETER.setInitialState(this);

    }
    public enum STATE {
        PARAMETER {
            @Override
            protected void switchState(SignalEncryptionState parent) {
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
                
                indexCounterKeys = 0;
                indexCounterEncryptedMsg = 0;
                indexCounterThird = 0;
                indexCounterMsg = 0;
                
                alicePlainTextMessages = new ArrayList<String>();
                bobPlainTextMessages = new ArrayList<String>();

                alicePlainTextMessages.add(indexCounterMsg, "Hello world!");
                bobPlainTextMessages.add(indexCounterMsg, "Hello world!");


                createText();
            }
            @Override
            protected void createText() {
                aliceRatchetPrivateKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRatchetPrivateKey().serialize()));
                aliceRatchetPublicKey.add(indexCounterKeys,ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRatchetPublicKey().serialize()));
                aliceRootKey.add(indexCounterKeys,ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRootKey().getKeyBytes()));
                aliceSendingChainKey.add(indexCounterKeys,"Keine Sitzung begonnen");
                aliceSenderMsgKey.add(indexCounterKeys,"Keine Sitzung begonnen");
                aliceReceivingChainKey.add(indexCounterKeys,"Keine Sitzung begonnen");
                
                bobRatchetPrivateKey.add(indexCounterKeys,"Keine Sitzung begonnen");
                bobRatchetPublicKey.add(indexCounterKeys,ToHex.toString(signalEncryptionAlgorithm.getSession().getBobPreKeyBundle().getSignedPreKey().serialize()));
                bobRootKey.add(indexCounterKeys,"Keine Sitzung begonnen");
                bobSendingChainKey.add(indexCounterKeys,"Keine Sitzung begonnen");
                bobReceivingChainKey.add(indexCounterKeys,"Keine Sitzung begonnen");
                bobSenderMsgKey.add(indexCounterKeys,"Keine Sitzung begonnen");
                updateText();
            }
            @Override
            protected void updateText() {
                varAliceRatchetPrivateKey = aliceRatchetPrivateKey.get(indexCounterKeys);
                varAliceRatchetPublicKey = aliceRatchetPublicKey.get(indexCounterKeys);
                varAliceRootKey = aliceRootKey.get(indexCounterKeys);
                varAliceSendingChainKey = aliceSendingChainKey.get(indexCounterKeys);
                varAliceSenderMsgKey = aliceSenderMsgKey.get(indexCounterKeys);
                varAliceReceivingChainKey = aliceReceivingChainKey.get(indexCounterKeys);
                
                varBobRatchetPrivateKey = bobRatchetPrivateKey.get(indexCounterKeys);
                varBobRatchetPublicKey = bobRatchetPublicKey.get(indexCounterKeys);
                varBobRootKey = bobRootKey.get(indexCounterKeys);
                varBobSendingChainKey = bobSendingChainKey.get(indexCounterKeys);
                varBobReceivingChainKey = bobReceivingChainKey.get(indexCounterKeys);
                varBobSenderMsgKey = bobSenderMsgKey.get(indexCounterKeys);
            }
            
            @Override 
            STATE back(SignalEncryptionState parent) {
                return PARAMETER;
            }            
            @Override
            STATE next(SignalEncryptionState parent) {
                indexCounterKeys++;
                PRE_KEY_SIGNAL_MESSAGE.switchState(parent);
                return PRE_KEY_SIGNAL_MESSAGE;
            }
        }, PRE_KEY_SIGNAL_MESSAGE {
            @Override
            protected void switchState(SignalEncryptionState parent) {
                try {
                    aliceEncryptedMessage.add(indexCounterMsg, signalEncryptionAlgorithm.getAliceSessionCipher().
                            encrypt(alicePlainTextMessages.get(indexCounterEncryptedMsg).getBytes("UTF-8")));
                } catch (UnsupportedEncodingException | UntrustedIdentityException e) {
                    updateText();
                }
                try {
                    alicePreKeySignalMessage =  new PreKeySignalMessage(aliceEncryptedMessage.get(indexCounterEncryptedMsg).serialize());
                } catch (InvalidMessageException | InvalidVersionException e) {
                    updateText();
                }
                createText();
            }
            @Override
            protected void createText() {
                aliceRatchetPrivateKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRatchetPrivateKey().serialize()));
                aliceRatchetPublicKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRatchetPublicKey().serialize()));
                aliceRootKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRootKey().getKeyBytes()));
                aliceSendingChainKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getChainKey().getKey()));
                aliceSenderMsgKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getMessageKeys().getCipherKey().getEncoded()));
                aliceReceivingChainKey.add(indexCounterKeys, "No Session initialized");
                
                bobRatchetPrivateKey.add(indexCounterKeys, "No Session initialized");
                bobRatchetPublicKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getSession().getBobPreKeyBundle().getSignedPreKey().serialize()));
                bobRootKey.add(indexCounterKeys, "No Session initialized");
                bobSendingChainKey.add(indexCounterKeys, "No Session initialized");
                bobReceivingChainKey.add(indexCounterKeys, "No Session initialized");
                bobSenderMsgKey.add(indexCounterKeys, "No Session initialized");
                updateText();
            }
            @Override
            protected void updateText() {
                varAliceRatchetPrivateKey = aliceRatchetPrivateKey.get(indexCounterKeys);
                varAliceRatchetPublicKey = aliceRatchetPublicKey.get(indexCounterKeys);
                varAliceRootKey = aliceRootKey.get(indexCounterKeys);
                varAliceSendingChainKey = aliceSendingChainKey.get(indexCounterKeys);
                varAliceSenderMsgKey = aliceSenderMsgKey.get(indexCounterKeys);
                varAliceReceivingChainKey = aliceReceivingChainKey.get(indexCounterKeys);
                
                varBobRatchetPrivateKey = bobRatchetPrivateKey.get(indexCounterKeys);
                varBobRatchetPublicKey = bobRatchetPublicKey.get(indexCounterKeys);
                varBobRootKey = bobRootKey.get(indexCounterKeys);
                varBobSendingChainKey = bobSendingChainKey.get(indexCounterKeys);
                varBobReceivingChainKey = bobReceivingChainKey.get(indexCounterKeys);
                varBobSenderMsgKey = bobSenderMsgKey.get(indexCounterKeys);
            }
            @Override
            STATE back(SignalEncryptionState parent) {
                indexCounterKeys--;
                PARAMETER.updateText();
                return PARAMETER;
            }
            @Override 
            STATE next(SignalEncryptionState parent) {
                indexCounterKeys++;
                indexCounterMsg++;
                RECEIVE_PRE_KEY_SIGNAL_MESSAGE.switchState(parent);
                return RECEIVE_PRE_KEY_SIGNAL_MESSAGE;
            }

        }, RECEIVE_PRE_KEY_SIGNAL_MESSAGE {
            @Override
            protected void switchState(SignalEncryptionState parent) {
                try {
                    bobMessage.add(indexCounterEncryptedMsg, new String(signalEncryptionAlgorithm.getBobSessionCipher().decrypt(alicePreKeySignalMessage)));
                } catch (DuplicateMessageException | LegacyMessageException | InvalidMessageException
                        | InvalidKeyIdException | InvalidKeyException | UntrustedIdentityException e) {
                    updateText();
                }
                createText();
            }
            @Override
            protected void createText() {
                aliceRatchetPrivateKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRatchetPrivateKey().serialize()));
                aliceRatchetPublicKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRatchetPublicKey().serialize()));
                aliceRootKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRootKey().getKeyBytes()));
                aliceSendingChainKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getChainKey().getKey()));
                aliceSenderMsgKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getMessageKeys().getCipherKey().getEncoded()));
                aliceReceivingChainKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getChainKey().getKey()));
                
                bobRatchetPrivateKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getRatchetPrivateKey().serialize()));
                bobRatchetPublicKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getRatchetPublicKey().serialize()));
                bobRootKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getRootKey().getKeyBytes()));
                bobSendingChainKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getChainKey().getKey()));
                bobReceivingChainKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getChainKey().getKey()));
                bobSenderMsgKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getMessageKeys().getCipherKey().getEncoded()));
                updateText();
            }
            @Override
            protected void updateText() {
                varAliceRatchetPrivateKey = aliceRatchetPrivateKey.get(indexCounterKeys);
                varAliceRatchetPublicKey = aliceRatchetPublicKey.get(indexCounterKeys);
                varAliceRootKey = aliceRootKey.get(indexCounterKeys);
                varAliceSendingChainKey = aliceSendingChainKey.get(indexCounterKeys);
                varAliceSenderMsgKey = aliceSenderMsgKey.get(indexCounterKeys);
                varAliceReceivingChainKey = aliceReceivingChainKey.get(indexCounterKeys);
                
                varBobRatchetPrivateKey = bobRatchetPrivateKey.get(indexCounterKeys);
                varBobRatchetPublicKey = bobRatchetPublicKey.get(indexCounterKeys);
                varBobRootKey = bobRootKey.get(indexCounterKeys);
                varBobSendingChainKey = bobSendingChainKey.get(indexCounterKeys);
                varBobReceivingChainKey = bobReceivingChainKey.get(indexCounterKeys);
                varBobSenderMsgKey = bobSenderMsgKey.get(indexCounterKeys);
                
            }
            @Override
            STATE back(SignalEncryptionState parent) {
                indexCounterKeys--;
                PRE_KEY_SIGNAL_MESSAGE.updateText();
                return PRE_KEY_SIGNAL_MESSAGE;
            }
            @Override 
            STATE next(SignalEncryptionState parent) {
                indexCounterKeys++;
                indexCounterEncryptedMsg++;
                return RECEIVE_PRE_KEY_SIGNAL_MESSAGE;
            }
        }, BOB_SEND_MSG{
            
            @Override
            protected void switchState(SignalEncryptionState parent) {
                try {
                    bobEncryptedMessage.add(indexCounterEncryptedMsg,signalEncryptionAlgorithm.getBobSessionCipher().
                            encrypt(bobPlainTextMessages.get(indexCounterMsg).getBytes("UTF-8")));
                } catch (UnsupportedEncodingException | UntrustedIdentityException e) {
                    updateText();
                }
                try {
                    tmpSignalMessage = new SignalMessage(bobEncryptedMessage.get(indexCounterEncryptedMsg).serialize());
                    bobSignalMessage.add(indexCounterEncryptedMsg, tmpSignalMessage);
                } catch (InvalidMessageException | LegacyMessageException e) {
                    updateText();
                }
                createText();
            }

            @Override
            protected void updateText() {
                
                varAliceRatchetPrivateKey = aliceRatchetPrivateKey.get(indexCounterKeys);
                varAliceRatchetPublicKey = aliceRatchetPublicKey.get(indexCounterKeys);
                varAliceRootKey = aliceRootKey.get(indexCounterKeys);
                varAliceSendingChainKey = aliceSendingChainKey.get(indexCounterKeys);
                varAliceSenderMsgKey = aliceSenderMsgKey.get(indexCounterKeys);
                varAliceReceivingChainKey = aliceReceivingChainKey.get(indexCounterKeys);
                
                varBobRatchetPrivateKey = bobRatchetPrivateKey.get(indexCounterKeys);
                varBobRatchetPublicKey = bobRatchetPublicKey.get(indexCounterKeys);
                varBobRootKey = bobRootKey.get(indexCounterKeys);
                varBobSendingChainKey = bobSendingChainKey.get(indexCounterKeys);
                varBobReceivingChainKey = bobReceivingChainKey.get(indexCounterKeys);
                varBobSenderMsgKey = bobSenderMsgKey.get(indexCounterKeys);
                
            }

            @Override
            protected void createText() {
                aliceRatchetPrivateKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRatchetPrivateKey().serialize()));
                aliceRatchetPublicKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRatchetPublicKey().serialize()));
                aliceRootKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRootKey().getKeyBytes()));
                aliceSendingChainKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getChainKey().getKey()));
                aliceSenderMsgKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getMessageKeys().getCipherKey().getEncoded()));
                aliceReceivingChainKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getChainKey().getKey()));
                
                bobRatchetPrivateKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getRatchetPrivateKey().serialize()));
                bobRatchetPublicKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getRatchetPublicKey().serialize()));
                bobRootKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getRootKey().getKeyBytes()));
                bobSendingChainKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getChainKey().getKey()));
                bobReceivingChainKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getChainKey().getKey()));
                bobSenderMsgKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getMessageKeys().getCipherKey().getEncoded()));
            }

            @Override
            STATE next(SignalEncryptionState parent) {
                indexCounterKeys++;
                indexCounterEncryptedMsg++;
                indexCounterThird++;
                ALICE_RCV_MSG.switchState(parent);
                return ALICE_RCV_MSG;
            }

            @Override
            STATE back(SignalEncryptionState parent) {
                indexCounterKeys--;
                indexCounterEncryptedMsg--;
                indexCounterThird--;
                indexCounterMsg--;
                if(indexCounterKeys == 3) {
                    RECEIVE_PRE_KEY_SIGNAL_MESSAGE.updateText();
                    return RECEIVE_PRE_KEY_SIGNAL_MESSAGE;
                } else {
                    BOB_RCV_MSG.updateText();
                    return BOB_RCV_MSG;
                }

            }
            
        }, ALICE_RCV_MSG{

            @Override
            protected void switchState(SignalEncryptionState parent) {
                try {
                    aliceMessage.add(indexCounterEncryptedMsg, new String(signalEncryptionAlgorithm.getAliceSessionCipher().decrypt(bobSignalMessage.get(indexCounterThird))));
                } catch (InvalidMessageException | DuplicateMessageException | LegacyMessageException
                        | NoSessionException | UntrustedIdentityException e) {
                    updateText();
                }
                createText();                
            }

            @Override
            protected void updateText() {
                varAliceRatchetPrivateKey = aliceRatchetPrivateKey.get(indexCounterKeys);
                varAliceRatchetPublicKey = aliceRatchetPublicKey.get(indexCounterKeys);
                varAliceRootKey = aliceRootKey.get(indexCounterKeys);
                varAliceSendingChainKey = aliceSendingChainKey.get(indexCounterKeys);
                varAliceSenderMsgKey = aliceSenderMsgKey.get(indexCounterKeys);
                varAliceReceivingChainKey = aliceReceivingChainKey.get(indexCounterKeys);
                
                varBobRatchetPrivateKey = bobRatchetPrivateKey.get(indexCounterKeys);
                varBobRatchetPublicKey = bobRatchetPublicKey.get(indexCounterKeys);
                varBobRootKey = bobRootKey.get(indexCounterKeys);
                varBobSendingChainKey = bobSendingChainKey.get(indexCounterKeys);
                varBobReceivingChainKey = bobReceivingChainKey.get(indexCounterKeys);
                varBobSenderMsgKey = bobSenderMsgKey.get(indexCounterKeys);                
            }

            @Override
            protected void createText() {
                aliceRatchetPrivateKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRatchetPrivateKey().serialize()));
                aliceRatchetPublicKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRatchetPublicKey().serialize()));
                aliceRootKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRootKey().getKeyBytes()));
                aliceSendingChainKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getChainKey().getKey()));
                aliceSenderMsgKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getMessageKeys().getCipherKey().getEncoded()));
                aliceReceivingChainKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getChainKey().getKey()));
                
                bobRatchetPrivateKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getRatchetPrivateKey().serialize()));
                bobRatchetPublicKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getRatchetPublicKey().serialize()));
                bobRootKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getRootKey().getKeyBytes()));
                bobSendingChainKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getChainKey().getKey()));
                bobReceivingChainKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getChainKey().getKey()));
                bobSenderMsgKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getMessageKeys().getCipherKey().getEncoded()));             
            }

            @Override
            STATE next(SignalEncryptionState parent) {
                indexCounterKeys++;
                indexCounterEncryptedMsg++;
                indexCounterThird++;
                ALICE_SEND_MSG.switchState(parent);
                return ALICE_SEND_MSG;
            }

            @Override
            STATE back(SignalEncryptionState parent) {
                indexCounterKeys--;
                indexCounterEncryptedMsg--;
                indexCounterThird--;
                BOB_SEND_MSG.updateText();
                return BOB_SEND_MSG;
            }
            
        }, ALICE_SEND_MSG{

            @Override
            protected void switchState(SignalEncryptionState parent) {
                try {
                    aliceEncryptedMessage.add(indexCounterEncryptedMsg,signalEncryptionAlgorithm.getAliceSessionCipher().
                            encrypt(alicePlainTextMessages.get(indexCounterEncryptedMsg).getBytes("UTF-8")));
                } catch (UnsupportedEncodingException | UntrustedIdentityException e) {
                    updateText();
                }
                try {
                    tmpSignalMessage = new SignalMessage(aliceEncryptedMessage.get(indexCounterThird).serialize());
                    aliceSignalMessage.add(indexCounterEncryptedMsg, tmpSignalMessage);
                } catch (InvalidMessageException | LegacyMessageException e) {
                    updateText();
                }
                createText();                
            }

            @Override
            protected void updateText() {
                varAliceRatchetPrivateKey = aliceRatchetPrivateKey.get(indexCounterKeys);
                varAliceRatchetPublicKey = aliceRatchetPublicKey.get(indexCounterKeys);
                varAliceRootKey = aliceRootKey.get(indexCounterKeys);
                varAliceSendingChainKey = aliceSendingChainKey.get(indexCounterKeys);
                varAliceSenderMsgKey = aliceSenderMsgKey.get(indexCounterKeys);
                varAliceReceivingChainKey = aliceReceivingChainKey.get(indexCounterKeys);
                
                varBobRatchetPrivateKey = bobRatchetPrivateKey.get(indexCounterKeys);
                varBobRatchetPublicKey = bobRatchetPublicKey.get(indexCounterKeys);
                varBobRootKey = bobRootKey.get(indexCounterKeys);
                varBobSendingChainKey = bobSendingChainKey.get(indexCounterKeys);
                varBobReceivingChainKey = bobReceivingChainKey.get(indexCounterKeys);
                varBobSenderMsgKey = bobSenderMsgKey.get(indexCounterKeys);                
            }

            @Override
            protected void createText() {
                aliceRatchetPrivateKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRatchetPrivateKey().serialize()));
                aliceRatchetPublicKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRatchetPublicKey().serialize()));
                aliceRootKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRootKey().getKeyBytes()));
                aliceSendingChainKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getChainKey().getKey()));
                aliceSenderMsgKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getMessageKeys().getCipherKey().getEncoded()));
                aliceReceivingChainKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getChainKey().getKey()));
                
                bobRatchetPrivateKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getRatchetPrivateKey().serialize()));
                bobRatchetPublicKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getRatchetPublicKey().serialize()));
                bobRootKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getRootKey().getKeyBytes()));
                bobSendingChainKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getChainKey().getKey()));
                bobReceivingChainKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getChainKey().getKey()));
                bobSenderMsgKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getMessageKeys().getCipherKey().getEncoded()));           
            }

            @Override
            STATE next(SignalEncryptionState parent) {
                indexCounterKeys++;
                indexCounterEncryptedMsg++;
                indexCounterThird++;
                indexCounterMsg++;
                BOB_RCV_MSG.switchState(parent);
                return BOB_RCV_MSG;
            }

            @Override
            STATE back(SignalEncryptionState parent) {
                indexCounterKeys--;
                indexCounterEncryptedMsg--;
                indexCounterThird--;
                ALICE_RCV_MSG.updateText();
                return ALICE_RCV_MSG;
            }
            
        }, BOB_RCV_MSG{

            @Override
            protected void switchState(SignalEncryptionState parent) {
                try {
                    bobMessage.add(indexCounterEncryptedMsg, new String(signalEncryptionAlgorithm.getBobSessionCipher().decrypt(aliceSignalMessage.get(indexCounterThird))));
                } catch (InvalidMessageException | DuplicateMessageException | LegacyMessageException
                        | NoSessionException | UntrustedIdentityException e) {
                    updateText();
                }
                createText();                   
            }

            @Override
            protected void updateText() {
                varAliceRatchetPrivateKey = aliceRatchetPrivateKey.get(indexCounterKeys);
                varAliceRatchetPublicKey = aliceRatchetPublicKey.get(indexCounterKeys);
                varAliceRootKey = aliceRootKey.get(indexCounterKeys);
                varAliceSendingChainKey = aliceSendingChainKey.get(indexCounterKeys);
                varAliceSenderMsgKey = aliceSenderMsgKey.get(indexCounterKeys);
                varAliceReceivingChainKey = aliceReceivingChainKey.get(indexCounterKeys);
                
                varBobRatchetPrivateKey = bobRatchetPrivateKey.get(indexCounterKeys);
                varBobRatchetPublicKey = bobRatchetPublicKey.get(indexCounterKeys);
                varBobRootKey = bobRootKey.get(indexCounterKeys);
                varBobSendingChainKey = bobSendingChainKey.get(indexCounterKeys);
                varBobReceivingChainKey = bobReceivingChainKey.get(indexCounterKeys);
                varBobSenderMsgKey = bobSenderMsgKey.get(indexCounterKeys);                
            }

            @Override
            protected void createText() {
                aliceRatchetPrivateKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRatchetPrivateKey().serialize()));
                aliceRatchetPublicKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRatchetPublicKey().serialize()));
                aliceRootKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getRootKey().getKeyBytes()));
                aliceSendingChainKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getChainKey().getKey()));
                aliceSenderMsgKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getMessageKeys().getCipherKey().getEncoded()));
                aliceReceivingChainKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getChainKey().getKey()));
                
                bobRatchetPrivateKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getRatchetPrivateKey().serialize()));
                bobRatchetPublicKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getRatchetPublicKey().serialize()));
                bobRootKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getRootKey().getKeyBytes()));
                bobSendingChainKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getChainKey().getKey()));
                bobReceivingChainKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getAliceKeys().getChainKey().getKey()));
                bobSenderMsgKey.add(indexCounterKeys, ToHex.toString(signalEncryptionAlgorithm.getBobKeys().getMessageKeys().getCipherKey().getEncoded()));             
            }

            @Override
            STATE next(SignalEncryptionState parent) {
                indexCounterKeys++;
                indexCounterEncryptedMsg++;
                indexCounterThird++;
                BOB_SEND_MSG.switchState(parent);
                return BOB_SEND_MSG;
            }

            @Override
            STATE back(SignalEncryptionState parent) {
                indexCounterKeys--;
                indexCounterEncryptedMsg--;
                indexCounterThird--;
                indexCounterMsg--;
                ALICE_SEND_MSG.updateText();
                return ALICE_SEND_MSG;
            }
            
        };
        protected abstract void switchState(SignalEncryptionState parent);
        protected abstract void updateText();
        protected abstract void createText();
        abstract STATE next(SignalEncryptionState parent);
        abstract STATE back(SignalEncryptionState parent);
        
        public STATE setInitialState(SignalEncryptionState parent) {
            PARAMETER.switchState(parent);
            return PARAMETER;
        }
    }

    public STATE getCurrentState() {
        return currentState;
    }
    public void stepForward(SignalEncryptionState parent) {
        currentState = currentState.next(parent);
    }
    public void stepBack(SignalEncryptionState parent) {
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
    public String getBobMessage() {
        return bobMessage.get(indexCounterKeys);
    }
    public String getAliceMessage() {
        return aliceMessage.get(indexCounterKeys);
    }
    public String getBobEncryptedMessage() {
        return ToHex.toString(bobEncryptedMessage.get(indexCounterEncryptedMsg).serialize());
    }
    public String getAliceEncryptedMessage() {
        return ToHex.toString(aliceEncryptedMessage.get(indexCounterEncryptedMsg).serialize());
    }
    public void storeAlicePlainTextMessage(String msg) {
        alicePlainTextMessages.set(indexCounterEncryptedMsg, msg);
    }
    public void storeBobPlainTextMessage(String msg) {
        bobPlainTextMessages.set(indexCounterEncryptedMsg, msg);
    }
    

}
