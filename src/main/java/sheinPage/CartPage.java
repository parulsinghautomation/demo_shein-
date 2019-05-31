package sheinPage;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;



public class CartPage extends BasePage{

	public CartPage(WebDriver driver) {
		super(driver);
		 if (!driver.getTitle().contains("Shopping Bag")){
		      throw new IllegalStateException("Not on cart page");
		    }
		}	
		
	@FindBy(xpath="//div[@class='j-vue-bag c-vue-bag']/div/div[1]/div[2]/div[1]/div[1]")
	protected WebElement confirmationWidget;
		
	@FindBy(xpath="//a[contains(text(),'Delete')]")
	protected WebElement deleteButton;
	
	@FindBy(xpath="//button[@class='she-btn-black'][contains(text(),'YES')]")
	protected WebElement yesButton;
	
	@FindBy(xpath="//a[@class='right-link j-continue-shopping']")
	protected WebElement continueShopLink;
	
	@FindBy(xpath="//a[contains(@href,'logout')]")
	protected WebElement logout;
	
	@FindBy(xpath="//div[@class=\"empty-bag j-empty-bag\"]")
	protected WebElement emptyCart;
	
	@FindBy(xpath ="//table/tbody/tr[@sku]")
	private List<WebElement> results;
	
	protected String resultUrl="./td/div[2]/div/a";
	
	
   public void isItemAddedinCart(String item) {
	boolean found = false;
	   for(WebElement eachresult :  results ){
		  if(eachresult.findElement(By.xpath(resultUrl)).getAttribute("href").contains(item)) { 
			 found = true;
			 }
		  }
	   	Assert.assertTrue(found,"Item not in cart"); 
   }
	
	public void continueShopping()
	{		
		continueShopLink.click();
	}
	
	public void removeItemfromCart() throws InterruptedException
	{ 
		deleteButton.click();
		yesButton.click();
		Thread.sleep(2000);
	}

	public boolean isCartEmpty()
	{
	try	{		
		if(emptyCart.isDisplayed())
		{throw new Exception("Cart is not empty");}
		return true; }
	catch(Exception e)
		{
		e.printStackTrace();
		return false;	}
	}
}

	