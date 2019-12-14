import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC004_GET_PrintAllHeaders {
	
	@Test
	void getAndPrintAllHeaders(){
		
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
		
		Headers allHeaders = response.headers();
		
		for(Header header:allHeaders){
			System.out.println(header.getName()+ " ---> "+header.getValue());
		}
		
		
		
		
		
	}

}
