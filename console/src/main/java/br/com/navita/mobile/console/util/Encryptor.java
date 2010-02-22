package br.com.navita.mobile.console.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;


public class Encryptor {

	public static String encrypt(String plain,String key) throws Exception{
		SecretKeySpec spec=new SecretKeySpec(new Base64().decode(key.getBytes()),"AES");
		Cipher aesCipher = Cipher.getInstance("AES");
		aesCipher.init(Cipher.ENCRYPT_MODE,spec);
		//concatenar plain com um hash SHA1 de plain
		byte[] sha1Hash = DigestUtils.sha(plain);
		byte[] plainBytes = plain.getBytes();
		byte[] plainAndHash = new byte[plainBytes.length + sha1Hash.length];
		System.arraycopy(plainBytes, 0, plainAndHash, 0, plainBytes.length);
		System.arraycopy(sha1Hash, 0, plainAndHash, plainBytes.length, sha1Hash.length);
		byte[] encrypted = aesCipher.doFinal(plainAndHash);

		return new String(new Base64().encode(encrypted)).replace("/", "_").replace("+", "-").replace("=", ".");

	}


}
