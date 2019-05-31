package sheinTest;

import java.io.IOException;

import org.testng.annotations.Test;


public class LoginTest extends BaseTest {
		
	@Test 
	public void verifyValidLogin() throws IOException
	{
		loginPage=homePage.clickloginbutton();
		accountPage=loginPage.validlogin();
	}
}

