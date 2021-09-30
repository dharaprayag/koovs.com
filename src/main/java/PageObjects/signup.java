package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Resources.base;

public class signup extends base
{
	By signupLink = By.linkText("Sign Up");
	By companyLogo = By.xpath("//div[@class='header-wrapper']/div[1]/div[1]");
	By signupText = By.xpath("//div[@class='signup-content']/div[1]");
	By loginLink = By.linkText("Login");
	By wishlistIcon = By.xpath("//div[@class='hright-section']/div[2]/div[1]/a/div");
	By loginErrorMsg = By.xpath("//div[@class='login-section']/div[1]/div[2]/div");
	By bagIcon = By.xpath("//div[@class='hright-section']/div[2]/div[2]/a/div");
	By menLink = By.xpath("//*[@href='/men']");
	By womenLink = By.xpath("//*[@href='/women']");
	By theBlogLink = By.cssSelector("a[title='THE BLOG']");
	By koovsxyouLink = By.xpath("//*[@href='koovsxyou']");
	By instyleofLink = By.xpath("//a[@title='IN STYLE OF']");
	By searchIcon = By.xpath("//div[@class='koovs-search-btn']/div/div");
	By trendingText = By.xpath("//div[text()='TRENDING SEARCHES']");
	By searchInput = By.xpath("//div[@class='koovs-search-input']/input");
	
	
	public signup(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub		
		this.driver = driver;
		//PAGE FACTORY
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getSearchInput()
	{
		 return driver.findElement(searchInput);
	}
	public WebElement getTrendingText()
	{
		 return driver.findElement(trendingText);
	}
	public WebElement getSearchIcon()
	{
		 return driver.findElement(searchIcon);
	}
	public WebElement getInstyleofLink()
	{
		 return driver.findElement(instyleofLink);
	}
	public WebElement getKoovxyouLink()
	{
		 return driver.findElement(koovsxyouLink);
	}
	public WebElement getSignupLink()
	{
		 return driver.findElement(signupLink);
	}
	public WebElement getCompanyLogo()
	{
		 return driver.findElement(companyLogo);
	}
	public WebElement getSignupText()
	{
		 return driver.findElement(signupText);
	}
	public WebElement getLoginLink()
	{
		 return driver.findElement(loginLink);
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
	public WebElement getMenLink()
	{
		 return driver.findElement(menLink);
	}
	public WebElement getWomenLink()
	{
		 return driver.findElement(womenLink);
	}
	public WebElement getTheBlogLink()
	{
		 return driver.findElement(theBlogLink);
	}
	
}
