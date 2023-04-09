package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPricePage
{
	
	

	WebDriver ldriver;
	
  public ProductPricePage(WebDriver driver)
	{
	    ldriver= driver;
		PageFactory.initElements(driver, this);
	}
	
  @FindBy(xpath=("//span[@class='title']"))
  WebElement ProductLable;
  
  @FindBy(xpath=("//div[@class='inventory_item_price' and text()!='$']"))
   List <WebElement> PriceBar;
   
  public boolean getProductLable()
  {
	  Boolean res= ProductLable.isDisplayed();
	return res;
  } 
   
  public List<WebElement> getValue()
  {
	  return PriceBar;
  }
  
}