package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Resources.base;

public class WomenCategory extends base
{
	By womenLink = By.xpath("//a[@href='/women']");
	By womenProductsLinksCount = By.xpath("//*[@class='header_menu_Title']/li[2]/div/ul[1]/li[3]/div/ul/li");
	By womenProductLink = By.xpath("//*[@class='header_menu_Title']/li[2]/div/ul[1]/li[3]/div/ul/li/a");
	By totalNumberOfProductsCount = By.xpath("//*[@id='prodBox']/li");
	By productName = By.xpath("//*[@id='prodBox']/li/div[3]/a/div[4]/span[2]");
	By mouseHoverOnProduct =By.xpath("//*[@id='prodBox']/li/div[3]");
	By addToCart = By.xpath("//*[@id='prodBox']/li/div[3]/a/div[3]/div[1]/button[1]");
	By totalSize = By.xpath("//*[@class='size-lists']/div");
	By size = By.xpath("//*[@class='size-lists']/div/span");
	By clickOnAddToBag = By.xpath("//div[@class='pd-right-side']/div[3]/div/button[1]");
	By closeProductPopup =By.xpath("//div[@class='modal-content-wrap']/span");
	By closeButton = By.xpath("//div[@class='hcart-items']/div/div[1]/div/div/div/div/div/div/div[3]/img");
	By mouseHoverOnCart = By.xpath("//*[@class='header__wishlist-bag']/div[2]/a/div");
	By badgeDigit = By.xpath("//span[@id='cart_total_items']");
	By numberOfItemsInCart = By.xpath("//div[@id='hcartItems']/div[1]/div[2]/div/div");
	
	
	public WomenCategory(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub		
		this.driver = driver;
		//PAGE FACTORY
		PageFactory.initElements(driver, this);
	}
	public List<WebElement> getNumberOfItemsInCart()
	{
		 return driver.findElements(numberOfItemsInCart);
	}
	public List<WebElement> getCloseButtoncount()
	{
		 return driver.findElements(closeButton);
	}
	public WebElement getBadgeDigit()
	{
		 return driver.findElement(badgeDigit);
	}
	public WebElement getMouseHoverOnCart()
	{
		 return driver.findElement(mouseHoverOnCart);
	}
	public WebElement getCloseButton()
	{
		 return driver.findElement(closeButton);
	}
	public WebElement getCloseProductPopup()
	{
		 return driver.findElement(closeProductPopup);
	}
	public WebElement getClickOnAddToBag()
	{
		 return driver.findElement(clickOnAddToBag);
	}
	public List<WebElement> getSize()
	{
		 return driver.findElements(size);
	}
	public List<WebElement> getAddToCart()
	{
		 return driver.findElements(addToCart);
	}
	public List<WebElement> getTotalSize()
	{
		 return driver.findElements(totalSize);
	}
	public List<WebElement> getMouseHoverOnProduct()
	{
		 return driver.findElements(mouseHoverOnProduct);
	}
	public WebElement getWomenLink()
	{
		 return driver.findElement(womenLink);
	}
	public List<WebElement> getWomenProductsLinksCount()
	{
		 return driver.findElements(womenProductsLinksCount);
	}
	public List<WebElement> getWomenProductsText()
	{
		 return driver.findElements(womenProductsLinksCount);
	}
	public List<WebElement> getWomenProductLink()
	{
		 return driver.findElements(womenProductLink);
	}
	public List<WebElement> getTotalNumberOfProductsCount()
	{
		 return driver.findElements(totalNumberOfProductsCount);
	}
	public List<WebElement> getProductName()
	{
		 return driver.findElements(productName);
	}
	
	

}