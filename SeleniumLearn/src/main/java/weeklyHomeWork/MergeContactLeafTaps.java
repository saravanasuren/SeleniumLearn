package weeklyHomeWork;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class MergeContactLeafTaps {

	public static void main(String[] args) throws InterruptedException {
		//Initialize WebDriver
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//Launch URL
		driver.get("http://leaftaps.com");
		//Maximize
		driver.manage().window().maximize();	
		//Implicitly Wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Enter User Name
		driver.findElementById("username").sendKeys("DemoSalesManager");
		//Enter Password
		driver.findElementById("password").sendKeys("crmsfa");
		//Click Submit
		driver.findElementByClassName("decorativeSubmit").click();
		//Click CRM/SFA
		driver.findElementByLinkText("CRM/SFA").click();
		//Click Leads link
		driver.findElementByLinkText("Leads").click();
		//Click Merge leads
		driver.findElementByLinkText("Merge Leads").click();
		String firstWindow = driver.getWindowHandle();
		//Click on Icon near From Lead - To Select Frm Lead
		driver.findElementByXPath("(//img[@alt='Lookup'])[1]").click();
		//Switch to New Window
		Set<String> windowshandle = driver.getWindowHandles();
		System.out.println(windowshandle.size());
		int i = 1;
		//for Each to loop between open windows
		for (String nextWindow : windowshandle) {
			driver.switchTo().window(nextWindow);
			System.out.println(driver.getTitle());
			//go to 2nd window and perform actions
			if(i==2){
				System.out.println("Inside Loop --->"+driver.getTitle());
				driver.findElementByXPath("//label[contains(text(),'Lead ID:')]/following::input").sendKeys("22525");
				driver.findElementByXPath("//button[contains(text(),'Find Leads')]").click();
				driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a").click();
				Thread.sleep(5000);
				break;
			}
			i++;
		}
		//Switch to First Window
		driver.switchTo().window(firstWindow);
		System.out.println(driver.getTitle());
		//Click on Icon near To Lead - To Select Frm Lead
		
		
		
		
		
		
		
		
		//driver.quit();
		System.out.println("Test Completed Success");
	}

}
