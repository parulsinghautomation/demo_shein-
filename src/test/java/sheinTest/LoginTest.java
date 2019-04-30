package sheinTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {
	
	@Test
	public void verifyloginPageTitle() 
	{
		loginPage=homePage.clickloginbutton();
		String actualTitle = testDriver.getTitle();
		String expectedTitle="Sign In";
		try
		{
			Assert.assertEquals(actualTitle, expectedTitle, "Title not matched");
		}
		catch(Exception e) {
			e.printStackTrace();
		
		}
	}
	
	@Test
	public void verifyValidLogin() throws IOException
	{
		loginPage=homePage.clickloginbutton();
		accountPage=loginPage.validlogin();
		System.out.println(" Login Successfully");
	}
	

}
