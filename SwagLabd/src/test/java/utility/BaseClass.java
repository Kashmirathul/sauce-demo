package utility;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.apache.log4j.Logger;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
     static ReadConfigFile read = new ReadConfigFile();	
	protected static String global_username = read.getUsername() ;
	protected static String global_password = read.getPassword();
	protected static String url = read.getUrl();
	protected static String browser = read.getBrowser();
	public static Logger log;
	protected static WebDriver driver;
		
		
		@BeforeTest
		public void setup()
		{
			if (browser.equalsIgnoreCase("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver= new ChromeDriver();	
				log = Logger.getLogger("SwagLabd");
		        PropertyConfigurator.configure("logfile.properties");
				
		       
			}
			
			if (browser.equals("firefox"))
			{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			log = Logger.getLogger("SwagLabd");
	        PropertyConfigurator.configure("logfile.properties");
			
			
		}
			if (browser.equals("Edge"))
			{
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
			log = Logger.getLogger("SwagLabd");
	        PropertyConfigurator.configure("logfile.properties");
			
			
		}
			
			
		}
		@AfterTest
		public void tearDown()
		{
			driver.quit();
		}
		
		
		     

	}

