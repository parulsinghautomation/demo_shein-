package sheinTest;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {

	@Test
	public void verifyHomePageDetails() 
	{			
		homePage.islogopresent();
		homePage.isloginpresent();
		homePage.verifyOptions();
		loginPage=homePage.clickloginbutton();
	}
	
}
