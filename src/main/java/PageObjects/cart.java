package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Resources.base;

public class cart extends base
{
	By cartIcon = By.xpath("//div[@class='header-top-section']/div[2]/div[3]/div[2]/a/div");
	
	
	
	
	public cart(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		
		this.driver = driver;
		//PAGE FACTORY
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getCartIcon()
	{
		return driver.findElement(cartIcon);
	}
	
	
	/*
	public List<WebElement> getSectionText()
	{
		 return driver.findElements(sectionText);
	}
	public WebElement getColorSection()
	{
		 return driver.findElement(colorSection);
	}
	*/


}
