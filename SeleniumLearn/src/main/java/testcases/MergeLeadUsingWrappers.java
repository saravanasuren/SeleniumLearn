package testcases;

import org.junit.Test;

import wrappers.GenericWrappers;

public class MergeLeadUsingWrappers extends GenericWrappers{

	@Test
	public void MergeLead() throws InterruptedException {
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
		//Click on Merge Leads
		clickByLink("Merge Leads");
		//Click From Lead icon
		clickByXpath("(//img[@alt='Lookup'])[1]");
		//Switch to New Window
		switchToLastWindow();
		Thread.sleep(3000);
		//Select the first lead that gets displayed
		clickByXpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]");
		Thread.sleep(3000);
		//Select the First Link
		clickByXpathNoSnap("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a");
		//Switch to Parent window
		switchToParentWindow();
		//Click To Lead icon
		clickByXpath("(//img[@alt='Lookup'])[2]");
		//Switch to New Window
		switchToLastWindow();
		
		//Select the first lead that gets displayed
		clickByXpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]");
		//Select the First Link
		clickByXpathNoSnap("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a");
		//Switch to Parent window
		switchToParentWindow();
		//Click on Merge Leads button
		clickByLinkNoSnap("Merge");
		//Accept Alert
		acceptAlert();
		//Click on Find Leads
		clickByLink("Find Leads");
		//Enter Leads ID
		enterByXpath("//label[contains(text(),'Lead ID:')]/following::input", "22608");
		//Click on Find Leads
		clickByXpath("//button[contains(text(),'Find Leads')]");
		//Get Text 
		String errormsg = getTextByXpath("//div[contains(text(),'No records to display')]");
		if(errormsg.equalsIgnoreCase("No records to display")){
			System.out.println("Merge Succesful and no records to display message validated");
		}
		else{
			System.out.println("No Records to display ***NOT FOUND***");
		}
		closeAllBrowsers();
		System.out.println("MERGE LEAD USING WRAPPERS: TEST COMPLETED SUCCESSFULLY");
		
	}

}
