package sheinTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;


public class SearrchresultTest extends BaseTest{
	
	@BeforeClass
	public void verifySearchItem()
	{
		loginPage=homePage.clickloginbutton();
		accountPage=loginPage.validlogin();
        searchresultpage= accountPage.searchButton();
	}
	
	@DataProvider
	public String[] itemID()
	{
		String itemId = "375255";
		String itemId1 = "654595";		
		return new String[] {itemId,itemId1};
	}
		
	@Test(dataProvider="itemID")
	public void verifyItemSearched(String itemID)
	{
        searchresultpage.searchItem(itemID);
        try
        {
        Assert.assertTrue(searchresultpage.isSearchedItem(itemID));
	}
        catch(Exception e) {
			e.printStackTrace();
		
		}
	}

}
