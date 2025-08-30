package day1_HTTPRequest;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

/*
 given()
 	content type, set cookies, add auth, add parameters, set headers info etc....
 	
 when()
 	get, post, put, delete
 
 then()
 	validate status code, extract response, extract headers, cookies and response body.....
 */


public class HTTPRequest {
	
	int id;
	
	//@Test(priority=1)
	void getUsers()			// Getting all users
	{
		given()
			.header("x-api-key","reqres-free-v1")
		
		.when()
			.get("https://reqres.in/api/users?page=2")
		
		.then()
			.statusCode(200)
			//.body(null, null)
			.log().all();
	}
	
	
	@Test(priority=2)
	void createUser()		// Creating a user
	{
		HashMap data = new HashMap();
		data.put("name", "dev");
		data.put("job", "testing");
		
		//getting the id
		id = given() 
			.header("x-api-key","reqres-free-v1")
			.contentType("application/json")
			.body(data)
		
		.when()
			.post("https://reqres.in/api/users")
			.jsonPath().getInt("id"); //returning the id
		
		//.then()
		//	.statusCode(201)
		//	.log().all();
		
	}
	
	
	@Test(priority=3, dependsOnMethods = {"createUser"})
	void updateUser()		// Updating the user
	{
		HashMap data = new HashMap();
		data.put("name", "shiva");
		data.put("job", "educator");
		
		
		given()
			.header("x-api-key","reqres-free-v1")
			.contentType("application/json")
			.body(data)
		
		.when()
			.put("https://reqres.in/api/users/"+id)
		
		.then()
			.statusCode(200)
			.log().all();
	}
	
	
	@Test(priority=4, dependsOnMethods = {"createUser"})
	void deleteUser()		// Deleting the user
	{
		
		given()
		.header("x-api-key","reqres-free-v1")
		
		.when()
			.delete("https://reqres.in/api/users/"+id)
		
		.then()
			.statusCode(204);
		
	}
	
}
