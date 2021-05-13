package org.jcryptool.visual.signalencryption.algorithm;

import org.whispersystems.libsignal.SignalProtocolAddress;
import org.whispersystems.libsignal.ecc.ECPublicKey;
import org.whispersystems.libsignal.ratchet.ChainKey;
import org.whispersystems.libsignal.ratchet.MessageKeys;
import org.whispersystems.libsignal.ratchet.RootKey;
import org.whispersystems.libsignal.state.SessionRecord;
import org.whispersystems.libsignal.state.SessionState;
import org.whispersystems.libsignal.state.SessionStore;

public class Keys {
    
   
    private SessionRecord sessionRecord;
    private SessionState  sessionState;
    private ChainKey      senidngChainKey;
    private MessageKeys   messageKeys;
    private ECPublicKey   senderEphemeral;
    private int           previousCounter;
    private int           sessionVersion;
    private RootKey       rootKey;


    public Keys(SessionStore sessionStore, SignalProtocolAddress remoteAddress) {
        this.sessionRecord   = sessionStore.loadSession(remoteAddress);
        this.sessionState    = sessionRecord.getSessionState();
        this.senidngChainKey = sessionState.getSenderChainKey();
        this.messageKeys     = senidngChainKey.getMessageKeys();
        this.rootKey         = sessionState.getRootKey();
        this.senderEphemeral = sessionState.getSenderRatchetKey();
        this.previousCounter = sessionState.getPreviousCounter();
        
        }
    public ChainKey getChainKey() {
        return senidngChainKey;
    }
    public RootKey getRootKey() {
        return rootKey;
    }

}
