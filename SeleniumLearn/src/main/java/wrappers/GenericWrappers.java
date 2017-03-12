package wrappers;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class GenericWrappers implements Wrappers {

	RemoteWebDriver driver;
	int i=1;

	public void invokeApp(String browser, String url) {

		if(browser.equalsIgnoreCase("chrome")){		
			System.setProperty("webdriver.chrome.driver",
					"./drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")){		
			System.setProperty("webdriver.gecko.driver",
					"./drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		takeSnap();
		System.out.println("The Browser "+browser+" is Launched" );


	}

	public void enterById(String idValue, String data) {
		driver.findElementById(idValue).clear();
		driver.findElementById(idValue).sendKeys(data);
		takeSnap();
		System.out.println("The text field "+idValue+" is entered with data :"+data);

	}

	public void enterByName(String nameValue, String data) {
		// TODO Auto-generated method stub

	}

	public void enterByXpath(String xpathValue, String data) {
		// TODO Auto-generated method stub

	}

	public boolean verifyTitle(String title) {
		boolean bReturn = false;
		if(driver.getTitle().equals(title)){
			bReturn = true;
		}
		return bReturn;
	}

	public void verifyTextById(String id, String text) {
		// TODO Auto-generated method stub

	}

	public void verifyTextByXpath(String xpath, String text) {
		// TODO Auto-generated method stub

	}

	public void verifyTextContainsByXpath(String xpath, String text) {
		// TODO Auto-generated method stub

	}

	public void clickById(String id) {
		// TODO Auto-generated method stub

	}

	public void clickByClassName(String classVal) {
		driver.findElementByClassName(classVal).click();
		takeSnap();
		System.out.println("The button "+classVal+" is clicked");
	}

	public void clickByName(String name) {
		// TODO Auto-generated method stub

	}

	public void clickByLink(String name) {
		driver.findElementByLinkText(name).click();
		takeSnap();
		System.out.println("Clicked on the " + name + "succesfully");

	}

	public void clickByLinkNoSnap(String name) {
		// TODO Auto-generated method stub

	}

	public void clickByXpath(String xpathVal) {
		// TODO Auto-generated method stub

	}

	public void clickByXpathNoSnap(String xpathVal) {
		// TODO Auto-generated method stub

	}

	public String getTextById(String idVal) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTextByXpath(String xpathVal) {
		// TODO Auto-generated method stub
		return null;
	}

	public void selectVisibileTextById(String id, String value) {
		WebElement dropDown = driver.findElementById(id);
		Select dDown = new Select(dropDown);
		dDown.selectByVisibleText(value);
		takeSnap();
		System.out.println("The dropdown " + value + " is selected using id: " + id);

	}

	public void selectIndexById(String id, int value) {
		// TODO Auto-generated method stub

	}

	public void switchToParentWindow() {
		// TODO Auto-generated method stub

	}

	public void switchToLastWindow() {
		// TODO Auto-generated method stub

	}

	public void acceptAlert() {
		// TODO Auto-generated method stub

	}

	public void dismissAlert() {
		// TODO Auto-generated method stub

	}

	public String getAlertText() {
		// TODO Auto-generated method stub
		return null;
	}

	public void takeSnap() {
		File src = 	driver.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./snaps/snap"+i+".jpg");
		try {
			FileUtils.copyFile(src, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		i++;
	}

	public void closeBrowser() {
		driver.close();
		System.out.println("The Browser is closed succesfully");

	}
	
	public void closeAllBrowsers() {
		driver.quit();
		System.out.println("All Browsers are closed succesfully");

	}

}
