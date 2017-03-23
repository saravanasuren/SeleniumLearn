package wrappers;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class GenericWrappers implements Wrappers {

	RemoteWebDriver driver;
	int i=1;

	public void invokeApp(String browser, String url) {
		try {
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
			System.out.println(browser+ "Browser is Launched Succesfully" );
		} catch (NoSuchWindowException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - InvokeApp: No Such Window Found");
			throw new RuntimeException();
		} catch (WebDriverException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - InvokeApp: WebDriver Exception Occured");
			throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - InvokeApp: Other Exception");
			throw new RuntimeException();
		} finally{
			takeSnap();
		}
	}

	public void enterById(String idValue, String data) {
		try {
			driver.findElementById(idValue).clear();
			driver.findElementById(idValue).sendKeys(data);
			System.out.println("The text field "+idValue+" is entered with data :"+data);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - enterById: No Such Element - element could not be found Occured");
			throw new RuntimeException();
		} catch (NotFoundException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - enterById: Element Not Found Exception Occured");
			throw new RuntimeException();
		} catch (WebDriverException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - enterById: Web Driver Exception Occured");
			throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - enterById: Other Exception Occured");
			throw new RuntimeException();
		} finally{
			takeSnap();
		}
	}

	public void enterByName(String nameValue, String data) {
		try {
			driver.findElementByName(nameValue).clear();
			driver.findElementByName(nameValue).sendKeys(data);
			System.out.println("The text field "+nameValue+" is entered with data: "+data);
		}  catch (NoSuchElementException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - enterByName: No Such Element - element could not be found Occured");
			throw new RuntimeException();
		} catch (NotFoundException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - enterByName: Element Not Found Exception Occured");
			throw new RuntimeException();
		} catch (WebDriverException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - enterByName: Web Driver Exception Occured");
			throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - enterByName: Other Exception Occured");
			throw new RuntimeException();
		} finally{
			takeSnap();
		}
	}

	public void enterByXpath(String xpathValue, String data) {
		try {
			driver.findElementByXPath(xpathValue).clear();
			driver.findElementByXPath(xpathValue).sendKeys(data);
			System.out.println("The text field "+xpathValue+" is entered with data: "+data);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - enterByXpath: No Such Element - element could not be found Occured");
			throw new RuntimeException();
		} catch (NotFoundException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - enterByXpath: Element Not Found Exception Occured");
			throw new RuntimeException();
		} catch (WebDriverException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - enterByXpath: Web Driver Exception Occured");
			throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - enterByXpath: Other Exception Occured");
			throw new RuntimeException();
		} finally{
			takeSnap();
		}
	}

	public boolean verifyTitle(String title) {
		boolean bReturn = false;
		try {
			if(driver.getTitle().equals(title)){
				bReturn = true;
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - verifyTitle: No Such Element - element could not be found Occured");
		} catch (NotFoundException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - verifyTitle: Element Not Found Exception Occured");
		} catch (WebDriverException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - verifyTitle: Web Driver Exception Occured");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - verifyTitle: Other Exception Occured");
		} 
		return bReturn;
	}

	public void verifyTextById(String id, String text) {
		try {
			String textValueById = driver.findElementById(id).getText();
			if(textValueById.equals(text)){
				System.out.println("The text "+text+" matches searched by id:" +id);
			}
			else{
				System.out.println("The text "+text+" does not match searched by id:" +id);
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - verifyTextById: No Such Element - element could not be found Occured");
		} catch (NotFoundException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - verifyTextById: Element Not Found Exception Occured");
		} catch (WebDriverException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - verifyTextById: Web Driver Exception Occured");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - verifyTextById: Other Exception Occured");
		} 
	}

	public void verifyTextByLink(String name, String text) {
		try {
			String textValueByName = driver.findElementById(name).getText();
			if(textValueByName.equals(text)){
				System.out.println("The text "+text+" matches searched by id:" +name);
			}
			else{
				System.out.println("The text "+text+" does not match searched by id:" +name);
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - verifyTextByLink: No Such Element - element could not be found Occured");
		} catch (NotFoundException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - verifyTextByLink: Element Not Found Exception Occured");
		} catch (WebDriverException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - verifyTextByLink: Web Driver Exception Occured");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - verifyTextByLink: Other Exception Occured");
		} 
	}

	public void verifyTextByXpath(String xpath, String text) {
		try {
			String textValueByxpath = driver.findElementByXPath(xpath).getText();
			if(textValueByxpath.equals(text)){
				System.out.println("The text "+text+" matches searched by xpath:" +xpath);
			}
			else{
				System.out.println("The text "+text+" does not match searched by xpath:" +xpath);
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - verifyTextByXpath: No Such Element - element could not be found Occured");
		} catch (NotFoundException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - verifyTextByXpath: Element Not Found Exception Occured");
		} catch (WebDriverException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - verifyTextByXpath: Web Driver Exception Occured");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - verifyTextByXpath: Other Exception Occured");
		} 
	}

	public void verifyTextContainsByXpath(String xpath, String text) {
		try {
			String textValueByxpath = driver.findElementByXPath(xpath).getText();
			if(textValueByxpath.contains(text)){
				System.out.println("The text "+text+" is found - searched by xpath:" +xpath);
			}
			else{
				System.out.println("The text "+text+" is not found - searched by xpath:" +xpath);
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - verifyTextContainsByXpath: No Such Element - element could not be found Occured");
		} catch (NotFoundException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - verifyTextContainsByXpath: Element Not Found Exception Occured");
		} catch (WebDriverException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - verifyTextContainsByXpath: Web Driver Exception Occured");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - verifyTextContainsByXpath: Other Exception Occured");
		} 
	}

	public void clickById(String id) {
		try {
			driver.findElementByClassName(id).click();
			System.out.println("The button "+id+" is clicked");
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - clickById: No Such Element - element could not be found Occured");
			throw new RuntimeException();
		} catch (NotFoundException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - clickById: Element Not Found Exception Occured");
			throw new RuntimeException();
		} catch (WebDriverException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - clickById: Web Driver Exception Occured");
			throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - clickById: Other Exception Occured");
			throw new RuntimeException();
		} finally{
			takeSnap();
		}
	}

	public void clickByClassName(String classVal) {
		try {
			driver.findElementByClassName(classVal).click();
			System.out.println("The button "+classVal+" is clicked");
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - clickByClassName: No Such Element - element could not be found Occured");
			throw new RuntimeException();
		} catch (NotFoundException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - clickByClassName: Element Not Found Exception Occured");
			throw new RuntimeException();
		} catch (WebDriverException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - clickByClassName: Web Driver Exception Occured");
			throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - clickByClassName: Other Exception Occured");
			throw new RuntimeException();
		} finally{
			takeSnap();
		}
	}

	public void clickByName(String name) {
		try {
			driver.findElementByClassName(name).click();
			System.out.println("The button "+name+" is clicked");
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - clickByName: No Such Element - element could not be found Occured");
			throw new RuntimeException();
		} catch (NotFoundException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - clickByName: Element Not Found Exception Occured");
			throw new RuntimeException();
		} catch (WebDriverException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - clickByName: Web Driver Exception Occured");
			throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - clickByName: Other Exception Occured");
			throw new RuntimeException();
		} finally{
			takeSnap();
		}
	}

	public void clickByLink(String name) {
		try {
			driver.findElementByLinkText(name).click();
			System.out.println("Clicked on the " + name + " Successfully");
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - clickByLink: No Such Element - element could not be found Occured");
			throw new RuntimeException();
		} catch (NotFoundException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - clickByLink: Element Not Found Exception Occured");
			throw new RuntimeException();
		} catch (WebDriverException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - clickByLink: Web Driver Exception Occured");
			throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - clickByLink: Other Exception Occured");
			throw new RuntimeException();
		} finally{
			takeSnap();
		}
	}

	public void clickByLinkNoSnap(String name) {
		try {
			driver.findElementByLinkText(name).click();
			System.out.println("Clicked on the " + name + " Successfully");
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - clickByLinkNoSnap: No Such Element - element could not be found Occured");
			throw new RuntimeException();
		} catch (NotFoundException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - clickByLinkNoSnap: Element Not Found Exception Occured");
			throw new RuntimeException();
		} catch (WebDriverException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - clickByLinkNoSnap: Web Driver Exception Occured");
			throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - clickByLinkNoSnap: Other Exception Occured");
			throw new RuntimeException();
		}
		//takeSnap();
	}

	public void clickByXpath(String xpathVal) {
		try {
			driver.findElementByXPath(xpathVal).click();
			System.out.println("Clicked on the " + xpathVal + " Successfully");
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - clickByXpath: No Such Element - element could not be found Occured");
			throw new RuntimeException();
		} catch (NotFoundException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - clickByXpath: Element Not Found Exception Occured");
			throw new RuntimeException();
		} catch (WebDriverException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - clickByXpath: Web Driver Exception Occured");
			throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - clickByXpath: Other Exception Occured");
			throw new RuntimeException();
		} finally{
			takeSnap();
		}
	}

	public void clickByXpathNoSnap(String xpathVal) {
		try {
			driver.findElementByXPath(xpathVal).click();
			System.out.println("Clicked on the " + xpathVal + " Successfully");
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - clickByXpathNoSnap: No Such Element - element could not be found Occured");
			throw new RuntimeException();
		} catch (NotFoundException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - clickByXpathNoSnap: Element Not Found Exception Occured");
			throw new RuntimeException();
		} catch (WebDriverException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - clickByXpathNoSnap: Web Driver Exception Occured");
			throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - clickByXpathNoSnap: Other Exception Occured");
			throw new RuntimeException();
		}
		//takeSnap();
	}

	public String getTextById(String idVal) {
		String textById = "null";
		try {
			textById = driver.findElementById(idVal).getText();
			System.out.println("Get Text by using id "+idVal+" completed  Successfully" );
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - getTextById: No Such Element - element could not be found Occured");
			throw new RuntimeException();
		} catch (NotFoundException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - getTextById: Element Not Found Exception Occured");
			throw new RuntimeException();
		} catch (WebDriverException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - getTextById: Web Driver Exception Occured");
			throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - getTextById: Other Exception Occured");
			throw new RuntimeException();
		} finally{
			takeSnap();
		}
		return textById;
	}

	public String getTextByXpath(String xpathVal) {
		String textByxpath = "null";
		try {
			textByxpath = driver.findElementByXPath(xpathVal).getText();
			System.out.println("Get Text by using xpath "+xpathVal+" completed  Successfully" );
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - getTextByXpath: No Such Element - element could not be found Occured");
			throw new RuntimeException();
		} catch (NotFoundException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - getTextByXpath: Element Not Found Exception Occured");
			throw new RuntimeException();
		} catch (WebDriverException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - getTextByXpath: Web Driver Exception Occured");
			throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - getTextByXpath: Other Exception Occured");
			throw new RuntimeException();
		} finally{
			takeSnap();
		}
		return textByxpath;
	}

	public void selectVisibileTextById(String id, String value) {
		try {
			WebElement dropDown = driver.findElementById(id);
			Select dDown = new Select(dropDown);
			dDown.selectByVisibleText(value);
			System.out.println("The dropdown " + value + " is selected using id: " + id);
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

	public void selectIndexById(String id, int value) {
		try {
			WebElement dropDown = driver.findElementById(id);
			Select dDown = new Select(dropDown);
			dDown.selectByIndex(value);
			System.out.println("The dropdown " + value + " is selected using id: " + id);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - selectIndexById: No Such Element - element could not be found Occured");
			throw new RuntimeException();
		} catch (NotFoundException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - selectIndexById: Element Not Found Exception Occured");
			throw new RuntimeException();
		} catch (WebDriverException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - selectIndexById: Web Driver Exception Occured");
			throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - selectIndexById: Other Exception Occured");
			throw new RuntimeException();
		} finally{
			takeSnap();
		}
	}

	public void switchToParentWindow() {
		try {
			Set<String> allWindow = driver.getWindowHandles();
			System.out.println("Number of Windows: "+ allWindow.size());		
			//System.out.println("Title of Current (Parent) Window: " + driver.getTitle());	
			//Or this can be written by just getting the handle of First Window and saving in a string variable
			//Then call the string variable when we need to switch to the First Window
			//String firstWindow = driver.getWindowHandle();
			int i=1;
			for (String eachWindow : allWindow) {			
				driver.switchTo().window(eachWindow);
				if(i==1){
					break;
				}
				i++;			
			}
			//driver.switchTo().window(firstWindow);
			System.out.println("Title of Parent/First Window: " + driver.getTitle());
		} catch (NoSuchWindowException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - switchToParentWindow: target to be switched doesn’t exist");
			throw new RuntimeException();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - switchToParentWindow: No Such Element - element could not be found Occured");
			throw new RuntimeException();
		} catch (NotFoundException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - switchToParentWindow: Element Not Found Exception Occured");
			throw new RuntimeException();
		} catch (WebDriverException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - switchToParentWindow: Web Driver Exception Occured");
			throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - switchToParentWindow: Other Exception Occured");
			throw new RuntimeException();
		} finally{
			takeSnap();
		}
	}

	public void switchToLastWindow() {
		try {
			Set<String> allWindow = driver.getWindowHandles();		
			System.out.println("Number of Windows: "+ allWindow.size());		
			System.out.println("Title of Current (Parent) Window: " + driver.getTitle());	
			for (String eachWindow : allWindow) {		
				//System.out.println("Inside Loop - Title of Current Window: " + driver.getTitle());
				driver.switchTo().window(eachWindow);
			}
			System.out.println("Title of Last Window: " + driver.getTitle());
		} catch (NoSuchWindowException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - switchToLastWindow: target to be switched doesn’t exist");
			throw new RuntimeException();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - switchToLastWindow: No Such Element - element could not be found Occured");
			throw new RuntimeException();
		} catch (NotFoundException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - switchToLastWindow: Element Not Found Exception Occured");
			throw new RuntimeException();
		} catch (WebDriverException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - switchToLastWindow: Web Driver Exception Occured");
			throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - switchToLastWindow: Other Exception Occured");
			throw new RuntimeException();
		} finally{
			takeSnap();
		}	
	}

	public void acceptAlert() {
		try {
			driver.switchTo().alert().accept();
			System.out.println("Generic Wrappers - acceptAlert: Alert accepted succesfully");
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - acceptAlert: Alert Pop-Up not found");
			throw new RuntimeException();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - acceptAlert: No Such Element - element could not be found Occured");
			throw new RuntimeException();
		} catch (NotFoundException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - acceptAlert: Element Not Found Exception Occured");
			throw new RuntimeException();
		} catch (WebDriverException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - acceptAlert: Web Driver Exception Occured");
			throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - acceptAlert: Other Exception Occured");
			throw new RuntimeException();
		} 	
	}

	public void dismissAlert() {
		try {
			driver.switchTo().alert().dismiss();
			System.out.println("Generic Wrappers - dismissAlert: Alert Dismissed succesfully");
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - dismissAlert: Alert Pop-Up not found");
			throw new RuntimeException();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - dismissAlert: No Such Element - element could not be found Occured");
			throw new RuntimeException();
		} catch (NotFoundException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - dismissAlert: Element Not Found Exception Occured");
			throw new RuntimeException();
		} catch (WebDriverException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - dismissAlert: Web Driver Exception Occured");
			throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - dismissAlert: Other Exception Occured");
			throw new RuntimeException();
		} 	
	}

	public String getAlertText() {
		String alertText = "null";
		try {
			Alert handleAlert = driver.switchTo().alert();
			alertText = handleAlert.getText();
			System.out.println("Generic Wrappers - getAlertText: Alert Text" + alertText + "captured succesfully");
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - getAlertText: Alert Pop-Up not found");
			throw new RuntimeException();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - getAlertText: No Such Element - element could not be found Occured");
			throw new RuntimeException();
		} catch (NotFoundException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - getAlertText: Element Not Found Exception Occured");
			throw new RuntimeException();
		} catch (WebDriverException e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - getAlertText: Web Driver Exception Occured");
			throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Generic Wrappers - getAlertText: Other Exception Occured");
			throw new RuntimeException();
		} 	

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
		try {
			driver.close();
			System.out.println("The Browser is closed  Successfully");
		} catch (WebDriverException e) {
			e.printStackTrace();
			System.out.println("WebDriver Exception Occured while Closing Browser");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Other Exception Occured while Closing Browser");
		}
	}

	public void closeAllBrowsers() {
		try {
			driver.quit();
			System.out.println("The Browsers are closed  Successfully");
		} catch (WebDriverException e) {
			e.printStackTrace();
			System.out.println("WebDriver Exception Occured while Closing All Browsers");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Other Exception Occured while Closing All Browsers");
		}
	}

}
