package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
    
	@Test(groups={"Sanity","Master"})
	public void verify_login() {
		logger.info("*****Starting TC002_LoginTest*****");
		
		try {
		//HomePage
		HomePage hp=new HomePage(driver);
		
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount Link..");
		
		hp.clickLogin();
		logger.info("Clicked on Login Link..");
		
		//LoginPage
		LoginPage lp=new LoginPage(driver);
		
		lp.setEmail(p.getProperty("email"));
		logger.info("Entered Valid Email..");
		
		lp.setPassword(p.getProperty("password"));
		logger.info("Entered Valid Password..");
		
		lp.clickLogin();
		logger.info("Clicked on Login Button..");
		
		//MyAccountPage
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetPage=macc.isMyAccountPageExists();
		
		logger.info("Validating Target Page..");
		Assert.assertTrue(targetPage); //Assert.assertEquals(targetPage, true,"Login failed");
		}catch(Exception e) {
			logger.error("Test failed..");
			logger.debug("Debug logs..");
			Assert.fail();
		}
		
		logger.info("*****Finished TC002_LoginTest*****");
	}
}
