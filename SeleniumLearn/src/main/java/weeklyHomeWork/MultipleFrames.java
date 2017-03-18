package weeklyHomeWork;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleFrames {

	public static void main(String[] args) {	
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("http://layout.jquery-dev.com/demos/iframes_many.html");
		List<WebElement> iframecount = driver.findElementsByTagName("iframe");
		int noOfFrames = iframecount.size();
		int noOfNestedFrame = 0;
		int CountOfNestedFrame = 0;
		System.out.println(noOfFrames);
		for (int i = 0;i<noOfFrames;i++){
			System.out.println(driver.findElementByTagName("iframe").getTagName() + " " + i);
			driver.switchTo().frame(i);
			List <WebElement> nestedframe = driver.findElementsByTagName("iframe");
			noOfNestedFrame=nestedframe.size();
			if(noOfNestedFrame>0)
			{
				CountOfNestedFrame = CountOfNestedFrame+noOfNestedFrame;
				
			}
			System.out.println(noOfNestedFrame);
			//Switch to parent Frame so it can go and find the next frame 
			//else it will try to find a nested frame inside the inner frame instead of searching from outer frame
			driver.switchTo().defaultContent(); 
		}
		
		System.out.println("Total Number of Frames: "+ (CountOfNestedFrame+noOfFrames));
		driver.quit();
	}

}
