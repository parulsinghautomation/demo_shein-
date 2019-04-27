package sheinPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage extends BasePage {

	public AccountPage(WebDriver driver) {
		super(driver);
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.visibilityOf(signoutbutton));
		if (!driver.getCurrentUrl().contains("https://www.shein.in/user/index"))
		{
		      throw new IllegalStateException("Not on Account page");
		 }
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//a[contains(text(),'My ACCOUNT')]")
	protected WebElement myaccount;
	
	@FindBy(xpath="//i[@class='iconfont-critical icon-tubiaozhizuomoban header2-icon-search']")
	protected WebElement submitsearch;
	
	
	@FindBy(xpath="//a[@class='she-btn-white']")
	protected WebElement signoutbutton;
	
	public boolean isAccountLinkPresent()
	{
		return myaccount.isDisplayed();
	}
	
	public Searchresultpage searchButton()
	{
		
		submitsearch.click();
		return new Searchresultpage(pageDriver);
	}
	
	
	
}
