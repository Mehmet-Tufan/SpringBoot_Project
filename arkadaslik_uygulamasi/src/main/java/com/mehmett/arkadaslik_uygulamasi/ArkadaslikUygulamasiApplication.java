package com.mehmett.arkadaslik_uygulamasi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/au")
public class ArkadaslikUygulamasiApplication {
	@GetMapping("/m")
	public String merhaba() {
		return "merhaba";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ArkadaslikUygulamasiApplication.class, args);
	}
	
}