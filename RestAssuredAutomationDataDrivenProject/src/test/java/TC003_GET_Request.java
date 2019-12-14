import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_GET_Request {

	
	@Test
	void googleMapTest(){
		
		//Specify the base URI
		RestAssured.baseURI = "https://maps.googleapis.com";
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response Object
		Response response = httpRequest.request(Method.GET);
		
		//Print Response in console
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is: "+ responseBody);
		
		//Validating Headers
		String contentType = response.header("Content-Type"); //validating the content type in header
		System.out.println("Content type: "+contentType);
		Assert.assertEquals(contentType, "text/html; charset=utf-8");
		
		
		String Server = response.header("Server"); //validating the Server in header
		System.out.println("Server type: "+Server);
		Assert.assertEquals(Server, "Google Frontend");
		
		
		
		
		
	}
}
