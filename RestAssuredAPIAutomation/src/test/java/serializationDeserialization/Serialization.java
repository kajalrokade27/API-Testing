package serializationDeserialization;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Serialization 
{
   @Test
   public void convertPojoToJson() throws JsonProcessingException
   {
	// created java object using POJO class
	    StudPOJO stupojo = new StudPOJO();  // POJO
	    stupojo.setName("Scott");
	    stupojo.setLocation("France");
	    stupojo.setPhone("123456");
	    String coursesArr[] = {"C", "C++"};
	    stupojo.setCourses(coursesArr);

	    // convert java object ---> JSON object (serialization)
	    ObjectMapper objMapper = new ObjectMapper();

	    String jsondata = objMapper
	                        .writerWithDefaultPrettyPrinter()
	                        .writeValueAsString(stupojo);

	    System.out.println(jsondata); 
   }
}
