package com.testing.springboot.client;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class ClientAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(ClientAppApplication.class, args);

	}

}
