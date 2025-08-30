package day3_QueryPathCookies;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class HeadersTest {

	//@Test(priority=1)
	void testHeaders()
	{
		given()
			
		.when()
			.get("https://www.google.com")
		
		.then()
			.header("Cache-Control", "private, max-age=0")
			.header("Content-Type", "text/html; charset=ISO-8859-1");
			//.log().all();
			
	}
		
		
	
	@Test(priority=2)
	void getHeaders()
	{
		Response res = given()
			
		.when()
			.get("https://www.google.com");
		
		// Get single header
		//String header_value = res.getHeader("Content-Type");
		//System.out.println("Header value of 'Content-Type' : " + header_value);
	
		
		// Not need for getting all header like below. Same can be done using log().headers()
		
		// Get multiple headers
		 Headers headers_values = res.getHeaders();
		
		 for(Header hd : headers_values)
		 {
			 System.out.println(hd.getName() + " : " + hd.getValue());
		 }
		 
		 
	}
		
}
