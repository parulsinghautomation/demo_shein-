package sheinTest;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;

public class CartTest extends BaseTest{
	
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
	public void verifyItemAddedToCart(String itemID)
	{
		searchresultpage.searchItem(itemID);
		searchresultpage.addtocart();
		cartpage=searchresultpage.navigateToCart();
		Assert.assertTrue(cartpage.isItemAddedinCart(itemID), "Selected item is not present in the cart");
		cartpage.continueShopping();
	}
	
	@Test (dependsOnMethods = { "verifyItemAddedToCart" }, dataProvider="itemID")
	public void verifyItemIsRemoved(String itemID)
	{
		homePage.navigateToCart();
		Assert.assertTrue(cartpage.removeItemfromCart(),"Item not removed from cart");
		cartpage.continueShopping();
	}
	
}
