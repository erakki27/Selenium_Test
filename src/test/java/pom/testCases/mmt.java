package pom.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class mmt {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://makemytrip.com");
		driver.findElement(By.className("commonModal__close")).click();
		//Thread.sleep(2000);
		 WebElement from = driver.findElement(By.id("fromCity"));
		
		from.click();
		from.sendKeys("Jaipur");
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("react-autowhatever-1-section-0-item-0")).click();
		
		Thread.sleep(2000);
		
		
		
		driver.close();
	}

}
