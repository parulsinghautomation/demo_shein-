package sheinTest;

import org.testng.annotations.Test;

public class AccountTest extends BaseTest 

{
	@Test
	public void verifyAccountLink()
	{
		loginPage=homePage.clickloginbutton();
		accountPage=loginPage.validlogin();
		accountPage.isAccountLinkPresent();
		accountPage.isSearchButtonPresent();
		searchresultPage= accountPage.searchButton();
		
	}
	
}
