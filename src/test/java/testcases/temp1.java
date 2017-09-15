package testcases;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;



public class temp1  {
	

	public static void main(String args[]) throws InterruptedException, IOException
	
	{
	
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\thinksysuser\\Desktop\\SeleniumJar\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("load-extension=C:\\Users\\thinksysuser\\AppData\\Roaming\\Skype\\My Skype Received Files\\Chrome_Staging_31_08_2017_10_53AM\\Chrome_Staging_31_08_2017_10_53AM");
		driver = new ChromeDriver(options);
		driver.get("https://www.gmail.com");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//input[@class='whsOnd zHQkBf']")).sendKeys("zyntek8@gmail.com");
		driver.findElement(By.xpath("//span[@class='RveJvd snByac']")).click();

		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("salesforce@123");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@class='RveJvd snByac']")).click();
		Thread.sleep(9000);

		List<WebElement> tabs = driver.findElements(By.xpath("//td[@tabindex='-1']"));
		

		if(tabs.size()>2)
		{
			tabs.get(3).click();
		}
		else
		{
			System.out.println("no emails present");
			driver.quit();
		}

		Thread.sleep(16000);
		
		driver.findElement(By.xpath("//img[@src='chrome-extension://jehjlpjhciomhlifnmlpfnkanhncpfgi/img/ZynBit-YinYang-WHITEX24.png']")).click();
		Thread.sleep(9000);
		
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//WebElement Iframes= (WebElement) js.executeScript("document.getElementsByClassName('zb-frame zb-ext-width');");
		driver.switchTo().defaultContent();
		//System.out.println("Located");
		WebElement Iframes=driver.findElement(By.cssSelector("iframe.zb-frame.zb-ext-width"));
		driver.switchTo().frame(Iframes);
		String extension_Url=Iframes.getAttribute("src");
		System.out.println(extension_Url);
		driver.get(extension_Url);
		
	    //chrome-extension://jehjlpjhciomhlifnmlpfnkanhncpfgi/start/frame.html?id=17f348f9-225a-4dc7-8586-c81eece5a508&amp;height=157&amp;p=GMAIL&amp;m=inbox
		//chrome-extension://knfmbndboiakeimpiipbmopibkadcilh/start/frame.html?id=8c8b0038-7ee4-4cb4-a6a8-f207f89dc81f&amp;height=271&amp;p=GMAIL&amp;m=inbox#parent=https%3A%2F%2Fmail.google.com&amp;rpctoken=1980551215
		//System.out.println("LIST KA SIZE: "+Iframes.size());	
		
		
		WebElement Iframes1=driver.findElement(By.id("zb-ext-frame"));
		String extension_Url1=Iframes1.getAttribute("src");
		System.out.println(extension_Url1);
		driver.get(extension_Url1);
		
		//driver.findElement(By.cssSelector("div.col-xs-4.zyn-pad-none'] >a[title='Sign in with Google']")).click();
		Thread.sleep(9000);
		//driver.findElement(By.xpath("*[@id='zyn-connections']/div[3]/div[2]/div[1]/div[2]/a[2]/img")).click();
	List<WebElement> g=driver.findElements(By.className("zyn-btn-sm-signin "));
	g.get(1).click();
		
		//tr:nth-child(1)
		//driver.switchTo().frame(Iframes);
		System.out.println("Switched");
		
		Thread.sleep(4000);
		//driver.close();
		
}
}