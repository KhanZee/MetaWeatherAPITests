package com.khanzee.testpackage;
import org.testng.annotations.Test;
import org.hamcrest.core.Is;
import org.testng.annotations.BeforeClass;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;

//This class contains tests for "Location Search" method of Meta Weather API
public class LocationSearch extends TestDataProvider {


	@BeforeClass
	public void setup() {
		
		// Setting BaseURI once
		RestAssured.baseURI = "https://www.metaweather.com/api/location/search/?query=";
	}

	//Test to check a 200 OK code is returned with valid request parameters
	@Test (dataProvider = "locationSearch")
	public void testStatusCode (String location) {

		given()
			.get(baseURI+location)
		.then()
			.statusCode(200);
	}
	
	//Test to validate response body contains valid field names and values
		@Test
		public void testPayload () {
			
			given()
			.get(baseURI+"Nottingham")
			.then()
	        	.assertThat()
	        	.body("[0].location_type", Is.is("City"))
	        	.body("[0].title", Is.is("Nottingham"))
	        	.body("[0].woeid", Is.is(30720))
	        	.body("[0].latt_long", Is.is("52.949219,-1.143920"));
		}
}