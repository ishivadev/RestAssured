package day6_SchemaValidate;

import io.restassured.matcher.RestAssuredMatchers;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class XMLSchemaValidator {

	@Test
	void testXmlSchemaValidate()
	{
		given()
		
		
		.when()
			.get("https://webhook.site/c6c5dae8-0a55-43f5-9ec5-b44580f1a8c1")
		
		.then()
			.assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("xmlSchema.xsd"));
	}
	
	
}
