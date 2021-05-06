package org.jcryptool.visual.signalencryption.algorthim;

import org.whispersystems.libsignal.ratchet.*;
import org.whispersystems.libsignal.state.SessionState;

public class SignalEncryptionInitAlice {


    
    private AliceSignalProtocolParameters.Builder initializeAlice;
    private AliceSignalProtocolParameters alice;
     
    private SessionState aliceState;


    public SignalEncryptionInitAlice() {
        this.alice = initializeAlice.create();
        this.aliceState = new SessionState();
    }
    
    public SessionState getAliceState() {
        return aliceState;
    }
    
    public AliceSignalProtocolParameters getAlice() {
        return alice;
    }

}
