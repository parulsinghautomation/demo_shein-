package sheinTest;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountTest extends BaseTest 

{
	@Test
	public void verifyAcoountLink() throws IOException	
	{
		loginPage=homePage.clickloginbutton();
		accountPage=loginPage.validlogin();
		Assert.assertTrue(accountPage.isAccountLinkPresent(), "Account link not present on this page");
		searchresultpage= accountPage.searchButton();
		
	}
	

}
