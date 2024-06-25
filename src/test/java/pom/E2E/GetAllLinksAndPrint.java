package pom.E2E;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAllLinksAndPrint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		  driver.manage().window().maximize();
		  
		  driver.get("https://www.amazon.in/");
		  
			/*
			 * List<WebElement> el = driver.findElements(By.tagName("a"));
			 * 
			 * for(WebElement ln : el) { System.out.println(ln.getText());
			 * 
			 * }
			 */
		WebElement  w = driver.findElement(By.xpath("//*a[contains(text(),'Career')]/parent::div"));
		
		WebElement p = w.findElement(By.xpath("parent::*"));
		System.out.println(w.getText()); 
		System.out.println(p.getTagName());
		  
		  driver.quit();
		  
		  
	}
	
	

}
