package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectProduct {

	

	WebDriver ldriver;
	
  public SelectProduct(WebDriver driver)
	{
	    ldriver= driver;
		PageFactory.initElements(driver, this);
	}
  
  @FindBy(xpath=("//div[normalize-space()='Sauce Labs Bike Light']"))
  WebElement SelectProductByName ;
  
  @FindBy(xpath=("//div[@class='inventory_details_desc large_size']"))
  WebElement VerifyDescription ;
  
  @FindBy(xpath=("//button[@id='back-to-products']"))
  WebElement BackBtnElement ;
  
  @FindBy(xpath=("//img[@alt='Sauce Labs Bolt T-Shirt']"))
   WebElement ImageVerify ;
  
  @FindBy(xpath=("//div[@class='inventory_details_desc large_size']"))
  WebElement VerifyProductDetails;
  
  public void SelectItemName() {
  
  	SelectProductByName.click();
  }
  
  public void Description(String VerifyDes) {
	  
	  VerifyDescription.sendKeys(VerifyDes);
	  }
	  

  
  
  public  void BackToProduct()
  {
	  BackBtnElement.click();
  }
  
public void VerifyImage(String VerifyImg ) {
	  
	ImageVerify.sendKeys(VerifyImg);
	  }

public void ProductDetailsVerify(String VerifyProduct ) {
	  
	VerifyProductDetails.sendKeys(VerifyProduct);
	  }

  
}













