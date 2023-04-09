package testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddToCartPage;
import pages.LoginPage;
import pages.ProductDisplay;
import utility.BaseClass;

public class EndToEndTest extends BaseClass {

	@Test
	public void verifyEndToEndFlow() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		LoginPage login = new LoginPage(driver);
		login.setUserName(global_username);
		login.setPassword(global_password);
		login.clickButton();
		log.info("user logged in");
		Thread.sleep(4000);
		ProductDisplay product = new ProductDisplay(driver);
		product.SelectSouceLabsByImg();
		product.souceLabsLableVerify();
		log.info("product is verified by its image");
		product.BackToProduct();
		product.productLableVerify();
		product.SelectSouceLabsByName();
		product.souceLabsLableVerify();
		log.info("product is verified by its name");
		product.BackToProduct();
		product.productLableVerify();

		AddToCartPage cart = new AddToCartPage(driver);

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
		if (cart.isProductRemoved() == true) {
			log.info("Product is removed from cart");
			Assert.assertTrue(true);
		} else {
			log.info("Product is not removed from cart");
			Assert.assertTrue(false);
		}
		cart.clickContinueShoping();
		login.logout();
		log.info("user is logged out");
	}

}
