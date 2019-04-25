package sheinTest;


import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CartTest extends BaseTest{
	
	@Test
	public void verifyItemAddedToCart()
	{
		loginPage=homePage.clickloginbutton();
		dashBoardPage=loginPage.validlogin();
        searchresultpage= dashBoardPage.search();
		searchresultpage.addtocart();
		cartpage=searchresultpage.navigateToCart();
		if(cartpage.isCorrectItemAdded())
		{
			assertTrue(true);
		}
		else
		{
			assertTrue(false);
			System.out.println("cart Item not matched");
			
		}
	}
	
	@Test(dependsOnMethods = { "verifyItemAddedToCart" })
	public void verifyItemIsRemoved()
	{
		cartpage.removeItemfromCart();
		
	}
	
}
