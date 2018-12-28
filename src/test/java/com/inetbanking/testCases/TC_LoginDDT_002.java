package com.inetbanking.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass
{
	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd)
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		Logger.info("user name provided");
		lp.setPassword(pwd);
		Logger.info("password provided");
		lp.clickSubmit();
		Thread.sleep(3000);
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			Logger.warn("Login failure");
			
			
			
		}
		else
		{
			Assert.assertTrue(true);
			Logger.info("Login passed");
			Thread.sleep(3000);
			lp.clickLogout();
			driver.switchTo().alert().accept();//close logout alert
		    driver.switchTo().defaultContent();
		
		}
			
		
		
	}
	
	public booleon isAlertPresent()
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}
	@DataProvider(name="LoginData")
	String[][]getData() throws IOException
	{
		String path=System.getProperty("user.dir")+ "/src/est/java/cominetbanking/testData/LoginData (2).xlsx";
		int rownum=XLUtils.getRowCount(path, "sheet1");
		int colcount=XLUtils.getCellCount(path, "sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		for(int i=1;1<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1",i,j);//1,0
				
			}
		return logindata;
		}
			
		
		
		
	}

}
