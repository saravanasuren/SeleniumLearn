package week3HomeWork;

import org.junit.Test;

import wrappers.LeafTapsWrappers;

public class DeleteContactInfoUsingWrappers extends LeafTapsWrappers {
	@Test
	public void CreateAccount() {
		//Login to LeafTaps
		loginLeafTaps();
		//Click on CRM/SFA
		clickByLink("CRM/SFA");
		//Click On Accounts Tab
		clickByLink("Accounts");
		//Click on Find Account
		clickByLink("Find Accounts");
		//Click on Phone Tab
		clickByLink("Phone");
		//Enter Phone Number
		enterByName("phoneNumber", "9944121392");
		//Click Find Accounts Button
		clickByXpath("//button[text()='Find Accounts']");
		//Capture the Account ID of First Link
		String AccountId = getTextByXpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");
		//Click on the first link
		clickByXpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");
		//Click on Delete Phone
		clickByXpath("(//img[@alt='Expire'])[2]");
		//Click on Delete email
		clickByXpath("(//img[@alt='Expire'])[1]");
		//Click on Find Accounts Link
		clickByLink("Find Accounts");
		//Enter Account Id Captures above
		enterByXpath("//span[text()='Name and ID']/following::input[@name='id']", AccountId);
		//Click on Find Account Button
		clickByXpath("//button[text()='Find Accounts']");
		//Click on First Resulting Link
		clickByXpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");
		//Verify Verify contact details -No contact information on file
		verifyTextByXpath("//div[text()='No contact information on file']", "No contact information on file");
		//Close All Browsewrs
		closeAllBrowsers();
		

		
		
		
	}

}
