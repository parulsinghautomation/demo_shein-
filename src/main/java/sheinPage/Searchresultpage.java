package sheinPage;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import org.testng.Assert;

public class Searchresultpage extends BasePage{

	public Searchresultpage(WebDriver driver) {
		super(driver);
//		WebDriverWait wait = new WebDriverWait(driver, 100);
//		wait.until(ExpectedConditions.visibilityOf(product));
		if (!driver.getTitle().contains("Search"))
		{
		      throw new IllegalStateException("Not on Search page");
		 }			
		}

	@FindBy(xpath ="//div[contains(@class,'gds-li-ratiowrap')]//img[contains(@class,'j-verlok-lazy loaded')]")
	protected WebElement itemImage;
	
	@FindBy(xpath="//input[@type='search']")
	protected WebElement search;
	
	@FindBy(xpath="//i[@class='iconfont-critical icon-tubiaozhizuomoban header2-icon-search']")
	protected WebElement submitsearch;
	
	@FindBy(xpath ="//button[contains(@class,'btn-add-to-bag')]")
	protected WebElement item;
	
	@FindBy(xpath ="//label[3]//span[1]")
	protected WebElement size;
	
	@FindBy(xpath ="(//button[contains(text(),'Submit')])[1]")
	protected WebElement selectitem;
	
	
	@FindBy(xpath ="//i[contains(@class,'iconfont-critical icon-gouwudai')]")
	protected WebElement addcartbutton;
	
	@FindBy(xpath ="//span[@class='header-sum']")
	protected WebElement product;
		
	
	@FindBy(xpath ="//i[contains(@class,'iconfont-critical icon-gouwudai')]")
	protected WebElement Cartbutton;
	

	@FindBy(xpath ="//a[@data-id]")
	private WebElement results;
	
	
   public boolean isSearchedItem(String item) {
	   	 Assert.assertTrue(results.getAttribute("data-id").contains(item) , item + "Found");
		 return true;}
	
	public void searchItem(String itemID) throws InterruptedException
	{
		search.clear();
		search.sendKeys(itemID);
		javascriptClick(submitsearch);
		Thread.sleep(1000);
	}
	
	public void addtocart() throws InterruptedException
	{
		Actions act = new Actions(pageDriver);
		Thread.sleep(3000);
		for(int i=0;i<=5;i++) {
			act.moveToElement(itemImage).perform();
			try {
				item.click();
				break;
				
			} catch (ElementNotInteractableException e) {
				Thread.sleep(2000);
				continue;
			}
		}
		
//		javascriptMoveToElement(itemImage);
		size.click();
		selectitem.click();
	}

	public CartPage navigateToCart()
	{
		Cartbutton.click();
		return new CartPage(pageDriver);
	}
		
}
