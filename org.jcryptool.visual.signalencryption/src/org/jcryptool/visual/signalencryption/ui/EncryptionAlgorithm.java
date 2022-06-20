package org.jcryptool.visual.signalencryption.ui;

import java.util.Optional;

import org.jcryptool.visual.signalencryption.algorithm.AliceBobSessionBuilder;
import org.jcryptool.visual.signalencryption.ui.AlgorithmState;
import org.jcryptool.visual.signalencryption.ui.AlgorithmState.STATE;
import org.jcryptool.visual.signalencryption.algorithm.Keys;
import org.jcryptool.visual.signalencryption.util.ToHex;
import org.whispersystems.libsignal.SessionCipher;
import org.whispersystems.libsignal.SignalProtocolAddress;
import org.whispersystems.libsignal.ecc.ECPublicKey;
import org.whispersystems.libsignal.state.PreKeyBundle;
import org.whispersystems.libsignal.state.SessionStore;


public class EncryptionAlgorithm {

    public AliceBobSessionBuilder session;
    
    private SessionCipher bobSessionCipher;
    private SessionCipher aliceSessionCipher;

    //private Keys aliceKeys;
    //private Keys bobKeys;
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
    
    public EncryptionAlgorithm() {
        this.session = new AliceBobSessionBuilder();
        session.createSessionBoth();
        this.bobSessionCipher = session.getBobSessionCipher();
        this.aliceSessionCipher = session.getAliceSessionCipher();
        
        this.aliceSessionStore = session.getAliceSessionStore();
        this.bobSessionStore = session.getBobSessionStore();
        
        this.aliceAddress = session.getAliceAddress();
        this.bobAddress = session.getBobAddress();
    }

    public Keys getAliceKeys(STATE state) {
        ECPublicKey theirRatchetKey = bobSessionStore.loadSession(aliceAddress).getSessionState().getSenderRatchetKey();
        return new Keys(aliceSessionStore, bobAddress, Optional.of(theirRatchetKey), state);
    }
    public Keys getBobKeys(STATE state) {
        ECPublicKey theirRatchetKey = aliceSessionStore.loadSession(bobAddress).getSessionState().getSenderRatchetKey();
        return new Keys(bobSessionStore, aliceAddress, Optional.of(theirRatchetKey), state);   
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
    }
    
    public void generateAlice(STATE currentState) {
        session.createSessionAlice();
        
        aliceSessionCipher = session.getAliceSessionCipher();
        aliceSessionStore = session.getAliceSessionStore();
        aliceAddress = session.getAliceAddress();
    }
    
    public void generateBob(STATE state) {
        session.createSessionBob();
        
        bobSessionCipher = session.getBobSessionCipher();
        bobSessionStore = session.getBobSessionStore();
        bobAddress = session.getBobAddress();
    }
    
    

}
