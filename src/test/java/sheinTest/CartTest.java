package sheinTest;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CartTest extends BaseTest{
	
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
		String itemId = "654595";
		String itemId1 = "375255";
		
	return new String[] {itemId,itemId1};
	}
	
	@Test(dataProvider="itemID")
	public void verifyItemAddedToCart(String itemID) throws InterruptedException 
	{
		searchresultPage.searchItem(itemID);
		searchresultPage.addtocart();
		cartPage=searchresultPage.navigateToCart();		
		cartPage.isItemAddedinCart(itemID);
		cartPage.continueShopping();
						
	}
	
	@Test (dependsOnMethods = { "verifyItemAddedToCart" }, dataProvider="itemID")
	public void verifyItemIsRemoved(String item) throws InterruptedException
	{
		homePage.navigateToCart();
		cartPage.removeItemfromCart();
		cartPage.continueShopping();
	}	
	
	@Test(dependsOnMethods = { "verifyItemIsRemoved" })
	public void verifyCartIsEmpty()
	{
		homePage.navigateToCart();
		cartPage.isCartEmpty();
		cartPage.continueShopping();
	}
	

}
