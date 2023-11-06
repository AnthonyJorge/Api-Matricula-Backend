package com.moviles.segurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class DecoderPassword {

	public static void main(String[] args) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		String password = "admin";
		String encodedPassword = "$2a$10$zkMHOYQF9IK1q4t76oI9N.zEz3O78ivuHYCif9mkuE/1yh4.me9bS";
		
		boolean isPasswordMatch = passwordEncoder.matches(password, encodedPassword);
		System.out.println("Password : " + password + "   isPasswordMatch    : " + isPasswordMatch);
		
	}
}
