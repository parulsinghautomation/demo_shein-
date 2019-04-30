package sheinTest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountTest extends BaseTest 

{
	@Test
	public void verifyAcoountLink() 
	{
		loginPage=homePage.clickloginbutton();
		accountPage=loginPage.validlogin();
		try {
		Assert.assertTrue(accountPage.isAccountLinkPresent(), "Account link not present on this page");
		}
		catch(Exception e) {
			e.printStackTrace();
		
		}
		searchresultpage= accountPage.searchButton();
		
	}
	
}
