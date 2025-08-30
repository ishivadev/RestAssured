package day3_QueryPathCookies;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class LogginDemo {

	@Test
	void testLogging()
	{
		given()
			
		.when()
			.get("https://www.google.com")
		
		.then()
			/*
			.log().headers()
			.log().cookies()
			.log().body()
			.log().cookies()
			.log().all();
			*/
			.log().everything();
	}
	
}
