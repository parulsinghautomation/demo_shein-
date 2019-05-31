package sheinPage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
	protected WebDriver pageDriver;
	
	@FindBy(xpath="//a[@href='https://www.shein.in']")
	protected WebElement home;
	
	@FindBy(xpath = "//i[@class='iconfont-critical icon-yonghuicon-']")
	protected WebElement options;
	
	@FindBy(xpath="//a[contains(@href,'logout')]")
	protected WebElement logout;
	

	@FindBy(xpath ="//i[contains(@class,'iconfont-critical icon-gouwudai')]")
	protected WebElement Cartbutton;
	
	
	//Initializing the Page objects
	public BasePage(WebDriver driver)
	{
		pageDriver= driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 25), this);
	}

	public void javascriptClick(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(pageDriver, 200);
		wait.until(ExpectedConditions.visibilityOf(element));
			
		try {
		JavascriptExecutor executor = (JavascriptExecutor)pageDriver;
		executor.executeScript("arguments[0].click()", element);}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void javascriptMoveToElement(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(pageDriver, 200);
		wait.until(ExpectedConditions.visibilityOf(element));
			
		try {
		JavascriptExecutor executor = (JavascriptExecutor)pageDriver;
		executor.executeScript("arguments[0].scrollIntoView(true);", element);}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public CartPage navigateToCart()
	{	
		Cartbutton.click();
		return new CartPage(pageDriver);
		
	}
	public HomePage returntoHomePage() 
	{
		home.click();
		return new HomePage(pageDriver);
	}
	
}
	


