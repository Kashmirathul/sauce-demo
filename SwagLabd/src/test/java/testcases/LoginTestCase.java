package testcases;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test; 
import pages.LoginPage;
import utility.ExcelUtility;
import utility.BaseClass;

public class LoginTestCase {
	public class LoginTestCases extends BaseClass {
		
		@DataProvider
		Object getInfo() throws IOException
		{
			String path = "E:\\Eclips work\\SwagLabd\\resources\\Data.xlsx";
			ExcelUtility read = new ExcelUtility(path);
		    int row=	read.getRowCount("login");
		    int cols=	read.getCellCount("login", row);
		    Object info[][]= new Object[row][cols];

		    for(int i=1;i<=row;i++)
		    {
		    	
		    	 for(int j=0;j<cols;j++)
		 	    {
		 	    	info[i-1][j]=read.getCellData("login", i, j);
		 	    	
		 	    	
		 	    }
		    }
		    
		

		    return info;
			
		}
		
	
		@Test
		void verifyvalidUser()
		{
			driver.get(url);
			LoginPage login  = new LoginPage(driver);
			login.setUserName(global_username);
			login.setPassword(global_password);
			login.clickButton(); 	   
		
     }
		@Test(dataProvider = "getInfo" ,description = "Login negative")
		void verifyInValidUser(String user, String pass)
		{
			
			driver.get("https://www.saucedemo.com/");
			LoginPage login  = new LoginPage(driver);
			login.setUserName(user);
			login.setPassword(pass);
			login.clickButton(); 	
			
		
		}
	}
}

