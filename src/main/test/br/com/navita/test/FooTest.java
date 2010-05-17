package br.com.navita.test;

import org.springframework.security.providers.encoding.Md5PasswordEncoder;

public class FooTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Md5PasswordEncoder().encodePassword("banana01", null));

	}

}
