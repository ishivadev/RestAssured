package day3_QueryPathCookies;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class PathAndQueryParameters {

	@Test
	void testPathAndQueryParams()
	{
	
		given()
			.header("x-api-key","reqres-free-v1")
			.pathParam("usersList", "users")	// 'path' variable name can be user defines
			.queryParam("page", 2)		// query variable name should not changed
			.queryParam("id", 4)		// query variable name should not changed
		
		.when()
			.get("https://reqres.in/api/{usersList}")
			
		.then()
			.log().all();
	}
	
}
