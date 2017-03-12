package wrappers;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
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
		driver.findElementByName(nameValue).clear();
		driver.findElementByName(nameValue).sendKeys(data);
		takeSnap();
		System.out.println("The text field "+nameValue+" is entered with data: "+data);

	}

	public void enterByXpath(String xpathValue, String data) {
		driver.findElementByName(xpathValue).clear();
		driver.findElementByName(xpathValue).sendKeys(data);
		takeSnap();
		System.out.println("The text field "+xpathValue+" is entered with data: "+data);

	}

	public boolean verifyTitle(String title) {
		boolean bReturn = false;
		if(driver.getTitle().equals(title)){
			bReturn = true;
		}
		return bReturn;
	}

	public void verifyTextById(String id, String text) {
		String textValueById = driver.findElementById(id).getText();
		takeSnap();
		if(textValueById.equalsIgnoreCase(text)){
			System.out.println("The text "+text+" matches searched by id:" +id);
		}
		else{
			System.out.println("The text "+text+" does not match searched by id:" +id);
		}
	}

	public void verifyTextByXpath(String xpath, String text) {
		String textValueByxpath = driver.findElementById(xpath).getText();
		takeSnap();
		if(textValueByxpath.equalsIgnoreCase(text)){
			System.out.println("The text "+text+" matches searched by xpath:" +xpath);
		}
		else{
			System.out.println("The text "+text+" does not match searched by xpath:" +xpath);
		}
	}

	public void verifyTextContainsByXpath(String xpath, String text) {
		String textValueByxpath = driver.findElementById(xpath).getText();
		takeSnap();
		if(textValueByxpath.contains(text)){
			System.out.println("The text "+text+" is found - searched by xpath:" +xpath);
		}
		else{
			System.out.println("The text "+text+" is not found - searched by xpath:" +xpath);
		}
	}

	public void clickById(String id) {
		driver.findElementByClassName(id).click();
		takeSnap();
		System.out.println("The button "+id+" is clicked");

	}

	public void clickByClassName(String classVal) {
		driver.findElementByClassName(classVal).click();
		takeSnap();
		System.out.println("The button "+classVal+" is clicked");
	}

	public void clickByName(String name) {
		driver.findElementByClassName(name).click();
		takeSnap();
		System.out.println("The button "+name+" is clicked");

	}

	public void clickByLink(String name) {
		driver.findElementByLinkText(name).click();
		takeSnap();
		System.out.println("Clicked on the " + name + "succesfully");

	}

	public void clickByLinkNoSnap(String name) {
		driver.findElementByLinkText(name).click();
		//takeSnap();
		System.out.println("Clicked on the " + name + "succesfully");

	}

	public void clickByXpath(String xpathVal) {
		driver.findElementByLinkText(xpathVal).click();
		takeSnap();
		System.out.println("Clicked on the " + xpathVal + "succesfully");

	}

	public void clickByXpathNoSnap(String xpathVal) {
		driver.findElementByLinkText(xpathVal).click();
		//takeSnap();
		System.out.println("Clicked on the " + xpathVal + "succesfully");

	}

	public String getTextById(String idVal) {
		String textById = driver.findElementById(idVal).getText();
		takeSnap();
		System.out.println("Get Text by using id "+idVal+" completed succesfully" );
		return textById;
	}

	public String getTextByXpath(String xpathVal) {
		String textByxpath = driver.findElementById(xpathVal).getText();
		takeSnap();
		System.out.println("Get Text by using xpath "+xpathVal+" completed succesfully" );
		return textByxpath;
	}

	public void selectVisibileTextById(String id, String value) {
		WebElement dropDown = driver.findElementById(id);
		Select dDown = new Select(dropDown);
		dDown.selectByVisibleText(value);
		takeSnap();
		System.out.println("The dropdown " + value + " is selected using id: " + id);

	}

	public void selectIndexById(String id, int value) {
		WebElement dropDown = driver.findElementById(id);
		Select dDown = new Select(dropDown);
		dDown.selectByIndex(value);
		takeSnap();
		System.out.println("The dropdown " + value + " is selected using id: " + id);

	}

	public void switchToParentWindow() {
		Set<String> allWindow = driver.getWindowHandles();
		System.out.println("Number of Windows: "+ allWindow.size());		
		System.out.println("Title of Current (Parent) Window: " + driver.getTitle());	
		int i=1;
		for (String eachWindow : allWindow) {			
			driver.switchTo().window(eachWindow);
			if(i==1){
				break;
			}
			i++;			
		}		
		takeSnap();
		System.out.println("Title of Parent/First Window: " + driver.getTitle());
	}

	public void switchToLastWindow() {
		Set<String> allWindow = driver.getWindowHandles();		
		System.out.println("Number of Windows: "+ allWindow.size());		
		System.out.println("Title of Current (Parent) Window: " + driver.getTitle());		
		for (String eachWindow : allWindow) {			
			driver.switchTo().window(eachWindow);
		}		
		takeSnap();
		System.out.println("Title of Last Window: " + driver.getTitle());
	}

	public void acceptAlert() {
		driver.switchTo().alert().accept();

	}

	public void dismissAlert() {
		driver.switchTo().alert().dismiss();

	}

	public String getAlertText() {
		Alert handleAlert = driver.switchTo().alert();
		String alertText = handleAlert.getText();
		return alertText;
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
