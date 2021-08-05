package PageObjects;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Resources.base;

public class MenCategory extends base
{
	By menLink = By.xpath("//a[@href='/men']");
	By linksCount = By.xpath("//*[@id='app']/div/div/div/div[1]/div[2]/div/div/div/div/div[2]/div[1]/div/div/ul/li[1]");
	By menProductsLinksCount = By.xpath("//*[@class='header_menu_Title']/li[1]/div/ul[1]/li[3]/div/ul/li");
	By shirtsOrJeansText = By.xpath("//*[@class='header_menu_Title']/li[1]/div/ul[1]/li[3]/div/ul/li");
	By clickOnShirtsOrJeansLink = By.xpath("//*[@class='header_menu_Title']/li[1]/div/ul[1]/li[3]/div/ul/li/a");
	By shirtsCount = By.xpath("//*[@id='prodBox']/li");
	By loadMoreButton = By.xpath("//*[@id='loadMoreList']");
	By totalShirtOrJeansCount = By.xpath("//div[@class='row-base']/div[2]/ul/li");
	By viewAllButton = By.xpath("//div[@id='filterRow']/div[4]/div");
	By numberOfBrands = By.xpath("//div[@id='viewAll']/div[2]/div");
	By brandName = By.xpath("//div[@id='viewAll']/div[2]/div/label/span[1]");
	By clickOnApplyButtonInSelectBrand = By.xpath("//div[@id='viewAll']/div[3]/div[2]");
	By numberOfColors = By.xpath("//div[@id='filterRow']/div[6]/ul/li");
	By colorName = By.xpath("//div[@id='filterRow']/div[6]/ul/li/label/span[1]	");
	By clickOnColor = By.xpath("//div[@id='filterView']/div/div[6]/ul/li/label/div");
	By priceRanges = By.xpath("//div[@id='filterView']/div/div[8]/ul/li");
	By priceRange = By.xpath("//div[@id='filterView']/div/div[8]/ul/li/label/span[1]");
	By clickOnPriceRangeCheckbox = By.xpath("//div[@id='filterView']/div/div[8]/ul/li/label/div");
	By shirtOrJeansName = By.xpath("//*[@id='prodBox']/li/div[3]/a/div[4]/span[2]");
	By mouseHoverOnShirtOrJeans = By.xpath("//*[@id='prodBox']/li/div[3]");
	By clickOnAddToCart = By.xpath("//*[@id='prodBox']/li/div[3]/a/div[3]/div[1]/button[1]");
	By totalSize = By.xpath("//*[@class='size-lists']/div");
	By size = By.xpath("//*[@class='size-lists']/div/span");
	By clickOnAddToBag = By.xpath("//div[@class='pd-right-side']/div[3]/div/button[1]");
	By closeProductPopup =By.xpath("//div[@class='modal-content-wrap']/span");
	By mouseHoverOnCart = By.xpath("//*[@class='header__wishlist-bag']/div[2]/a/div");
	By badgeDigit = By.xpath("//span[@id='cart_total_items']");
	By numberOfItemsInCart = By.xpath("//div[@id='hcartItems']/div[1]/div[2]/div/div");
	By brands = By.xpath("//div[@id='viewAll']/div[2]/div");
	By brandText = By.xpath("//div[@id='viewAll']/div[2]/div/label/span[1]");
	By brandCheckBox = By.xpath("//div[@id='viewAll']/div[2]/div/label/div");
	By discounts = By.xpath("//div[@id='filterRow']/div[10]/ul/li");
	By discountText = By.xpath("//div[@id='filterRow']/div[10]/ul/li/label/span[1]");
	By discountCheckBox = By.xpath("//div[@id='filterRow']/div[10]/ul/li/label/div");
	By colorSection = By.xpath("//div[@id='filterRow']/div[5]");
	By priceRangeSection = By.xpath("//div[@id='filterRow']/div[7]");
	By discountSection = By.xpath("//div[@id='filterRow']/div[9]");
	By sections = By.xpath("//div[@class='brand-menu']/ul/li");
	By sectionText = By.xpath("//div[@class='brand-menu']/ul/li/a");
	
	private Random randomGenerator;
    private ArrayList<String> catalogue;
    
	public MenCategory(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		
		this.driver = driver;
		//PAGE FACTORY
		PageFactory.initElements(driver, this);
	}
	public String getRandomEmail()
    {
		catalogue = new ArrayList<String>();
		//catalogue.add("dharagharshendiya@gmail.com");
		catalogue.add("dharapatel80085@gmail.com");
        randomGenerator = new Random();
        int index = randomGenerator.nextInt(catalogue.size());
        String item = catalogue.get(index);
        System.out.println("Managers choice this week" + item + "our recommendation to you");
        return item;
    }
	public List<WebElement> getSections()
	{
		 return driver.findElements(sections);
	}
	public List<WebElement> getSectionLink()
	{
		 return driver.findElements(sectionText);
	}
	public List<WebElement> getSectionText()
	{
		 return driver.findElements(sectionText);
	}
	public WebElement getColorSection()
	{
		 return driver.findElement(colorSection);
	}
	public WebElement getDiscountSection()
	{
		 return driver.findElement(discountSection);
	}
	public WebElement getPriceRangeSection()
	{
		 return driver.findElement(priceRangeSection);
	}
	public List<WebElement> getTotalSize()
	{
		 return driver.findElements(totalSize);
	}
	public List<WebElement> getDiscountCheckBox()
	{
		 return driver.findElements(discountCheckBox);
	}
	public List<WebElement> getDiscountText()
	{
		 return driver.findElements(discountText);
	}
	public List<WebElement> getDiscounts()
	{
		 return driver.findElements(discounts);
	}
	public List<WebElement> getBrandCheckBox()
	{
		 return driver.findElements(brandCheckBox);
	}
	public List<WebElement> getBrands()
	{
		 return driver.findElements(brands);
	}
	public List<WebElement> getBrandText()
	{
		 return driver.findElements(brandText);
	}
	public List<WebElement> getNumberOfItemsInCart()
	{
		 return driver.findElements(numberOfItemsInCart);
	}
	public List<WebElement> getSize()
	{
		 return driver.findElements(size);
	}
	public WebElement getBadgeDigit()
	{
		 return driver.findElement(badgeDigit);
	}
	public WebElement getMouseHoverOnCart()
	{
		 return driver.findElement(mouseHoverOnCart);
	}
	public WebElement getCloseProductPopup()
	{
		 return driver.findElement(closeProductPopup);
	}
	public List<WebElement> getMouseHoverOnShirtOrJeans()
	{
		 return driver.findElements(mouseHoverOnShirtOrJeans);
	}
	public List<WebElement> getAddToCart()
	{
		 return driver.findElements(clickOnAddToCart);
	}
	public WebElement getClickOnAddToCart()
	{
		 return driver.findElement(clickOnAddToCart);
	}
	public WebElement getClickOnAddToBag()
	{
		 return driver.findElement(clickOnAddToBag);
	}
	public WebElement getClickOnApplyButton()
	{
		 return driver.findElement(clickOnApplyButtonInSelectBrand);
	}
	public List<WebElement> getShirtOrJeansName()
	{
		 return driver.findElements(shirtOrJeansName);
	}
	public List<WebElement> getClickOnPriceRangeCheckbox()
	{
		 return driver.findElements(clickOnPriceRangeCheckbox);
	}
	public List<WebElement> getClickOnColor()
	{
		 return driver.findElements(clickOnColor);
	}
	public List<WebElement> getPriceRange()
	{
		 return driver.findElements(priceRange);
	}
	public List<WebElement> getPriceRanges()
	{
		 return driver.findElements(priceRanges);
	}	
	public List<WebElement> getNumberOfColors()
	{
		 return driver.findElements(numberOfColors);
	}
	public WebElement getColorsName()
	{
		 return driver.findElement(colorName);
	}
	public List<WebElement> getColorName()
	{
		 return driver.findElements(colorName);
	}
	public List<WebElement> getBrandName()
	{
		 return driver.findElements(brandName);
	}
	public WebElement getViewAllButton()
	{
		 return driver.findElement(viewAllButton);
	}
	public WebElement getMenLink()
	{
		 return driver.findElement(menLink);
	}
	public WebElement getLoadMoreButton()
	{
		 return driver.findElement(loadMoreButton);
	}
	public List<WebElement> getLoadMoreButtonSize()
	{
		 return driver.findElements(loadMoreButton);
	}
	public List<WebElement> getNumberOfBrands()
	{
		 return driver.findElements(numberOfBrands);
	}
	public List<WebElement> getTotalShirtOrJeansCount()
	{
		 return driver.findElements(totalShirtOrJeansCount);
	}
	public List<WebElement> getLinksCount()
	{
		 return driver.findElements(linksCount);
	}
	
	public List<WebElement> getShirtsCount()
	{
		 return driver.findElements(shirtsCount);
	}
	public List<WebElement> getMenProductsLinksCount()
	{
		 return driver.findElements(menProductsLinksCount);
	}
	public List<WebElement> getShirtsOrJeansText()
	{
		 return driver.findElements(shirtsOrJeansText);
	}
	public List<WebElement> getClickOnShirtsOrJeansLink()
	{
		 return driver.findElements(clickOnShirtsOrJeansLink);
	}
	public WebElement getMensCategoryLink()
	{
	return driver.findElement(menLink);
	}
	
}
