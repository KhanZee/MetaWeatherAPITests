package com.khanzee.testpackage;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;

//This class contains tests for Location method of Meta Weather API
public class Location extends TestDataProvider {

	@BeforeClass
	public void setup() {
		
		// Setting BaseURI once
		RestAssured.baseURI = "https://www.metaweather.com/api/location/";
	}

	//Test to check a 200 OK code is returned with valid request parameters
	@Test (dataProvider = "location")
	public void testStatusCode (String woeid) {

		given()
			.get(baseURI+woeid)
		.then()
			.statusCode(200);
			
	}
	
	//Test to check a 404 code is returned with invalid request parameters
		@Test (dataProvider = "location")
		public void test404StatusCode (String woeid) {

			given()
				.get(baseURI+woeid+"111111")
				.then()
				.statusCode(404);
			}

	
	
	
}

