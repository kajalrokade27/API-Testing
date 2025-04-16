package apiEndpoints;
//UserEndPoints.java
//Created to perform Create, Read, Update, Delete requests to the API
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndpoints 
{
	 public static Response createUser(User payload) {
	        Response response = given()
	                .contentType(ContentType.JSON)
	                .accept(ContentType.JSON)
	                .body(payload)
	                .when()
	                .post(Routes.post_url);

	        return response;
	    }

	    public static Response readUser(String userName) {
	        Response response = given()
	                .pathParam("username", userName)
	                .when()
	                .get(Routes.get_url);

	        return response;
	    }

	    public static Response updateUser(String userName, User payload) {
	        Response response = given()
	                .contentType(ContentType.JSON)
	                .accept(ContentType.JSON)
	                .body(payload)
	                .when()
	                .post(Routes.post_url); // ⚠ This should likely be Routes.update_url

	        return response;
	    }
}
