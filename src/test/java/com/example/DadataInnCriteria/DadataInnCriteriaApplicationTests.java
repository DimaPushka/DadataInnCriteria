package com.example.DadataInnCriteria;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(properties = "dadata.client.token=5aca1b4081ef5604ffa22a187a4dcd34a8327a62")
class DadataInnCriteriaApplicationTests {

	Dadata dadata;

	@Test
	public void contextLoads() {
		dadata.GetResponse("7707083893").PrintSuggests();
	}

}
