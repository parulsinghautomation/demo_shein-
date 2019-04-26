package sheinTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import sheinManager.configManager;
import sheinPage.BasePage;
import sheinPage.CartPage;
import sheinPage.DashBoardPage;
import sheinPage.HomePage;
import sheinPage.LoginPage;
import sheinPage.Searchresultpage;


public class BaseTest {

	protected  WebDriver testDriver;
	protected  BasePage basePage;
	protected  HomePage homePage;	
	protected  LoginPage loginPage;
	protected  DashBoardPage dashBoardPage;
	protected  Searchresultpage searchresultpage;
	protected  CartPage cartpage;
	
	@BeforeClass
	public void beforeClass() throws Exception
	{	
		
		configManager.configreader();
		//WebDriverManager.chromedriver().version("73.0.3683.103").setup();
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\parul.singh\\eclipse-workspace\\chromedriver.exe");
		testDriver = new ChromeDriver();	
		testDriver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
		testDriver.manage().window().maximize();
		testDriver.get(configManager.property.getProperty("url"));;
		homePage = new HomePage(testDriver);
	}
	
	@AfterMethod
	public void returntoHomePage() throws Exception
	{
	    homePage.returntoHomePage();
	       
	 }
	
	@AfterClass
	public void afterClass()
	{
		testDriver.quit();
		
	}
	
}
