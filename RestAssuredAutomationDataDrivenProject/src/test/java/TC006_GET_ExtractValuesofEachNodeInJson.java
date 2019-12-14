import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC006_GET_ExtractValuesofEachNodeInJson {
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
		
		String city = response.jsonPath().getString("City");
		System.out.println("City is: "+ city);
		String temperature = response.jsonPath().getString("Temperature");
		System.out.println("Temperature is: "+ temperature);
		
		
		Assert.assertEquals(response.jsonPath().getString("City"), "Delhi");
		
		
		
	}

}
