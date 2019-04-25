package sheinTest;


import org.testng.annotations.Test;


public class HomeTest extends BaseTest {


	@Test
	public void verifycompanylogo()
	{
		homePage.islogopresent();
		
	}
	
	@Test
	public void verifyloinbutton()
	{
		homePage.isloginpresent();		
	}
	
	@Test
	public void verifymenuoption()
	{
		homePage.Verifyoptions();
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
