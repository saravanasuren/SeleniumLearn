package weeklyHomeWork;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateContactLeafTaps {

	public static void main(String[] args) throws InterruptedException {
		//Initialize WebDriver
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//Launch URL
		driver.get("http://leaftaps.com");
		//Maximize
		driver.manage().window().maximize();		
		//Enter User Name
		driver.findElementById("username").sendKeys("DemoSalesManager");
		//Enter Password
		driver.findElementById("password").sendKeys("crmsfa");
		//Click Submit
		driver.findElementByClassName("decorativeSubmit").click();
		//Click CRM/SFA
		driver.findElementByLinkText("CRM/SFA").click();
		//Click Create Contact
		driver.findElementByLinkText("Create Contact").click();
		//enter first name
		driver.findElementById("firstNameField").sendKeys("Suren");
		//enter last name
		driver.findElementById("lastNameField").sendKeys("Subramanian");
		//enter first name local
		driver.findElementById("createContactForm_firstNameLocal").sendKeys("SS");
		//enter last name local
		driver.findElementById("createContactForm_lastNameLocal").sendKeys("S");		
		//enter salutation
		driver.findElementById("createContactForm_personalTitle").sendKeys("Mr.");
		//enter Title
		driver.findElementById("createContactForm_generalProfTitle").sendKeys("Er.");
		//enter Department
		driver.findElementById("createContactForm_departmentName").sendKeys("IT");
		//enter DOB
		driver.findElementById("createContactForm_birthDate").sendKeys("12/12/84");		
		//Currency DropDown
		WebElement currencyDD = driver.findElementById("createContactForm_preferredCurrencyUomId");
		Select currdd = new Select(currencyDD);
		currdd.selectByVisibleText("INR - Indian Rupee");
		//enter Description
		driver.findElementById("createContactForm_description").sendKeys("Description");
		//enter Imp. Note
		driver.findElementById("createContactForm_importantNote").sendKeys("Important notes");		
		//enter Country Code
		driver.findElementById("createContactForm_primaryPhoneCountryCode").sendKeys("91");
		//enter Phone#
		driver.findElementById("createContactForm_primaryPhoneNumber").sendKeys("4121392");
		//enter Area Code	
		driver.findElementById("createContactForm_primaryPhoneAreaCode").sendKeys("994");
		//enter Extn
		driver.findElementById("createContactForm_primaryPhoneExtension").sendKeys("66163327");
		//enter Person to ask
		driver.findElementById("createContactForm_primaryPhoneAskForName").sendKeys("Suren");
		//enter email
		driver.findElementById("createContactForm_primaryEmail").sendKeys("saravanasuren@gmail.com");
		//enter to Name
		driver.findElementById("generalToNameField").sendKeys("suren");
		//enter ATTN. Name
		driver.findElementById("createContactForm_generalAttnName").sendKeys("suren");
		//enter Address Line 1
		driver.findElementById("createContactForm_generalAddress1").sendKeys("2803B, Seawood");
		//enter Address Line 2
		driver.findElementById("createContactForm_generalAddress2").sendKeys("house of Hiranandani");
		//enter City
		driver.findElementById("createContactForm_generalCity").sendKeys("Chennai");
		//enter Zipcode
		driver.findElementById("createContactForm_generalPostalCode").sendKeys("600010");
		//enter Zeipcode extn.
		driver.findElementById("createContactForm_generalPostalCodeExt").sendKeys("4401");
		//Country DropDown
		WebElement cntryDropDown = driver.findElementById("createContactForm_generalCountryGeoId");
		Select cntrydd = new Select(cntryDropDown);
		cntrydd.selectByVisibleText("India");	
		Thread.sleep(3000);
		//State DropDown
		WebElement stateDropDown = driver.findElementById("createContactForm_generalStateProvinceGeoId");
		Select statedd = new Select(stateDropDown);
		statedd.selectByVisibleText("TAMILNADU");	
		//Click Create Contact
		driver.findElementByClassName("smallSubmit").click();
		driver.close();
		System.out.println("Test Completed Success");
	}

}
