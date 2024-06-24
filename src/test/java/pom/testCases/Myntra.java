package pom.testCases;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;

public class Myntra {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		  driver.manage().window().maximize();
		  
		  //open myntra website
		  
		  driver.get("https://www.myntra.com/");
		  
		  
		//hover on women menu
			 
			 WebElement hove = driver.findElement(By.xpath("//a[contains(text(),'Women')]"));
			 Actions action = new Actions(driver);
			 action.moveToElement(hove).build().perform();
		  
		  //click on dresses
		  
		  driver.findElement(By.xpath("//a[contains(text(),'Dresses')]")).click();
		  
		  //select jumpsuit type
		  
		
		 driver.findElement(By.xpath("//div[@class='vertical-filters-filters categories-container']/ul/li/label[contains(text(),'Jumpsuit')]")).click();
		  
		  Thread.sleep(3000);
		  
		  //select color
		  
		  driver.findElement(By.cssSelector("span[data-colorhex='black']")).click();
		  Thread.sleep(3000);
		  
		  //select brand
		  
		  driver.findElement(By.xpath("//div[@class='vertical-filters-filters brand-container']/ul/li/label[contains(text(),'KASSUALLY')]")).click();
		  Thread.sleep(2000);
		  
		  //select product
		  
		  driver.findElement(By.xpath("(//div[@class='product-productMetaInfo'])[3]")).click();
		  Thread.sleep(3000);
		  
		  String currentwindow = driver.getWindowHandle();
			
			Set<String> s =driver.getWindowHandles();
			
			Iterator<String> li = s.iterator();
			
			while(li.hasNext()) {
				String childwindow = li.next();
				if(!currentwindow.equals(childwindow)) {
					driver.switchTo().window(childwindow);
					
				String childwindowtitle=	driver.switchTo().window(childwindow).getTitle();
				System.out.println(childwindowtitle);
				
				}
			}
				
			/*
			 * //hover profile for login
			 * 
			 * WebElement hove = driver.findElement(By.className("desktop-userTitle"));
			 * Actions action = new Actions(driver);
			 * action.moveToElement(hove).build().perform();
			 * 
			 * //login
			 * driver.findElement(By.xpath("//a[contains(text(),'login')]")).click();
			 */
		  
		  driver.quit();
		  
	}

}
