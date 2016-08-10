package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage {
	
	@FindBy(xpath="//*[@id='nav']/ol/li[1]/a")
	WebElement mobile;
	
	public static void click(WebElement ele)
	{
		ele.click();
	}
	
	public void clickOnMobile()
	{
		mobile.click();
	}
	
	
	
	

}
