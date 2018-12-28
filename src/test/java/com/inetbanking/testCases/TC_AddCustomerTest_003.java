package com.inetbanking.testCases;

import org.junit.Assert;
import org.junit.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003  extends BaseClass

{
    @Test 
	public void addNewCustomer() throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		Logger.info("User name is provided");
		lp.setPassword(password);
		Logger.info("pwd provided");

		lp.clickSubmit();
		Thread.sleep(3000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		addcust.clickAddNewCustomer();
		Logger.info("provide cust details");

		addcust.custName("Paven");
		addcust.custgender("male");
		addcust.custdob("10", "15", "1985");
		Thread.sleep(3000);
		addcust.custaddress("INDIA");
		addcust.custcity("HYD");
		addcust.custstate("AP");
		addcust.custpinno("50000074");
		addcust.custtelephoneno("987890091");
		
		String email=randomestring()+"gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		Thread.sleep(3000);
		
		Logger.info("validation started");

		
		boolean res=driver.getPageSource().contains("customer registered success");
		
		if (res==true)
		{
			Assert.assertTrue(true);
			Logger.info("test case passed");

			
		}
		else
		{
			Logger.info("test case failed");

			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
			
		
	}
    
    //create user define function to create random email address
    
    public String randomestring()
    {
    	String generatedstring=RandomStringUtils.randomAlphabetic(8);
    	return(generatedstring);
    }
    
    public String randomeNum()
    {
    	String generatedstring2=RandomStringUtils.randomNumeric(4);
    	return(generatedstring2);
    }


    
}
