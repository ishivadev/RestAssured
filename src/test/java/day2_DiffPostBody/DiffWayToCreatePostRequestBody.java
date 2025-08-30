package day2_DiffPostBody;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

/*
 Different ways to create POST Request Body
 1. Post Request Body creation using Hashmap
 2. Post Request Body creation using Org.JSON
 3. Post Request Body creation using POJO Class (Plain Old Java Object)
 4. Post Request Body creation using External JSON File 
 */

public class DiffWayToCreatePostRequestBody {

	int id;
	
	// 1. Post Request Body creation using Hashmap
	//@Test(priority=1)
	void createPostUsingHashMap()
	{
		HashMap data = new HashMap();
		data.put("name", "Shiva");
		data.put("job", "Automation QA");
		data.put("phone", "123456");
		
		String coursesArr[] = {"Test", "Demo"};
		data.put("courses", coursesArr);
		
		
		given()
			.header("x-api-key","reqres-free-v1")
			.contentType("application/json")
			.body(data)
				
		.when()
			.post("https://reqres.in/api/users")
			//.jsonPath().getInt("id");
			
		.then()
			.statusCode(201)
			.body("name", equalTo("Shiva"))
			.body("job", equalTo("Automation QA"))
			.body("phone", equalTo("123456"))
			.body("courses[0]", equalTo("Test"))
			.body("courses[1]", equalTo("Demo"))
			.log().all();
	}
	
	
	// 2. Post Request Body creation using Org.JSON
	//@Test(priority=2)
	void createPostUsingOrgJSON()
	{
		
		JSONObject data = new JSONObject();
		data.put("name", "Shiva");
		data.put("job", "Automation QA");
		data.put("phone", "123456");
		
		String coursesArr[] = {"Test_1", "Demo_1"};
		data.put("courses", coursesArr);
		
		
		given()
			.header("x-api-key","reqres-free-v1")
			.contentType("application/json")
			.body(data.toString())	// Convert JSONObject to JSON string — REST-assured cannot handle org.json.JSONObject directly
			   						// ✅ Conversion to String is mandatory for org.json.JSONObject, since REST-assured expects a raw JSON string, not a JSONObject object.
 				
		.when()
			.post("https://reqres.in/api/users")
			//.jsonPath().getInt("id");
			
		.then()
			.statusCode(201)
			.body("name", equalTo("Shiva"))
			.body("job", equalTo("Automation QA"))
			.body("phone", equalTo("123456"))
			.body("courses[0]", equalTo("Test_1"))
			.body("courses[1]", equalTo("Demo_1"))
			.log().all();
	}
	
	
	// 3. Post Request Body creation using POJO Class (Plain Old Java Object)
	//@Test(priority=3)
	void createPostUsingPojoClass()
	{
		
		Data_PojoClass data = new Data_PojoClass();

		data.setName("Shiva");
		data.setJob("Automation QA");
		data.setPhone("123456");
		
		String coursesArr[] = {"Test_2", "Demo_2"};
		data.setCourses(coursesArr);	
		
		
		given()
			.header("x-api-key","reqres-free-v1")
			.contentType("application/json")
			.body(data)
				
		.when()
			.post("https://reqres.in/api/users")
			//.jsonPath().getInt("id");
			
		.then()
			.statusCode(201)
			.body("name", equalTo("Shiva"))
			.body("job", equalTo("Automation QA"))
			.body("phone", equalTo("123456"))
			.body("courses[0]", equalTo("Test_2"))
			.body("courses[1]", equalTo("Demo_2"))
			.log().all();
	}
	
	
	//  4. Post Request Body creation using External JSON File 
	@Test(priority=4)
	void createPostUsingExternalJSON() throws FileNotFoundException
	{
		
		File f = new File(".\\body.json");	// Create a File object pointing to the JSON file located in the current directory
		
		FileReader fr = new FileReader(f);	// Create a FileReader to read the contents of the specified JSON file 
		
		JSONTokener ft = new JSONTokener(fr);	// Pass the FileReader to a JSONTokener, which parses the character stream into JSON tokens
		
		JSONObject data = new JSONObject(ft);	// Create a JSONObject from the JSONTokener — this parses the actual JSON content into a usable object
		
		given()
			.header("x-api-key","reqres-free-v1")
			.contentType("application/json")
			.body(data.toString())		// Convert JSONObject to JSON string — REST-assured cannot handle org.json.JSONObject directly
									   // ✅ Conversion to String is mandatory for org.json.JSONObject, since REST-assured expects a raw JSON string, not a JSONObject object.
				
		.when()
			.post("https://reqres.in/api/users")
			//.jsonPath().getInt("id");
			
		.then()
			.statusCode(201)
			.body("name", equalTo("Shiva"))
			.body("job", equalTo("Automation QA"))
			.body("phone", equalTo("123456"))
			.body("courses[0]", equalTo("Test_3"))
			.body("courses[1]", equalTo("Demo_3"))
			.log().all();
	}
	
}
