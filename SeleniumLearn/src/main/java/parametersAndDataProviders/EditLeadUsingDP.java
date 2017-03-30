package parametersAndDataProviders;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import wrappers.LeafTapsWrappers2;

public class EditLeadUsingDP extends LeafTapsWrappers2{
	@Test(dataProvider = "datasource", groups={"sanity"},dependsOnGroups={"smoke"}, 
			dependsOnMethods={"parametersAndDataProviders.CreateLeadUsingDP.creteLead"})
	public void EditLeads(String fName,String companyName){
		//Click on Leads Link
		clickByLink("Leads");
		//Click on Find Leads Link
		clickByLink("Find Leads");
		//Enter First Name
		enterByXpath("//span[text()='Name and ID']/following::input[@name='firstName']", fName);
		//Click on find Leads button
		clickByXpath("//button[text()='Find Leads']");
		//Click on the First Resulting Lead
		clickByXpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]");
		//Verify the Title of the Page
		verifyTitle("View Lead | opentaps CRM");
		//Click on Edit Link
		clickByLink("Edit");
		//Enter the Company Name - Edit the Company Name
		enterById("updateLeadForm_companyName", companyName);
		//Click on Update
		clickByXpath("//input[@value='Update']");
		//Verify the New Company Name
		verifyTextById("viewLead_companyName_sp", "Suren Corp. LTD");
		System.out.println("EDIT LEAD COMPLETED SUCCESFULLY");
	}
	
	@DataProvider(name="datasource")
	public Object[][] fetchdata(){
		Object[][] obj = new Object[1][2];
		obj[0][0] = "Suren";
		obj[0][1] = "Suren Corp";
		return obj;
	}
}
