package org.jcryptool.visual.signalencryption.algorithm;

import org.whispersystems.libsignal.ecc.ECPrivateKey;
import org.whispersystems.libsignal.ecc.ECPublicKey;

/** Dataclass which is passed through the algorithm to capture each relevant variable */
public class JCrypToolCapturer {
    // Diffie-Hellman-Ratchet
    public ECPublicKey publicDiffieHellmanRatchetKey;
    public ECPrivateKey  privateDiffieHellmanRatchetKey;
    public byte[] diffieHellmanRatchetOutput;

    // Root Chain
    public Object rootChainKey;
    public Object rootChainConstantInput;
    public Object rootKdfOutput;
    public Object newRootChain;

    public SendReceiveChain sendChain = new SendReceiveChain();
    public SendReceiveChain receiveChain = new SendReceiveChain();


    // MessageKey
    public Object messageKey;

    public class SendReceiveChain {
    // Send/Receive chain
        public Object chainKey;
        public Object chainConstantInput;
        public Object kdfOutput;
        public Object newChainKey;
    }
}
