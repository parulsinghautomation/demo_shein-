package sheinPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);		
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.visibilityOfAllElements(options));
		if (!driver.getCurrentUrl().contains("https://www.shein.in/"))
			//	getTitle().contains("Shop Women's Clothing, Shoes, Bags & more online | SHEIN IN"))
				
		{
		      throw new IllegalStateException("Not on Home page");
		 }
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath ="//*[@class='iconfont-critical icon-sheinlogo']")
	//@FindBy(partialLinkText = "")
	protected WebElement HomeLogo;
	
	@FindBy(xpath = "//i[@class='iconfont-critical icon-yonghuicon-']")
	protected WebElement LoginButton;
	
	@FindBy(xpath = "//i[@class='iconfont-critical icon-yonghuicon-']")
	protected WebElement options;
	
	@FindBy(xpath="//div[@class='c-coupon-box']/i[contains(@class,'she-close')]")
	protected WebElement coupon;
	
	public boolean islogopresent() 
	{
		Boolean logo= HomeLogo.isDisplayed();
		Assert.assertTrue(logo,"Company Logo not found");
		return  logo;
	}
	
	public boolean isloginpresent() 
	{
		Assert.assertTrue(LoginButton.isDisplayed(),"Login button not present");
		return LoginButton.isDisplayed();
	}
	
	public boolean isPromotionDisplayed()
	{
		return coupon.isDisplayed();
	}
	
	public void closePromotion()
	{
		javascriptClick(coupon);				
	}
	
	public void verifyOptions()
	{		
		Actions act = new Actions(pageDriver);
		act.moveToElement(options).build().perform();
		
		String expected1 = "Sign in/Register;My Orders;My Message;My Tickets;My Wallet;My Wishlist;My Address Book;My Design;Free Trial Report;Gift Card;My Points";
		List<String> expected2 = new ArrayList<>(Arrays.asList(expected1.split(";")));		
		List<WebElement> actualallOptions = pageDriver.findElements(By.xpath("//div[contains(@class,'nologin-user-dropdown')]//a"));
		List<String> actualdropdownvalues=new ArrayList<>();
		for(WebElement eachdropdownvalue: actualallOptions)
		{
			actualdropdownvalues.add(eachdropdownvalue.getText());
		}		
		actualdropdownvalues.removeAll(Arrays.asList(null,""));
		Assert.assertEquals(actualdropdownvalues, expected2,"Menu item not matched");
	}
		
	public LoginPage clickloginbutton()	
	{ 
			LoginButton.click();
			return new LoginPage(pageDriver);
	}
	
}
