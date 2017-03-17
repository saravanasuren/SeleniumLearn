package weeklyHomeWork;

import java.util.Set;
import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultiplePopUps{

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/ChromeDriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://popuptest.com/");
		String FirstWindow = driver.getWindowHandle();
		System.out.println(FirstWindow);
		driver.findElementByLinkText("Multi-PopUp Test #2").click();
		Thread.sleep(3000);
		driver.findElementByXPath("/html/body/table[2]/tbody/tr/td/form/input").click();
		Set<String> AllWindows = driver.getWindowHandles();
		System.out.println("Window Size of all windows: " + AllWindows.size());
		for (String loopWindows : AllWindows) {
			System.out.println(loopWindows);
			if(FirstWindow.equals(loopWindows)){
				driver.switchTo().window(loopWindows);
				//System.out.println(loopWindows);
			}
			else if(!FirstWindow.equals(loopWindows)) {				
				driver.switchTo().window(loopWindows);
				driver.close();
			}
		}		
		AllWindows = driver.getWindowHandles();
		System.out.println(AllWindows.size());
		int i = 1;
		for (String loopWindows1 : AllWindows) {
			System.out.println(loopWindows1 + " " + i);
			if(i == 1){
			driver.switchTo().window(loopWindows1);
			System.out.println(driver.getTitle());
			}
			else{
				driver.switchTo().window(loopWindows1);
				driver.close();
			}
			i++;
		}		
		driver.quit();
		System.out.println("Test Completed Succesfully");
	}
}
