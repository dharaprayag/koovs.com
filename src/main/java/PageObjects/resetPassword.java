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
	
	
	
	
	public resetPassword(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		
		this.driver = driver;
		//PAGE FACTORY
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getLoginLink()
	{
		 return driver.findElement(loginLink);
	}
	public WebElement getResetPasswordLink()
	{
		 return driver.findElement(resetPasswordLink);
	}
	
	
	
	
	
}
