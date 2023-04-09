package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
		
		WebDriver ldriver;
		
	  public LoginPage(WebDriver driver)
		{
		    ldriver= driver;
			PageFactory.initElements(driver, this);
		}
		
		
		
			
		@FindBy(id="user-name")
		WebElement usernameElement;
		

		@FindBy(id="password")
		WebElement passwordElement;

		

		@FindBy(id="login-button")
		WebElement buttonElement;

		@FindBy(id="react-burger-menu-btn")
		WebElement dropDown;

		

		@FindBy(linkText = "Logout")
		WebElement logout;
		
		
		public void setUserName(String username)
		{
			usernameElement.sendKeys(username);
		}
		
		
		public void setPassword(String password)
		{
			passwordElement.sendKeys(password);
		}
		
		
		public  void clickButton()
		 {
			buttonElement.click();
		 }
		
		
		
public void logout() {
	dropDown.click();
	logout.click();
	
}
		
		
	}
