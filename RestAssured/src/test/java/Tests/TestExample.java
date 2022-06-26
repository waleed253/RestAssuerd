package Tests;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class TestExample {
	
	@Test
	public void test1() {
		
		Response response = get("https://reqres.in/api/users?page=2");
		
		System.out.println("STATUS CODE: " + response.getStatusCode());
		System.out.println("RESPONSE TIME: " + response.getTime());
		System.out.println("GET BODY : " + response.getBody().asString());
		System.out.println("STATUS LINE : " + response.getStatusLine());
		System.out.println("HEADERS : " + response.getHeader("content-type"));
		
		int statuscode = response.getStatusCode();
		
		Assert.assertEquals(statuscode, 200);
		}
	
	@Test
	public void test2() {
		baseURI = "https://reqres.in";
		
		given().get("api/users?page=2").then().statusCode(200)
		.body("data[0].email", equalTo("michael.lawson@reqres.in"))   // verifying the data...
		.body("data.first_name", hasItems("George","Rachel"));
		
				
	}
	
	
	
	

}
