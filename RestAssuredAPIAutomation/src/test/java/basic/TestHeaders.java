package basic;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TestHeaders 
{
	@Test(enabled=true)
    void testCookie()
    {
    	given()
    	
    	.when()
    	      .get("https://www.google.com/")
    	 
    	 .then()
    	       .header("Content-Type", "text/html; charset=ISO-8859-1")
    	       .and()
    	       .header("Content-Encoding", "gzip")
    	       .and()
    	       .header("Server", "gws")
    	       .log().headers();
    }
	
	@Test
	void testCookies()
	{
		Response res = given()
				 
				
				     .when()
				     .get("https://www.google.com/");
		//Get single header info
		String headerValue = res.getHeader("Content_Type");
		System.out.println("The value of Content-Type is " + headerValue);
		
		//Get all headers info
		Headers allHeaders = res.getHeaders();
		
		for(Header hd: allHeaders)
		{
			System.out.println(hd.getName()+"            "+hd.getValue());
		}
		
				     
	}
}
