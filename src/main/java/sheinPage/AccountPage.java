package sheinPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AccountPage extends BasePage {

	public AccountPage(WebDriver driver) {
		super(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.visibilityOf(signoutbutton));
			wait.until(ExpectedConditions.visibilityOf(submitsearch));			
						
		if (!driver.getCurrentUrl().contains("https://www.shein.in/user/index"))
		{
		      throw new IllegalStateException("Not on Account page");
		 }
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//a[contains(text(),'My ACCOUNT')]")
	protected WebElement myaccount;
	
	@FindBy(xpath="//i[contains(@class,'header2-icon-search')]")
	protected WebElement submitsearch;
	
	
	@FindBy(xpath="//input[@type='search']")
	protected WebElement search;
	
	@FindBy(xpath="//a[@class='she-btn-white']")
	protected WebElement signoutbutton;
	
	public boolean isAccountLinkPresent()
	{	
		
		Assert.assertTrue(myaccount.isDisplayed(), "Account link not present on this page");
		return true;
	}
	
	public boolean isSearchButtonPresent()
	{	
		
		Assert.assertTrue(submitsearch.isEnabled(), "button not enabled");
		return true;
	}
	
	public Searchresultpage searchButton() 
	{
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		submitsearch.click();
		return new Searchresultpage(pageDriver);
	}
	
	
	
}
