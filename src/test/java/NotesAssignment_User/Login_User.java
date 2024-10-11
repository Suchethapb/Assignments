package NotesAssignment_User;

import org.testng.annotations.Test;

//import org.junit.Test;
//import org.testng.annotations.BeforeTest;

import pk_MyNotes.BaseClass;

public class Login_User {
	static String Token;
	@Test
	public static String log() {

		Token=BaseClass.LOGIN("ayanakash936@gmail.com", "Epsilon@123");
		System.out.println("hi");
		//String LOGINid = BaseClass.bookindid;
		//outh_token = BaseClass.outh_token;
		return Token;
	}

}
