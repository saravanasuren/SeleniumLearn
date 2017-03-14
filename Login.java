package testcases;

import org.junit.Test;

import wrappers.GenericWrappers;

public class Login extends GenericWrappers {

	@Test
	public void login(){
		
		invokeApp("firefox", "http://leaftaps.com");
		enterById("username", "DemoSalesManager");
		enterById("password", "crmsfa");
		clickByClassName("decorativeSubmit");
		clickByClassName("decorativeSubmit");
		
	}
	
}
