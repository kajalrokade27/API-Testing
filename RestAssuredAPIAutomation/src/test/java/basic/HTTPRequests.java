package basic;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

/* 
 * given()
 * Content type, set cookies, add auth, add param, set headers info etc
 * 
 * When()
 * get,post, put, delete
 * 
 * then()
 * validate status code, extract response, extract headers cookies and response body...
 * 
 * 
 * import static packages
 */
public class HTTPRequests
{
	int id; 
    @Test(priority=0)
    void getUser()
    {
    	given()
    	
    	.when()
    	        .get("https://reqres.in/api/users?page=2")
    	.then()
    	       .statusCode(200)
    	       .body("page",equalTo(2))
    	       .log().all();
    }
    @Test(priority=1)
    void createUser()
    {
    	HashMap data = new HashMap();
    	data.put("name", "kajal");
    	data.put("job", "QA");
    	
    	id=given()
    	      .contentType("application/json")
    	       .body(data)
    	       
    	.when()
    	       .post("https://reqres.in/api/users?page=2")
    	       .jsonPath().getInt("id");
    	
    	   
//    	 .then()
//    	        .statusCode(201)
//    	        .log().all();
    	       
    	       
    }
    
    @Test(priority=2,dependsOnMethods = {"createUser"})
    void updateUser()
    {
    	HashMap data = new HashMap();
    	data.put("name", "kajal satpute");
    	data.put("job", "QA Engineer");
    	
    	given()
    	      .contentType("application/json")
    	       .body(data)
    	       
    	.when()
    	       .put("https://reqres.in/api/users/"+id)
    	       
    	
    	   
    	 .then()
    	        .statusCode(200)
    	        .log().all();
    	       
    }
    
    @Test(priority=3)
    void deleteUser()
    {
    	given()
    	
    	.when()
    	       .delete("https://reqres.in/api/users/"+id)
    	
    	.then()
    	      .statusCode(204)
    	      .log().all();
    	
    }
    
}


