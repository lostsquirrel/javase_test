package demo.security.rsa;

import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class AsymmetricKeyTester {

	
	public static void main(String[] args) throws Exception {
//		what for?
		String algorithm = "Blowfish";
		KeyGenerator keyGenerator = KeyGenerator.getInstance(algorithm);
		keyGenerator.init(128);
		Key blowfishKey = keyGenerator.generateKey();

		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		keyPairGenerator.initialize(1024);
		KeyPair keyPair = keyPairGenerator.genKeyPair();

		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());

		byte[] blowfishKeyBytes = blowfishKey.getEncoded();
		System.out.println(new String(blowfishKeyBytes));
		byte[] cipherText = cipher.doFinal(blowfishKeyBytes);
		System.out.println(new String(cipherText));
		cipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());

		byte[] decryptedKeyBytes = cipher.doFinal(cipherText);
		System.out.println(new String(decryptedKeyBytes));
		@SuppressWarnings("unused")
		SecretKey newBlowfishKey = new SecretKeySpec(decryptedKeyBytes,
				algorithm);
	}
}
