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
	By listOfItems = By.xpath("//div[@class='bag-left-section']/div/div[3]/div");
	By prices = By.xpath("//div[@class='bag-left-section']/div/div[3]/div/div[2]/div[1]/div[2]/div/div/div[2]/div/div[1]/div[1]");
	
	
	
	
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
	public List<WebElement> getListOfItems()
	{
		 return driver.findElements(listOfItems);
	}
	public List<WebElement> getPrices()
	{
		 return driver.findElements(prices);
	}
	



}
