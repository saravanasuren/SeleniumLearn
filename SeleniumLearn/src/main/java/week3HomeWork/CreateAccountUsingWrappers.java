package week3HomeWork;

import org.junit.Test;

import wrappers.LeafTapsWrappers;

public class CreateAccountUsingWrappers extends LeafTapsWrappers {
	@Test
	public void CreateAccount() {
		//Login to LeafTaps
		loginLeafTaps();
		//Click on CRM/SFA
		clickByLink("CRM/SFA");
		//Click On Accounts Tab
		clickByLink("Accounts");
		//Click on Create Account Link
		clickByLink("Create Account");
		//Set the Account Name in String Variable - TO validate later
		String AccountName = "Suren Corp6";
		//Enter the Account Name
		enterById("accountName", AccountName);
		//Select Industry Drop down
		selectVisibileTextByName("industryEnumId", "Manufacturing");
		//Select Currency Drop Down
		selectVisibileTextById("currencyUomId", "MUR - Mauritius Rupee");
		//Select Data Source drop downs
		selectVisibileTextById("dataSourceId", "Existing Customer");
		//Select Marketing Campaign Drop Down
		selectVisibileTextById("marketingCampaignId", "Automobile");
		//Enter Phone Number
		enterById("primaryPhoneNumber", "9944121392");
		//Enter City
		enterById("generalCity", "Coimbatore");
		//Enter Primary email
		enterById("primaryEmail", "saravanasuren@gmail.com");
		//Select Country Drop Down
		selectVisibileTextById("generalCountryGeoId", "India");
		//Select State
		selectVisibileTextById("generalStateProvinceGeoId", "TAMILNADU");
		//Click Submit button
		clickByClassName("smallSubmit"); 
		String TempAccountID = getTextByXpath("//span[text()='Account Name']/following::span[@class='tabletext']");
		System.out.println("Temp Account ID: "+TempAccountID);
		String ActualAccountID = TempAccountID.substring(TempAccountID.indexOf("(")+1,TempAccountID.indexOf(")"));
		System.out.println("ACTUAL ACCOUNT ID: "+ActualAccountID);
		//Click Find Accounts Option
		clickByLink("Find Accounts");
		//Enter the Account Name Captured Above
		enterByXpath("//span[text()='Name and ID']/following::input[@name='accountName']", AccountName);
		//Enter the Account ID Captured Above
		enterByXpath("//span[text()='Name and ID']/following::input[@name='id']", ActualAccountID);
		//Click on Find Accounts
		clickByXpath("//button[text()='Find Accounts']");
		//Verify the Account ID with the resulting row
		verifyTextByXpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a", ActualAccountID);
		//Close Browser
		System.out.println("CREATE ACCOUNT COMPLETED SUCCESSFULLY");
		closeAllBrowsers();
		
	}

}
