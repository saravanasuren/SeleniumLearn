package day3;

import java.util.Set;

import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {

	public static void main(String[] args) {
		//Initialize Driver
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				ChromeDriver driver = new ChromeDriver();
				//Launch URL
				driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
				//Click on Contact Us
				driver.findElementByLinkText("Contact Us").click();
				// get window handles
				Set<String> allWindows = driver.getWindowHandles();
				System.out.println(allWindows.size());
				System.out.println(driver.getTitle());
				int i = 1;
				System.out.println("+======Inside Loop======+");
				for (String activeWindow : allWindows) {
					driver.switchTo().window(activeWindow);
					if(i == 2){
					System.out.println(driver.getTitle());
					break;
					}
					i++;					
				}
				driver.quit();
	}

}
