package NotesAssignment_User;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.BeforeTest;
//import org.junit.Test;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Assignment_NOTES_API_delete.BaseClass;
import Assignment_NOTES_API_delete.delet_all;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Change_password {
	static String Token;

	@BeforeTest
	public static void Login() throws IOException, ParseException {
		Token=Login_User.log();
	}
	@Test
	public static void Change() {
	RestAssured.baseURI = "https://practice.expandtesting.com";
	RequestSpecification request = RestAssured.given();

	JSONObject requestParams = new JSONObject();
	requestParams.put("currentPassword", "API05**");
	requestParams.put("newPassword", "Pass5*");
	// Add a header stating the Request body is a JSON
	request.header("Content-Type", "application/json");
	request.header("x-auth-token", Token);
	request.body(requestParams.toJSONString());
	//request.header
	// POST the Response
	Response response = request.request(Method.POST, "/notes/api/users/change-password");
	// Response response = request.request(Method.POST,"/spree_oauth/token");
	response.prettyPrint();
	int statusCode = response.getStatusCode();}
	
}
