package org.jcryptool.visual.signal;

import org.whispersystems.*;
import org.whispersystems.libsignal.IdentityKey;
import org.whispersystems.libsignal.ecc.Curve;
import org.whispersystems.libsignal.ecc.ECKeyPair;
public class SignallibTest {
	public static void main(String[] args)
    {
		System.out.println("Importing libsignal");
		System.out.println("Creating new DJBEC curve");
        ECKeyPair testKeyPair = Curve.generateKeyPair();
//        IdentityKey testIK = new IdentityKey(testKeyPair.getPublicKey());
//        System.out.println("Test IdentityKey Fingerprint: " + testIK.getFingerprint());
        
        
       
    }
}
