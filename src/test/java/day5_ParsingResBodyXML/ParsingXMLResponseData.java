package day5_ParsingResBodyXML;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;


public class ParsingXMLResponseData {

	//@Test(priority=1)
	void testXMLData()
	{
		//Approach 1
		/*
		given()
		
		.when()
			.get("https://webhook.site/c6c5dae8-0a55-43f5-9ec5-b44580f1a8c1")
		
		.then()
			.statusCode(200)
			.body("TravelerInformationResponse.page", equalTo("1"))
			.body("TravelerInformationResponse.travelers.TravelerInformation[0].name", equalTo("Vijay Bharath Reddy"))
			//.log().all()
			
			;		
		*/
		
		
		//Approach 2
		Response res = given()
				
		.when()
			.get("https://webhook.site/c6c5dae8-0a55-43f5-9ec5-b44580f1a8c1");
		
		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.xmlPath().get("TravelerInformationResponse.page").toString(), "1");
		String name = res.xmlPath().get("TravelerInformationResponse.travelers.TravelerInformation[0].name").toString();
		Assert.assertEquals(name, "Vijay Bharath Reddy");
	}
	
	
	
	@Test(priority=2)
	void testXMLResponseData()
	{
		Response res = given()
				
		.when()
			.get("https://webhook.site/c6c5dae8-0a55-43f5-9ec5-b44580f1a8c1");
				
		XmlPath xmlObj = new XmlPath(res.asString());
		
		List<String> travelers_names = xmlObj.getList("TravelerInformationResponse.travelers.TravelerInformation.name");
		System.out.println(travelers_names.size());
		
		for(String name : travelers_names)
		{
			System.out.println("Travelers name : " + name);
		}
		
	
	}
	
	
}
