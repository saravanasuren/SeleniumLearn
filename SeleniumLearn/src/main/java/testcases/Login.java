package testcases;

import org.junit.Test;

import wrappers.GenericWrappers;

public class Login extends GenericWrappers {

	@Test
	public void login(){
		invokeApp("chrome", "http://leaftaps.com");
		//Enter User Name
		enterById("username", "DemoSalesManager");
		//Enter Password
		enterById("password", "crmsfa");
		//Click Login Button
		clickByClassName("decorativeSubmit");
		//Click CRM/SFA Link
		clickByLink("CRM/SFA");			
	}
	
}
