package pom.testCases;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;

import com.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();
	
	public String BaseUrl = readconfig.getApplicationUrl();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();
	public static WebDriver driver;
	public static Logger Logger;
	
	@SuppressWarnings("static-access")
	@BeforeClass
	public void setup() {
		//System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
		 ChromeOptions chromeOptions = new ChromeOptions();
		 chromeOptions.setCapability("platformName", "Windows 10");
		 
		 chromeOptions.addArguments("--remote-allow-origins=*");
		 
		 WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();
		    
		
		Logger = Logger.getLogger("Demo");
		PropertyConfigurator.configure("log4j.properties");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(BaseUrl);
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}


	public void captureScreenshot(WebDriver drive, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"\\Screenshots\\" +tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot is taken");
		
	}

}
