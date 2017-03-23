package week3HomeWork;

import org.junit.Test;

import wrappers.GenericWrappers;
import wrappers.LeafTapsWrappers;

public class MergeAccountsUsingWrappers extends LeafTapsWrappers{

	@Test
	public void MergeLead() throws InterruptedException {
		//Launch URL
		loginLeafTaps();
		//Click on CRM/SFA Link
		clickByLink("CRM/SFA");
		//Click on Leads Link
		clickByLink("Leads");
		clickByLink("Merge Leads");
		//Click On From Lead icon
		clickByXpath("(//img[@alt='Lookup'])[1]");
		//Switch to Last Window
		switchToLastWindow();
		//Get the Lead ID from the First Resulting Lead
		String FromLeadID = getTextByXpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]");
		System.out.println("From Lead Id: " + FromLeadID);
		//Select the First resulting lead
		clickByXpathNoSnap("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]");
		//Switch Back to Primary Window
		switchToParentWindow();
		//Select To Lead Icon
		clickByXpath("(//img[@alt='Lookup'])[2]");
		//Switch to Last Window
		switchToLastWindow();
		//Select the second Resulting Lead ID
		clickByXpathNoSnap("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]");
		//Switch to Parent Window
		switchToParentWindow();
		//Click on Merge Lead
		clickByLinkNoSnap("Merge");
		//Accept Alert
		acceptAlert();
		//Click on Find Leads on left side
		clickByLink("Find Leads");
		//Enter the Lead ID saved earlier
		enterByName("id", FromLeadID);
		//Click on Find Leads button
		clickByXpath("//button[text()='Find Leads']");
		//Verify the error message
		verifyTextByXpath("//div[text()='No records to display']", "No records to display");
		//Close all browsers
		closeAllBrowsers();
		System.out.println("MERGE LEAD USING WRAPPERS: TEST COMPLETED SUCCESSFULLY");
		
	}

}
