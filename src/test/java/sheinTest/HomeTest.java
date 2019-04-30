package sheinTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {


	@Test
	public void verifyHomePageDetails() 
	{
		try {
		Assert.assertTrue(homePage.islogopresent(),"Company Logo not found");
		}
		catch(Exception e) {
			e.printStackTrace();
		
		}
		Assert.assertTrue(homePage.isloginpresent(),"Login button not present");
		try
		{
		Assert.assertTrue(homePage.verifyOptions(),"Menu item not matched");
		}
		catch(Exception e) {
			e.printStackTrace();
		
		}
		loginPage=homePage.clickloginbutton();
	}
	
}
