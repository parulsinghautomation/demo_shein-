package sheinTest;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HomeTest extends BaseTest {


	@Test
	public void verifycompanylogo()
	{
		Assert.assertTrue(homePage.islogopresent());
		
	}
	
	@Test
	public void verifyloinbutton()
	{
		Assert.assertTrue(homePage.isloginpresent());
	}
	
	@Test
	public void verifymenuoption()
	{
		Assert.assertTrue(homePage.verifyOptions());
	}
	
	@Test
	public void verifyloginpage() throws Exception
	{
		loginPage=homePage.clickloginbutton();
	}
//	
//	@AfterClass 
//	public void returnToHomaPage() {
//	homePage.returntoHomePage(); 
//	}
}
