package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.support.PageFactory;

public class Login 
{
	public WebDriver driver;
	
	By loginLink = By.xpath("//a[text()='Login']");
	By enterEmail = By.cssSelector("input[id='login-email']");
	By enterPassword = By.cssSelector("input[id='login-pswd']");
	By loginButton = By.xpath("//button[@type='submit']");
	By AcceptButtton = By.xpath("//*[@id='app']/div/div/div/div[1]/div[3]/div[2]/div");
	By notification = By.id("notification-wrapper");
	By userName = By.xpath("//div[@class='account-links']/span");
	By companyLogo = By.xpath("//div[@class='header-wrapper']/div[1]/div[1]");
	By wishlistIcon = By.xpath("//div[@class='hright-section']/div[2]/div[1]/a/div");
	By loginErrorMsg = By.xpath("//div[@class='login-section']/div[1]/div[2]/div");
	By bagIcon = By.xpath("//div[@class='hright-section']/div[2]/div[2]/a/div");
	By menLink = By.xpath("//*[@href='/men']");
	By womenLink = By.xpath("//*[@href='/women']");
	By koovsxyouLink = By.xpath("//*[@href='koovsxyou']");
	By instyleofLink = By.xpath("//a[@title='IN STYLE OF']");
	By searchInput = By.xpath("//div[@class='koovs-search-input']/input");
	By searchIcon = By.xpath("//div[@class='koovs-search-btn']/div/div");
	By trendingText = By.xpath("//div[text()='TRENDING SEARCHES']");
	By googleLink = By.id("customBtn");
	By facebookLink = By.xpath("//div[@class='koovs-fblock']");
	By emailInput = By.cssSelector("*[id='login-email']");
	By passwordInput = By.cssSelector("*[id='login-pswd']");
	By showOrHideLink = By.xpath("//*[@id='login-pswd']/following-sibling::span");
	By emailErrorMsg = By.xpath("//div[@class='login-form']/div[1]/div");
	By passwordErrorMsg = By.xpath("//div[@class='login-form']/div[2]/div");
	
	
	
	public Login(WebDriver driver) 
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
	public WebElement getEmailErrorMsg()
	{
		return driver.findElement(emailErrorMsg);
	}
	public WebElement getShowOrHide()
	{
		return driver.findElement(showOrHideLink);
	}
	public WebElement getPasswordInput()
	{
		return driver.findElement(passwordInput);
	}
	public WebElement getEmailInput()
	{
		return driver.findElement(emailInput);
	}
	public WebElement getFacebookLink()
	{
		return driver.findElement(facebookLink);
	}
	public WebElement getGoogleLink()
	{
		return driver.findElement(googleLink);
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
	public WebElement getBagIcon()
	{
		 return driver.findElement(bagIcon);
	}
	public WebElement getLoginErrorMsg()
	{
		 return driver.findElement(loginErrorMsg);
	}
	public WebElement getWishlistIcon()
	{
		 return driver.findElement(wishlistIcon);
	}
	public WebElement getCompanyLogo()
	{
		 return driver.findElement(companyLogo);
	}
	public WebElement getLoginLink()
	{
		 return driver.findElement(loginLink);
	}
	
	public WebElement getEnterEmail()
	{
		return driver.findElement(enterEmail);
	}
	
	public WebElement getEnterPassword()
	{
		return driver.findElement(enterPassword);
	}
	
	public WebElement getLoginButton()
	{
		return driver.findElement(loginButton);
	}
	
	public WebElement getAcceptButton()
	{
		return driver.findElement(AcceptButtton);
	}
	
	public WebElement getNotification()
	{
		return driver.findElement(notification);
	}
	
	public WebElement getUserName()
	{
		return driver.findElement(userName);
	}
	

}
