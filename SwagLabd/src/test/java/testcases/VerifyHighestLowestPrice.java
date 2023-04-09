package testcases;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ProductPricePage;
import utility.BaseClass;

public class VerifyHighestLowestPrice extends BaseClass
 {
	 
@Test
	void verifyHighestPrice() throws InterruptedException
	
	{
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 driver.get(url);
	 LoginPage login  = new LoginPage(driver);
	 login.setUserName(global_username);
	 login.setPassword(global_password);
	 login.clickButton();
	 ProductPricePage productPricePage=new ProductPricePage(driver);
		Assert.assertEquals(productPricePage.getProductLable(),true);
		
		List<WebElement> val =productPricePage.getValue();

		float arr[] =  new float[val.size()];
	    int count=0;
		Iterator itr =  val.iterator();
        while (itr.hasNext()) 
        {
        String str=  new String(((WebElement) itr.next()).getText());
		arr[count] = Float.parseFloat((str).substring(1));
		System.out.println("========"+arr[count]);
		count++;
		
        }
        
        float max = arr[0];
		
		 for (int i = 1; i < arr.length; i++)
		 {
	            if (arr[i] > max)
	                max = arr[i];
	         
	       
	    }
		 System.out.println(max);
 }
   
   
		// find the highest 
		
	
	
	
	@Test(enabled=true)
	void verifyLowestPrice() throws InterruptedException
	{
		driver.get("https://www.saucedemo.com/");
		LoginPage login = new LoginPage(driver);
		login.setUserName("standard_user");
		login.setPassword("secret_sauce");
		login.clickButton();
		Thread.sleep(3000);
		ProductPricePage productPricePage = new ProductPricePage(driver);
		List<WebElement> val =productPricePage.getValue();

 
	
	// find the lowest
	float arr[] =  new float[val.size()];
    int count=0;
	Iterator itr =  val.iterator();
    while (itr.hasNext()) 
    {
    String str=  new String(((WebElement) itr.next()).getText());
	arr[count] = Float.parseFloat((str).substring(1));
	System.out.println("========"+arr[count]);
	count++;
	
    }
    
    float min = arr[0];
	
	 for (int i = 1; i < arr.length; i++)
	 {
            if (arr[i] < min)
                min = arr[i];
         
       
    }
	 System.out.println(min);
 }
   
	}
	
