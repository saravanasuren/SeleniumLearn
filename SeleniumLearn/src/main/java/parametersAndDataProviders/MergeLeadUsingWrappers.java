package parametersAndDataProviders;

import org.testng.annotations.Test;

import wrappers.LeafTapsWrappers;

public class MergeLeadUsingWrappers extends LeafTapsWrappers{

	@Test(groups={"regression"})
	public void MergeLead() throws InterruptedException {
		//Click on Accounts Link
		clickByLink("Accounts");
		//Click on Merge Accounts
		clickByLink("Merge Accounts");
		//Click On From Account icon
		clickByXpath("(//img[@alt='Lookup'])[1]");
		//Switch to Last Window
		switchToLastWindow();
		//Get the Account ID from the First Resulting Lead
		String FromAccountID = getTextByXpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]");
		System.out.println("From Lead Id: " + FromAccountID);
		//Select the First resulting Account
		clickByXpathNoSnap("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]");
		//Switch Back to Primary Window
		switchToParentWindow();
		//Select To Account Icon
		clickByXpath("(//img[@alt='Lookup'])[2]");
		//Switch to Last Window
		switchToLastWindow();
		//Select the second Resulting Account ID
		clickByXpathNoSnap("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]");
		//Switch to Parent Window
		switchToParentWindow();
		//Click on Merge Account
		clickByLinkNoSnap("Merge");
		//Accept Alert
		acceptAlert();
		//Click on Find Accounts on left side
		clickByLink("Find Accounts");
		//Enter the Lead ID saved earlier
		enterByName("id", FromAccountID);
		//Click on Find Leads button
		clickByXpath("//button[text()='Find Accounts']");
		//Verify the error message
		verifyTextByXpath("//div[text()='No records to display']", "No records to display");
		System.out.println("MERGE ACCOUNT USING WRAPPERS: TEST COMPLETED SUCCESSFULLY");
		
	}

}
