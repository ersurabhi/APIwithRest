package proof_of_concept;
import static com.jayway.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import API_Testig_classes.Info;
import API_Testig_classes.Posts_class;
import API_Testig_classes._Posts;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class JsonSeverRequests {
	
//	@Test
	//GET    /posts
	public void Test_01()
	{
		Response resp = given().when().get("http://localhost:3000/posts");
		System.out.println("Get response is:"+resp.asString());
	}//@Test 

public void Test_02()
{
	Response resp = given().body("{\"id\": \"2\","
	    +" \"title\": \"dummyTitle\","
	    +"\"author\": \"Surabhi\"}").when().contentType(ContentType.JSON).post("http://localhost:3000/posts");
	System.out.println("Post response is:"+resp.asString());
	
}
//@Test 

public void Test_03()
{
	Posts_class posts = new Posts_class();
	posts.setId("3");
posts.setTitle("post request by object");
posts.setAuthor("Surabhi");
	
	Response resp = given().when().contentType(ContentType.JSON).body(posts).post("http://localhost:3000/posts");
	System.out.println("Response:"+resp.asString());
	
}
//@Test
public void Test_04()
{
	Response resp = given().when().get("http://localhost:3000/posts/3");
	
System.out.println("Get response is:"+resp.asString());

}

//@Test
public void Test_05()
{
	Posts_class posts = new Posts_class();
	posts.setId("3");
posts.setTitle("updated title");
posts.setAuthor("Updated author");
	
	Response resp = given().when().contentType(ContentType.JSON).body(posts).put("http://localhost:3000/posts/3");
	System.out.println("Response:"+resp.asString());
	
}
//@Test
public void Test_06()
{
	
	Response resp = given().when().contentType(ContentType.JSON).body("{\"title\":\"updated by patch request\"}").patch("http://localhost:3000/posts/3");
	System.out.println("Response:"+resp.asString());
	
}
//@Test
public void Test_07()
{
	
	Response resp = given().when().delete("http://localhost:3000/posts/3");
	System.out.println("Response:"+resp.asString());
	
}
//Complex Post
@Test

public void Test_08()
{

	Info info= new Info();
	info.setEmail("ersurabhi.jain01@gmail.com");
	info.setPhone("4372389213");
	info.setAddress("Canada");
	
	_Posts posts = new _Posts();
	posts.setAuthor("author");
	posts.setId("10");
	posts.setTitle("title");
	posts.setInfo(info);
	
	
Response resp= given().when().contentType(ContentType.JSON).body(posts).post("http://localhost:3000/posts");
System.out.println("Response:" +resp.asString());
	
	
	
}

}

