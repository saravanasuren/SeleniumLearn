package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownAndList {

	public static void main(String[] args) throws InterruptedException {
		//Initialize Driver
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//Launch URL
		driver.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");
		//Identify the DropDown Element
		WebElement dropDown = driver.findElementById("userRegistrationForm:securityQ");
		//Initialize the Select class for DropDown
		Select dDown = new Select(dropDown);
		//Select by Visible Text
		dDown.selectByVisibleText("What is your pet name?");
		Thread.sleep(1000);
		//Select by Value
		dDown.selectByValue("5");
		Thread.sleep(1000);
		//Select by Index
		dDown.selectByIndex(4);
		Thread.sleep(1000);
		//Get & Print the size of Dropdown
		System.out.println(dDown.getOptions().size());
		//Select the last option in DropDown
		dDown.selectByIndex(dDown.getOptions().size()-1);
		
		

	}

}
