package parsingResponseBody;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;
import java.util.Map;

public class ParsingXMLRes 
{
   @Test
   void textXMLResponse()
   {
	  //Approach 1(not executed because url is not valid 404 error)
	  /* given()
	   .when()
	       .get("http://restapi.adequateshop.com/api/Traveler?page=1")
	    .then()
	        .statusCode(200)
	        .header("Content-Type","application/xml; charset=utf-8")
	       .body("TravelerinformationResponse.page",equalTo("1"))
           .body("TravelerinformationResponse.travelers.Travelerinformation.name", equalTo("Vijay Bharat Reddy"));  }
   */
   
          //Approach 2 Store data in variable
   
   Response res = given()
   .when()
      .get("http://restapi.adequateshop.com/api/Traveler?page=1");
    
   Assert.assertEquals(res.getStatusCode(), 200);
   Assert.assertEquals(res.header("Content-Type"), "application/xml; charset=utf-8");
   String pageNo = res.xmlPath().get("TravelerinformationResponse.page").toString();
   Assert.assertEquals(pageNo, "1");
      
      
      
       }
   
   @Test
   void testXMLResponseBody() {

       Response res = 
           given()
               .get("http://restapi.adequateshop.com/api/Traveler?page=1");

       XmlPath xmlobj = new XmlPath(res.asString());

       //Verify total number of travellers
       List<String> travellers = xmlobj.getList("TravelerinformationResponse.travelers.Travelerinformation");
       Assert.assertEquals(travellers.size(), 10);

       //verify traveller name is present in response
       List<String> traveller_names = xmlobj.getList("TravelerinformationResponse.travelers.Travelerinformation.name");

       boolean status = false;
       for (String travellername : traveller_names) {
           if (travellername.equals("Vijay Bharath Reddy")) {
               status = true;
               break;
           }
       }

       Assert.assertEquals(status, true);
   }
}
