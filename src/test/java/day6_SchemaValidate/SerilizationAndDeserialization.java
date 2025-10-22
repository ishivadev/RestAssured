package day6_SchemaValidate;

// Pojo ---- Serialize ----> Json ---- Deserialize -----> Pojo

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerilizationAndDeserialization {

	// Pojo ------> Json ( Serialization )
	//@Test(priority=1)
	void convertPojo2Json() throws JsonProcessingException
	{
		// Created java object using Pojo class
		Student_PojoClass stupojo = new Student_PojoClass();	//Pojo class
		
		stupojo.setName("Shiva");
		stupojo.setJob("Automation QA");
		stupojo.setPhone("123456");
		String coursesArr[] = {"Test_2", "Demo_2"};
		stupojo.setCourses(coursesArr);
		
		// Convert Java Object ----> JSON Object ( Serialization )
		ObjectMapper objMapper = new ObjectMapper();
		
		String jsondata = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(stupojo);
		
		System.out.println(jsondata);
	}
	
	
	
	// Json ------> Pojo ( De-Serialization )
	@Test(priority=2)
	void convertJson2Pojo() throws JsonMappingException, JsonProcessingException
	{
		String jsondata = "{\r\n"
				+ "  \"name\" : \"Shiva\",\r\n"
				+ "  \"job\" : \"Automation QA\",\r\n"
				+ "  \"phone\" : \"123456\",\r\n"
				+ "  \"courses\" : [ \"Test_2\", \"Demo_2\" ]\r\n"
				+ "}";
		
		// Convert JSON Object ----> Java Object ( De-Serialization )
		ObjectMapper objMapper = new ObjectMapper();
		
		Student_PojoClass stupojo = objMapper.readValue(jsondata, Student_PojoClass.class);
		
		System.out.println("Name : " + stupojo.getName("Dev"));
		System.out.println("Job : " + stupojo.getJob("Automation QA"));
		System.out.println("Phone : " + stupojo.getPhone("123456"));
		System.out.println("Couser 1 : " + stupojo.getCourses()[0]);
		System.out.println("Couser 2 : " + stupojo.getCourses()[1]);
	}
}
