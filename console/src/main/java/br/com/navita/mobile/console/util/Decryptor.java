package br.com.navita.mobile.console.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
 * @author Joe Prasanna Kumar
 * This program provides the following cryptographic functionalities
 * 1. Encryption using Decryptor
 * 2. Decryption using Decryptor
 *
 * High Level Algorithm :
 * 1. Generate a DES key (specify the Key size during this phase)
 * 2. Create the Cipher
 * 3. To Encrypt : Initialize the Cipher for Encryption
 * 4. To Decrypt : Initialize the Cipher for Decryption
 *
 *
 */

public class Decryptor {
	private static final int DIGEST_LENGTH = 20;
	public static String decrypt(String safeBase64,String key) throws DecryptorException {

		String encrypted = safeBase64.replace("_", "/").replace("-", "+").replace(".", "=");
		//.replace('/', '_').replace('+', '-').replace('=', '.')
		String strDecryptedText = "";

		try{
			/**
			 *  Step 1. Generate an Decryptor key using KeyGenerator
			 *  		Initialize the keysize to 128
			 *
			 */
			SecretKeySpec spec=new SecretKeySpec(new Base64().decode(key.getBytes()),"AES");
			/**
			 *  Step2. Create a Cipher by specifying the following parameters
			 * 			a. Algorithm name - here it is Decryptor
			 */

			Cipher aesCipher = Cipher.getInstance("AES");

			/**
			 *  Step 3. Initialize the Cipher for Encryption
			 */

			aesCipher.init(Cipher.ENCRYPT_MODE,spec);

			/**
			 *  Step 4. Encrypt the Data
			 *  		1. Declare / Initialize the Data. Here the data is of type String
			 *  		2. Convert the Input Text to Bytes
			 *  		3. Encrypt the bytes using doFinal method
			 */
			byte[] byteCipherText = new Base64().decode(encrypted.getBytes());
			/**
			 *  Step 5. Decrypt the Data
			 *  		1. Initialize the Cipher for Decryption
			 *  		2. Decrypt the cipher bytes using doFinal method
			 */
			aesCipher.init(Cipher.DECRYPT_MODE,spec,aesCipher.getParameters());
			byte[] byteDecryptedText = aesCipher.doFinal(byteCipherText);

			//Remove os 20 bytes finais
			byte[] plaintextAndHash =byteDecryptedText;
			int plaintextLength = plaintextAndHash.length - DIGEST_LENGTH;
			byte[] plaintext = new byte[ plaintextLength ];
			byte[] hash = new byte[ DIGEST_LENGTH ];
			System.arraycopy( plaintextAndHash, 0, plaintext, 0, plaintextLength );
			System.arraycopy( plaintextAndHash, plaintextLength, hash, 0,DIGEST_LENGTH );
			strDecryptedText = new String(plaintext);

		}catch (Throwable t){
			throw new DecryptorException(t);
		}
		return strDecryptedText;
	}

}

