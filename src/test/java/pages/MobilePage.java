package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class MobilePage {
	
	@FindBy(css="select[title='Sort By']")
	WebElement Dropdown;
	
	@FindBy(css=".product-image>img")
	List<WebElement> order;
	
	
	public void SortBy(String value)
	{
		Select select=new Select(Dropdown);
		
		if (value.equalsIgnoreCase("name"))
		{
		select.selectByVisibleText("Name");
		}
		if (value.equalsIgnoreCase("position"))
		{
		select.selectByVisibleText("Position");
		}
		if (value.equalsIgnoreCase("Price"))
		{
		select.selectByVisibleText("Price");
		}
		
	}
	

}
