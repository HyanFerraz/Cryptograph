package keys;


import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.Cipher;

public class Keys
{

	public KeyPair CreateKeyPair()
	{
		
		
		final int KEY_SIZE = 2048;
		try {
			KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
			keyPairGenerator.initialize(KEY_SIZE);			
			return keyPairGenerator.genKeyPair();
		} catch (NoSuchAlgorithmException e) {
			System.out.println("Algoritimo inexistente");
			return null;
		}
		
	}

    public byte[] encrypt(PublicKey publicKey, String texto) throws Exception
    {
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");  
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);  
        return cipher.doFinal(texto.getBytes());  
    }
	
	public String decrypt(PrivateKey privateKey, byte [] encrypted) throws Exception
    { 
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");  
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return new String(cipher.doFinal(encrypted));
    }
}
