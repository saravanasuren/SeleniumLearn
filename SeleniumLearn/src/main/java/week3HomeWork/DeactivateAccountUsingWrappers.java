package week3HomeWork;

import org.junit.Test;

import wrappers.LeafTapsWrappers;

public class DeactivateAccountUsingWrappers extends LeafTapsWrappers{
	@Test
	public void EditAndSave(){
		//Login to LeafTaps
		loginLeafTaps();
		//Click on CRM/SFA
		clickByLink("CRM/SFA");
		//Click On Accounts Tab
		clickByLink("Accounts");
		//Click Find Accounts
		clickByLink("Find Accounts");
		String AccountId = "23719";
		String AccountName="Suren Corp.";
		//Enter Account ID
		enterByXpath("//span[text()='Name and ID']/following::input[@name='id']", AccountId);
		//Enter Account Name
		enterByXpath("//span[text()='Name and ID']/following::input[@name='accountName']", AccountName);
		//Click on Find ACCOUNTS
		clickByXpath("//button[text()='Find Accounts']");
		//Capture the Account ID
		getTextByXpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");
		//Click on the first Link
		clickByXpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");
		//Verify Title
		verifyTitle("Account Details | opentaps CRM");
		//Click On Deactivate Account
		clickByLinkNoSnap("Deactivate Account");
		//Accept Alert
		acceptAlert();
		//Verify displayed message(This account was deactivated with date and time)
		verifyTextByXpath("//span[contains(text(),'This account was deactivated as of ')]", "This account was deactivated as of");
		//Click Find Accounts
		clickByLink("Find Accounts");
		//Enter Account ID
		enterByXpath("//span[text()='Name and ID']/following::input[@name='id']", AccountId);
		//Enter Account Name
		enterByXpath("//span[text()='Name and ID']/following::input[@name='accountName']", AccountName);
		//Click on Find ACCOUNTS
		clickByXpath("//button[text()='Find Accounts']");
		//Verify error message(no records to display)
		verifyTextByXpath("//div[text()='No records to display']", "No records to display");
		//Close Browser
		closeAllBrowsers();
		
	}

}
