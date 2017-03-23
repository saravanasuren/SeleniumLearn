package day1;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sample1 {

	public static void main(String[] args) throws InterruptedException {
				
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 3);
		driver.get("http://leaftaps.com");
		driver.manage().window().maximize();		
		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		Thread.sleep(3000);
		driver.findElementByLinkText("Create Lead").click();
		driver.findElementById("createLeadForm_companyName").sendKeys("My Company");
		driver.findElementById("createLeadForm_firstName").sendKeys("My First Name");
		driver.findElementById("createLeadForm_lastName").sendKeys("My Last Name");
		driver.findElementById("createLeadForm_parentPartyId").sendKeys("17865"); 
		driver.findElementById("createLeadForm_dataSourceId").sendKeys("Conference");
		driver.findElementById("createLeadForm_marketingCampaignId").sendKeys("Automobile");
		driver.findElementById("createLeadForm_firstNameLocal").sendKeys("Local First Name");
		driver.findElementById("createLeadForm_lastNameLocal").sendKeys("Local Last Name");		
		driver.findElementById("createLeadForm_personalTitle").sendKeys("My Salutation");	
		driver.findElementById("createLeadForm_generalProfTitle").sendKeys("My Title");
		//Placeholder for D.O.B
		driver.findElementById("createLeadForm_departmentName").sendKeys("My Department");
		driver.findElementById("createLeadForm_annualRevenue").sendKeys("12,00,00");	
		driver.findElementById("createLeadForm_industryEnumId").sendKeys("Aerospace");
		driver.findElementById("createLeadForm_ownershipEnumId").sendKeys("Corporation");
		driver.findElementById("createLeadForm_currencyUomId").sendKeys("USD - American Dollar");
		driver.findElementById("createLeadForm_numberEmployees").sendKeys("5000");
		driver.findElementById("createLeadForm_sicCode").sendKeys("121284");
		driver.findElementById("createLeadForm_tickerSymbol").sendKeys("Symbol");
		driver.findElementById("createLeadForm_description").sendKeys("Description goes here");
		driver.findElementById("createLeadForm_importantNote").sendKeys("Important notes goes here");
		driver.findElementById("createLeadForm_primaryPhoneCountryCode").sendKeys("1");
		driver.findElementById("createLeadForm_primaryPhoneNumber").sendKeys("5759131");
		driver.findElementById("createLeadForm_primaryPhoneAreaCode").sendKeys("678");
		driver.findElementById("createLeadForm_primaryPhoneAskForName").sendKeys("Suren");
		driver.findElementById("createLeadForm_primaryPhoneExtension").sendKeys("83434");
		driver.findElementById("createLeadForm_primaryEmail").sendKeys("saravanasuren@gmail.com");		
		driver.findElementById("createLeadForm_primaryWebUrl").sendKeys("http://www.suren.com");	
		driver.findElementById("createLeadForm_generalToName").sendKeys("To Name");		
		driver.findElementById("createLeadForm_generalAttnName").sendKeys("Attn. Name");
		driver.findElementById("createLeadForm_generalAddress1").sendKeys("Address Line 1");
		driver.findElementById("createLeadForm_generalAddress2").sendKeys("Address Line 2");
		driver.findElementById("createLeadForm_generalCity").sendKeys("Atlanta");
		driver.findElementById("createLeadForm_generalPostalCode").sendKeys("30080");
		driver.findElementById("createLeadForm_generalPostalCodeExt").sendKeys("1234");
		driver.findElementById("createLeadForm_generalStateProvinceGeoId").sendKeys("Georgia");
		driver.findElementById("createLeadForm_generalCountryGeoId").sendKeys("United States");
		driver.findElementByClassName("smallSubmit").click();
		System.out.println("Test Complete");
		driver.close();
	}

}
