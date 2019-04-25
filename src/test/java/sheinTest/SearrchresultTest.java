package sheinTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class SearrchresultTest extends BaseTest{
	
	@DataProvider
	public String[] itemID()
	{
		String itemId = "375255";
		return new String[] {itemId};
	}
	
	@Test(dataProvider="itemID")
	public void verifySelectItem(String itemID)
	{
		loginPage=homePage.clickloginbutton();
		dashBoardPage=loginPage.validlogin();
        searchresultpage= dashBoardPage.search();
        searchresultpage.searchItem(itemID);
		searchresultpage.addtocart();
		System.out.println("Item selected sucessfully");
		cartpage=searchresultpage.navigateToCart();
		
	}

}
