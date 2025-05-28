package com.example.castells_casteller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CastellsCastellerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CastellsCastellerApplication.class, args);
	}

}
