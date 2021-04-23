package jeep.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import entity.Jeep;
import entity.jeepModel;
import io.swagger.v3.oas.models.PathItem.HttpMethod;
import jeep.controller.support.FetchTestJeep;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class FetchJeepTest extends FetchTestJeep{
	  @Autowired
	  private TestRestTemplate restTemplate;
	
	  @Test
	void testThatJeepsAreReturnedWhenAValidModelAndTrimAreSupplied() {
jeepModel model = jeepModel.WRANGLER;
	String trim = "Sport";
	String URI = String.format("%s?model=%s&trim=%s", getBaseURI(), model, trim);
	

	ResponseEntity<List<Jeep>> response = 
	restTemplate.exchange(URI, HttpMethod.GET, null, 
			new ParameterizedTypeReference<>() {});
	
	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	
	
	List<Jeep> expected = buildExpected();
	assertThat(response.getBody()).isEqualTo(expected);	}


	}


	

	
	

	
	
	


