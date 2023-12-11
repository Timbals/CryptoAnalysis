package pkc.ka.issuesDHandECDH;

import java.security.*;
import java.security.spec.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import javax.crypto.interfaces.*;

public final class NonAuthenticatedDH_1024 {

	/**
	 * Original test with updated constraints:
	 * 	apg.init(1014) -> apg.init(3072)
	 */
	public void positiveTestCase() {
		try {
			AlgorithmParameterGenerator apg = AlgorithmParameterGenerator.getInstance("DH", "SunJCE");
			apg.init(3072);
			AlgorithmParameters p = apg.generateParameters();
			DHParameterSpec dhps = (DHParameterSpec) p.getParameterSpec(DHParameterSpec.class);

			KeyPairGenerator kpg1 = KeyPairGenerator.getInstance("DH", "SunJCE");
			kpg1.initialize(dhps);
			KeyPair kp1 = kpg1.generateKeyPair();

			KeyAgreement ka1 = KeyAgreement.getInstance("DH", "SunJCE");
			ka1.init(kp1.getPrivate());

			byte[] pubKey1 = kp1.getPublic().getEncoded();

			KeyFactory kf1 = KeyFactory.getInstance("DH", "SunJCE");
			X509EncodedKeySpec x509ks = new X509EncodedKeySpec(pubKey1);
			PublicKey apk1 = kf1.generatePublic(x509ks);

			DHParameterSpec dhps2 = ((DHPublicKey) apk1).getParams();

			KeyPairGenerator kpg2 = KeyPairGenerator.getInstance("DH", "SunJCE");
			kpg2.initialize(dhps2);
			KeyPair kp2 = kpg2.generateKeyPair();

			KeyAgreement ka2 = KeyAgreement.getInstance("DH", "SunJCE");
			ka2.init(kp2.getPrivate());

			byte[] pubKey2 = kp2.getPublic().getEncoded();

			KeyFactory kf2 = KeyFactory.getInstance("DH", "SunJCE");
			x509ks = new X509EncodedKeySpec(pubKey2);
			PublicKey apk2 = kf2.generatePublic(x509ks);
			ka1.doPhase(apk2, true);
			byte[] genSec1 = ka1.generateSecret();

			ka2.doPhase(apk1, true);
			byte[] genSec2 = ka2.generateSecret();

		} catch (Exception e) {
		}
	}

	/**
	 * Original test without any updates
	 */
	public void negativeTestCase() {
		try {
			AlgorithmParameterGenerator apg = AlgorithmParameterGenerator.getInstance("DH", "SunJCE");

			// Since 3.0.1: size of 1024 is not allowed
			apg.init(1024);
			AlgorithmParameters p = apg.generateParameters();
			DHParameterSpec dhps = (DHParameterSpec) p.getParameterSpec(DHParameterSpec.class);

			KeyPairGenerator kpg1 = KeyPairGenerator.getInstance("DH", "SunJCE");
			kpg1.initialize(dhps);
			KeyPair kp1 = kpg1.generateKeyPair();

			KeyAgreement ka1 = KeyAgreement.getInstance("DH", "SunJCE");
			ka1.init(kp1.getPrivate());

			byte[] pubKey1 = kp1.getPublic().getEncoded();

			KeyFactory kf1 = KeyFactory.getInstance("DH", "SunJCE");
			X509EncodedKeySpec x509ks = new X509EncodedKeySpec(pubKey1);
			PublicKey apk1 = kf1.generatePublic(x509ks);

			DHParameterSpec dhps2 = ((DHPublicKey) apk1).getParams();

			KeyPairGenerator kpg2 = KeyPairGenerator.getInstance("DH", "SunJCE");
			kpg2.initialize(dhps2);
			KeyPair kp2 = kpg2.generateKeyPair();

			KeyAgreement ka2 = KeyAgreement.getInstance("DH", "SunJCE");
			ka2.init(kp2.getPrivate());

			byte[] pubKey2 = kp2.getPublic().getEncoded();

			KeyFactory kf2 = KeyFactory.getInstance("DH", "SunJCE");
			x509ks = new X509EncodedKeySpec(pubKey2);
			PublicKey apk2 = kf2.generatePublic(x509ks);
			ka1.doPhase(apk2, true);
			byte[] genSec1 = ka1.generateSecret();

			ka2.doPhase(apk1, true);
			byte[] genSec2 = ka2.generateSecret();

		} catch (Exception e) {
		}
	}
}
