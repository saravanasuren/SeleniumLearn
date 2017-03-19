package wrappers;

public class LeafTapsWrappers extends GenericWrappers{
	
	public void loginLeafTaps(){
		invokeApp("Chrome", "http://leaftaps.com/control/main");
		enterById("username", "DemoSalesManager");
		enterById("password", "crmsfa");
		clickByClassName("decorativeSubmit");		
	}

}
