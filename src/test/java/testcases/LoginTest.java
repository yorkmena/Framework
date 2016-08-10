package testcases;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Factory.BrowserFactory;
import pages.IndexPage;
import pages.MobilePage;
import utility.CaptureScreenshots;

public class LoginTest extends TestBase{
	
	@BeforeTest
	public void setup()
	{
		report=new ExtentReports(".\\Reports\\HomePageReport.html",true);
	    logger=report.startTest("Login Test Logs");
		driver=BrowserFactory.getBrowser(Config.getvalue("Browser"));
		logger.log(LogStatus.INFO, "Browser Started");
		driver.get(Config.getUrl());
	    logger.log(LogStatus.INFO, "Webpage Open");
	}
	
	@Test(testName="login")
	public void VerifyTitle() throws Exception
	{
		IndexPage Index1=PageFactory.initElements(driver, IndexPage.class);	
		Index1.clickOnMobile();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertEquals(driver.getTitle(),"Mobile");
		logger.log(LogStatus.PASS, "Title Verified");
		
	}
	@Test(priority=1)
	public void VefifySorting()
	{
		MobilePage Mobile =PageFactory.initElements(driver, MobilePage.class);
		Mobile.SortBy("name");
		List<WebElement> order=driver.findElements(By.cssSelector(".product-image>img"));
		List<String>OrderName=new LinkedList<String>();
		for(WebElement ele : order)
		{
			ele.getAttribute("alt");
			OrderName.add(ele.getAttribute("alt"));
		}
		String pre="";
		Boolean b=true;
		int i;
		for(String str:OrderName)
		{ 
			if (pre.compareTo(str)>0)
			{
				i=pre.compareTo(str);
				System.out.println(pre+"------"+str+"------"+i);
			    b=false;
			}
		pre=str;
		}
		Assert.assertTrue(b);
		String path=CaptureScreenshots.captureScreenshoot(driver,"Sorting test" );
		logger.log(LogStatus.PASS, "Sortby Name Verified",logger.addScreenCapture(path));
	}
	@AfterMethod
	public void teardownMethod(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String path= CaptureScreenshots.captureScreenshoot(driver, result.getName());
			logger.log(LogStatus.FAIL,result.getName(), logger.addScreenCapture(path));
			
		}
	}
	@AfterTest
	public void teardownTest()
	{
		report.endTest(logger);report.flush();
		driver.quit();
	} 
}
