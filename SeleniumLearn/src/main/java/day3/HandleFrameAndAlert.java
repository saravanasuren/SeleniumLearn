package day3;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFrameAndAlert {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/ChromeDriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
		
		driver.switchTo().frame("iframeResult");
		
		driver.findElement(By.xpath("/html/body/button")).click();
		
		Alert HandleAlert = driver.switchTo().alert();
		
		HandleAlert.sendKeys("Kiran Bedi");
		HandleAlert.accept();
		
		String Resultname = driver.findElement(By.id("demo")).getText();

		
	   if( Resultname.contains("Kiran Bedi"))
	   {
		   System.out.println("Name is Correct");
	   }
	   else{
		   System.out.println("False");
	   }
		   
		
/*		if(Resultname.equalsIgnoreCase("Kiran Bedi")){
			System.out.println("The Name Matches");
		}
		else{
			System.out.println("Name does not match");
		}*/
		
	}

}
