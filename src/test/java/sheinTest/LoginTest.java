package sheinTest;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Test;


public class LoginTest extends BaseTest {
	
	@Test
	public void verifyloginpagetitle()
	{
		loginPage=homePage.clickloginbutton();
		String actualTitle = testDriver.getTitle();
		String expectedTitle="Sign In";
		assertEquals(actualTitle, expectedTitle);
		System.out.println("Title matched Successfully");
	}
	
	@Test
	public void verifyvalidlogin() throws IOException
	{
		
		dashBoardPage=loginPage.validlogin();
		System.out.println(" Login Successfully");
	}
	

}
