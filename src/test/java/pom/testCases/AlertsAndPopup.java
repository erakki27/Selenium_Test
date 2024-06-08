package pom.testCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsAndPopup {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		  driver.manage().window().maximize();
		  
			/*
			 * driver.get("https://demoqa.com/alerts");
			 * driver.findElement(By.xpath("//*[@id=\"confirmButton\"]")).click();
			 * 
			 * Thread.sleep(5000);
			 * 
			 * Alert al= driver.switchTo().alert();
			 * 
			 * String text=driver.switchTo().alert().getText();
			 * 
			 * System.out.println(text);
			 * 
			 * al.accept(); driver.close();
			 * 
			 * //frame driver.get("https://demoqa.com/frames");
			 * driver.switchTo().frame("IF1"); driver.switchTo().defaultContent();
			 */
		 
		 //file upload using send keys
		 
		 driver.get("https://www.google.com/intl/en-US/gmail/about/");
		 driver.findElement(By.linkText("Sign in")).click();
		 
		 driver.findElement(By.id("identifierId")).sendKeys("erakki27@gmail.com");
		 
		 driver.findElement(By.xpath("//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc LQeN7 BqKGqe Jskylb TrZEUc lw1w4b']")).click();
		 driver.findElement(By.xpath("//input[@name='Passwd']")).sendKeys("Shutup@27a");
		 
		 driver.findElement(By.xpath("(//div[@class='VfPpkd-RLmnJb'])[2]")).click();
		 
		 
		 
	}

}
