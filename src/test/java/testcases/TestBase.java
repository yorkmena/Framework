package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import dataProvider.configDataProvider;
import pages.IndexPage;
import pages.MobilePage;

public class TestBase {
	
	configDataProvider Config=new configDataProvider();
	WebDriver driver;
	ExtentReports report; 
	ExtentTest logger;
	//IndexPage Index =PageFactory.initElements(driver, IndexPage.class);
    //MobilePage Mobile=PageFactory.initElements(driver, MobilePage.class);
}
