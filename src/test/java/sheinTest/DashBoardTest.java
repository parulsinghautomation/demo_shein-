package sheinTest;

import java.io.IOException;
import org.testng.annotations.Test;

public class DashBoardTest extends BaseTest 

{
	@Test
	public void verifysubmitsearch() throws IOException	
	{
		loginPage=homePage.clickloginbutton();
		dashBoardPage=loginPage.validlogin();
		searchresultpage= dashBoardPage.search();
		System.out.println("Search Successfully");
	}
	

}
