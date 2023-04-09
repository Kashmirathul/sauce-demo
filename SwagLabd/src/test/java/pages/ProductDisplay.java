package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProductDisplay {
WebDriver ldriver;

public ProductDisplay(WebDriver driver)
{
	ldriver= driver;
	PageFactory.initElements(driver, this);
}


@FindBy(xpath=("//img[@alt='Sauce Labs Backpack']"))
WebElement SelectProductByImg;


@FindBy(xpath=("//button[@id='back-to-products']"))
WebElement BackBtnElement;

@FindBy(xpath=("//div[normalize-space()='Sauce Labs Backpack']"))
WebElement selectproductName ;

@FindBy(xpath=("//button[@id='back-to-products']"))
WebElement Back;
@FindBy(xpath="//div[@class='inventory_details_name large_size']")
WebElement inverntaryProductLable;
@FindBy(xpath="//span[@class='title']")
WebElement productLable;
@FindBy(xpath = "//div[@class='inventory_details_desc large_size']")
WebElement discriptionLable;




public void SelectSouceLabsByImg() {
	
	SelectProductByImg.click();
} 
	  

public void BackToProduct()
{
	  BackBtnElement.click();
}

public void SelectSouceLabsByName() {
	  
	selectproductName.click();
  }
public void souceLabsLableVerify() {
	String souceLabs=inverntaryProductLable.getText();
	System.out.println(souceLabs);
	Assert.assertEquals("Sauce Labs Backpack", souceLabs);
	
}
public void productLableVerify() {
	String product=productLable.getText();
	Assert.assertEquals("Products", product);
	
}
public void verifySousdrisciption() {
	String discription=discriptionLable.getText();
	Assert.assertEquals("carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.", discription);
	
}

}

    
    
   
    
    
 