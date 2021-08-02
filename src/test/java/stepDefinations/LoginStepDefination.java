package stepDefinations;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import java.util.ArrayList;
import java.util.Random;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import PageObjects.Login;
import PageObjects.MenCategory;
import PageObjects.WomenCategory;
import Resources.base;

@RunWith(Cucumber.class)
public class LoginStepDefination extends base 
{
	Login login;
	MenCategory men;
	Actions action;
	JavascriptExecutor javascript;
	WomenCategory women;
	
	
	@Before(value="@menScenario,@menScenarioWithFilter,@womenScenario", order=1)
	@Given("^Initialize browser with chrome and navigate to site$")
    public void initialize_browser_with_chrome_and_navigate_to_site() throws Throwable 
	{
		driver = initilizeDriver();
		driver.get(siteUrl);
		driver.manage().window().maximize();
		login = new Login(driver);
    }
	@Before(value="@menScenario,@menScenarioWithFilter,@womenScenario", order=2)
    @When("^click on login link and Fill up Email and Password and click on log in button$")
    public void click_on_login_link_and_Fill_up_Email_and_Password_and_click_on_log_in_button() throws Throwable
    {
		javascript = (JavascriptExecutor) driver;
    	Thread.sleep(5000);    	
    	
    	
    		login.getLoginLink().click();
    		login.getEnterEmail().sendKeys(men.getRandomEmail());
        	login.getEnterPassword().sendKeys(Password);
        	login.getAcceptButton().click();
        	javascript.executeScript("scroll(0, 150);");
        	Thread.sleep(6000);
        	login.getLoginButton().click();   	
    }
	

    @Then("^Landed into home page$")
    public void landed_into_home_page() throws Throwable
    {
    	Thread.sleep(2000);
    	System.out.println("Username is " + login.getUserName().getText());
    	System.out.println("Login Successful");
    	driver.quit();
    	//System.out.println(login.getNotification().getText());
    }
    
    
    
    ////////////////////////////////MEN SCENARIO////////////////////////////////////////////
    @Given("^Select (.+), (.+) and (.+) click on add to bag$")
    public void select_and_click_on_add_to_bag(String mensproduct, String mensproductname, String menssize) throws Throwable
    {
    	men = new MenCategory(driver);
    	action = new Actions(driver);
    	WebElement menlink = men.getMensCategoryLink1();
		action.moveToElement(menlink).build().perform();
        
		//SELECT PRODUCT
        int count = men.getMenProductsLinksCount().size();
        for(int i=0; i<count; i++)
   		{
        	String text =men.getShirtsOrJeansText().get(i).getText();
  			if(text.equalsIgnoreCase(mensproduct))
   			{
  				men.getClickOnShirtsOrJeansLink().get(i).click();				
  				//SELECT PRODUCTNAME
  				int shirtCount = men.getTotalShirtOrJeansCount().size();
  				for(int j=0; j<shirtCount; j++)
  				{
  					String shirtname = men.getShirtOrJeansName().get(j).getText();
  					if(shirtname.equalsIgnoreCase(mensproductname))
  					{
  						WebElement mouseHoverOnShirt = men.getMouseHoverOnShirtOrJeans().get(j);
  						javascript.executeScript("arguments[0].scrollIntoView(true);",mouseHoverOnShirt);
  						action.moveToElement(mouseHoverOnShirt).build().perform();
  						men.getAddToCart().get(j).click();
  						//SELECT SHIRT SIZE
  						int sizes = men.getTotalSize().size();
  						for(int k=0; k<sizes; k++)
  						{
  							String Size = men.getSize().get(k).getText();
  							if(Size.equalsIgnoreCase(menssize))
  							{
  						    	men.getTotalSize().get(k).click();
  						    	break;
  						    }
  						}
  						Thread.sleep(3000);
  						men.getClickOnAddToBag().click();
  						Thread.sleep(4000);
  						men.getCloseProductPopup().click();
  						break;
  				}
  				
  			}
  			javascript.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
  			break;  			
   		}
   		}
       
    }

    @When("^mouseHover on cart and verify number of items added into cart and badge digit are equal$")
    public void mousehover_on_cart_and_verify_number_of_items_added_into_cart_and_badge_digit_are_equal() throws Throwable
    {
    	//MOUSE HOVER ON CART
    	WebElement mouseHoverOncart = men.getMouseHoverOnCart();
    	action.moveToElement(mouseHoverOncart).build().perform();
    	
    	//VERIFY CART AND BUDGE DIGIT
    	String badgeText = men.getBadgeDigit().getText();
    	System.out.println("Badge number is " + badgeText);
    	int numberOfItemsInCart = men.getNumberOfItemsInCart().size();
    	System.out.println("Total Numbers of added items are " + numberOfItemsInCart);
    	
    	Assert.assertEquals(badgeText, Integer.toString(numberOfItemsInCart));    
    }
    
    @Then("^clear cart$")
    public void clear_cart() throws Throwable
    {
    	System.out.println("Mens scenario completed");
    	driver.quit();
    }
    	
			//CLICK ON LOAD MORE BUTTON
			//int loadMoreCount = men.getLoadMoreButtonSize().size();
			/*for (int i=0; i<loadMoreCount; i++)
			{
				Thread.sleep(3000);
				javascript.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				Thread.sleep(3000);
				while(men.getLoadMoreButton().isDisplayed())
				{
					Thread.sleep(3000);
					String button = men.getLoadMoreButtonSize().get(i).getText();
					if(button.equalsIgnoreCase("Load More"))
					{
						men.getLoadMoreButtonSize().get(i).click();
						Thread.sleep(3000);
						javascript.executeScript("window.scrollTo(0, document.body.scrollHeight)");
						Thread.sleep(3000);
					}
				}
				javascript.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
			}
			System.out.println("Total number of Shirts are " + men.getTotalShirtCount().size());*/
    
    
	
    //////////////////////////////////MEN SCENARIO WITH FILTER///////////////////////////////////////////
    
    @Given("^Select (.+)$")
    public void select(String product) throws Throwable
    {
    	
    }

    @When("^Filter (.+), (.+), (.+) and (.+)$")
    public void filter_and(String brand, String colors, String pricerange, String discount) throws Throwable
    {
    	
    }

    @Then("^Select (.+) and (.+) click on add to bag $")
    public void select_and_click_on_add_to_bag(String mensproductname, String menssize) throws Throwable
    {
    	
    }
    

    
    //////////////////////WOMEN CATEGORY/////////////////////////
    @Given("^Select (.+) and (.+) and (.+) click on add to bag$")
    public void select_and_and_click_on_add_to_bag(String product, String productname, String size) throws Throwable
    {
    	women = new WomenCategory(driver);
    	action = new Actions(driver);
        WebElement womenLink = women.getWomenLink();
        action.moveToElement(womenLink).build().perform();
        
        int count = women.getWomenProductsLinksCount().size();
        for(int i=0; i<count; i++)
   		{
        	String text = women.getWomenProductsText().get(i).getText();
  			if(text.equalsIgnoreCase(product))
   			{
  				women.getWomenProductLink().get(i).click();
   				
  		//SELECT TOP
  	    	int topCount = women.getTotalNumberOfProductsCount().size();
  			for(int j=0; j<topCount; j++)
  			{
  				String top = women.getProductName().get(j).getText();
  				if(top.equalsIgnoreCase(productname))
  				{
  					Thread.sleep(3000);
  					WebElement mouseHoverOnTop = women.getMouseHoverOnProduct().get(j);
  					javascript.executeScript("arguments[0].scrollIntoView(true);",mouseHoverOnTop);
  					action.moveToElement(mouseHoverOnTop).build().perform();
  					women.getAddToCart().get(j).click();
  					int sizes = women.getTotalSize().size();
  			    	for(int k=0; k<sizes; k++)
  			    	{
  			    		String Size = women.getSize().get(k).getText();
  			    		if(Size.equalsIgnoreCase(size))
  			    		{
  			    			women.getTotalSize().get(k).click();
  			    			break;
  			    		}
  			    	}
  			    	women.getClickOnAddToBag().click();
  					Thread.sleep(4000);
  					women.getCloseProductPopup().click();
  					break;
  				}
  				
  			}
  			javascript.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
  			break;  			
   		}
   		}
       
      
    }

    @When("^MouseHover on cart and Verify number of items added into cart and badge digit are equal$")
    public void MouseHover_on_cart_and_Verify_number_of_items_added_into_cart_and_badge_digit_are_equal() throws Throwable 
    {
    	//MOUSE HOVER ON CART
    	WebElement mouseHoverOncart = women.getMouseHoverOnCart();
    	action.moveToElement(mouseHoverOncart).build().perform();
    	
    	//VERIFY CART AND BUDGE DIGIT
    	String badgeText = women.getBadgeDigit().getText();
    	System.out.println("Badge number is " + badgeText);
    	int numberOfItemsInCart = women.getNumberOfItemsInCart().size();
    	System.out.println("Total Numbers of added items are " + numberOfItemsInCart);
    }
   
    @Then("^Clear cart$")
    public void Clear_cart() throws Throwable
    {
    	WebElement mouseHoverOncart = women.getMouseHoverOnCart();
    	action.moveToElement(mouseHoverOncart).build().perform();
    	int closeButtonCount = women.getCloseButtoncount().size();
    	for(int i=0; i<closeButtonCount; i++)
    	{
    		while(women.getCloseButton().isDisplayed())
    		{
    			women.getCloseButton().click();
    		}
    		break;
    	}
    	System.out.println("Womens scenario competed");
    	System.out.println("Clear cart");
    	driver.quit();	
    }
    
}
