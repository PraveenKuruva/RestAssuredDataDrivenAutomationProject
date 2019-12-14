
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POST_Request {
	
	@Test
	void RegistrationSuccesfull(){
		
		//Specify the base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response Object
		JSONObject requestParams = new JSONObject();
		
		//Request payload sending along with post request
		requestParams.put("FirstName", "Kpk1");
		requestParams.put("LastName", "Kumar1");
		requestParams.put("UserName", "Praveen1");
		requestParams.put("Password", "Praveen1");
		requestParams.put("Email", "kpk1@gmail.com");
		
		
		
		httpRequest.header("Content-Type","application/json");
		
		//attach above data to the request
		httpRequest.body(requestParams.toJSONString());
		
		//Response Object
		Response response = httpRequest.request(Method.POST,"/register");
		
		
		//Print Response in console
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is: "+ responseBody);
		
		//Status code validation
		int statusCode = response.getStatusCode();
		System.out.println("Status code is: "+ statusCode);
		Assert.assertEquals(statusCode, 201);
		
		//success code validation
		String successCode = response.jsonPath().get("SuccessCode");
		Assert.assertEquals(successCode, "OPERATION_SUCCESS");
		
		
		
		
		
		
		
	}

}
