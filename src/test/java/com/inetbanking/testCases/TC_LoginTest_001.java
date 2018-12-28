package com.inetbanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;




public class TC_LoginTest_001 extends BaseClass
{
	@Test
	public void loginTest()
	{
		driver.get(baseUrl);
		Logger.info("URL is opened");
		LoginPage lp= new LoginPage(driver);
		lp.setUserName(username);
		Logger.info("Entered Username");
		
		lp.setUserName(password);
		Logger.info("Entered password");
		
		lp.clickSubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			Logger.info("Login test passed");
		}
		else
		{
			Assert.assertTrue(false);
			Logger.info("Login test failed");
		}
		
		
	}
}

	



