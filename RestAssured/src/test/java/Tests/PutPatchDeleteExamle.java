package Tests;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PutPatchDeleteExamle {
	
	
	@Test
	public void TestPut() {              											 // same for patch just change the function
		//Map<String, Object> map = new HashMap<String, Object>();
		JSONObject request = new JSONObject();
		request.put("name", "waleed");
		request.put("job", "SQA");
		
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in/api";
		
		given().body(request.toJSONString()).when().put("/users/2").then().statusCode(200).and().log().all();
		
	}
	
	@Test
	public void TestDelete() {
		
		
		baseURI = "https://reqres.in";
		
		when().delete("/api/users/2").then().statusCode(204).and().log().all();
		
	}
	
	
	
	
	
	
	
	
	

}
