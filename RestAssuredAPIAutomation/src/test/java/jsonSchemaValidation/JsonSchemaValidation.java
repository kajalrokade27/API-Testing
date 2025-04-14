package jsonSchemaValidation;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.module.jsv.JsonSchemaValidator;
public class JsonSchemaValidation 
{
	@Test
    void jsonschemavalidation() {
        given()
        .when()
            .get("https://simple-books-api.glitch.me/status")
        .then()
            .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("storeSchema.json"));
        
    }
}