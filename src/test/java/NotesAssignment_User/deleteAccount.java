package NotesAssignment_User;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import bsh.ParseException;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class deleteAccount {
	String token;
	Base_Class obj = new Base_Class();
	@BeforeTest
	public void login() {
		obj.Create_New_User("accountDel", "delaccount@gmail.com", "test@123");
		token = obj.LOGIN("delaccount@gmail.com", "test@123");
	}
	@Test
	  public void delete() throws IOException, ParseException, org.json.simple.parser.ParseException 
	  {
		  obj.deleteAccount(token);
	  }
}

