package testcases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import Factory.BrowserFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import dataProvider.ExcelDataProvider;
import dataProvider.configDataProvider;
import pages.IndexPage;
import pages.MobilePage;
import utility.CaptureScreenshots;

public class TestBase {
	
	configDataProvider Config=new configDataProvider();
	ExcelDataProvider excel=new ExcelDataProvider();
	WebDriver d;
	ExtentReports report;
	ExtentTest logger;
	
	Logger log=Logger.getLogger(TestBase.class.getClass().getName());
	
	
	//IndexPage Index =PageFactory.initElements(driver, IndexPage.class);
    //MobilePage Mobile=PageFactory.initElements(driver, MobilePage.class);
	
	
	@BeforeTest
	public void setup()
	{
		// For Extent Reporting
	    report=new ExtentReports(".\\Reports\\HomePageReport.html",true);
		logger=report.startTest("Login Test Logs");
		d=BrowserFactory.getBrowser(Config.getvalue("Browser"));
		logger.log(LogStatus.INFO, "Browser Started");
		d.get(Config.getUrl1());
	    logger.log(LogStatus.INFO, "Webpage Open");
	    
	    //log4j Property Configurator
	   System.out.println(System.getProperty("user.dir"));
	    //PropertyConfigurator.configure(System.getProperty("user.dir")+"/Configuration/log4j.properties");
	   PropertyConfigurator.configure(System.getProperty("user.dir")+"\\Configutation\\log4j.properties");
	}
	
	@AfterMethod
	public void teardownMethod(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String path= CaptureScreenshots.captureScreenshoot(d, result.getName());
			logger.log(LogStatus.FAIL,result.getName(), logger.addScreenCapture(path));
			
		}
	}
	@AfterTest
	public void teardownTest()
	{
		report.endTest(logger);
		report.flush();
		d.quit();
		d.close();
	} 
	
}
