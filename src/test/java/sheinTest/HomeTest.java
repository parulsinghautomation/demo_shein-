package sheinTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {


	@Test
	public void verifyHomePageDetails()
	{
		Assert.assertTrue(homePage.islogopresent(),"Company Logo not found");
		Assert.assertTrue(homePage.isloginpresent(),"Login button not present");
		Assert.assertTrue(homePage.verifyOptions(),"Menu item not matched");
		loginPage=homePage.clickloginbutton();
	}
	
}
