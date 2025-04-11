package fileUploadDownload;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

import org.testng.annotations.Test;

public class SingleFileUpload 
{
	@Test
	void singleFileUpload() {

	    File myfile = new File("C:\\AutomationPractice\\Test1.txt");

	    given()
	        .multiPart("file", myfile)
	        .contentType("multipart/form-data")
	    .when()
	        .post("http://localhost:8080/uploadFile")
	    .then()
	        .statusCode(200)
	        .body("fileName", equalTo("Test1.txt"))
	        .log().all();
	}
}
