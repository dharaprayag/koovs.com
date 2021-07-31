package stepDefinations;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
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
	
	@Before(value="@firstScenario,@secondScenario,@womenScenario", order=1)
	@Given("^Initialize browser with chrome and navigate to site$")
    public void initialize_browser_with_chrome_and_navigate_to_site() throws Throwable 
	{
		driver = initilizeDriver();
		driver.get(siteUrl);
		driver.manage().window().maximize();
		login = new Login(driver);
    }
	@Before(value="@firstScenario,@secondScenario,@womenScenario", order=2)
    @When("^click on login link and Fill up Email and Password and click on log in button$")
    public void click_on_login_link_and_Fill_up_Email_and_Password_and_click_on_log_in_button() throws Throwable
    {
		javascript = (JavascriptExecutor) driver;
    	Thread.sleep(5000);    	
    	
    		login.getLoginLink().click();
    		login.getEnterEmail().sendKeys(Email);
        	login.getEnterPassword().sendKeys(Password);
        	login.getAcceptButton().click();
        	javascript.executeScript("scroll(0, 150);");
        	Thread.sleep(4000);
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
    
    ///MENS CATEGORY//////////////////////
    //@FIRST SCENARIO
    //@After(value="@Login")
    @Before(value="@secondScenario",order=3)
	@Given("^Go to Mens category$")
    public void Go_to_Mens_category() throws Throwable 
	{
    	/*INITIALIZE DRIVER
    	driver = initilizeDriver();
		driver.get(siteUrl);
		driver.manage().window().maximize();
		//login = new Login(driver);
		//INITIALIZE DRIVER 
		javascript = (JavascriptExecutor) driver;
		wait = (WebDriverWait) new WebDriverWait(driver, 30);*/
		
    	men = new MenCategory(driver);
		action = new Actions(driver);
		Thread.sleep(3000);
		WebElement menlink = men.getMensCategoryLink1();
		action.moveToElement(menlink).build().perform();
    }
    
    @Before(value="@secondScenario",order=4)
    @When("^Select a shirt Section$")
    public void Select_a_shirt_Section() throws Throwable
    {
		//Thread.sleep(3000);
    	//click on shirt link
    	int count = men.getMenProductsLinksCount().size();		
    	for(int i=0; i<count; i++)
   		{
    		String text =men.getShirtsOrJeansText().get(i).getText();
  			if(text.equalsIgnoreCase(mensProductCategory))
   			{
   				men.getClickOnShirtsOrJeansLink().get(i).click();
   				break;
   			}
   		}
    	
    }
  
    @Then("^Get total number of shirts$")
    public void Get_total_number_of_shirts() throws Throwable 
    {
    	//int loadMoreCount = men.getLoadMoreButtonSize().size();
    	System.out.println("Total number of Shirts are " + men.getTotalShirtOrJeansCount().size());
    	System.out.println("First scenario completed");
    	driver.quit();
    	
    	
    }
    
    
    //SECOND SCENARIO
    @Given("^Select (.+) and mousehover on image, Select size and click on add to bag$")
    public void select_and_mousehover_on_image_select_size_and_click_on_add_to_bag(String shirtName) throws Throwable
    {
    	men = new MenCategory(driver);
    	action = new Actions(driver);
    	int shirtCount = men.getTotalShirtOrJeansCount().size();
		for(int j=0; j<shirtCount; j++)
		{
			
			//CLICK ON LOAD MORE BUTTON
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
			
			String shirtname = men.getShirtOrJeansName().get(j).getText();
			if(shirtname.equalsIgnoreCase(shirtName))
			{
				WebElement mouseHoverOnShirt = men.getMouseHoverOnShirtOrJeans().get(j);
				javascript.executeScript("arguments[0].scrollIntoView(true);",mouseHoverOnShirt);
				action.moveToElement(mouseHoverOnShirt).build().perform();
				men.getAddToCart().get(j).click();
				Thread.sleep(2000);					
			    //SELECT SHIRT SIZE
				int sizes = men.getTotalSize().size();
			    for(int k=0; k<sizes; k++)
			   	{
			   		String Size = men.getSize().get(k).getText();
			   		if(Size.equalsIgnoreCase(shirtSize))
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
    }
	
    @Given("^and (.+) mousehover on image, select size and added into cart$")
    public void and_mousehover_on_image_select_size_and_added_into_cart(String jeans) throws Throwable
    {
    	Thread.sleep(2000);
    	WebElement menlink = men.getMensCategoryLink1();
		action.moveToElement(menlink).build().perform();
		//SELECT JEANS SECTION
		int count = men.getMenProductsLinksCount().size();		
    	for(int i=0; i<count; i++)
   		{
    		String text =men.getShirtsOrJeansText().get(i).getText();
  			if(text.equalsIgnoreCase(mensProductCategory1))
   			{
   				men.getClickOnShirtsOrJeansLink().get(i).click();
   				break;
   			}
   		}
    	//SELECT JEANS
    	int jeansCount = men.getTotalShirtOrJeansCount().size();
		for(int j=0; j<jeansCount; j++)
		{
			String Jeans = men.getShirtOrJeansName().get(j).getText();
			if(Jeans.equalsIgnoreCase(jeans))
			{
				Thread.sleep(3000);
				WebElement mouseHoverOnJeans = men.getMouseHoverOnShirtOrJeans().get(j);
				javascript.executeScript("arguments[0].scrollIntoView(true);",mouseHoverOnJeans);
				action.moveToElement(mouseHoverOnJeans).build().perform();
				men.getAddToCart().get(j).click();
				int sizes = men.getTotalSize().size();
		    	for(int k=0; k<sizes; k++)
		    	{
		    		String Size = men.getSize().get(k).getText();
		    		if(Size.equalsIgnoreCase(jeansSize))
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
    	
    }

    @When("^Mousehover on cart$")
    public void mousehover_on_cart() throws Throwable
    {
    	WebElement mouseHoverOncart = men.getMouseHoverOnCart();
    	action.moveToElement(mouseHoverOncart).build().perform();	
    }
    
    @Then("^Check number of items added into cart and badge digit are equal$")
    public void check_number_of_items_added_into_cart_and_badge_digit_are_equal() throws Throwable
    {
    	String badgeText = men.getBadgeDigit().getText();
    	System.out.println("Badge number is " + badgeText);
    	int numberOfItemsInCart = men.getNumberOfItemsInCart().size();
    	System.out.println("Total Numbers of added items are " + numberOfItemsInCart);
    	
    	Assert.assertEquals(badgeText, Integer.toString(numberOfItemsInCart));
    	//Assert.assertTrue(true, budge);
    	
    	System.out.println("Second scenario completed");
    	driver.quit();
    }
    
    //WOMEN CATEGORY
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

    @When("^MouseHover On cart$")
    public void MouseHover_On_cart() throws Throwable 
    {
        
    }

    @Then("^Verify number of items added into cart and badge digit are equal$")
    public void Verify_number_of_items_added_into_cart_and_badge_digit_are_equal() throws Throwable
    {
    	
    }
    
}
