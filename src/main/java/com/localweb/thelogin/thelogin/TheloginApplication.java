package com.localweb.thelogin.thelogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.localweb.thelogin.thelogin")
public class TheloginApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheloginApplication.class, args);
	}

}
