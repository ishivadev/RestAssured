package day4_ParsingResBodyJSON;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

public class ParsingJSONresponseData {

	//@Test(priority=1)
	void testResponseData()
	{
		// Approach 1
		/*
		 given()
			.header("x-api-key","reqres-free-v1")
			.contentType(ContentType.JSON)
			
		.when()
			.get("https://reqres.in/api/users?page=2")
		
		
		.then()
			.statusCode(200)
			.body("page", equalTo(2))
			.body("per_page", equalTo(6))
		 	.header("Content-Type", "application/json; charset=utf-8")
		 	.body("data[1].first_name", equalTo("Lindsay"));
			//.log().all()
		*/
		
		
		// Approach 2
		
		Response res = given()
					.header("x-api-key","reqres-free-v1")
					
				.when()
					.get("https://reqres.in/api/users?page=2");
		 
		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.header("Content-Type"), "application/json; charset=utf-8");
		
		String firstname = res.jsonPath().get("data[1].first_name").toString();
		Assert.assertEquals(firstname, "Lindsay");
		
		
	}
	
	
	
	@Test(priority=2)
	void testResponseJSONBody()
	{
		 Response res = given()
			.header("x-api-key","reqres-free-v1")
			.contentType(ContentType.JSON)
			
		.when()
			.get("https://reqres.in/api/users?page=2");
		
		
		JSONObject jo = new JSONObject(res.getBody().asString());
		
		/*
		for(int i = 0; i < jo.getJSONArray("data").length(); i++ )
		{
			String allFirstName =  jo.getJSONArray("data").getJSONObject(i).get("first_name").toString();
			System.out.println(allFirstName);
		}
		*/
		
		boolean status = false;
		
		for(int i = 0; i < jo.getJSONArray("data").length(); i++ )
		{
			String firstName =  jo.getJSONArray("data").getJSONObject(i).get("first_name").toString();
			//System.out.println(frstName);
			
			/* if(firstName.equals("George"))
			{
				Assert.assertTrue(true);
				break;
			} */
			
			if(firstName.equals("George"))
				{
					status = true;
					break;
				} 
		}
		
		Assert.assertEquals(status, true);
		
	}
		
}
