package org.jcryptool.visual.signalencryption.algorithm;

import org.jcryptool.visual.signalencryption.ui.SignalEncryptionAlgorithm.STATE;
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
    private ChainKey      sendingChainKey;
    private ChainKey      receivingChainKey;
    private MessageKeys   messageKeys;
    private ECPublicKey   senderEphemeral;
    private int           previousCounter;
    private int           sessionVersion;
    private RootKey       rootKey;
    
    private SessionStore sessionStore;
    private SignalProtocolAddress remoteAddress;

    public Keys(SessionStore sessionStore, SignalProtocolAddress remoteAddress, STATE currentState) {
        this.sessionRecord   = sessionStore.loadSession(remoteAddress);
        this.sessionState    = sessionRecord.getSessionState();
        this.sendingChainKey = sessionState.getSenderChainKey();
        this.messageKeys     = sendingChainKey.getMessageKeys();
        this.rootKey         = sessionState.getRootKey();
        this.senderEphemeral = sessionState.getSenderRatchetKey();
        if (currentState == STATE.PARAMETER) {
            this.receivingChainKey = null;
        }else {
            this.receivingChainKey = sessionState.getReceiverChainKey(senderEphemeral);
        }
        this.previousCounter = sessionState.getPreviousCounter();
        }
    public Keys(Keys keys) {
        this.sessionStore = keys.sessionStore;
        this.remoteAddress = keys.remoteAddress;
    }
    
    public ChainKey getChainKey() {
        return sendingChainKey;
    }
    public RootKey getRootKey() {
        return rootKey;
    }
    public SessionRecord getSessionRecord() {
        return sessionRecord;
    }
    public ChainKey getReceivingChainKey() {
        return receivingChainKey;
    }
    
}
