import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC005_GET_ValidatingJSONResponse {
	@Test
	void getAndPrintAllHeaders(){
		
		//Specify the base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		
		//Request Object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Response Object
		Response response = httpRequest.request(Method.GET,"/Delhi");
		
		//Print Response in console
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is: "+ responseBody);
		
		
		Assert.assertEquals(responseBody.contains("Delhi"), true);
		
		
		
		
		
	}

}
