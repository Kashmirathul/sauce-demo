package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AddToCartPage {

	

	WebDriver ldriver;
	
  public AddToCartPage(WebDriver driver)
	{
	    ldriver= driver;
		PageFactory.initElements(driver, this);
		
	}
  
  @FindBy(xpath=("/div[normalize-space()='Sauce Labs Backpack']"))
  WebElement SelectProductName ;
  
  @FindBy(xpath=("//button[@id='add-to-cart-sauce-labs-backpack']"))
  WebElement addtocartbtnelement ;
  
  
  @FindBy(xpath=("//a[@class='shopping_cart_link']"))
  WebElement CartProductElement ;
  
  
  
  @FindBy(xpath=("//button[@id='remove-sauce-labs-backpack']"))
  WebElement RemoveBtnElement ;
  @FindBy(xpath=("//button[@id='continue-shopping']"))
  WebElement continueShopBtn ;
 
  @FindBy(xpath=("//div[@class='inventory_item_name']"))
  List<WebElement> itemNames ;
  
  @FindBy(xpath=("//span[@class='shopping_cart_badge']"))
  WebElement cartIconText ;

  @FindBy(xpath=("//div[@class='inventory_item_name']"))
  WebElement itemName ;
  
  @FindBy(xpath=("//div[@class='removed_cart_item']"))
  WebElement itemRemovedValidation ;
  

  public void SelectProductName (String selectproduct)
  {
	  SelectProductName.sendKeys(selectproduct);
  }
  
  public void Addtocart ()
  {
	  addtocartbtnelement.click();
  }
  public boolean isProductAddedToCart()
  {
	  boolean productAdded=false;
	 String cartBadgeText= cartIconText.getText();
	 int cartBadge =Integer.valueOf(cartBadgeText);
	 int totalItem=itemNames.size();
	  if(cartBadge==totalItem)
	  {
		 productAdded=true;
		 
	  }
	  return productAdded;
  }
  public void AddtocartVerify ()
  {
	 String addcart= addtocartbtnelement.getText();
	 Assert.assertEquals("Add to cart", addcart);
  }
  public void CartProduct()
  {
	  CartProductElement.click();
  }
  
  public boolean isProductRemoved()
  {
	  boolean proctuctRemoved=false;
	  RemoveBtnElement.click();
	if(itemRemovedValidation.isEnabled())
	  {
		  proctuctRemoved=true;
	  }
	return proctuctRemoved;
  }
  public void verifyRemoveLable() {
	String remove=  RemoveBtnElement.getText();
	 Assert.assertEquals("Remove",remove);
	
	
}
  public void clickContinueShoping()
  {
	  continueShopBtn.click();
  }
  public void souceLabsLableVerify() {
		String souceLabs=itemName.getText();
		System.out.println(souceLabs);
		Assert.assertEquals("Sauce Labs Backpack", souceLabs);
		
	}
  
  public void clickRemove()
  {
	  RemoveBtnElement.click();
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}