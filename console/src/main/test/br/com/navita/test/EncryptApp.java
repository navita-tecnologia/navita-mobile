package br.com.navita.test;

import br.com.navita.mobile.console.util.Encryptor;

public class EncryptApp {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		System.out.println(Encryptor.encrypt("user=navita&password=navita123", "RrSe916DqrdQANfFKaQkgQ=="));
	}

}
