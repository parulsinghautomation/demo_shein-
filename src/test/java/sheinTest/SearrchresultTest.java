package sheinTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearrchresultTest extends BaseTest{
	
	@BeforeClass
	public void verifySearchItem()
	{
		loginPage=homePage.clickloginbutton();
		accountPage=loginPage.validlogin();
        searchresultPage= accountPage.searchButton();
	}
	
	@DataProvider
	public String[] itemID()
	{
		String itemId = "375255";
		String itemId1 = "654595";		
		return new String[] {itemId,itemId1};
	}
		
	@Test(dataProvider="itemID")
	public void verifyItemSearched(String itemID) throws InterruptedException
	{
        searchresultPage.searchItem(itemID);
        searchresultPage.isSearchedItem(itemID);
	
	}

}
