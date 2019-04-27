package sheinTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import sheinPage.BasePage;
import sheinPage.CartPage;
import sheinPage.AccountPage;
import sheinPage.HomePage;
import sheinPage.LoginPage;
import sheinPage.Searchresultpage;
import sheinUtility.WebEventListener;
import sheinUtility.configManager;


public class BaseTest {

	protected  WebDriver testDriver;
	protected  BasePage basePage;
	protected  HomePage homePage;	
	protected  LoginPage loginPage;
	protected  AccountPage accountPage;
	protected  Searchresultpage searchresultpage;
	protected  CartPage cartpage;
	
	@BeforeClass(alwaysRun=true)
	public void beforeClass() throws Exception
	{	
		
		configManager.configreader();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		//WebDriverManager.chromedriver().version("73.0.3683.103").setup();
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\parul.singh\\eclipse-workspace\\chromedriver.exe");
		testDriver = new ChromeDriver(options);	
		EventFiringWebDriver event_driver = new EventFiringWebDriver(testDriver);
		WebEventListener eventlistner = new WebEventListener(event_driver);
		event_driver.register(eventlistner);
		testDriver = event_driver;	
		
		testDriver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
		testDriver.manage().window().maximize();
		testDriver.get(configManager.property.getProperty("url"));;
		homePage = new HomePage(testDriver);
	}
	
	@AfterMethod(alwaysRun=true)
	public void returntoHomePage() throws Exception
	{
	    homePage.returntoHomePage();
	       
	 }
	
	@AfterClass(alwaysRun=true)
	public void afterClass()
	{
		testDriver.quit();
		
	}
	
}
