package Tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PostExample {
	

	@Test
	public void testpost() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		
		JSONObject request = new JSONObject();
		request.put("name", "waleed");
		request.put("job", "SQA");
		
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in/api";
		
		given().body(request.toJSONString()).when().post("/users").then().statusCode(201).and().log().all();
		
	}
	

}
