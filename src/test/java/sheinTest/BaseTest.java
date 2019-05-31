package sheinTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.*;



import io.github.bonigarcia.wdm.WebDriverManager;
import sheinPage.BasePage;
import sheinPage.CartPage;
import sheinPage.AccountPage;
import sheinPage.HomePage;
import sheinPage.LoginPage;
import sheinPage.Searchresultpage;
import sheinUtility.ExtentReport;
import sheinUtility.WebEventListener;
import sheinUtility.configManager;


public class BaseTest {

	protected  WebDriver testDriver;
	protected  BasePage basePage;
	protected  HomePage homePage;	
	protected  LoginPage loginPage;
	protected  AccountPage accountPage;
	protected  Searchresultpage searchresultPage;
	protected  CartPage cartPage;
	
	@BeforeClass(alwaysRun=true)
	public void beforeClass() throws Exception
	{	
		configManager.configreader();
		String browserName = configManager.property.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			//WebDriverManager.chromedriver().version("73.0.3683.103").setup();
			WebDriverManager.chromedriver().ignoreVersions("75.0.3770.8").setup();
			//System.setProperty("webdriver.chrome.driver","C:\\Users\\parul.singh\\eclipse-workspace\\chromedriver.exe");
			testDriver = new ChromeDriver(options);	
		}
		else if(browserName.equals("ff"))
		{
			WebDriverManager.firefoxdriver().setup();
			//System.setProperty("webdriver.gecko.driver","C:\\Users\\parul.singh\\eclipse-workspace\\geckodriver.exe");
			FirefoxOptions option = new FirefoxOptions();
			option.addPreference("dom.webnotifications.enabled", false);
			testDriver = new FirefoxDriver(option);
		}
					
		EventFiringWebDriver event_driver = new EventFiringWebDriver(testDriver);
		WebEventListener eventlistner = new WebEventListener(event_driver);
		event_driver.register(eventlistner);
		testDriver = event_driver;			
		
		//testDriver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		testDriver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
		testDriver.manage().window().maximize();
		testDriver.get(configManager.property.getProperty("url"));
		homePage = new HomePage(testDriver);
	}
	
	
	@BeforeSuite(alwaysRun=true)
	public void suiteTest()	
	{
		
		ExtentReport.getInstance();
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
