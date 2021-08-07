package stepDefinations;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import java.util.ArrayList;
import java.util.List;
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
	@Before(value="@menScenario,@womenScenario,@menScenarioWithFilter", order=2)
    @When("^click on login link and Fill up Email and Password and click on log in button$")
    public void click_on_login_link_and_Fill_up_Email_and_Password_and_click_on_log_in_button() throws Throwable
    {
		javascript = (JavascriptExecutor) driver;
    	Thread.sleep(5000);    	
    	
    	
    		login.getLoginLink().click();
    		login.getEnterEmail().sendKeys(Email);
    		//login.getEnterEmail().sendKeys(men.getRandomEmail());
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
    	WebElement menlink = men.getMensCategoryLink();
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
    public void select_(String product) throws Throwable
    {    	
    	men = new MenCategory(driver);
    	action = new Actions(driver);
    	javascript = (JavascriptExecutor) driver;
    	WebElement menlink = men.getMensCategoryLink();
		action.moveToElement(menlink).build().perform();
		
		//SELECT PRODUCT SECTION
		int count = men.getMenProductsLinksCount().size();
        for(int i=0; i<count; i++)
   		{
        	String text =men.getShirtsOrJeansText().get(i).getText();
  			if(text.equalsIgnoreCase(product))
   			{
  				men.getClickOnShirtsOrJeansLink().get(i).click();
  				break;
   			}
   		}  
  				
    }

    @When("^Filter (.+), (.+), (.+)$")
    public void filter_(String brand, String colors, String pricerange) throws Throwable
    {
    	men.getViewAllButton().click();
    	//SELECT BRAND
    	int brands = men.getBrands().size();
    	for(int j=0; j<brands; j++)
    	{
    		String brandText = men.getBrandText().get(j).getText();
    		if(brandText.equalsIgnoreCase(brand))
    		{
    			men.getBrandCheckBox().get(j).click();
    			men.getClickOnApplyButton().click();
    	    	Thread.sleep(2000);
    	    	break;
    		}
    	}
    	 
    	//SELECT COLORS
    	WebElement colorsSection = men.getColorSection();
    	javascript.executeScript("arguments[0].scrollIntoView(true);",colorsSection);
    	
    	int numberOfColors1 = men.getNumberOfColors().size();
    	for(int k=0; k<numberOfColors1; k++)
    	{
    		List<WebElement> colotname = men.getColorName();
    				WebElement get = colotname.get(k);
    				String gettext = get.getText();
    		if(gettext.equalsIgnoreCase(colors))
    		{
    			men.getClickOnColor().get(k).click();
    			break;
    		}
    	}
    	
    	//SELECT PRICE RANGE
    	WebElement pricerangeSection = men.getPriceRangeSection();
    	javascript.executeScript("arguments[0].scrollIntoView(true);",pricerangeSection);
    	
    	int ranges = men.getPriceRanges().size();
    	for(int l=0; l<ranges; l++)
    	{
    		String range = men.getPriceRange().get(l).getText();
    		if(range.equalsIgnoreCase(pricerange))
    		{
    			men.getClickOnPriceRangeCheckbox().get(l).click();
    			break;
    		}
    	}
    	
    	
    }

    @Then("^(.+), (.+) and (.+) click on add to bag$")
    public void _and_click_on_add_to_bag(String discount, String mensproductname, String menssize) throws Throwable
    {
    	//SELECT DISCOUNT
    	WebElement discountSection = men.getDiscountSection();
    	javascript.executeScript("arguments[0].scrollIntoView(true);",discountSection);
    	
    	int discounts = men.getDiscounts().size();
    	for(int m=0; m<discounts; m++)
    	{
    		String discountText = men.getDiscountText().get(m).getText();
    		if(discountText.equalsIgnoreCase(discount))
    		{
    			men.getDiscountCheckBox().get(m).click();    	
    	
    	
    	javascript.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
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
		break;
		}
    		
		}
    	
    }
    
    
    //////////////////////WOMEN CATEGORY WITH FILTER//////////////
    @Given("^Selection (.+) from women Category$")
    public void selection_from_women_category(String womenfilterproduct) throws Throwable
    {
    	
    }

    @When("^product's filter (.+), (.+), (.+)$")
    public void products_filter_(String womenfilterbrand, String womenfiltercolors, String womenfilterpricerange) throws Throwable
    {
    	
    }

    @Then("^(.+), (.+) and (.+) and then product added into cart$")
    public void _and_and_then_product_added_into_cart(String womenfilterdiscount, String womenfilterproductname, String womenfiltersize) throws Throwable
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
