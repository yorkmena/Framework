package testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.apache.commons.lang3.RandomStringUtils;

public class Registration extends TestBase {
	
	
	public static void main(String args[])
{
			
	for(int i=0; i<=10; i++)
		
	{
		System.out.println(RandomEmail());
		
	}
	
}
	
	
	
	public static String RandomEmail()
	{
		String  Email;
		
	    System.out.println();	
	
		Email="rohit"+"_"+RandomStringUtils.randomAlphabetic(8)+"@gmail.com";
		
		return Email;
	}
	
	
	/*public void Register()
	{
		d.findElement(By.id("userName")).sendKeys("");
	}*/
	
	
}
