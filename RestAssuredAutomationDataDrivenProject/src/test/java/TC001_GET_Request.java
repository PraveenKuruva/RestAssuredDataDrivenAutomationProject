import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_Request {
	
	@Test
	void getWeatherDetails(){
		
		//Specify the base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response Object
		Response response = httpRequest.request(Method.GET,"/Hyderabad");
		
		//Print Response in console
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is: "+ responseBody);
		
		//Status code validation
		int statusCode = response.getStatusCode();
		System.out.println("Status code is: "+ statusCode);
		Assert.assertEquals(statusCode, 200);
		
		//Status line verification
		String statusLine = response.getStatusLine();
		System.out.println("Status Line is: "+ statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
		String x = response.getBody().jsonPath().get("City").toString();
		System.out.println("X values: "+ x);
		
		
		
		
		
	}

}
