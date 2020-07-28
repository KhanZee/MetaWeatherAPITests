package com.khanzee.testpackage;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import io.restassured.RestAssured;

//This class contains tests for "Location Day" method of Meta Weather API
public class LocationDay extends TestDataProvider {

	@BeforeClass
	public void setup() {
		
		// Setting BaseURI once
		RestAssured.baseURI = "https://www.metaweather.com/api/location/";
	}

	//Test to check a 200 OK code is returned with valid request parameters
	@Test (dataProvider = "locationDay")
	public void test200StatusCode (String woeid, String date) {

		given()
			.get(baseURI+woeid+"/"+date)
		.then()
			.statusCode(200);
	}
	
	//Test to check a 404 code is returned with invalid request parameters
		@Test (dataProvider = "locationDay")
		public void test404StatusCode (String woeid, String date) {

			given()
				.get(baseURI+woeid+"/"+date+"11")
			.then()
				.statusCode(404);
		}
	
	//This test confirm that response field names and data types are as expected.
	@Test
	public void testJSONSchema () {
		
		given()
		.get(baseURI+"30720/2020/08/01")
		.then()
			.statusCode(200).log().all()
        	.assertThat()
        	.body(matchesJsonSchemaInClasspath("nottinghamLocationDaySchemaFile.json"));
	}

	//Test to confirm that response headers are as expected.
	@Test
	public void testResponseHeaders () {
	
	given()
	.get(baseURI+"30720/2020/08/01")
	.then()
    	.assertThat()
    	.header("Content-Language", "en")
    	.header("x-xss-protection", "1; mode=block")
    	.header("x-content-type-options", "nosniff")
    	.header("strict-transport-security", "max-age=2592000; includeSubDomains")
		.header("Vary", "Accept-Language, Cookie")
		.header("Allow", "GET, HEAD, OPTIONS")
		.header("x-frame-options", "DENY")
		.header("Content-Type", "application/json");
	}
}
