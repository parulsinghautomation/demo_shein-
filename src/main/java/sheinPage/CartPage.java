package sheinPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class CartPage extends BasePage{

	public CartPage(WebDriver driver) {
		super(driver);
		 if (!driver.getTitle().contains("Shopping Bag")){
		      throw new IllegalStateException("Not on cart page");
		    }
		}
	
	@FindBy(xpath="//a[contains(@href,'375255')]")
	protected WebElement cartItemlink;
	
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
	
	public boolean isCorrectItemAdded()
	
	{
		return cartItemlink.isDisplayed();
	}
	
	public void removeItemfromCart()
	{
		
		deleteButton.click();
		javascriptClick(yesButton);
		javascriptClick(continueShopLink);
	

	}
}


	