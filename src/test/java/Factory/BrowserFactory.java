package Factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import dataProvider.configDataProvider;

public class BrowserFactory {
	
	static WebDriver d;
	
	public  static WebDriver getBrowser(String Browser)
	{
		if (Browser.equalsIgnoreCase("firefox"))
		{
			d=new FirefoxDriver();
		}
		
		if (Browser.equalsIgnoreCase("chrome"))
		{
			configDataProvider configData=new configDataProvider();
			System.setProperty("webdriver.chrome.driver", configData.getchromePath());
			d=new ChromeDriver();
		}
		
		if(Browser.equalsIgnoreCase("IE"))
		{
			configDataProvider configData=new configDataProvider();
		    System.setProperty("webDriver.ie.driver", configData.getIEPath());
		    d=new InternetExplorerDriver();
		}
		
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return d;	
	}	
	public void closeBrowser()
	{
	d.quit();
	}
}
