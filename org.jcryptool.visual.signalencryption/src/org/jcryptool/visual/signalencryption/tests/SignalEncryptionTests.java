package org.jcryptool.visual.signalencryption.tests;

import java.io.UnsupportedEncodingException;

import org.jcryptool.visual.signalencryption.algorithm.JCrypToolCapturer;
import org.jcryptool.visual.signalencryption.algorithm.SessionManager;
//import org.junit.jupiter.api.Test;
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


public class SignalEncryptionTests {
    
    
    private CiphertextMessage aliceEncryptedMessage;
    private PreKeySignalMessage alicePreKeySignalMessage;
    
    private CiphertextMessage encryptedMessageBob;
    private SignalMessage preKeySignalMessageBob;
    
    private SessionManager sessionBuilder;
    
    private SessionCipher alice;
    private SessionCipher bob;

    
    //@Test
    void shouldEncryptAndDecrypMessages() throws UnsupportedEncodingException, UntrustedIdentityException, InvalidMessageException, 
    LegacyMessageException, DuplicateMessageException, NoSessionException, InvalidVersionException, InvalidKeyIdException, InvalidKeyException {
        
        sessionBuilder = new SessionManager();
        
        sessionBuilder.createSessionBoth();
        alice = sessionBuilder.getAliceSessionCipher();
        bob = sessionBuilder.getBobSessionCipher();
        
        
        aliceEncryptedMessage = alice.encrypt().doEncrypt("Hello world!".getBytes("UTF-8"));
        alicePreKeySignalMessage = new PreKeySignalMessage(aliceEncryptedMessage.serialize());
        
        System.out.println(aliceEncryptedMessage.serialize());
        String string = new String(bob.decrypt(alicePreKeySignalMessage, new JCrypToolCapturer()));
        System.out.println(string);
        
        
        encryptedMessageBob = bob.encrypt().doEncrypt("Wie gehts?".getBytes("UTF-8"));
        preKeySignalMessageBob = new SignalMessage(encryptedMessageBob.serialize());
        
        
        string = new String(alice.decrypt(preKeySignalMessageBob, new JCrypToolCapturer()));
        
        aliceEncryptedMessage = alice.encrypt().doEncrypt("Hello world!".getBytes("UTF-8"));
        preKeySignalMessageBob = new SignalMessage(aliceEncryptedMessage.serialize());

        System.out.println(aliceEncryptedMessage.serialize());
        string = new String(bob.decrypt(preKeySignalMessageBob, new JCrypToolCapturer()));
        System.out.println(string);
        
        aliceEncryptedMessage = alice.encrypt().doEncrypt("Hello world!".getBytes("UTF-8"));
        preKeySignalMessageBob = new SignalMessage(aliceEncryptedMessage.serialize());

        System.out.println(aliceEncryptedMessage.serialize());
        System.out.println(aliceEncryptedMessage);
        string = new String(bob.decrypt(preKeySignalMessageBob, new JCrypToolCapturer()));
        System.out.println(string);
        
    }
        

}
