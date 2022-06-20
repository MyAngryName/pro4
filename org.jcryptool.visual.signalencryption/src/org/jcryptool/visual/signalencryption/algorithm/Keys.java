package org.jcryptool.visual.signalencryption.algorithm;

import java.util.Optional;

import org.jcryptool.core.logging.utils.LogUtil;
import org.jcryptool.visual.signalencryption.exceptions.SignalAlgorithmException;
import org.jcryptool.visual.signalencryption.ui.AlgorithmState.STATE;
import org.whispersystems.libsignal.SignalProtocolAddress;
import org.whispersystems.libsignal.ecc.ECPrivateKey;
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
    private ECPublicKey   ratchetPublicKey;
    private ECPrivateKey  ratchetPrivateKey;
    
    private SessionStore sessionStore;
    private SignalProtocolAddress remoteAddress;

    public Keys(
            SessionStore sessionStore,
            SignalProtocolAddress remoteAddress,
            Optional<ECPublicKey> theirEphemeralKey,
            STATE currentState
    ) {
        this.sessionRecord   = sessionStore.loadSession(remoteAddress);
        this.sessionState    = sessionRecord.getSessionState();
        this.sendingChainKey = sessionState.getSenderChainKey();
        this.messageKeys     = sendingChainKey.getMessageKeys();
        this.rootKey         = sessionState.getRootKey();
        this.senderEphemeral = sessionState.getSenderRatchetKey();
        if (currentState == STATE.INITIALIZING) {
            this.receivingChainKey = null;
        } else {
            try {
                this.receivingChainKey = sessionState.getReceiverChainKey(theirEphemeralKey.orElseThrow(() -> new SignalAlgorithmException()));
            } catch (SignalAlgorithmException e) {
                LogUtil.logError(e);
            }
        }
        this.ratchetPublicKey = sessionState.getSenderRatchetKey();
        this.ratchetPrivateKey = sessionState.getSenderRatchetKeyPair().getPrivateKey();
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
    public MessageKeys getMessageKeys() {
        return messageKeys;
    }
    public ECPublicKey getRatchetPublicKey() {
        return ratchetPublicKey;
    }
    public ECPrivateKey getRatchetPrivateKey() {
        return ratchetPrivateKey;
    }
    
}
