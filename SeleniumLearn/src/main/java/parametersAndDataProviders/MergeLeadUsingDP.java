package parametersAndDataProviders;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import wrappers.LeafTapsWrappers2;

public class MergeLeadUsingDP extends LeafTapsWrappers2{

	@Test(dataProvider="datasource",groups={"regression"}, dependsOnGroups={"sanity"}, enabled=false)
	//Passed FromAccountID as null from DP and used it here to run the program as many times as defined in DP[][]
	public void MergeLead(String FromAccountID) throws InterruptedException {
		//Click on Accounts Link
		clickByLink("Accounts");
		//Click on Merge Accounts
		clickByLink("Merge Accounts");
		//Click On From Account icon
		clickByXpath("(//img[@alt='Lookup'])[1]");
		//Switch to Last Window
		switchToLastWindow();
		//Get the Account ID from the First Resulting Lead
		//FromAccountID variable is coming from DP - It is not holding any value but using this to run the test case 3 times using DP[][]
		FromAccountID = getTextByXpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]");
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

	@DataProvider(name = "datasource")
	public Object[][] fetchdata(){
		Object[][] obj = new Object[1][1];
		obj[0][0] = "FromAccountID";
		return obj;
	}

}
