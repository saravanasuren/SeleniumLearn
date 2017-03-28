package wrappers;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class LeafTapsWrappers2 extends GenericWrappers{
	
	@Parameters({"browser","url","username","password"})
	@BeforeMethod
	public void loginLeafTaps(String browser, String url,String uName,String pwd){
		//Launch URL
		invokeApp(browser, url);
		//Enter User ID
		enterById("username", uName);
		//Enter Password
		enterById("password", pwd);
		//Click On Login
		clickByClassName("decorativeSubmit");
		//Click CRM/SFA Link
		clickByLink("CRM/SFA");	
	}
	
	@AfterMethod(groups="common")
	public void closeAllBrowser(){
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
