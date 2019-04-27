package sheinPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import sheinManager.configManager;


public class LoginPage extends BasePage  {

	public LoginPage(WebDriver driver) {
		super(driver);
		if (!driver.getTitle().contains("Sign"))
		{
		      throw new IllegalStateException("Not on Sign In page");
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
		Submitbutton.click();
		return new AccountPage(pageDriver);
	
	}

	
}
