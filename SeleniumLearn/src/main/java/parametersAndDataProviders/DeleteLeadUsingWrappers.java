package parametersAndDataProviders;

import org.testng.annotations.Test;

import wrappers.LeafTapsWrappers;

public class DeleteLeadUsingWrappers extends LeafTapsWrappers{
	@Test(groups={"sanity"},dependsOnGroups={"smoke"})
	public void deleteLeads(){
		//Click on Leads Link
		clickByLink("Leads");
		//Click on find Leads Link
		clickByLink("Find Leads");
		//Click on Phone Tab
		clickByXpath("//span[text()='Phone']");
		//Enter Phone Number
		//enterByXpath("//input[@name='phoneNumber']", "9944121392");
		//Click on Find Leads button
		//clickByXpath("//button[text()='Find Leads']");
		//Get the Lead ID in a variable
		String LeadId = getTextByXpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]");
		//Click on first resulting Lead
		clickByXpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]");
		//Click on Delete Tab
		clickByXpath("//a[text()='Delete']");
		//Click Find Leads 
		clickByLink("Find Leads");
		//Enter the Saved Lead Id
		enterByXpath("//span[text()='Name and ID']/following::input[@name='id']", LeadId);
		//Click on Find Leads
		clickByXpath("//button[text()='Find Leads']");
		//Verify No Records found text
		verifyTextByXpath("//div[text()='No records to display']", "No records to display");
		System.out.println("DELETE LEAD COMPLETED SUCCESFULLY");
	}

}
