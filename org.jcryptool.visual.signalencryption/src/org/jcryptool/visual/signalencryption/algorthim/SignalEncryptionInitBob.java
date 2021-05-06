package org.jcryptool.visual.signalencryption.algorthim;

import org.whispersystems.libsignal.ratchet.*;
import org.whispersystems.libsignal.state.SessionState;

public class SignalEncryptionInitBob {
    
    private BobSignalProtocolParameters.Builder initializeBob;
    private BobSignalProtocolParameters bob;

    private SessionState bobState;
    
    
    public SignalEncryptionInitBob() {
        this.bobState = new SessionState();
        this.bob = initializeBob.create();
    }
    public SessionState getBobState() {
        return bobState;
    }
    
    public BobSignalProtocolParameters getBob() {
        return bob;
    }

}
