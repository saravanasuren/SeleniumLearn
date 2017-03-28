package parametersAndDataProviders;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import wrappers.LeafTapsWrappers2;

public class CreateLeadUsingDP extends LeafTapsWrappers2 {

	@Test (dataProvider="datasource")
	public void creteLead(String companyName, String fName, String lName, String dsource, String mCampaign,
			String dept, String aRevenue, String currency, String phone, String email){
		//Click on Create Lead
		clickByLink("Create Lead");
		//Enter Company Name
		enterById("createLeadForm_companyName",companyName );
		//Enter First Name		
		enterById("createLeadForm_firstName", fName);
		//Enter Last Name
		enterById("createLeadForm_lastName", lName);
		//Select Source Drop Down
		selectVisibileTextById("createLeadForm_dataSourceId", dsource);
		//Select Marketing Campaign Drop down
		selectVisibileTextById("createLeadForm_marketingCampaignId", mCampaign);
		//Place Holder for D.O.B
		//Enter Department
		enterById("createLeadForm_departmentName", dept);
		//Enter Annual Revenue
		enterById("createLeadForm_annualRevenue", aRevenue);
		//Select Currency
		selectVisibileTextById("createLeadForm_currencyUomId", currency);
		//Enter Phone Number
		enterById("createLeadForm_primaryPhoneNumber", phone);
		//Enter Email
		enterById("createLeadForm_primaryEmail", email);
		//Click Create Lead Button
		clickByClassName("smallSubmit");
		System.out.println("CREATE LEAD USING WRAPPERS: TEST COMPLETED SUCCESSFULLY");		
	}

	//Data Provider - This is created to pass the data to the test case using DP matrix.
	@DataProvider(name="datasource")
	public Object[][] fetchData(){
		Object[][] obj = new Object[3][10];
		obj[0][0] = "Suren Corp8";
		obj[0][1] = "Suren";
		obj[0][2] = "S";
		obj[0][3] = "Conference";
		obj[0][4] = "Automobile";
		obj[0][5] = "My Dept";	
		obj[0][6] = "120000";
		obj[0][7] = "INR - Indian Rupee";
		obj[0][8] = "9944121392";
		obj[0][9] = "saravanasuren@gmail.com";
		obj[1][0] = "Suren Corp9";
		obj[1][1] = "Suren";
		obj[1][2] = "S";
		obj[1][3] = "Conference";
		obj[1][4] = "Automobile";
		obj[1][5] = "My Dept";	
		obj[1][6] = "120000";
		obj[1][7] = "INR - Indian Rupee";
		obj[1][8] = "9944121392";
		obj[1][9] = "saravanasuren@gmail.com";
		obj[2][0] = "Suren Corp10";
		obj[2][1] = "Suren";
		obj[2][2] = "S";
		obj[2][3] = "Conference";
		obj[2][4] = "Automobile";
		obj[2][5] = "My Dept";	
		obj[2][6] = "120000";
		obj[2][7] = "INR - Indian Rupee";
		obj[2][8] = "9944121392";
		obj[2][9] = "saravanasuren@gmail.com";
		return obj;
	}

}
