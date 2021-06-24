package com.hiberus.twitter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories("com.hiberus.twitter.repository")
public class TwitterApplication {

	public static void main(String[] args) {

		SpringApplication.run(TwitterApplication.class, args);
	}

}
