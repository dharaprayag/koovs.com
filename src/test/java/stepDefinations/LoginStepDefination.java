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
import PageObjects.signup;
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
	signup signup;
	
	
	@Before(value="@getTitleSrNo.1,@signupFunctionalitySrNo.2.1,@signupFunctionalitySrNo.2.2,@signupFunctionalitySrNo.2.3,@signupFunctionalitySrNo.2.4,@signupFunctionalitySrNo.2.5,@signupFunctionalitySrNo.2.6,@signupFunctionalitySrNo.2.7,@signupFunctionalitySrNo.2.8,@signupFunctionalitySrNo.2.9,@signupFunctionalitySrNo.2.10,@menScenario,@menScenarioWithFilter,@womenScenario,@womenScenarioWithFilter,@calculateTotalAmount,@numberOfitemsInCart", order=1)
	@Given("^Initialize browser with chrome and navigate to site$")
    public void initialize_browser_with_chrome_and_navigate_to_site() throws Throwable 
	{
		driver = initilizeDriver();
		driver.get(siteUrl);
		driver.manage().window().maximize();
		login = new Login(driver);
    	signup = new signup(driver);
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
    	System.out.println("__________________________________________________________");
    	driver.quit();
    	//System.out.println(login.getNotification().getText());
    
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////// @getTitleSrNo.1 /////////////////////////////
    @Given("^Initialize browser$")
    public void initialize_browser() throws Throwable
    {
    	System.out.println("@getTitleSrNo.1");
    	System.out.println("Initialized browser for get website title");
    }

    @Then("^Get text of website Title$")
    public void get_text_of_website_title() throws Throwable
    {
        System.out.println("'@getTitleSrNo.1' Website title is " + driver.getTitle());
        driver.quit();
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////// @signupFunctionalitySrNo.2.1 /////////////////////////////
    
    @Given("^Initialize browser for click on signup link and get title$")
    public void initialize_browser_for_click_on_signup_link_and_get_title() throws Throwable
    {
    	System.out.println("@signupFunctionalitySrNo.2.1");
    	System.out.println("Initialize browser for click on signup link and get title");
    }

    @When("^Click on sign up link$")
    public void click_on_sign_up_link() throws Throwable
    {
    	signup.getSignupLink().click();
    	System.out.println("Clicked on sign up link");
    }

    @Then("^Get title of sign up page$")
    public void get_title_of_sign_up_page() throws Throwable
    {
    	String signupTitle = driver.getTitle();
    	System.out.println("Signup page title is " + signupTitle);
    	Assert.assertTrue(signupTitle.toLowerCase().contains("signup"));
    	System.out.println("Landed on Signup page");
    	System.out.println("__________________________________________________________");
    	driver.quit();
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////// @signupFunctionalitySrNo.2.2 /////////////////////////////
    
    @Given("Initialize browser and click on signup link for get homepage title$")
    public void initialize_browser_and_click_on_signup_link_for_get_homepage_title() throws Throwable
    {
    	System.out.println("@signupFunctionalitySrNo.2.2");
    	System.out.println("Initialize browser and click on signup link for get homepage title");
    	signup.getSignupLink().click();
    }

    @When("^Click on company logo$")
    public void click_on_company_logo() throws Throwable
    {
        signup.getCompanyLogo().click();
        
    }

    @Then("^Get title of homepage$")
    public void get_title_of_homepage() throws Throwable
    {
        String homepageTitle = driver.getTitle();
        System.out.println("Homepage title is " + homepageTitle);
        Assert.assertTrue(homepageTitle.toLowerCase().contains("online shopping"));
        System.out.println("Landed on Homepage");
    	System.out.println("__________________________________________________________");
    	driver.quit();
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////// @signupFunctionalitySrNo.2.3 /////////////////////////////
    @Given("^Initialize browser and click on signup link for login link title$")
    public void initialize_browser_and_click_on_signup_link_for_login_link_title() throws Throwable
    {
    	System.out.println("@signupFunctionalitySrNo.2.3");
    	System.out.println("Initialize browser and click on signup link for login link title");
    	signup.getSignupLink().click();
    	
    }

    @When("^Click on Login link$")
    public void click_on_login_link() throws Throwable
    {
    	signup.getLoginLink().click();
    }

    @Then("^Get title of Login page$")
    public void get_title_of_login_page() throws Throwable
    {
    	String loginpageTitle = driver.getTitle();
    	System.out.println("Loginpage title is " + loginpageTitle);
    	Assert.assertTrue(loginpageTitle.toLowerCase().contains("login"));
    	System.out.println("Landed on Login page");
    	System.out.println("__________________________________________________________");
    	driver.quit();
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////// @signupFunctionalitySrNo.2.4 /////////////////////////////
    @Given("^Initialize browser and click on signup link for click on wishlist icon and get error message$")
    public void initialize_browser_and_click_on_signup_link_for_click_on_wishlist_icon_and_get_error_message() throws Throwable
    {
    	System.out.println("@signupFunctionalitySrNo.2.4");
    	System.out.println("Initialize browser and click on signup link for login link title");
    	signup.getSignupLink().click();
    }

    @When("^Click on wishlist icon$")
    public void click_on_wishlist_icon() throws Throwable
    {
    	signup.getWishlistIcon().click();    	
    }

    @Then("^Get error message$")
    public void get_error_message() throws Throwable
    {
    	String errorMsg = signup.getLoginErrorMsg().getText();
    	Assert.assertTrue(errorMsg.toLowerCase().contains("sign in to access your orders"));
    	System.out.println("(WISHLIST)Landed on Login page and got login error message");
    	System.out.println("__________________________________________________________");
    	driver.quit();
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////// @signupFunctionalitySrNo.2.5 /////////////////////////////
    @Given("^Initialize browser and click on signup link for click on bag icon and get error message$")
    public void initialize_browser_and_click_on_signup_link_for_click_on_bag_icon_and_get_error_message() throws Throwable
    {
    	System.out.println("@signupFunctionalitySrNo.2.5");
    	System.out.println("Initialize browser and click on signup link for click on bag icon and get error message");
    	signup.getSignupLink().click();
    }

    @When("^Click on bag icon$")
    public void click_on_bag_icon() throws Throwable
    {
    	signup.getBagIcon().click();
    }

    @Then("^Get bag error message$")
    public void get_bag_error_message() throws Throwable
    {
    	String errorMsg = signup.getLoginErrorMsg().getText();
    	Assert.assertTrue(errorMsg.toLowerCase().contains("sign in to access your orders"));
    	System.out.println("(BAG)Landed on Login page and got login error message");
    	System.out.println("__________________________________________________________");
    	driver.quit();
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////// @signupFunctionalitySrNo.2.6 /////////////////////////////
    
    @Given("^Initialize browser and click on signup link$")
    public void initialize_browser_and_click_on_signup_link() throws Throwable
    {
    	System.out.println("@signupFunctionalitySrNo.2.6");
    	System.out.println("initialize browser and click on signup link");
    	signup.getSignupLink().click();
    }

    @When("^click on Men link$")
    public void click_on_men_link() throws Throwable
    {
    	signup.getMenLink().click();
    }

    @Then("^Landed in Mens section$")
    public void landed_in_mens_section() throws Throwable
    {
    	String mensTitle = driver.getTitle();
    	Assert.assertTrue(mensTitle.toLowerCase().contains("online shopping for men"));
    	System.out.println("Landed on Men section");
    	System.out.println("__________________________________________________________");
    	driver.quit();
    }    
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////// @signupFunctionalitySrNo.2.7 /////////////////////////////
    @Given("^Initialize browser for click on women link and click on signup link$")
    public void initialize_browser_for_click_on_women_link_and_click_on_signup_link() throws Throwable
    {
    	System.out.println("@signupFunctionalitySrNo.2.7");
    	System.out.println("Initialize browser for click on women link and click on signup link");
    	signup.getSignupLink().click();
    }

    @When("^click on women link$")
    public void click_on_women_link() throws Throwable
    {
    	signup.getWomenLink().click();
    }

    @Then("^Landed in women section$")
    public void landed_in_women_section() throws Throwable
    {
    	String womenTitle = driver.getTitle();
    	Assert.assertTrue(womenTitle.toLowerCase().contains("online shopping for women"));
    	System.out.println("Landed on Women section");
    	System.out.println("__________________________________________________________");
    	driver.quit();
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////// @signupFunctionalitySrNo.2.8 /////////////////////////////
    @Given("^Initialize browser for click on THE BLOG link and click on signup link$")
    public void initialize_browser_for_click_on_the_blog_link_and_click_on_signup_link() throws Throwable
    {
    	System.out.println("@signupFunctionalitySrNo.2.8");
    	System.out.println("Initialize browser for click on THE BLOG link and click on signup link");
    	signup.getSignupLink().click();
    }

    @When("^click on THE BLOG$")
    public void click_on_the_blog() throws Throwable
    {
    	signup.getTheBlogLink().click();
    }

    @Then("^Landed on Blog page$")
    public void landed_on_blog_page() throws Throwable
    {
    	String blogTitle = driver.getTitle();
    	Assert.assertTrue(blogTitle.toLowerCase().contains("latest fashion trends"));
    	System.out.println("Landed on THE BLOG page");
    	System.out.println("__________________________________________________________");
    	driver.quit();
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////// @signupFunctionalitySrNo.2.9 /////////////////////////////
    @Given("^Initialize browser for click on KOOVSXYOU link and click on signup link$")
    public void initialize_browser_for_click_on_koovsxyou_link_and_click_on_signup_link() throws Throwable
    {
    	System.out.println("@signupFunctionalitySrNo.2.9");
    	System.out.println("Initialize browser for click on KOOVSXYOU link and click on signup link");
    	signup.getSignupLink().click();
    }

    @When("^click on KOOVSXYOU$")
    public void click_on_koovsxyou() throws Throwable
    {
    	signup.getKoovxyouLink().click();
    }

    @Then("^Landed on KOOVSXYOU page$")
    public void landed_on_koovsxyou_page() throws Throwable
    {
    	String koovsxyouLink = driver.getTitle();
    	Assert.assertTrue(koovsxyouLink.toLowerCase().contains("koovsxyou"));
    	System.out.println("Landed on KOOVSXYOU page");
    	System.out.println("__________________________________________________________");
    	driver.quit();
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////// @signupFunctionalitySrNo.2.10 /////////////////////////////
    @Given("^Initialize browser for click on IN STYLE OF link and click on signup link$")
    public void initialize_browser_for_click_on_in_style_of_link_and_click_on_signup_link() throws Throwable
    {
    	System.out.println("@signupFunctionalitySrNo.2.10");
    	System.out.println("Initialize browser for click on IN STYLE OF link and click on signup link");
    	signup.getSignupLink().click();
    }

    @When("^click on IN STYLE OF$")
    public void click_on_in_style_of() throws Throwable
    {
    	signup.getInstyleofLink().click();
    }

    @Then("^Landed on IN STYLE OF page$")
    public void landed_on_in_style_of_page() throws Throwable
    {
    	String instyleofLink = driver.getTitle();
    	Assert.assertTrue(instyleofLink.toLowerCase().contains("fashion"));
    	System.out.println("Landed on IN STYLE OF page");
    	System.out.println("__________________________________________________________");
    	driver.quit();
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////// @signupFunctionalitySrNo.2.11 /////////////////////////////
    
    
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    			///////////////////////////////////MEN SCENARIO////////////////////////////////////////////
    //@Before(value="@calculateTotalAmount", order=3)
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
	  				System.out.println(mensproduct + " selected");
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
					System.out.println("Successfully clicked on " + mensproductname);
					break;
				}
			}
			
			
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
			    	System.out.println(menssize + " size clicked");
			    	break;
			    }
			}
			Thread.sleep(3000);
			men.getClickOnAddToBag().click();
			Thread.sleep(4000);
			men.getCloseProductPopup().click();
			javascript.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
			System.out.println("__________________________________________________________");
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
  				System.out.println(product + " is selected");
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
    	    	System.out.println(brand + " brand clicked");
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
    			System.out.println(pricerange + " pricerange clicked");
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
    			System.out.println(discount + " discount clicked");
    	
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
				    	System.out.println(menssize + " size selected");
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
    	System.out.println("__________________________________________________________");
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
  				System.out.println(product + " is selected");
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
					System.out.println(productname + " product clicked");
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
	    			System.out.println(size + " size selected");
	    			break;
	    		}
	    	}
	    	Thread.sleep(2000);
	    	women.getClickOnAddToBag().click();
			Thread.sleep(4000);
			women.getCloseProductPopup().click();
			javascript.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
			System.out.println("__________________________________________________________");
			driver.quit();    	
    }
    
    
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
    						//////////////////////WOMEN CATEGORY WITH FILTER//////////////
    
    @Given("^Selection (.+) from women Category$")
    public void selection_from_women_category(String womenfilterproduct) throws Throwable
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
  			if(text.equalsIgnoreCase(womenfilterproduct))
   			{
  				women.getWomenProductLink().get(i).click();
  				break;
   			}
   		}
    	
    	System.out.println(womenfilterproduct + " selected");
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
				System.out.println(womenfilterbrand + " brand selected");
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
				System.out.println(womenfilterpricerange + " pricerange selected");
				Thread.sleep(2000);
				break;
			}
		}
    	
		//System.out.println("clicked on " + womenfilterbrand + " and " + womenfilterpricerange);
 
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
    			System.out.println(womenfilterdiscount + " discount selected");
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
    					System.out.println(womenfilterproductname + " filtered product selected");
    					
    					//SELECT SIZE
    					int sizes = women.getTotalSize().size();
      			    	for(int k=0; k<sizes; k++)
      			    	{
      			    		String Size = women.getSize().get(k).getText();
      			    		if(Size.equalsIgnoreCase(womenfiltersize))
      			    		{
      			    			women.getTotalSize().get(k).click();
      			    			Thread.sleep(3000);
      			    			System.out.println(womenfiltersize + " size selected");
      			    			break;
      			    		}
      			    	}
      			    	Thread.sleep(2000);
      			    	women.getClickOnAddToBag().click();
      					Thread.sleep(4000);
      					women.getCloseProductPopup().click();
      					System.out.println(womenfilterproductname + " product selected");
      					break;
      				}
      				
      			}
      			javascript.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
      			break;  			
       		}
       		}
    	System.out.println("successfully " + womenfilterproductname + " added into cart");
    	System.out.println("__________________________________________________________");
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
    	Thread.sleep(5000);
    	
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
    		try
    		{
    		//WebElement individualItem = cart.getIndividualItem().get(a);
			//javascript.executeScript("arguments[0].scrollIntoView(true);",individualItem);
    		String price = cart.getPrices().get(a).getText();
    		String itemprice = price.substring(1);
    		String item = itemprice.replace(" ", "");
    		//STRING TO INTEGER
    		int priceInt = Integer.parseInt(item);
    		//SUM
    		total =  total + priceInt;	
    		//System.out.println(total);
    		
    			javascript.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    		}
    		catch(Exception e)
    		{
    			System.out.println(e.getStackTrace());
    		}
    	}
    	
    	javascript.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
    	System.out.println("Price of the items are " + total);
    	Thread.sleep(2000);
    	javascript.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
    	
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
    	    	System.out.println("__________________________________________________________");
    	    	driver.quit();
    			
    }  
    
    
    //////////////////@numberOfitemsInCart///////////////////
    
    @Given("^Mousehover on cart$")
    public void mousehover_on_cart() throws Throwable
    {
    	cart = new cart(driver);
    	action = new Actions(driver);
    	javascript = (JavascriptExecutor) driver;
    	Thread.sleep(5000);
    	
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
    		Thread.sleep(2000);
    	}
    	System.out.println("Successfully cleared cart");
    	System.out.println("__________________________________________________________");
    	driver.quit();
    	
    }
    
    
    /*
     add sys out after line number 171
sys out ma add "brand clicked" in line number 252
sys out ma add "pricerange clicked" in line number 227
sys out ma add "discount clicked" in line number 252
     */
    
    
    
    
    
}
