package pom.E2E;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Accuweather {

	public static void main(String[] args) {
WebDriver driver = new ChromeDriver();
		
		/*driver.get("https://www.accuweather.com/");
		
		
		WebElement table = driver.findElement(By.xpath("//span[contains(text(),'Lucknow')]/ancestor::a"));
	System.out.println(table.getText());*/
	
	
	/* driver.get("https://weather.com/en-IN/weather/tenday/l/cf7a2c7494189a64dfab3e18f5fbf920c6594a022a5bbd7b1ceb6cf85e2a76d8");
	
	
	WebElement we = driver.findElement(By.id("detailIndex14"));
System.out.println(we.getText());
	
	driver.quit();*/
		
		
	driver.get("https://www.amazon.in/");
	
	System.out.println(driver.findElement(By.xpath("//a[contains(text(),\"Today's Deals\")]")).getText());
	
	driver.quit();

	}

}
