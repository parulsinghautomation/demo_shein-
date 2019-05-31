package sheinPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import sheinUtility.configManager;


public class LoginPage extends BasePage  {

	public LoginPage(WebDriver driver) {
		super(driver);
		
		if (!driver.getTitle().equalsIgnoreCase("Sign In"))
		{
		      throw new IllegalStateException("Not on sign in page");
		 }
			}
	
	@FindBy(xpath="//div[@class='j-login-con col-xs-3 col-xs-offset-2']//input[@name='email']")
	protected WebElement Username;
	
	@FindBy(xpath="//div[@class='j-login-con col-xs-3 col-xs-offset-2']//input[@name='password']")
	protected WebElement Password;
	
	
	@FindBy(xpath="//div[@class='sign-in-btn-wrapper']//button[@class='she-btn-black she-btn-l she-btn-block'][contains(text(),'Sign In')]")
	protected WebElement Submitbutton;
	
	
	public AccountPage validlogin()
	{			
		Username.sendKeys(configManager.property.getProperty("username"));
		Password.sendKeys(configManager.property.getProperty("password"));
		Assert.assertTrue(Submitbutton.isDisplayed(),"Unable to find submit button");
		javascriptClick(Submitbutton);
		return new AccountPage(pageDriver);
	
	}

	
}
