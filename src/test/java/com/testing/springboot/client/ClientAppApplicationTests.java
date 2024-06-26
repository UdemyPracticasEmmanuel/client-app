package com.testing.springboot.client;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ClientAppApplicationTests {
	@Autowired
	TestRestTemplate restTemplate;
/*
	@Test
	void shouldReturnAPokemon() {
		ResponseEntity<String> response = restTemplate.getForEntity("/pokemon/ditto", String.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

		DocumentContext documentContext = JsonPath.parse(response.getBody());
		String id = documentContext.read("$.id");
		assertThat(id).isEqualTo("ditto");
	}
	@Test
	void shouldNotReturnAPokemonWithAnUnknownId() {
		ResponseEntity<String> response = restTemplate.getForEntity("/pokemon/fuecoco", String.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
		assertThat(response.getBody()).isBlank();
	} */

}
