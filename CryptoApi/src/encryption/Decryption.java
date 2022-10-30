package encryption;

import java.security.PrivateKey;

import keys.Keys;

public class Decryption 
{

	public String rsaDecryption(PrivateKey chavePrivada, byte[] textoCodificado)
    {
		Keys chaves = new Keys();
        String textoDescodificado;
        
			try {
				textoDescodificado = chaves.decrypt(chavePrivada, textoCodificado);
				return textoDescodificado; 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		 
    }
	
}
