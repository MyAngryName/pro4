package org.jcryptool.visual.signalencryption.ui;

import org.jcryptool.visual.signalencryption.algorithm.AliceBobSessionBuilder;
import org.jcryptool.visual.signalencryption.algorithm.Keys;
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
    private Keys keys;
    
    private SessionStore aliceSessionStore;
    private SessionStore bobSessionStore;

    private SignalProtocolAddress aliceAddress;
    private SignalProtocolAddress bobAddress;
    
    private STATE currentState = STATE.PARAMETER;

    
    public SignalEncryptionAlgorithm() {
        this.session = new AliceBobSessionBuilder();
        session.createSessionBoth();
        this.bobSessionCipher = session.getBobSessionCipher();
        this.aliceSessionCipher = session.getAliceSessionCipher();
        
        this.aliceSessionStore = session.getAliceSessionStore();
        this.bobSessionStore = session.getBobSessionStore();
        
        this.aliceAddress = session.getAliceAddress();
        this.bobAddress = session.getBobAddress();

        this.aliceKeys = new Keys(aliceSessionStore, bobAddress, currentState);
        this.bobKeys = new Keys(bobSessionStore, aliceAddress, currentState);
    }
    
    public enum STATE {
        PARAMETER {
            protected void switchState(SignalEncryptionAlgorithm parent) {
                parent.keys = new Keys(parent.aliceKeys);
            }
            @Override
            STATE alice(SignalEncryptionAlgorithm parent) {
                return PARAMETER;
            }
            @Override 
            STATE bob(SignalEncryptionAlgorithm parent) {
                PRE_KEY_SIGNAL_MESSAGE.switchState(parent);
                return PRE_KEY_SIGNAL_MESSAGE;
            }
        }, PRE_KEY_SIGNAL_MESSAGE {
            protected void switchState(SignalEncryptionAlgorithm parent) {
                parent.keys = new Keys(parent.bobKeys);
            }
            @Override
            STATE alice(SignalEncryptionAlgorithm parent) {
                PARAMETER.switchState(parent);
                return PARAMETER;
            }
            @Override 
            STATE bob(SignalEncryptionAlgorithm parent) {
                return PRE_KEY_SIGNAL_MESSAGE;
            }
        };
        protected abstract void switchState(SignalEncryptionAlgorithm parent);
        abstract STATE alice(SignalEncryptionAlgorithm parent);
        abstract STATE bob(SignalEncryptionAlgorithm parent);
        
        public STATE setInitialState(SignalEncryptionAlgorithm parent) {
            PARAMETER.switchState(parent);
            return PARAMETER;
        }
    }

    public Keys getAliceKeys() {
        return aliceKeys;
    }
    public Keys getBobKeys() {
        return bobKeys;
    }
    public STATE getCurrentState() {
        return currentState;
    }
    public PreKeyBundle getAlicePreKeyBundle() {
        return session.getAlicePreKeyBundle();
    }
    public PreKeyBundle getBobPreKeyBundle() {
        return session.getBobPreKeyBundle();
    }
    public void generateBoth() {
        session.createSessionBoth();
        bobSessionCipher = session.getBobSessionCipher();
        aliceSessionCipher = session.getAliceSessionCipher();
        
        aliceSessionStore = session.getAliceSessionStore();
        bobSessionStore = session.getBobSessionStore();
        
        aliceAddress = session.getAliceAddress();
        bobAddress = session.getBobAddress();

        aliceKeys = new Keys(aliceSessionStore, bobAddress, currentState);
        bobKeys = new Keys(bobSessionStore, aliceAddress, currentState);
        keys = new Keys(aliceKeys);
    }
    
    public void generateAlice() {
        session.createSessionAlice();
        
        aliceSessionCipher = session.getAliceSessionCipher();
        aliceSessionStore = session.getAliceSessionStore();
        aliceAddress = session.getAliceAddress();
        aliceKeys = new Keys(aliceSessionStore, bobAddress, currentState);
    }
    
    public void generateBob() {
        session.createSessionBob();
        
        bobSessionCipher = session.getBobSessionCipher();
        bobSessionStore = session.getBobSessionStore();
        bobAddress = session.getBobAddress();
        bobKeys = new Keys(bobSessionStore, aliceAddress, currentState);
    }
    
    

}
