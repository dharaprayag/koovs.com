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
import PageObjects.cart;
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
	cart cart;
	
	
	@Before(value="@menScenario,@menScenarioWithFilter,@womenScenario,@womenScenarioWithFilter,@calculateTotalAmount,@numberOfitemsInCart", order=1)
	@Given("^Initialize browser with chrome and navigate to site$")
    public void initialize_browser_with_chrome_and_navigate_to_site() throws Throwable 
	{
		driver = initilizeDriver();
		driver.get(siteUrl);
		driver.manage().window().maximize();
		login = new Login(driver);
    }
	
	@Before(value="@menScenario,@menScenarioWithFilter,@womenScenario,@womenScenarioWithFilter,@calculateTotalAmount,@numberOfitemsInCart", order=2)
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
        	Thread.sleep(10000);
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
    
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    			///////////////////////////////////MEN SCENARIO////////////////////////////////////////////
    @Before(value="@calculateTotalAmount", order=3)
    @Given("^Select (.+)$")
    public void select(String mensproduct) throws Throwable 
    {
    	men = new MenCategory(driver);
    	action = new Actions(driver);
    	javascript = (JavascriptExecutor) driver;
    	Thread.sleep(3000);
    	WebElement menL = men.getMensCategoryLink();
		action.moveToElement(menL).build().perform();
		 int count = men.getMenProductsLinksCount().size();
	        for(int i=0; i<count; i++)
	   		{
	        	String text =men.getShirtsOrJeansText().get(i).getText();
	  			if(text.equalsIgnoreCase(mensproduct))
	   			{
	  				men.getClickOnShirtsOrJeansLink().get(i).click();
	  				System.out.println("Successfully found " + mensproduct);
	  				break;
	  				
	   			}
	   		}
	        Thread.sleep(4000);
    }

    @When("^Choose (.+)$")
    public void choose(String mensproductname) throws Throwable
    {
    	//SELECT PRODUCTNAME
			int shirtCount = men.getTotalShirtOrJeansCount().size();
			for(int a=0; a<shirtCount; a++)
			{
				String shirtname = men.getShirtOrJeansName().get(a).getText();
				if(shirtname.equalsIgnoreCase(mensproductname))
				{
					WebElement mouseHoverOnShirt = men.getMouseHoverOnShirtOrJeans().get(a);
					javascript.executeScript("arguments[0].scrollIntoView(true);",mouseHoverOnShirt);
					action.moveToElement(mouseHoverOnShirt).build().perform();
					men.getAddToCart().get(a).click();
					break;
				}
			}
			System.out.println("Successfully found " + mensproductname);
			
    }

    @Then("^(.+) click on add to bag$")
    public void click_on_add_to_bag(String menssize) throws Throwable
    {
    	// SELECT SIZE THEN ADD TO BAG
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
			javascript.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
			driver.quit();
			
			
    }
   
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    						////////////////////////////MEN SCENARIO WITH FILTER////////////////////////////////
    
    
    @Given("^Men scenario with filter (.+)$")
    public void Men_scenario_with_filter(String product) throws Throwable
    {
		men = new MenCategory(driver);
    	action = new Actions(driver);
    	javascript = (JavascriptExecutor) driver;
    	Thread.sleep(3000);
    	WebElement menL = men.getMensCategoryLink();
    	Thread.sleep(2000);
		action.moveToElement(menL).build().perform();
		
		//SELECT PRODUCT SECTION
		int count = men.getMenProductsLinksCount().size();
        for(int i=0; i<count; i++)
   		{
        	String text =men.getShirtsOrJeansText().get(i).getText();
  			if(text.equalsIgnoreCase(product))
   			{
  				men.getClickOnShirtsOrJeansLink().get(i).click();
  				Thread.sleep(3000);
  				break;
   			}
   		}  
  				
    }

    @When("^Filter (.+), (.+), (.+)$")
    public void filter_(String brand, String colors, String pricerange) throws Throwable
    {
    	Thread.sleep(5000);
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
    	/*WebElement colorsSection = men.getColorSection();
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
    	}*/
    	
    	//SELECT PRICE RANGE
    	WebElement pricerangeSection = men.getPriceRangeSection();
    	javascript.executeScript("arguments[0].scrollIntoView(true);",pricerangeSection);
    	Thread.sleep(3000);
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
    	Thread.sleep(3000);
    	
    }

    
    @Then("^(.+), (.+) and (.+) and add to bag$")
    public void _and_and_on_add_to_bag(String discount, String mensproductname, String menssize) throws Throwable
    {
    	//SELECT DISCOUNT
    	Thread.sleep(3000);
    	WebElement discountSection = men.getDiscountSection();
    	javascript.executeScript("arguments[0].scrollIntoView(true);",discountSection);
    	Thread.sleep(3000);
    	
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
    	System.out.println("Successfully added " + mensproductname + " into cart");
    	driver.quit();
    }
    

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    					////////////////////////////////WOMEN SCENARIO////////////////////////////////////////////
    
    @Given("^Women product (.+)$")
    public void Women_product(String product) throws Throwable
    {
    	women = new WomenCategory(driver);
    	action = new Actions(driver);
    	Thread.sleep(5000);
        WebElement womenLink = women.getWomenLink();
        action.moveToElement(womenLink).build().perform();
       
        
        int count = women.getWomenProductsLinksCount().size();
        for(int i=0; i<count; i++)
   		{
        	String text = women.getWomenProductsText().get(i).getText();
  			if(text.equalsIgnoreCase(product))
   			{
  				women.getWomenProductLink().get(i).click();
  				System.out.println("Clicked on " + product);
  				break;
   			}
   		}
  		Thread.sleep(3000);
  		
    }

    @When("^A women item (.+)$")
    public void A_women_item(String productname) throws Throwable
    {
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
					System.out.println("Clicked on " + productname);
					break;
				}
			}
			
    }

    @Then("^Click on women product then add to bag (.+)$")
    public void click_on_women_product_then_add_to_bag(String size) throws Throwable
    {
    	int sizes = women.getTotalSize().size();
	    	for(int k=0; k<sizes; k++)
	    	{
	    		String Size = women.getSize().get(k).getText();
	    		if(Size.equalsIgnoreCase(size))
	    		{
	    			women.getTotalSize().get(k).click();
	    			System.out.println("Clicked on " + size);
	    			break;
	    		}
	    	}
	    	Thread.sleep(2000);
	    	women.getClickOnAddToBag().click();
			Thread.sleep(4000);
			women.getCloseProductPopup().click();
			javascript.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
			driver.quit();    	
    }
    
    
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
    						//////////////////////WOMEN CATEGORY WITH FILTER//////////////
    
    @Given("^Selection (.+) from women Category$")
    public void selection_from_women_category(String womenfilterproduct) throws Throwable
    {
    	women = new WomenCategory(driver);
    	action = new Actions(driver);

    	WebElement womenLink = women.getWomenLink();
        action.moveToElement(womenLink).build().perform();
        
        int count = women.getWomenProductsLinksCount().size();
        for(int i=0; i<count; i++)
   		{
        	String text = women.getWomenProductsText().get(i).getText();
  			if(text.equalsIgnoreCase(womenfilterproduct))
   			{
  				women.getWomenProductLink().get(i).click();
  				break;
   			}
   		}
    	
    	System.out.println("Clicked on " + womenfilterproduct);
    }

    @When("^Product's filter (.+), (.+)$")
    public void Products_filter_(String womenfilterbrand, String womenfilterpricerange) throws Throwable
    {
    	//SCROLL DOWN TO BRAND SECTION
    	WebElement brandSection = women.getBrandSection();
		javascript.executeScript("arguments[0].scrollIntoView(true);",brandSection);
		
		int brands = women.getBrandList().size();
		for(int j=0; j<brands; j++)
		{
			String brand = women.getBrandText().get(j).getText();
			if(brand.equalsIgnoreCase(womenfilterbrand))
			{
				women.getBrandCheckBox().get(j).click();
				Thread.sleep(2000);
				break;
			}
		}
		
		//SCROLL DOWN TO PRICE RANGE
		WebElement priceRangeSection = women.getPriceRangeSection();
		javascript.executeScript("arguments[0].scrollIntoView(true);",priceRangeSection);
		
		int ranges = women.getPriceRanges().size();
		for(int k=0; k<ranges; k++)
		{
			String priceRange = women.getPriceRange().get(k).getText();
			if(priceRange.equalsIgnoreCase(womenfilterpricerange))
			{
				women.getPriceRangeCheckBox().get(k).click();
				Thread.sleep(2000);
				break;
			}
		}
    	
		System.out.println("clicked on " + womenfilterbrand + " and " + womenfilterpricerange);
 
    }

    @Then("^(.+), (.+) and (.+) and then product added into cart$")
    public void _and_and_then_product_added_into_cart(String womenfilterdiscount, String womenfilterproductname, String womenfiltersize) throws Throwable
    {
    	Thread.sleep(3000);
    	WebElement discountSection = women.getDiscountSection();
    	javascript.executeScript("arguments[0].scrollIntoView(true);",discountSection);
    	Thread.sleep(3000);
    	int discounts = women.getDiscounts().size();
    	for(int m=0; m<discounts; m++)
    	{
    		String discountText = women.getDiscountText().get(m).getText();
    		if(discountText.equalsIgnoreCase(womenfilterdiscount))
    		{
    			women.getDiscountCheckBox().get(m).click();
    			Thread.sleep(2000);
    			
    			//SCROLL TO TOP
    			javascript.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
    			int productName = women.getFilterProductCount().size();
    			for(int n=0; n<productName; n++)
    			{
    				String filterProductName = women.getFilterProductName().get(n).getText();
    				if(filterProductName.equalsIgnoreCase(womenfilterproductname))
    				{
    					WebElement mouseHoverOnProduct = women.getMouseHoverOnProduct().get(n);
    					javascript.executeScript("arguments[0].scrollIntoView(true);",mouseHoverOnProduct);
    					action.moveToElement(mouseHoverOnProduct).build().perform();
    					women.getAddToCart().get(n).click();
    					//SELECT SIZE
    					int sizes = women.getTotalSize().size();
      			    	for(int k=0; k<sizes; k++)
      			    	{
      			    		String Size = women.getSize().get(k).getText();
      			    		if(Size.equalsIgnoreCase(womenfiltersize))
      			    		{
      			    			women.getTotalSize().get(k).click();
      			    			Thread.sleep(3000);
      			    			break;
      			    		}
      			    	}
      			    	Thread.sleep(2000);
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
    	System.out.println("successfully " + womenfilterproductname + " added into cart");
    	System.out.println("______________________________________");
    	driver.quit();    
    }
    
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    					/////////////////////////CART FEATURE//////////////////////////////
    
    // int total = 0;
	// for loop  (to iterate over all the items from the left side)
	// Inside for loop, you will get price for each item as 'Ruppy 300'
	// You need to trim first character, remove white spaces, and then convert it to inetegr - item price
	//  total = total + item price
	// how to remove first char ? : 
    // item price= interger.parseString("ruppe 450".substring(1).replaceAll("\\s+",""))
	// 
    
    //////////@calculateTotalAmount////////
    
    @Given("^Click on cart icon$")
    public void click_on_cart_icon() throws Throwable
    {
    	cart = new cart(driver);
    	action = new Actions(driver);
    	javascript = (JavascriptExecutor) driver;
    	
    	//click on cart icon 
    	WebElement carticon = cart.getCartIcon();
    	action.moveToElement(carticon).click().build().perform();
    	Thread.sleep(4000);   	
    }

    @When("^Get items prices and convert into int and text of Bag total compare with when condition$")
    public void get_items_prices_and_convert_into_int_and_text_of_Bag_total_compare_with_when_condition() throws Throwable
    {
   
    	// FOR LOOP FOR GET PRICE
    	
    	
    	int listofitems = cart.getListOfItems().size();
    	int total = 0;
    	for(int a=0; a<listofitems; a++)
    	{
    		String price = cart.getPrices().get(a).getText();
    		String itemprice = price.substring(1);
    		String item = itemprice.replace(" ", "");
    		//STRING TO INTEGER
    		int priceInt = Integer.parseInt(item);
    		//SUM
    		total =  total + priceInt;	
    		//System.out.println(total);
    	}
    	System.out.println("Price of the items are " + total);
    	Thread.sleep(2000); 
    	
    	//GET TEXT OF BAG TOTAL
    			String bagTotal = cart.getBagTotalText().getText();
    	    	String removeRs = bagTotal.substring(1);
    	    	String removeWhiteSpace = removeRs.replace(" ", "");
    	    	//REMOVE SPECIAL CHARACTER ','
    	    	removeWhiteSpace = removeWhiteSpace.replace(",", "");
    	 
    	    	//STRING TO INTEGER
    	    	int bagTotalInt = Integer.parseInt(removeWhiteSpace);
    	    	System.out.println("Badge digit is " + bagTotalInt);
    	    	//System.out.println(bagTotalInt);
    	    	Thread.sleep(2000);
    	    	Assert.assertEquals(total, bagTotalInt);
    	    	System.out.println("Assert true");
    	    	driver.quit();
    			
    }  
    
    
    //////////////////@numberOfitemsInCart///////////////////
    
    @Given("^Mousehover on cart$")
    public void mousehover_on_cart() throws Throwable
    {
    	cart = new cart(driver);
    	action = new Actions(driver);
    	javascript = (JavascriptExecutor) driver;
    	
    	//click on cart icon 
    	WebElement carticon = cart.getCartIcon();
    	action.moveToElement(carticon).build().perform();
    	Thread.sleep(2000); 
    }

    @When("^Total number items in cart and compare with Badge digit$")
    public void total_number_items_in_cart_and_compare_with_badge_digit() throws Throwable
    {
    	    int numberOfItems = cart.getNumberOfItemsInCart().size();
    	    System.out.println("Number Of items in cart are " + numberOfItems);
    	    
    	    //GET BADGE DIGIT
    	    String badgeDigit = cart.getBadgeDigit().getText();
    	    System.out.println("Cart badge digit is " + badgeDigit);
    	    //STRING TO INTEGER
	    	int badgedigit = Integer.parseInt(badgeDigit);
	    	
	    	//NUMBEROFITEMS AND BADGEDIGIT ARE EQUAL
	    	Assert.assertEquals(numberOfItems, badgedigit);
    }

    @Then("^Clear cart$")
    public void clear_cart() throws Throwable
    {
    	WebElement carticon = cart.getCartIcon();
    	action.moveToElement(carticon).click().build().perform();
    	
    	//CLEAR CART
    	int numbers = cart.getItemsInCart().size();
    	for(int a=0; a<numbers; a++)
    	{
    		cart.getItemDeleteIcon().click();
    	}
    	driver.quit();
    	
    }
    
    
    
    
    
    
}
