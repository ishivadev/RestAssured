package day6_SchemaValidate;

import io.restassured.module.jsv.JsonSchemaValidator;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

// JSON to JSONSchema converter
// https://jsonformatter.org/json-to-jsonschema

public class JSONSchemaValidation {

	@Test
	void testJSONSchema()
	{
		given()
			.header("x-api-key","reqres-free-v1")
		
		.when()
			.get("https://reqres.in/api/users?page=2")
		
		.then()
			.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("jsonSchema.json"));
		
	}
	
}
