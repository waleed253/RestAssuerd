package Tests;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TestLocalApi {
	
	@Test
	public void testpost() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		JSONObject request = new JSONObject();
		request.put("firstname", "hashim");
		request.put("lastname", "khan");
		request.put("subjectid", 1);
		
		System.out.println(request.toJSONString());
		
		baseURI = "http://localhost:3000";
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON).
		body(request.toJSONString()).when().post("/users").then().statusCode(201).and().log().all();
		
	}
	
	@Test
	public void TestPut() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		JSONObject request = new JSONObject();
		//request.put("firstname", "umer");
		request.put("lastname", "khan");
		//request.put("subjectid", 1);
		
		System.out.println(request.toJSONString());
		
		baseURI = "http://localhost:3000";
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON).
		body(request.toJSONString()).when().patch("/users/2").then().statusCode(200).and().log().all();
		
	}
	
	@Test
	public void TestDelete() {
		
		
		baseURI = "http://localhost:3000";
		
		when().delete("users/6").then().statusCode(200);
		
	}
	
	

}
