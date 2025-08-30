package day3_QueryPathCookies;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class CookiesTest {

	//@Test(priority=1)
	void testCookies()
	{
		given()
			
		.when()
			.get("https://www.google.com")
		
		.then()
			.cookie("AEC", "AVh_V2iiWuzt99pZek828NmLugHG7smU1rbl7s8D6jfUG-FFlv7jNsEYgw");
		
	}
	
	
	
	@Test(priority=2)
	void getCookies()
	{
		Response res =  given()
			
		.when()
			.get("https://www.google.com");
		

		// get single cookie
		/*
		String cookie_value = res.getCookie("AEC");
		System.out.println(cookie_value);
		*/
		
		// get all the cookies
		Map<String, String> cookies_values = res.getCookies();
		System.out.println("Keys are : "+ cookies_values.keySet());
		
		for(String  k:cookies_values.keySet())
		{
			System.out.println(k + " : " + res.getCookie(k));
		}
		
	}
	
	
}
