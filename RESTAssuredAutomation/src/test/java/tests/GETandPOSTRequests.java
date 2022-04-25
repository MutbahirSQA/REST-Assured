package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static  io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class GETandPOSTRequests {

	
	//@Test
	public void testGet() {
		
		baseURI = "https://reqres.in/api";
		
		given().get("/users?page=2").then().statusCode(200).
		body("data.first_name", hasItems("George", "Rachel"));
		
	}
		@Test
		public void testPost() {
			
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
				post("/users").
			then().
				statusCode(201).log().all();
		}
}












