package com.neri.vr;

import static com.jayway.restassured.RestAssured.basic;
import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.when;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.not;

import java.io.File;
import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.http.ContentType;
import com.neri.vr.model.Credito;
import com.neri.vr.service.CreditoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CreditoServiceTest {
	
	@Autowired
	private CreditoService creditoService;
	
	@Value("${payment-server.baseURI}")
	private String baseURI;
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Before
	public void setup() {


		RestAssured.baseURI = baseURI;

		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		RestAssured.requestSpecification = new RequestSpecBuilder().setContentType(ContentType.JSON)
				.setAccept(ContentType.JSON).build();
	}
	
	@Test
	public void createSimplePayment() throws Throwable { // @formatter:off
		JsonNode json = getRequestBody("credit.json");

		 given().			
			body(json).
		when().
	       post("v1/creditos").
	    then().
	    	statusCode(201);
		
	} // @formatter:on
	
	
	@Test
	public void createCreditTest() {
		Credito credito = new Credito();
		credito.setAmount(1);
		credito.setCreatedAt(LocalDateTime.now());
		credito.setCreatedBy("teste");
		credito.setNextRecharge(LocalDateTime.now());
		Credito result = creditoService.create(credito);
	}
	
	
	private JsonNode getRequestBody(String filename) throws Throwable {
		File src = ResourceUtils.getFile("classpath:json/" + filename);
		return objectMapper.readValue(src, JsonNode.class);
	}

}
