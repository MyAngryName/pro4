package org.jcryptool.visual.signalencryption.ui;

import org.jcryptool.visual.signalencryption.algorithm.AliceBobSessionBuilder;
import org.jcryptool.visual.signalencryption.ui.SignalEncryptionState;
import org.jcryptool.visual.signalencryption.ui.SignalEncryptionState.STATE;
import org.jcryptool.visual.signalencryption.algorithm.Keys;
import org.jcryptool.visual.signalencryption.util.ToHex;
import org.whispersystems.libsignal.SessionCipher;
import org.whispersystems.libsignal.SignalProtocolAddress;
import org.whispersystems.libsignal.state.PreKeyBundle;
import org.whispersystems.libsignal.state.SessionStore;


public class SignalEncryptionAlgorithm {

    public AliceBobSessionBuilder session;
    
    private SessionCipher bobSessionCipher;
    private SessionCipher aliceSessionCipher;

    private Keys aliceKeys;
    private Keys bobKeys;
    private Keys aliceKeysParameter;
    private Keys bobKeysParameter;
    private Keys alicePreKeys;
    private Keys bobPreKeys;
    private Keys aliceCurrentKeys;
    private Keys bobCurrentKeys;
    
    private SessionStore aliceSessionStore;
    private SessionStore bobSessionStore;

    private SignalProtocolAddress aliceAddress;
    private SignalProtocolAddress bobAddress;
    
    private SignalEncryptionState signalEncryptionState;

    
    public SignalEncryptionAlgorithm(STATE state) {
        this.session = new AliceBobSessionBuilder();
        session.createSessionBoth();
        this.bobSessionCipher = session.getBobSessionCipher();
        this.aliceSessionCipher = session.getAliceSessionCipher();
        
        this.aliceSessionStore = session.getAliceSessionStore();
        this.bobSessionStore = session.getBobSessionStore();
        
        this.aliceAddress = session.getAliceAddress();
        this.bobAddress = session.getBobAddress();
        

        this.aliceKeys = new Keys(aliceSessionStore, bobAddress, state);
        this.bobKeys = new Keys(bobSessionStore, aliceAddress, state);   
    }
    
    

    public Keys getAliceKeys() {
        return aliceKeys;
    }
    public Keys getBobKeys() {
        return bobKeys;
    }
    public PreKeyBundle getAlicePreKeyBundle() {
        return session.getAlicePreKeyBundle();
    }
    public PreKeyBundle getBobPreKeyBundle() {
        return session.getBobPreKeyBundle();
    }
    public AliceBobSessionBuilder getSession() {
        return session;
    }
    public SessionCipher getBobSessionCipher() {
        return bobSessionCipher;
    }
    public SessionCipher getAliceSessionCipher() {
        return aliceSessionCipher;
    }
    
    
    public void generateBoth(STATE state) {
        session.createSessionBoth();
        bobSessionCipher = session.getBobSessionCipher();
        aliceSessionCipher = session.getAliceSessionCipher();
        
        aliceSessionStore = session.getAliceSessionStore();
        bobSessionStore = session.getBobSessionStore();
        
        aliceAddress = session.getAliceAddress();
        bobAddress = session.getBobAddress();

        aliceKeys = new Keys(aliceSessionStore, bobAddress, state);
        bobKeys = new Keys(bobSessionStore, aliceAddress, state);
    }
    
    public void generateAlice(STATE state) {
        session.createSessionAlice();
        
        aliceSessionCipher = session.getAliceSessionCipher();
        aliceSessionStore = session.getAliceSessionStore();
        aliceAddress = session.getAliceAddress();
        aliceKeys = new Keys(aliceSessionStore, bobAddress, state);
    }
    
    public void generateBob(STATE state) {
        session.createSessionBob();
        
        bobSessionCipher = session.getBobSessionCipher();
        bobSessionStore = session.getBobSessionStore();
        bobAddress = session.getBobAddress();
        bobKeys = new Keys(bobSessionStore, aliceAddress, state);
    }
    
    

}
