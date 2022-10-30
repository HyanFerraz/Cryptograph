package encryption;

import java.security.PublicKey;

import keys.Keys;

public class Encryption 
{

	public byte[] rsaEncryption(PublicKey chavePublica, String texto)
	{
	
		Keys chaves = new Keys();
		byte[] cipherText;
		try {
			cipherText = chaves.encrypt(chavePublica, texto);
			return cipherText;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			return null;
		}
	}
}
