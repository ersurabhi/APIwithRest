package proof_of_concept;

import static com.jayway.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class WeatherApi
{
//	@Test
	public void Test_01()
	{
		Response resp= when().
				get("http://api.openweathermap.org/data/2.5/weather?q=London&appid=419ad066a7f034a23804f806e69c8d6f");
				System.out.println("status code:" +resp.getStatusCode());
		Assert.assertEquals(resp.getStatusCode(), 200);
		
	}
//	@Test
	public void Test_02()
	{
		Response resp= when().
				get("http://api.openweathermap.org/data/2.5/weather?q=London&appid=419ad066a7f034a23804f806e69c8d6g");
				System.out.println("status code:" +resp.getStatusCode());
		Assert.assertEquals(resp.getStatusCode(), 401);
		
	}
	//@Test
	public void Test_03()
	{
		Response resp= given().param("q","London").param("appid","419ad066a7f034a23804f806e69c8d6f").
				when().
				get("http://api.openweathermap.org/data/2.5/weather");
				System.out.println(resp.getStatusCode());
		Assert.assertEquals(resp.getStatusCode(), 200);
		if (resp.getStatusCode()==200)
		{
			System.out.println("API is working fine");
		}	
		else
		{
			System.out.println("API is not working fine");
		}
	}
//	@Test
	public void Test_04()
	{
		given().param("q","London").param("appid","419ad066a7f034a23804f806e69c8d6f").
				when().
				get("http://api.openweathermap.org/data/2.5/weather").
				then().assertThat().statusCode(200);
	}	
//	@Test
	public void Test_05()
	{
		Response resp= given().param("q","London").param("appid","419ad066a7f034a23804f806e69c8d6f").
				when().
				get("http://api.openweathermap.org/data/2.5/weather");
		System.out.println(resp.asString());
				
	}	
//	@Test
	public void Test_06()
	{
		Response resp= given().param("id","2172797").param("appid","419ad066a7f034a23804f806e69c8d6f").
				when().
				get("http://api.openweathermap.org/data/2.5/weather");
		Assert.assertEquals(resp.getStatusCode(),200);
		System.out.println(resp.asString());
				
	}	
//	@Test
	public void Test_07()
	{
		Response resp= given().param("zip","94040,us").param("appid","419ad066a7f034a23804f806e69c8d6f").
				when().
				get("http://api.openweathermap.org/data/2.5/weather");
		Assert.assertEquals(resp.getStatusCode(),200);
		System.out.println(resp.asString());
				
	}	
//	@Test
	public void Test_08()
	{
		String weatherReport = given().param("id","2172797").param("appid","419ad066a7f034a23804f806e69c8d6f").
				when().
				get("http://api.openweathermap.org/data/2.5/weather").
				then().
				contentType(ContentType.JSON).extract().path("weather[0].description");
		
		System.out.println("Weather Report:" +weatherReport);
     }
	
	@Test
	public void Test_09()
	{
		Response resp = given().param("id","2172797").param("appid","419ad066a7f034a23804f806e69c8d6f").
				when().
				get("http://api.openweathermap.org/data/2.5/weather");
		
		String reportbyID = resp. then().
				contentType(ContentType.JSON).
				extract().
				path("weather[0].description");
		
		System.out.println("Weather Description by ID:" +reportbyID);
		
		String Lon = String.valueOf(resp. then().
				contentType(ContentType.JSON).
				extract().
				path("coord.lon"));
		
		System.out.println("Longitute:" +Lon);
		
		String Lat = String.valueOf(resp. then().
				contentType(ContentType.JSON).
				extract().
				path("coord.lat"));
		
		System.out.println("Latitute:" +Lat);
		
		Response responseByCordinate = given().param("lat",Lat).param("lon",Lon).
				param("appid","419ad066a7f034a23804f806e69c8d6f").
				when().
				get("http://api.openweathermap.org/data/2.5/weather");
		
		String reportbyCordinate = responseByCordinate. then().
				contentType(ContentType.JSON).
				extract().
				path("weather[0].description");
		
		System.out.println("Weather Description by Coordinate:" +reportbyCordinate);
		
		
		Assert.assertEquals(reportbyID, reportbyCordinate);
	}
	
}
	
	