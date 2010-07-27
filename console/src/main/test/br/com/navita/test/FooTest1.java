package br.com.navita.test;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

public class FooTest1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Md5PasswordEncoder().encodePassword("banana01", null));

	}

}
