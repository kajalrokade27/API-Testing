package serializationDeserialization;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Deserialization 
{
	@Test
	void convertJson2Pojo() throws JsonProcessingException {

	    String jsondata = "{\r\n"
	        + "  \"name\": \"Scott\",\r\n"
	        + "  \"location\": \"France\",\r\n"
	        + "  \"phone\": \"123456\",\r\n"
	        + "  \"courses\": [\"C\", \"C++\"]\r\n"
	        + "}";

	    // Convert JSON data --> POJO object
	    ObjectMapper objMapper = new ObjectMapper();

	    StudPOJO stupojo = objMapper.readValue(jsondata, StudPOJO.class); // convert JSON to POJO

	    System.out.println("Name: " + stupojo.getName());
	    System.out.println("Location: " + stupojo.getLocation());
	    System.out.println("Phone: " + stupojo.getPhone());
	    System.out.println("Course 1: " + stupojo.getCourses()[0]);
	    System.out.println("Course 2: " + stupojo.getCourses()[1]);
	}
}
