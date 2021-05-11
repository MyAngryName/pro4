package org.jcryptool.visual.signalencryption.algorithm;

import org.whispersystems.libsignal.InvalidKeyException;
import org.whispersystems.libsignal.SessionBuilder;
import org.whispersystems.libsignal.SessionCipher;
import org.whispersystems.libsignal.SignalProtocolAddress;
import org.whispersystems.libsignal.UntrustedIdentityException;
import org.whispersystems.libsignal.state.PreKeyBundle;
import org.whispersystems.libsignal.state.PreKeyRecord;
import org.whispersystems.libsignal.state.PreKeyStore;
import org.whispersystems.libsignal.state.SignedPreKeyStore;

public class SessionInitialization {
    
    
    
    private SignalSessionBuilder alice;
    private SignalSessionBuilder bob;
    
    private SessionBuilder aliceSession;
    private SessionBuilder bobSession;

    
    private PreKeyBundle bobPreKeyBundle;
    private PreKeyBundle alicePreKeyBundle;
    
    
    private final int aliceDeviceId;
    private final int bobDeviceId;
    
    private final SignalProtocolAddress aliceAddress;
    private final SignalProtocolAddress bobAddress;
    
    private SignedPreKeyStore signedPreKeyStore;
    private PreKeyStore preKeyStore;


    
    public SessionInitialization() {
        
        
        this.aliceDeviceId = 42;
        this.bobDeviceId = 43;
        this.aliceAddress = new SignalProtocolAddress("Alice", aliceDeviceId);
        this.bobAddress = new SignalProtocolAddress("Bob", bobDeviceId);
        this.alice = new SignalSessionBuilder(bobAddress, aliceDeviceId);
        this.bob = new SignalSessionBuilder(aliceAddress, bobDeviceId);
        this.bobPreKeyBundle = bob.getPreKeyBundle();
        this.alicePreKeyBundle = alice.getPreKeyBundle();   
    }
    
    public SessionCipher aliceBuildSession() {
        
        
        aliceSession = alice.getSession();
        
        signedPreKeyStore = alice.getSignedPreKeyStore();
        preKeyStore = alice.getPreKeyStore();
        
        signedPreKeyStore.storeSignedPreKey(alice.getParameter().getSignedPreKeyID(), alice.getParameter().getSignedPreKeyRecord());
        preKeyStore.storePreKey(alice.getParameter().getPreKeyID(), alice.getPreKeyRecord());
        
        
        try {
            aliceSession.process(bobPreKeyBundle);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (UntrustedIdentityException e) {
            e.printStackTrace();
        }
        SessionCipher sessionCipher = new SessionCipher(alice.getSessionStore(), 
                alice.getPreKeyStore(), alice.getSignedPreKeyStore(), 
                alice.getIdentityKeyStore(), bobAddress);
        
        return sessionCipher;
        }
    
    public SessionCipher bobBuildSession() {
        
        bobSession = bob.getSession();
        
        signedPreKeyStore = bob.getSignedPreKeyStore();
        preKeyStore = bob.getPreKeyStore();
        
        signedPreKeyStore.storeSignedPreKey(bob.getParameter().getSignedPreKeyID(), bob.getParameter().getSignedPreKeyRecord());
        preKeyStore.storePreKey(bob.getParameter().getPreKeyID(), bob.getPreKeyRecord());
        
        try {
            bobSession.process(alicePreKeyBundle);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (UntrustedIdentityException e) {
            e.printStackTrace();
        }
        SessionCipher sessionCipher = new SessionCipher(bob.getSessionStore(), 
                bob.getPreKeyStore(), bob.getSignedPreKeyStore(), 
                bob.getIdentityKeyStore(), aliceAddress);
        return sessionCipher;
        }
    
    

    
    
    
}
