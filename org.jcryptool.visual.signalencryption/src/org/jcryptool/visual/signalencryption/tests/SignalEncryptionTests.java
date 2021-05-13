package org.jcryptool.visual.signalencryption.tests;

import static org.junit.Assert.assertEquals;

import java.io.UnsupportedEncodingException;

import org.jcryptool.visual.signalencryption.algorithm.AliceBobSessionBuilder;
import org.junit.jupiter.api.Test;
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
    
    private AliceBobSessionBuilder sessionBuilder;
    
    private SessionCipher alice;
    private SessionCipher bob;


    @Test
    void TestMessages() throws UnsupportedEncodingException, UntrustedIdentityException, InvalidMessageException, LegacyMessageException, DuplicateMessageException, NoSessionException, InvalidVersionException, InvalidKeyIdException, InvalidKeyException {
        
        sessionBuilder = new AliceBobSessionBuilder();
        
        sessionBuilder.createSession();
        alice = sessionBuilder.getAliceSessionCipher();
        bob = sessionBuilder.getBobSessionCipher();
        
        
        aliceEncryptedMessage = alice.encrypt("Hello world!".getBytes("UTF-8"));
        alicePreKeySignalMessage = new PreKeySignalMessage(aliceEncryptedMessage.serialize());
        
        System.out.println(aliceEncryptedMessage.serialize());
        String string = new String(bob.decrypt(alicePreKeySignalMessage));
        System.out.println(string);
        
        
        encryptedMessageBob = bob.encrypt("Wie gehts?".getBytes("UTF-8"));
        preKeySignalMessageBob = new SignalMessage(encryptedMessageBob.serialize());
        
        
        string = new String(alice.decrypt(preKeySignalMessageBob));
        
        aliceEncryptedMessage = alice.encrypt("Hello world!".getBytes("UTF-8"));
        preKeySignalMessageBob = new SignalMessage(aliceEncryptedMessage.serialize());

        System.out.println(aliceEncryptedMessage.serialize());
        string = new String(bob.decrypt(preKeySignalMessageBob));
        System.out.println(string);
        
        aliceEncryptedMessage = alice.encrypt("Hello world!".getBytes("UTF-8"));
        preKeySignalMessageBob = new SignalMessage(aliceEncryptedMessage.serialize());

        System.out.println(aliceEncryptedMessage.serialize());
        System.out.println(aliceEncryptedMessage);
        string = new String(bob.decrypt(preKeySignalMessageBob));
        System.out.println(string);
        
    }
        

}
