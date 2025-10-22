package day5_ParsingResBodyXML;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

import org.testng.annotations.Test;

public class UploadFile {

	@Test(priority=1)
	void upluadSingleFile()
	{
		File file = new File("D:\\Automation\\Sample Json Test1.txt");
	
		given()
			.contentType("multipart/form-data")
			.multiPart("file", file)
			
		.when()
			.post("https://api.escuelajs.co/api/v1/files/upload")
		
		.then()
			.statusCode(201)
			.log().body()
			//.log().all()
		;
	}
	
	
	
	//@Test(priority=2)
	void upluadMultipleFiles()
	{
		File file1 = new File("D:\\Automation\\Sample Json Test1.txt");
		File file2 = new File("D:\\Automation\\Sample Json Test2.txt");
		
		given()
			.contentType("multipart/form-data")
			.multiPart("file", file1)
			.multiPart("file", file2)
			
		.when()
			.post("https://api.escuelajs.co/api/v1/files/upload")
		
		.then()
			.statusCode(201)
			.log().body()
			//.log().all()
		;
	}
	
}
