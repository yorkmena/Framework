package testcases;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class cookies {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "D:\\GeckoDriver\\geckodriver-v0.11.1-win32\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		
		driver.get("https://phptravels.org/clientarea.php");
		driver.findElement(By.id("inputEmail")).sendKeys("hello@gmail.com");
		//driver.findElement(By.id("next")).click();
		System.out.println("Enter Password");
		//Thread.sleep(5000);
		driver.findElement(By.id("inputPassword")).sendKeys("test@123");
		driver.findElement(By.id("login")).click();
		System.out.println("Login SUccessfull");
		Thread.sleep(10000);
		/*System.out.println("cookie Name:- "+driver.manage().getCookies());
		Cookie cookieDetails=(Cookie) driver.manage().getCookies();
		
		System.out.println("parsed Cookie"+cookieDetails);
		Thread.sleep(3000);
		driver.close();
		driver.manage().addCookie(cookieDetails);
		driver.get("https://www.gmail.com");*/
		
		/* Try the same for Gmail Now */
		
		/*driver.get("https://www.gmail.com");
		driver.findElement(By.id("Email")).sendKeys("narang.vikas@thinksys.com");
		driver.findElement(By.id("next")).click();
		System.out.println("Enter Password");
		Thread.sleep(5000);
		driver.findElement(By.id("Passwd")).sendKeys("");
		driver.findElement(By.id("signIn")).click();
		System.out.println("Login SUccessfull");
		Thread.sleep(25000);*/
		
		
		Set<Cookie> cookies = driver.manage().getCookies();
		System.out.println(cookies);
		
		/*
		Iterator<Cookie> itr=cookies.iterator();
		
		 while (itr.hasNext()){
			 
			 Cookie c = itr.next();
			 
			 
		 }*/
		 
		
		driver.close();
		
		System.out.println("Second session");
		
		//Starting new browser 
		driver = new FirefoxDriver();
		/*for(Cookie cookie : cookies)
		{
		    driver.manage().addCookie(cookie);
		}
		//driver.manage().window().maximize();
		System.out.println("here are we");
		driver.get("https://www.gmail.com");*/
		
		driver.get("https://phptravels.org/clientarea.php");
		//driver.get("https://www.gmail.com");
		
		Iterator<Cookie>itr = cookies.iterator();

	    while (itr.hasNext()){
	    Cookie c = itr.next();
	    System.out.println("Cookie Name: " + c.getName() + " --- " + "Cookie Domain: " + c.getDomain() + " --- " + "Cookie Value: " + c.getValue());
	    driver.manage().addCookie(c);
		System.out.println("cookie added successfully");
	    driver.get("https://phptravels.org/clientarea.php");
	   // driver.get("https://www.gmail.com");
		Thread.sleep(20000);
		System.out.println("Reached at the end");
		//driver.quit();
		
		
		//driver.manage().getCookies();
	    }
		
		

	}

}
