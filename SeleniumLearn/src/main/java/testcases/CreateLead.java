package testcases;

import org.junit.Test;

import wrappers.GenericWrappers;

public class CreateLead extends GenericWrappers {

	@Test
	public void creteLead(){
		
		invokeApp("chrome", "http://leaftaps.com");
		enterById("username", "DemoSalesManager");
		enterById("password", "crmsfa");
		clickByClassName("decorativeSubmit");
		clickByLink("CRM/SFA");		
		clickByLink("Create Lead");
		enterById("createLeadForm_companyName", "Suren Corp.");
		enterById("createLeadForm_firstName", "Suren");
		enterById("createLeadForm_lastName", "S");
		enterById("createLeadForm_parentPartyId", "17865");
		selectVisibileTextById("createLeadForm_dataSourceId", "Conference");
		selectVisibileTextById("createLeadForm_marketingCampaignId", "Automobile");
		enterById("createLeadForm_firstNameLocal", "First Name Local");
		clickByClassName("smallSubmit");
		closeAllBrowsers();		
		
	}
	
}
