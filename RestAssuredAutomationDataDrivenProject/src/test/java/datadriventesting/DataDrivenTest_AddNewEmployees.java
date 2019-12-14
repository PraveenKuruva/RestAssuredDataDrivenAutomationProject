package datadriventesting;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class DataDrivenTest_AddNewEmployees {
	
	@Test(dataProvider="empDataProvider")
	public void postNewEmployees(String ename, String esal,String eage){
		
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		//Here we have created data which we can send along with post request
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", ename);
		requestParams.put("salary", esal);
		requestParams.put("age", eage);
		
		//Add a header stating that Request body is a JSON
		httpRequest.header("Content-Type","application/json");
		
		//Add JSON to the body of the request
		httpRequest.body(requestParams.toJSONString());
		
		//POST Request
		Response response = httpRequest.request(Method.POST,"/create");
		
		//Capture Response body for Validation
		String responseBody = response.getBody().asString();
		
		System.out.println("Response Body is: "+responseBody);
		
		Assert.assertEquals(responseBody.contains(ename), true);
		Assert.assertEquals(responseBody.contains(esal), true);
		Assert.assertEquals(responseBody.contains(eage), true);
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		
	}
	
	@DataProvider(name="empDataProvider")
	String [][] getEmpData() throws IOException{
//		String empdata[][] = {{"kpk12361","60000","32"},{"kpk12362","70000","32"},{"kpk12363","80000","32"}};
		
		//Read data from Excel file
		String path = System.getProperty("user.dir")+"/src/test/java/datadriventesting/empdata.xlsx";
		
		int rownum = XLUtils.getRowCount(path,"Sheet1");
		int colcount = XLUtils.getCellCount(path,"Sheet1",1);
		
		String empdata[][] = new String[rownum][colcount];
		
		for(int i=1; i<=rownum;i++){
			for(int j=0; j<colcount;j++){
				empdata[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		

		return empdata;
	}

			
		
			
}
