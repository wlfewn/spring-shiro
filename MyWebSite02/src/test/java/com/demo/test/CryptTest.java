package com.demo.test;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CryptTest {

	@Test
	public void test01(){
		BCryptPasswordEncoder cryptPasswordEncoder = new BCryptPasswordEncoder(8);
		System.out.println(cryptPasswordEncoder.encode("admin123"));
	}
	
	@Test
	public void test02(){
		String encodedPassword = "$2a$08$Xfy6dDar3VJdA5UVgeN5NOkzQucC8CJI7zCmeXRbbZa/Ou7zgwciq"; 
		BCryptPasswordEncoder cryptPasswordEncoder = new BCryptPasswordEncoder(8);
		System.out.println(cryptPasswordEncoder.matches("admin123", encodedPassword));
	}
}
