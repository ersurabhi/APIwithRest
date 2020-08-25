package api.test;

import static com.jayway.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;


public class EEAPI
{
	@Test
	public void Test_Pneumovax()
	{
		
		Response resp= given().body("{\"query\": \"what is the dosage pgnancy\","
			    +" \"collection\": \"Pneumovax 23\"}").when().contentType(ContentType.JSON).
				post("http://universaltaxonomy.appspot.com/extract");
				System.out.println("status code:" +resp.getStatusCode());
		System.out.println("Response is " + resp.asString());
		Assert.assertEquals(resp.getStatusCode(), 200);
		
	}
			
	@Test
	public void Test_Voice()
	{
		
		Response resp= given().body("{\"query\": \"what is the dosage pgnancy\","
			    +" \"collection\": \"Pneumovax 23\"}").when().contentType(ContentType.JSON).
				post("https://splitter-dot-test-bayer-v-central.appspot.com/");
				System.out.println("status code:" +resp.getStatusCode());
		System.out.println("Response is " + resp.asString());
		Assert.assertEquals(resp.getStatusCode(), 200);
		
	}
	
}
	
	