package project1;

import org.junit.Test;

import wrappers.GenericWrappers;

public class DuplicateLeadUsingWrappers extends GenericWrappers{
	@Test
	public void DuplicateLead(){
		//Launch URL
		invokeApp("chrome", "http://leaftaps.com");
		//Enter User Name
		enterById("username", "DemoSalesManager");
		//Enter Password
		enterById("password", "crmsfa");
		//Click Login Button
		clickByClassName("decorativeSubmit");
		//Click CRM/SFA Link
		clickByLink("CRM/SFA");
		//Click on Leads Tab
		clickByLink("Leads");	
		//Click on Find Leads
		clickByLink("Find Leads");
		//Click on Email Tab
		clickByXpath("//span[contains(text(),'Email')]");
		//Enter Email Address
		enterByName("emailAddress", "123@gmail.com");
		//Click on Find Leads
		clickByXpath("//button[contains(text(),'Find Leads')]");
		//Capture the Name of first Result
		String nameOfFirstResult = getTextByXpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName'])[1]/a");
		System.out.println(nameOfFirstResult);
		//Click on First Result
		clickByXpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a");
		//Click Duplicate Lead
		clickByLink("Duplicate Lead");
		//Verify Title Text
		verifyTextByXpath("//div[contains(text(),'Duplicate Lead')]", "Duplicate Lead");
		//Click on Create Lead button
		clickByXpath(".//input[@class='smallSubmit']");
		//Get Name of the Duplicate Lead
		String DupFirstName = getTextById("viewLead_firstName_sp");
		if(DupFirstName.equals(nameOfFirstResult)){
			System.out.println("Name of First Result " + nameOfFirstResult+ " Duplicate Lead Name "+DupFirstName+ " Matches");
		}
		else{
			System.out.println("Name of First Result " + nameOfFirstResult+ " Duplicate Lead Name "+DupFirstName+ " does not Match");
		}
		System.out.println("DUPLICATE LEAD USING WRAPPERS: TEST COMPLETED SUCCESSFULLY");
		closeAllBrowsers();
	}

}
