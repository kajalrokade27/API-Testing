package fileUploadDownload;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class FileDownload 
{
	@Test
	void fileDownload() {

	    given()
	    .when()
	        .get("http://localhost:8080/downloadFile/Test1.txt")
	    .then()
	        .statusCode(200)
	        .log().body();
	}
}
