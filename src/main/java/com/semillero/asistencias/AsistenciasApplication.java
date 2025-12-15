package com.semillero.asistencias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class AsistenciasApplication implements CommandLineRunner {

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(AsistenciasApplication.class, args);
	}

/* 	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			// Configure CORS if needed
		};
	} */

	@Override
	public void run(String... args) throws Exception {
		
		//genere contraseña con Bean PasswordEncoder
		String password = "contra123";
		for (int i = 0; i < 3 ; i++) {
			String passwordEncoded = passwordEncoder.encode(password);
			System.out.println("Password encoded: " + passwordEncoded);
			
		}

		
	}

}
