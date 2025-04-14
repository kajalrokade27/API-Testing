package jsonSchemaValidation;
import io.restassured.matcher.RestAssuredMatchers;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class XmlSchemaValidation 
{
	@Test
    void xmlSchemavalidation() {
        given()
        .when()
            .get("http://restapi.adequateshop.com/api/Traveler")
        .then()
            .assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("traveler.xsd"));
    }
}
