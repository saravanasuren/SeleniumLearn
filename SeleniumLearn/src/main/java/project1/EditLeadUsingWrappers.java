package project1;

import org.junit.Test;

import wrappers.LeafTapsWrappers;

public class EditLeadUsingWrappers extends LeafTapsWrappers{
	@Test
	public void EditLeads(){
		//Login to LeafTaps
		loginLeafTaps();
		//Click on CRM/SFA link
		clickByLink("CRM/SFA");
		//Click on Leads Link
		clickByLink("Leads");
		//Click on Find Leads Link
		clickByLink("Find Leads");
		//Enter First Name
		enterByXpath("//span[text()='Name and ID']/following::input[@name='firstName']", "Suren");
		//Click on find Leads button
		clickByXpath("//button[text()='Find Leads']");
		//Click on the First Resulting Lead
		clickByXpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]");
		//Verify the Title of the Page
		verifyTitle("View Lead | opentaps CRM");
		//Click on Edit Link
		clickByLink("Edit");
		//Enter the Company Name - Edit the Company Name
		enterById("updateLeadForm_companyName", "Suren Corp. LTD");
		//Click on Update
		clickByXpath("//input[@value='Update']");
		//Verify the New Company Name
		verifyTextById("viewLead_companyName_sp", "Suren Corp. LTD");
		//Close Browser
		closeAllBrowsers();
	}
}
