package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class TestOnLocalAPI {
	
	@Test
public void Get() {
		
	baseURI = "http://localhost:3000";
		
		given().
			get("/users").
		then().
			statusCode(200).log().all(); 
		
	}

	@Test
	public void Post() {	
		JSONObject request = new JSONObject();
		
		request.put("firstName", "Adil");
		request.put("lastName", "Ali");
		
		baseURI = "http://localhost:3000"; 
		
		given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		post("/users").
		then().
		statusCode(201).log().all();
		
	}

	@Test
	public void Put() {	
		JSONObject request = new JSONObject();
		
		request.put("firstName", "Adil");
		request.put("lastName", "Jameel");
		
		baseURI = "http://localhost:3000"; 
		
		given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		put("/users/20").
		then().
		statusCode(200);
		
	}

	
	
	@Test
	public void Patch() {	
		JSONObject request = new JSONObject();
		
		
		request.put("lastName", "Mohammad");
		
		baseURI = "http://localhost:3000"; 
		
		given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		patch("/users/20").
		then().
		statusCode(200);
		
	}

	
	@Test
	public void Delete() {	
		JSONObject request = new JSONObject();
		
		
		
		baseURI = "http://localhost:3000"; 
		
		given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		delete("/users/20").
		then().
		statusCode(200);
		
	}
}
