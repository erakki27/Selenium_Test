package pom.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.Test;

import com.pageObjects.LoginPage;
import com.utilities.DataProviders;

public class TC_LoginDDT extends BaseClass 

{
	@Test(priority=1, dataProvider ="Data",dataProviderClass = DataProviders.class)
     public void loginDDT(String user, String pwd) throws InterruptedException, IOException
     {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		Logger.info("User name provided");
		lp.setPassword(pwd);
		Logger.info("Password name provided");
		lp.loginClick();
		Thread.sleep(3000);
		
		if(isAlertsPresent() == true) {

			
			driver.switchTo().alert().accept(); //close alert
			captureScreenshot(driver,"TC_LoginDDT");
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			Logger.warn("Login failed");
		
			
		}else
		{
			Assert.assertTrue(true);
			Logger.info("Login Passed");
			Thread.sleep(3000);
			lp.linklogout();
			driver.switchTo().alert().accept();  //logout alert

		}
			
     }
	
	public boolean isAlertsPresent()
	{
		try {
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	}
	
}
