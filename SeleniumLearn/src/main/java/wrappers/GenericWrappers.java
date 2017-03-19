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
		} catch (NoSuchWindowException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (WebDriverException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally{
			takeSnap();
		}
		System.out.println("The Browser "+browser+" is Launched" );
	}

	public void enterById(String idValue, String data) {
		try {
			driver.findElementById(idValue).clear();
			driver.findElementById(idValue).sendKeys(data);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (NotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (WebDriverException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally{
			takeSnap();
		}
		System.out.println("The text field "+idValue+" is entered with data :"+data);

	}

	public void enterByName(String nameValue, String data) {
		try {
			driver.findElementByName(nameValue).clear();
			driver.findElementByName(nameValue).sendKeys(data);
		}  catch (NoSuchElementException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (NotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (WebDriverException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally{
			takeSnap();
		}
		System.out.println("The text field "+nameValue+" is entered with data: "+data);

	}

	public void enterByXpath(String xpathValue, String data) {
		try {
			driver.findElementByXPath(xpathValue).clear();
			driver.findElementByXPath(xpathValue).sendKeys(data);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (NotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (WebDriverException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally{
			takeSnap();
		}
		System.out.println("The text field "+xpathValue+" is entered with data: "+data);

	}

	public boolean verifyTitle(String title) {
		boolean bReturn = false;
		try {
			if(driver.getTitle().equals(title)){
				bReturn = true;
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (NotFoundException e) {
			e.printStackTrace();
		} catch (WebDriverException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			takeSnap();
		}
		return bReturn;
	}

	public void verifyTextById(String id, String text) {
		try {
			String textValueById = driver.findElementById(id).getText();
			if(textValueById.equalsIgnoreCase(text)){
				System.out.println("The text "+text+" matches searched by id:" +id);
			}
			else{
				System.out.println("The text "+text+" does not match searched by id:" +id);
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (NotFoundException e) {
			e.printStackTrace();
		} catch (WebDriverException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			takeSnap();
		}
	}

	public void verifyTextByLink(String name, String text) {
		try {
			String textValueByName = driver.findElementById(name).getText();
			if(textValueByName.equalsIgnoreCase(text)){
				System.out.println("The text "+text+" matches searched by id:" +name);
			}
			else{
				System.out.println("The text "+text+" does not match searched by id:" +name);
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (NotFoundException e) {
			e.printStackTrace();
		} catch (WebDriverException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			takeSnap();
		}
	}

	public void verifyTextByXpath(String xpath, String text) {
		try {
			String textValueByxpath = driver.findElementByXPath(xpath).getText();
			if(textValueByxpath.equalsIgnoreCase(text)){
				System.out.println("The text "+text+" matches searched by xpath:" +xpath);
			}
			else{
				System.out.println("The text "+text+" does not match searched by xpath:" +xpath);
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (NotFoundException e) {
			e.printStackTrace();
		} catch (WebDriverException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			takeSnap();
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
		} catch (NotFoundException e) {
			e.printStackTrace();
		} catch (WebDriverException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			takeSnap();
		}
	}

	public void clickById(String id) {
		try {
			driver.findElementByClassName(id).click();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (NotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (WebDriverException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally{
			takeSnap();
		}
		System.out.println("The button "+id+" is clicked");

	}

	public void clickByClassName(String classVal) {
		try {
			driver.findElementByClassName(classVal).click();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (NotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (WebDriverException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally{
			takeSnap();
		}
		System.out.println("The button "+classVal+" is clicked");
	}

	public void clickByName(String name) {
		try {
			driver.findElementByClassName(name).click();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (NotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (WebDriverException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally{
			takeSnap();
		}
		System.out.println("The button "+name+" is clicked");

	}

	public void clickByLink(String name) {
		try {
			driver.findElementByLinkText(name).click();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (NotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (WebDriverException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally{
			takeSnap();
		}
		System.out.println("Clicked on the " + name + " Successfully");

	}

	public void clickByLinkNoSnap(String name) {
		try {
			driver.findElementByLinkText(name).click();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (NotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (WebDriverException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		} 
		//takeSnap();
		System.out.println("Clicked on the " + name + " Successfully");

	}

	public void clickByXpath(String xpathVal) {
		try {
			driver.findElementByXPath(xpathVal).click();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (NotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (WebDriverException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally{
			takeSnap();
		}
		System.out.println("Clicked on the " + xpathVal + " Successfully");

	}

	public void clickByXpathNoSnap(String xpathVal) {
		try {
			driver.findElementByXPath(xpathVal).click();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (NotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (WebDriverException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		} 
		//takeSnap();
		System.out.println("Clicked on the " + xpathVal + " Successfully");

	}

	public String getTextById(String idVal) {
		String textById;
		try {
			textById = driver.findElementById(idVal).getText();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (NotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (WebDriverException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally{
			takeSnap();
		}
		System.out.println("Get Text by using id "+idVal+" completed  Successfully" );
		return textById;
	}

	public String getTextByXpath(String xpathVal) {
		String textByxpath;
		try {
			textByxpath = driver.findElementByXPath(xpathVal).getText();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (NotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (WebDriverException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally{
			takeSnap();
		}
		System.out.println("Get Text by using xpath "+xpathVal+" completed  Successfully" );
		return textByxpath;
	}

	public void selectVisibileTextById(String id, String value) {
		try {
			WebElement dropDown = driver.findElementById(id);
			Select dDown = new Select(dropDown);
			dDown.selectByVisibleText(value);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (NotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (WebDriverException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally{
			takeSnap();
		}
		System.out.println("The dropdown " + value + " is selected using id: " + id);

	}

	public void selectIndexById(String id, int value) {
		try {
			WebElement dropDown = driver.findElementById(id);
			Select dDown = new Select(dropDown);
			dDown.selectByIndex(value);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (NotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (WebDriverException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally{
			takeSnap();
		}
		System.out.println("The dropdown " + value + " is selected using id: " + id);

	}

	public void switchToParentWindow() {
		try {
			Set<String> allWindow = driver.getWindowHandles();
			System.out.println("Number of Windows: "+ allWindow.size());		
			//System.out.println("Title of Current (Parent) Window: " + driver.getTitle());	
			int i=1;
			for (String eachWindow : allWindow) {			
				driver.switchTo().window(eachWindow);
				if(i==1){
					break;
				}
				i++;			
			}
		} catch (NoSuchWindowException e) {

			e.printStackTrace();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (NotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (WebDriverException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally{
			takeSnap();
		}		
		System.out.println("Title of Parent/First Window: " + driver.getTitle());
		//Or this can be written by just getting the handle of First Window and saving in a string variable
		//Then call the string variable when we need to switch to the First Window
	}

	public void switchToLastWindow() {
		try {
			Set<String> allWindow = driver.getWindowHandles();		
			System.out.println("Number of Windows: "+ allWindow.size());		
			System.out.println("Title of Current (Parent) Window: " + driver.getTitle());	
			for (String eachWindow : allWindow) {		
				System.out.println("Inside Loop - Title of Current Window: " + driver.getTitle());
				driver.switchTo().window(eachWindow);
			}
		} catch (NoSuchWindowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (NotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (WebDriverException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally{
			takeSnap();
		}		
		System.out.println("Title of Last Window: " + driver.getTitle());
	}

	public void acceptAlert() {
		try {
			driver.switchTo().alert().accept();
		} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (NotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (WebDriverException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		} 	
	}

	public void dismissAlert() {
		try {
			driver.switchTo().alert().dismiss();
		} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (NotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (WebDriverException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		} 	
	}

	public String getAlertText() {
		String alertText = "null";
		try {
			Alert handleAlert = driver.switchTo().alert();
			alertText = handleAlert.getText();
		} catch (NoAlertPresentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (NotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (WebDriverException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
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
		} catch (WebDriverException e) {
			e.printStackTrace();
			System.out.println("Exception Occured in Closing Browser");
		}
		System.out.println("The Browser is closed  Successfully");

	}

	public void closeAllBrowsers() {
		try {
			driver.quit();
		} catch (WebDriverException e) {
			e.printStackTrace();
			System.out.println("Exception Occured in Closing All Browsers");
		}
		System.out.println("The Browser is closed  Successfully");

	}

}
