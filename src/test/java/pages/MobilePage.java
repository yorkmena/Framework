package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class MobilePage {
	
	@FindBy(css="select[title='Sort By']")
	WebElement Dropdown;
	
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
