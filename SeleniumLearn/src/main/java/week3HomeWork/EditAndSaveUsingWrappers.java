package week3HomeWork;

import org.junit.Test;

import wrappers.LeafTapsWrappers;

public class EditAndSaveUsingWrappers extends LeafTapsWrappers{
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
		String AccountId = "23705";
		String AccountName="NewAccNam";
		//Enter Account ID
		enterByXpath("//span[text()='Name and ID']/following::input[@name='id']", AccountId);
		//Enter Account Name
		enterByXpath("//span[text()='Name and ID']/following::input[@name='accountName']", AccountName);
		//Click on Find ACCOUNTS
		clickByXpath("//button[text()='Find Accounts']");
		//Click on the first Link
		clickByXpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");
		//Verify Title
		verifyTitle("Account Details | opentaps CRM");
		//Click On Edit
		clickByLink("Edit");
		String NewAccName="Suren Corp2";
		//Edit the new Account Name
		enterById("accountName", NewAccName);
		//Click Submit Button
		clickByXpath("(//input[@class='smallSubmit'])[1]");
		//Verify the New Account Name ++> *************
		String FullAccName = NewAccName + " " + "(" + AccountId + ")";
		System.out.println(FullAccName);
		verifyTextByXpath("//span[text()='Account Name']/following::span[1]", FullAccName);
		//Close Browser
		closeAllBrowsers();
		
	}

}
