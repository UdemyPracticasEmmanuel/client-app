package com.testing.springboot.client;

import com.testing.springboot.client.services.PokeService;
import org.junit.jupiter.api.Test;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ClientAppApplicationTests {
	//TestRestTemplate restTemplate;
	PokeService pokeService = new PokeService();

	@Test
	void encryptStringTest() throws UnsupportedEncodingException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		String ivString = "1234567890123456";
		String secret = "UjXn2r5u8x/A?D(G";
		String message = "Hello AES World!";

		byte[] encrypted = pokeService.encryptAes(message, ivString, secret);
		System.out.println("Encrypted: " + encrypted.toString());

		//TODO: Decrypted en construcción
		//System.out.println("Decrypted " + decryptAes(encrypted, ivString, secret));
	}

	@Test
	void encryptNullMessageTest() throws UnsupportedEncodingException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		String ivString = "1234567890123456";
		String secret = "UjXn2r5u8x/A?D(G";
		String message = "222";

		byte[] encrypted = pokeService.encryptAes(message, ivString, secret);
		System.out.println("Encrypted: " + encrypted.toString());

	}

	@Test
	void pokemonExistTest(){
		try{
			String pokeName= "ditto";
			Map<String, String> pokemon = pokeService.getPokemonByName(pokeName);
			System.out.println(pokemon);

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Test
	void pokemonDoesNotExistTest(){
		try{
			String pokeName= "lolo";
			Map<String, String> pokemon = pokeService.getPokemonByName(pokeName);
			System.out.println(pokemon);

		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
