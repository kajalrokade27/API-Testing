package apiAutomation;

import java.util.HashMap;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class CreatePostRequestBody 
{
	int id;  
	
    @Test
    void testPostUsingHashmap()
    {
    	HashMap data = new HashMap();
    	data.put("name", "kajal");
        
    	String jobArr[] = {"QA Eng", "Chemist"};
    	data.put("job", jobArr);
    	
    	id=given()
    	      .contentType("application/json")
    	      .body(data)
    	 .when()
    	       .post("https://reqres.in/api/users?page=2")
//    	  .then()
//    	       .statusCode(201)
//    	       .body("name", equalTo("kajal"))
//    	       .log().all();
    	
    	
    	
    }
}
