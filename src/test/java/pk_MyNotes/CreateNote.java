package pk_MyNotes;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pk_MyNotes.BaseClass;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateNote extends BaseClass {

	static String Token;
	static String notesid;

	@BeforeTest
	public static void Login() throws IOException, ParseException {
		Token = BaseClass.LOGIN("suchetha01@mail.com", "API05**");
		System.out.println("LOGIN");
		//delet_all.deleteAllNotes();
	}

	

//	public static JSONObject readf() throws IOException, ParseException {
//
//		// Create json object of JSONParser class to parse the JSON data
//		JSONParser jsonparser = new JSONParser();
//		// Create object for FileReader class, which help to load and read JSON file
//		FileReader reader = new FileReader(".\\TestData\\Notess.json");
//		// Returning/assigning to Java Object
//		Object obj = jsonparser.parse(reader);
//		// Convert Java Object to JSON Object, JSONObject is typecast here
//		JSONObject prodjsonobj = (JSONObject) obj;
//		System.out.println("PASS");
//		return prodjsonobj;
//	}

	@Test
	public static void create() throws IOException, ParseException {
		
		JSONParser jsonparser = new JSONParser();
		// Create object for FileReader class, which help to load and read JSON file
		FileReader reader = new FileReader(".\\TestData\\Notess.json");
		// Returning/assigning to Java Object
		Object obj = jsonparser.parse(reader);
		// Convert Java Object to JSON Object, JSONObject is typecast here
		JSONObject prodjsonobj = (JSONObject) obj;
		System.out.println("PASS");

		RestAssured.baseURI = "https://practice.expandtesting.com";
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.header("x-auth-token", Token);
		request.body(prodjsonobj.toJSONString());
		// POST the Response
		Response response = request.request(Method.POST, "/notes/api/notes");
		// Response response = request.request(Method.POST,"/spree_oauth/token");
		response.prettyPrint();
		int statusCode = response.getStatusCode();
		// System.out.println(response.asString());
		Assert.assertEquals(statusCode, 200);
		// To get the Token from JSON Response
		//JsonPath jsonPathEvaluator = response.getBody().jsonPath();
		JsonPath jsonPathEvaluator = response.getBody().jsonPath();
		notesid = jsonPathEvaluator.get("data.id").toString();
		
		String fname = jsonPathEvaluator.get("data.title").toString();
		System.out.println("Title is =>  " + fname);
		Assert.assertEquals("Practice WebApp UI", fname);

	}

//	@Test(priority = 1)
//	public static void Update() throws IOException, ParseException {
//		// Create json object of JSONParser class to parse the JSON data
//		JSONParser jsonparser = new JSONParser();
//		// Create object for FileReader class, which help to load and read JSON file
//		FileReader reader = new FileReader(".\\TestData\\NotessUpdate.json");
//		// Returning/assigning to Java Object
//		Object obj = jsonparser.parse(reader);
//		// Convert Java Object to JSON Object, JSONObject is typecast here
//		JSONObject prodjsonobj = (JSONObject) obj;
//		System.out.println("PASS12345");
//		
//		RestAssured.baseURI = "https://practice.expandtesting.com";
//		RequestSpecification request = RestAssured.given();
//		request.header("Content-Type", "application/json");
//		request.header("x-auth-token", Token);
//		request.body(prodjsonobj.toJSONString());
//		
//		Response response = request.request(Method.PUT, "/notes/api/notes" + notesid);
//		
//		
//		response.prettyPrint();
//		int statusCode = response.getStatusCode();
//		// System.out.println(response.asString());
//		Assert.assertEquals(statusCode, 200);
//		// To get the Token from JSON Response
//
//	}
	
	@Test(priority = 1)
	  public void updatenotes() throws IOException, ParseException, org.json.simple.parser.ParseException 
	  {
		  
		  //Create json object of JSONParser class to parse the JSON data
		  JSONParser jsonparser=new JSONParser();
		  //Create object for FileReader class, which help to load and read JSON file
		  FileReader reader = new FileReader(".\\TestData\\NotessUpdate.json");
		  //Returning/assigning to Java Object
		  Object obj = jsonparser.parse(reader);
		  //Convert Java Object to JSON Object, JSONObject is typecast here
		  JSONObject prodjsonobj = (JSONObject)obj;
		  
		  RestAssured.baseURI = "https://practice.expandtesting.com";
	      RequestSpecification request = RestAssured.given();
		  request.header("Content-Type", "application/json");
		  request.header("X-Auth-Token", Token);
	      request.body(prodjsonobj.toJSONString());
	      // POST the Response
	      Response response = request.request(Method.PUT,"/notes/api/notes/"+notesid);
	      //Response response = request.request(Method.POST,"/spree_oauth/token");
	      response.prettyPrint();
	      int statusCode = response.getStatusCode();
	      // System.out.println(response.asString());
	      Assert.assertEquals(statusCode, 200);
	      // To get the Token from JSON Response
//	      JsonPath jsonPathEvaluator = response.getBody().jsonPath();
//	      id = jsonPathEvaluator.get("data.id").toString();
//	      System.out.println("Notes ID is =>  " + id);
	  }

}
