package basic;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

public class CreatePostRequestBody 
{
	int id; 
	
	@Test(priority=0, enabled=false)
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
    	       .jsonPath().getInt("id");
    	
    	
//    	  .then()
//    	       .statusCode(201)
//    	       .body("name", equalTo("kajal"))
//    	       .log().all();
    	
    }
	
	
	@Test(priority=0)
    void testPostUsingOrgJson()
    {
    	JSONObject data = new JSONObject();
        data.put("name", "kajal");
        
    	String jobArr[] = {"QA Eng", "Chemist"};
    	data.put("job", jobArr);
    	
    	id=given()
    	      .contentType("application/json")
    	      .body(data.toString())
    	 .when()
    	       .post("https://reqres.in/api/users?page=2")
    	       .jsonPath().getInt("id");
    	
    	
//    	  .then()
//    	       .statusCode(201)
//    	       .body("name", equalTo("kajal"))
//    	       .log().all();
    	
    }
	
	//Post request body using pojo class
	@Test
	void testPostUsingPojo()
	{
		POJO_PostRequest data = new POJO_PostRequest();
		data.setName("kajal");
		String jobs[]= {"QA", "Chemist"};
		data.setJobs(jobs);
		
    	
    	given()
    	      .contentType("application/json")
    	      .body(data)
    	      
    	 .when()
    	       .post("https://reqres.in/api/users?page=2")
    	       
    	
    	
   	  .then()   	       
   	       .statusCode(201)
   	       .body("name", equalTo("kajal"))
    	       .log().all();
	}
	
	//Post request body using external json file
	@Test
	void testPostUsingExtFile() throws FileNotFoundException
	{
		File f = new File(".\\body.json");
		
		FileReader fr = new FileReader(f);
		JSONTokener jt = new JSONTokener(fr);
		JSONObject data = new JSONObject(jt);
		
		given()
	      .contentType("application/json")
	      .body(data.toString())
	      
	 .when()
	       .post("https://reqres.in/api/users?page=2")
	       
	
	
	  .then()   	       
	       .statusCode(201)
	       .body("name", equalTo("Asawari"))
	       .log().all();
		
	}
	@Test(priority=1)
	void testDelete()
	{
        given()
    	
    	.when()
    	       .delete("https://reqres.in/api/users/"+id)
    	
    	.then()
    	      .statusCode(204)
    	      .log().all();
    	
	}
	
}
