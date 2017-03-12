package day3;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWindowsCruiseExample {
	public static void main(String[] args) throws InterruptedException {
		//Initialize the Driver path
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		//Launch/Initialize Browser
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Maximize the browser
		driver.manage().window().maximize();
		//Launch the URL
		driver.get("http://legacy.crystalcruises.com/");
		// click link
		driver.findElementByLinkText("GUEST CHECK-IN").click();
		
		Set<String> allWindow = driver.getWindowHandles();
		
		System.out.println(allWindow.size());
		
		System.out.println(driver.getTitle());
		
		for (String eachWindow : allWindow) {
			
			System.out.println(eachWindow);	
			
			driver.switchTo().window(eachWindow);
			
			
		}		
		System.out.println(driver.getTitle());
		
		driver.findElementByLinkText("click here").click();
		
		System.out.println(allWindow.size());
		
		allWindow = driver.getWindowHandles();
		
		System.out.println(allWindow.size());
		
		System.out.println(driver.getTitle());
	
		int i=1;
		for (String eachWindow : allWindow) {
			
			System.out.println(eachWindow);	
			
			driver.switchTo().window(eachWindow);
			if(i==1){
				break;
			}
			i++;
			
		}		
		System.out.println(driver.getTitle());
	}
}