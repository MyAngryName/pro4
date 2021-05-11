package org.jcryptool.visual.signalencryption.tests;

import static org.junit.Assert.assertEquals;

import java.io.UnsupportedEncodingException;

import org.jcryptool.visual.signalencryption.algorithm.SessionInitialization;
import org.jcryptool.visual.signalencryption.algorithm.SignalSessionBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
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
    
    private SignalSessionBuilder session;
    private SessionInitialization sessionInitialization;
    private SignalMessage message;
    
    private CiphertextMessage aliceEncryptedMessage;
    private PreKeySignalMessage alicePreKeySignalMessage;
    
    private CiphertextMessage encryptedMessageBob;
    private SignalMessage preKeySignalMessageBob;
    
    

    @Test
    void TestMessages() throws UnsupportedEncodingException, UntrustedIdentityException, InvalidMessageException, LegacyMessageException, DuplicateMessageException, NoSessionException, InvalidVersionException, InvalidKeyIdException, InvalidKeyException {
        
        sessionInitialization = new SessionInitialization();
        
        SessionCipher alice = sessionInitialization.aliceBuildSession();
        SessionCipher bob = sessionInitialization.bobBuildSession();
        
        
        aliceEncryptedMessage = alice.encrypt("Hello world!".getBytes("UTF-8"));
        alicePreKeySignalMessage = new PreKeySignalMessage(aliceEncryptedMessage.serialize());
        
        
        String string = new String(bob.decrypt(alicePreKeySignalMessage));
        System.out.println(string);
        
        
        encryptedMessageBob = bob.encrypt("Wie gehts?".getBytes("UTF-8"));
        preKeySignalMessageBob = new SignalMessage(encryptedMessageBob.serialize());
        
        
        string = new String(alice.decrypt(preKeySignalMessageBob));
        System.out.println(string);

        
        //message = new SignalMessage(encryptedMessage.serialize());
        
                
        
        
        
        
        
    }
        

}
