package pom.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{
	
	@Test
	public void loginTest() throws InterruptedException, IOException
	{
		driver.get(BaseUrl);
		Logger.info("Url is Openened");
		
		LoginPage lp = new LoginPage(driver);
		
		
		
		lp.setUserName(username);
		Logger.info("UserName Passed");
			
		
		lp.setPassword(password);
		Logger.info("Password Passed");
		
		lp.loginClick();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			Logger.info("Test Passed");
			
		}else {
			
			captureScreenshot(driver,"TC_LoginTest_001");
			Assert.assertTrue(false);
			Logger.info("Test Failed");
		}
	}

}
