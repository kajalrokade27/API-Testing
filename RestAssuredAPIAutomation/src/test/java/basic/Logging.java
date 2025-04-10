package basic;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import groovy.util.logging.Log;

public class Logging 
{
	@Test(enabled=true)
    void testCookie()
    {
    	given()
    	
    	.when()
    	      .get("https://www.google.com/")
    	 
    	 .then()
    	       .log().cookies()
    	       .log().body()
    	       .log().headers()
    	       .log().all();
    	      
    }
	
}
