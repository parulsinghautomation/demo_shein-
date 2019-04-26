package sheinPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashBoardPage extends BasePage {

	public DashBoardPage(WebDriver driver) {
		super(driver);
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.visibilityOf(signoutbutton));
		if (!driver.getCurrentUrl().contains("https://www.shein.in/user/index"))
		{
		      throw new IllegalStateException("Not on DashBoard page");
		 }
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//input[@type='search']")
	protected WebElement search;
	
	@FindBy(xpath="//i[@class='iconfont-critical icon-tubiaozhizuomoban header2-icon-search']")
	protected WebElement submitsearch;
	
	
	@FindBy(xpath="//a[@class='she-btn-white']")
	protected WebElement signoutbutton;
	
	
	public Searchresultpage search()
	{
		
		submitsearch.click();
		return new Searchresultpage(pageDriver);
	}
	
	
	
}
