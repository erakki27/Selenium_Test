package com.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter
{
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	String repName;
	
	public void onStart(ITestContext testContext)
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repName = "Test-Report-"+timeStamp +".html";
		
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/" +repName);
		/*try {
			sparkReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		sparkReporter.config().setDocumentTitle("SeleniumLearning");
		sparkReporter.config().setReportName("Mini Demo");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "User API");
		extent.setSystemInfo("OS", System.getProperty("os.name"));
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Env", "QA");
		extent.setSystemInfo("tester", "AK");
	}
	
	public void onTestSuccess(ITestResult result)
	{
		test = extent.createTest(result.getName());
		test.createNode(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel(result.getName(),ExtentColor.GREEN));
	}
	
	public void onTestFailure(ITestResult result)
	{
		test = extent.createTest(result.getName());
		test.createNode(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(),ExtentColor.RED));
		String screenshotPath = System.getProperty("user.dir")+"//Screenshots//" +result.getName()+".png";
		File f = new File(screenshotPath);
		
		if(f.exists()) {
			try {
				test.fail("Screenshot is below" + test.addScreenCaptureFromPath(screenshotPath));
			}
			catch(Exception e) {
				
			}
		}
		
	}
	public void onTestSkipped(ITestResult result)
	{
		test = extent.createTest(result.getName());
		test.createNode(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel(result.getName(),ExtentColor.ORANGE));
	}
    public void onFinish(ITestContext testContext)
    {
    	extent.flush();
    }
}

