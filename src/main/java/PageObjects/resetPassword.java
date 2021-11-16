package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Resources.base;

public class resetPassword extends base
{
	public WebDriver driver;
	
	By loginLink = By.xpath("//a[text()='Login']");
	By resetPasswordLink = By.linkText("Reset Password");
	By AcceptButtton = By.xpath("//div[@class='login-wrapper']/div[1]/div[3]/div[2]/div");
	By wishlistIcon = By.xpath("//div[@class='hright-section']/div[2]/div[1]/a/div");
	By loginErrorMsg = By.xpath("//div[@class='login-section']/div[1]/div[2]/div");
	By bagIcon = By.xpath("//div[@class='hright-section']/div[2]/div[2]/a/div");
	By menLink = By.xpath("//*[@href='/men']");
	By womenLink = By.xpath("//*[@href='/women']");
	By koovsxyouLink = By.xpath("//*[@href='koovsxyou']");
	By instyleofLink = By.xpath("//a[@title='IN STYLE OF']");
	By theBlogLink = By.linkText("THE BLOG");
	By searchInput = By.xpath("//div[@class='koovs-search-input']/input");
	By searchIcon = By.xpath("//div[@class='koovs-search-btn']/div/div");
	By trendingText = By.xpath("//div[text()='TRENDING SEARCHES']");
	By resetPasswordEmail = By.id("fp-email");
	By resetpasswordButton = By.xpath("//*[@class='fp-form-btn']/button");
	By passwordErrorMsg = By.xpath("//*[@class='fp-form']/div[1]/div");
	
	
	
	public resetPassword(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		
		this.driver = driver;
		//PAGE FACTORY
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getPasswordErrorMsg()
	{
		return driver.findElement(passwordErrorMsg);
	}
	public WebElement getResetpasswordButton()
	{
		return driver.findElement(resetpasswordButton);
	}
	public WebElement getResetPasswordEmail()
	{
		return driver.findElement(resetPasswordEmail);
	}
	public WebElement getTrendingText()
	{
		 return driver.findElement(trendingText);
	}
	public WebElement getSearchIcon()
	{
		 return driver.findElement(searchIcon);
	}
	public WebElement getSearchInput()
	{
		 return driver.findElement(searchInput);
	}
	public WebElement getTheBlogLink()
	{
		 return driver.findElement(theBlogLink);
	}
	public WebElement getLoginLink()
	{
		 return driver.findElement(loginLink);
	}
	public WebElement getResetPasswordLink()
	{
		 return driver.findElement(resetPasswordLink);
	}
	public WebElement getWishlistIcon()
	{
		 return driver.findElement(wishlistIcon);
	}
	public WebElement getLoginErrorMsg()
	{
		 return driver.findElement(loginErrorMsg);
	}	
	public WebElement getBagIcon()
	{
		 return driver.findElement(bagIcon);
	}
	public WebElement getInstyleofLink()
	{
		 return driver.findElement(instyleofLink);
	}
	public WebElement getKoovxyouLink()
	{
		 return driver.findElement(koovsxyouLink);
	}
	public WebElement getMenLink()
	{
		 return driver.findElement(menLink);
	}
	public WebElement getWomenLink()
	{
		 return driver.findElement(womenLink);
	}
	
	
	
}
