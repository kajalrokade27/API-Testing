package parsingResponseBody;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

import io.restassured.response.Response;

public class ParsingJsonResBody 
{
    @Test
    public void testJsonResData()
    {
    	Response res = given()
    			       .contentType("Content-Type.JSON")
    			       
    			       
    			       
    			       .when()
    			       .get("https://reqres.in/api/users?page=2");
    	
    	
    /*	Assert.assertEquals(res.getStatusCode(), 200);
        String firstName = res.jsonPath().get("data.first_name").toString();
    	Assert.assertEquals(firstName, "Charles");	  */
    	
    Boolean status = false;
       JSONObject jo = new JSONObject(res.toString());  //converting response to json object type
       
      for(int i =0; i<jo.getJSONArray("data").length(); i++)
       {
    	  String f_name = jo.getJSONArray("data").getJSONObject(i).get("first_name").toString();
          System.out.println(f_name);
          if(f_name.equals("Charles"))
          {
        	  status = true;
        	  break;
          }
       }
      
       
    			       
    }
}
