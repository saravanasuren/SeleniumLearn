package wrappers;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class LeafTapsWrappers extends GenericWrappers{
	
	@BeforeMethod
	public void loginLeafTaps(){
		//Launch URL
		invokeApp("Chrome", "http://leaftaps.com/control/main");
		//Enter User ID
		enterById("username", "DemoSalesManager");
		//Enter Password
		enterById("password", "crmsfa");
		//Click On Login
		clickByClassName("decorativeSubmit");
		//Click CRM/SFA Link
		clickByLink("CRM/SFA");	
	}
	
	@AfterMethod
	public void closeaAllBrowser(){
		closeAllBrowsers();
	}
	public void selectVisibileTextByName(String name, String value) {
		try {
			WebElement dropDown = driver.findElementByName(name);
			Select dDown = new Select(dropDown);
			dDown.selectByVisibleText(value);
			System.out.println("The dropdown " + value + " is selected using id: " + name);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - selectVisibileTextById: No Such Element - element could not be found Occured");
			throw new RuntimeException();
		} catch (NotFoundException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - selectVisibileTextById: Element Not Found Exception Occured");
			throw new RuntimeException();
		} catch (WebDriverException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - selectVisibileTextById: Web Driver Exception Occured");
			throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - selectVisibileTextById: Other Exception Occured");
			throw new RuntimeException();
		} finally{
			takeSnap();
		}
	}

}
