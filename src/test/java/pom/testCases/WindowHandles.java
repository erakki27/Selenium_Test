package pom.testCases;

import java.util.Set;

import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandles {
	
	public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	
	  driver.manage().window().maximize();
	
	driver.get("https://demoqa.com/browser-windows");
	driver.findElement(By.id("windowButton")).click();
	
	String currentwindow = driver.getWindowHandle();
	
	Set<String> s =driver.getWindowHandles();
	
	Iterator<String> li = s.iterator();
	
	while(li.hasNext()) {
		String childwindow = li.next();
		if(!currentwindow.equals(childwindow)) {
			driver.switchTo().window(childwindow);
			
		String childwindowtitle=	driver.switchTo().window(childwindow).getTitle();
		System.out.println(childwindowtitle);
		
		driver.close();
			
		}
		
		
		
	}
    driver.switchTo().window(currentwindow);
	}
}
