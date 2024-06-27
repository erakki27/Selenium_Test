package pom.testCases;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;

import com.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();
	
	public String BaseUrl = readconfig.getApplicationUrl();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();
	public String MyntraUrl = readconfig.getApplicationUrl1();
	public static WebDriver driver;
	public static Logger Logger;
	
	@BeforeClass
	public void setup() {
		//System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
		
		// added
		
		ChromeOptions opt = new ChromeOptions();
		//opt.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe"); 
		opt.addArguments("--no-sandbox");
		opt.addArguments("--disable-dev-shm-usage");
		//opt.addArguments("--headless");
		//chrome binary location specified here
		 driver = new ChromeDriver(opt);
		
		 
		    //original
				//driver = new ChromeDriver();
				Logger = Logger.getLogger("Demo");
				PropertyConfigurator.configure("log4j.properties");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(BaseUrl);
		driver.get(MyntraUrl);
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
