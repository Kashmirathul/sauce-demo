package testcases;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ProductDisplay;
import utility.BaseClass;
public class ProductDisplayTest extends BaseClass {

	
	@Test (description = "verifying sauce labs backpack Title by clicking image and name")
	void displaySauceProduct()
	{
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get(url);
	 LoginPage slogin = new LoginPage(driver);
	 slogin.setUserName(global_username);
	 slogin.setPassword(global_password);
	 slogin.clickButton();
	 
   ProductDisplay product=new ProductDisplay(driver);
		product.SelectSouceLabsByImg();
		product.souceLabsLableVerify();
		product.BackToProduct();
		product.productLableVerify();
		product.SelectSouceLabsByName();
		product.souceLabsLableVerify();
	    product.BackToProduct();
		product.productLableVerify();
		slogin.logout();
		
     
			
}
	@Test (description = "verifying souce labs backpack Discription by clicking image and name")
	void verifyDiscriptionSauceProduct()
	{
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 LoginPage slogin = new LoginPage(driver);
	 slogin.setUserName(global_username);
	 slogin.setPassword(global_password);
	 slogin.clickButton();
	
   ProductDisplay product=new ProductDisplay(driver);
		product.SelectSouceLabsByImg();
		product.verifySousdrisciption();
		product.BackToProduct();
		product.productLableVerify();
		product.SelectSouceLabsByName();
		product.verifySousdrisciption();
	    product.BackToProduct();
		product.productLableVerify();
		slogin.logout();
     
			
}

	

	
}