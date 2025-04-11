package basic;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class TestCookies {
	// cookies values are changing dynamically
	@Test(enabled = false)
	void testCookie() {
		given()

				.when()
				.get("https://www.google.com/")

				.then()
				.cookie("AEC", "AVcja2eQjj99yRCM8syS1DLBvoMFAOYZ_2IL_fDNJnTBWkYQ1n_bEGsasQ")
				.log().all();

	}

	@Test(enabled = true)
	void getCookiesInfo() {
		Response res = given()

				.when()
				.get("https://www.google.com/");

		// Get single cookie
		String sinCookie = res.getCookie("AEC");
		System.out.println("Value of single cookie is " + sinCookie);

		// Get all or multiple cookie keys
		Map<String, String> allCookies = res.getCookies();
		System.out.println("All generated cookie keys are " + allCookies.keySet());

		// Get all the cookie values

		for (String key : allCookies.keySet()) {
			String cookieVal = res.getCookie(key);
			System.out.println(key + "    " + cookieVal);
		}

	}
}
