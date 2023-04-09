package testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import pages.LoginPage;
import pages.AddToCartPage;
import utility.BaseClass;


public class VerifyAddCartTestCase extends BaseClass{
	
	@Test
	public void VerifyProductAddToCart() throws InterruptedException
	{
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 driver.get(url);
	 LoginPage login  = new LoginPage(driver);
	 login.setUserName(global_username);
	 login.setPassword(global_password);
	 login.clickButton();
	 AddToCartPage cart=new AddToCartPage(driver);
	cart.Addtocart();
	cart.CartProduct();
	if(cart.isProductAddedToCart()==true)
	{
		log.info("product added to the cart");
		Assert.assertTrue(true);
	}
	else
	{
		log.info("product added to the cart");
		Assert.assertTrue(false);
	}
	cart.souceLabsLableVerify();
	cart.clickRemove();
	cart.clickContinueShoping();
	login.logout();
	
}
	@Test
	public void verifyProductRemoveFromCart()
	{
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.get(url);
		 LoginPage login  = new LoginPage(driver);
		 login.setUserName(global_username);
		 login.setPassword(global_password);
		 login.clickButton();
		 AddToCartPage cart=new AddToCartPage(driver);
		cart.Addtocart();
		cart.CartProduct();
		if(cart.isProductRemoved()==true)
		{
			log.info("Product is removed from cart");
			Assert.assertTrue(true);
		}
		else
		{
			log.info("Product is not removed from cart");
			Assert.assertTrue(false);
		}
		
		cart.clickContinueShoping();
		login.logout();
	}
}
