package tests;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.sun.tools.javac.util.Log;
 
public class PutPatchDeleteExamples {
	
	@Test
	public void testPut() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		JSONObject Request = new JSONObject();
		
		Request.put("name", "Mutbahir");
		Request.put("job", "SQA");
		
		System.out.println(Request.toJSONString());
		
		baseURI = "https://reqres.in/api";
			
		given().
		header("Content-Type", "application/json").
			body(Request.toJSONString()).
		when().
			put("/users/2").
		then().
			statusCode(200).log().all();
	}

	@Test
	public void testPatch() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		JSONObject Request = new JSONObject();
		
		Request.put("name", "Mutbahir");
		Request.put("job", "SQA");
		
		System.out.println(Request.toJSONString());
		
		baseURI = "https://reqres.in";
			
		given().
		header("Content-Type", "application/json").
			body(Request.toJSONString()).
		when().
			patch("/api/users/2"). 
		then().
			statusCode(200).log().all();
	}
	
	
	@Test
	public void testDelete() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		JSONObject Request = new JSONObject();
		
		Request.put("name", "Mutbahir");
		Request.put("job", "SQA");
		
		System.out.println(Request.toJSONString());
		
		baseURI = "https://reqres.in";
			
		given().
		header("Content-Type", "application/json").
			body(Request.toJSONString()).
		when().
			delete("/api/users/2"). 
		then().
			statusCode(204).log().all();
	}
	
	
	
	


}
