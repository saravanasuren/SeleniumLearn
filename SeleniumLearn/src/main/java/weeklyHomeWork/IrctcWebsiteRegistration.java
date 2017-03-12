package weeklyHomeWork;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class IrctcWebsiteRegistration {

	public static void main(String[] args) throws InterruptedException {
		//Define WebDriver
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		//Create Object for WebDriver
		ChromeDriver driver = new ChromeDriver();
		//Launch URL
		driver.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");
		//maximize
		driver.manage().window().maximize();
		//UserName
		driver.findElementById("userRegistrationForm:userName").sendKeys("suren1984");
		//Password
		driver.findElementById("userRegistrationForm:password").sendKeys("password");
		//Confirm Password
		driver.findElementById("userRegistrationForm:confpasword").sendKeys("password");
		//Security Question DropDown
		WebElement SQDropDown = driver.findElementById("userRegistrationForm:securityQ");
		Select SQDDown = new Select(SQDropDown);
		//Select the drop down option
		SQDDown.selectByVisibleText("What is your pet name?");
		//Security answer
		driver.findElementById("userRegistrationForm:securityAnswer").sendKeys("Danie");
		//Preferred Language Drop Down
		WebElement LangDropDown = driver.findElementById("userRegistrationForm:prelan");
		Select LangdDown = new Select(LangDropDown);
		//Select English option
		LangdDown.selectByVisibleText("English");
		//Enter First Name
		driver.findElementById("userRegistrationForm:firstName").sendKeys("Suren");
		//Enter Last Name
		driver.findElementById("userRegistrationForm:lastName").sendKeys("Subramanian");	
		//Select Gender
		driver.findElementById("userRegistrationForm:gender:0").click();	
		//Select Martial Status
		driver.findElementById("userRegistrationForm:maritalStatus:0").click();
		//Select DOB Day
		WebElement dobDayDropDown = driver.findElementById("userRegistrationForm:dobDay");
		Select dobDayDDown = new Select(dobDayDropDown);
		//Select the drop down option
		dobDayDDown.selectByVisibleText("12");
		//Select DOB Day
		WebElement dobMonDropDown = driver.findElementById("userRegistrationForm:dobMonth");
		Select dobMonDDown = new Select(dobMonDropDown);
		//Select the drop down option
		dobMonDDown.selectByVisibleText("DEC");
		//Select DOB Year
		WebElement dobYearDropDown = driver.findElementById("userRegistrationForm:dateOfBirth");
		Select dobYearDDown = new Select(dobYearDropDown);
		//Select the drop down option
		dobYearDDown.selectByVisibleText("1984");
		//Select Occupation
		WebElement Occupation = driver.findElementById("userRegistrationForm:occupation");
		Select OccupationDDown = new Select(Occupation);
		//Select the drop down option
		OccupationDDown.selectByVisibleText("Professional");	
		//Enter email
		driver.findElementById("userRegistrationForm:email").sendKeys("saravanasuren@gmail.com");
		//Enter Mobile #
		driver.findElementById("userRegistrationForm:mobile").sendKeys("9944121392");	
		//Select nationality
		WebElement nationalityDropDown = driver.findElementById("userRegistrationForm:nationalityId");
		Select nationalityDDown = new Select(nationalityDropDown);
		//Select the drop down option
		nationalityDDown.selectByVisibleText("India");		
		//Enter Door No	
		driver.findElementById("userRegistrationForm:address").sendKeys("2803B");
		//Select Country
		WebElement countryDropDown = driver.findElementById("userRegistrationForm:countries");
		Select countryDDown = new Select(countryDropDown);
		//Select the drop down option
		countryDDown.selectByVisibleText("India");
		//Enter PIN Code	
		driver.findElementById("userRegistrationForm:pincode").sendKeys("600096",Keys.TAB);
		Thread.sleep(5000);
		
		/*Why?
				If you notice the application, on entering Pincode the STATE is auto populated and hence CITY too;
				whereas the page does not load again. So, the implicitly wait is not applied as the page does not get
				reloaded; whereas the element values does load using JavaScript when the mouse is out of the pincode
				and generally simulated using key tab on the pincode field.
				Possible Solutions / Workarounds:
				When entering value in the pincode field, add the keyboard tab action as well. Sample code below:
				driver.findElementById(“pincodeidhere”).sendKeys(“600061”,Keys.TAB); */
		//Enter State	== This is Auto Selected based on PinCode
		//String sn = driver.findElementById("userRegistrationForm:statesName").getText();
		//Select City Drop Down
		WebElement cityDropDown = driver.findElementById("userRegistrationForm:cityName");
		Select cityDDown = new Select(cityDropDown);
		//Select the drop down option
		cityDDown.selectByIndex(1);	
		//Select Post Office Drop Down
		Thread.sleep(5000);	
		WebElement poDropDown = driver.findElementById("userRegistrationForm:postofficeName");
		Select poDDown = new Select(poDropDown);
		//Select the drop down option
		poDDown.selectByVisibleText("Perungudi S.O");	
		//Enter LandLine	
		driver.findElementById("userRegistrationForm:landline").sendKeys("04466163327");
		//Select Copy Residence to Office Address Radio button	
		driver.findElementById("userRegistrationForm:resAndOff:0").click();
		driver.close();
		System.out.println("Test Completed succesfully");
	}



}
