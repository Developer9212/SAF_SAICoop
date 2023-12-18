package com.saf_saicoop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.saf_saicoop.controller",
	            "com.saf_saicoop.service",
	            "com.saf_saicoop.util",
	            "com.saf_saicoop.servicios_externo_SAF",
	            "com.saf_saicoop.security"})
@EntityScan("com.saf_saicoop.entity")
@EnableJpaRepositories("com.saf_saicoop.dao")
public class SafSaiCoopApplication {
    //wilmer
	public static void main(String[] args) {
		SpringApplication.run(SafSaiCoopApplication.class, args);
	}

}
