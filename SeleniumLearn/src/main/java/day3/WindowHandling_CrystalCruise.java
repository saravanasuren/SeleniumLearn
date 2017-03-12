package day3;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling_CrystalCruise {

	public static void main(String[] args) {
		//Initialize Driver
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				ChromeDriver driver = new ChromeDriver();
				//Launch URL
				driver.get("http://legacy.crystalcruises.com/");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				//Click on Guest Check IN
				driver.findElementByLinkText("GUEST CHECK-IN").click();
				//Click on Click Here
				driver.findElementByLinkText("click here").click(); // This is failing here - Please check when free.
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
