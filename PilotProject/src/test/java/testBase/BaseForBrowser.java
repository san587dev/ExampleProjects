package testBase;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class BaseForBrowser 
{
	
	WebDriver driver;
	
	@Test
	public void launchBrowser(String browserName)
	{
		
		if(browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
			System.setProperty(ChromeDriverService.CHROME_DRIVER_VERBOSE_LOG_PROPERTY, "BrowserLogs\\Chrome.log");
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			
			ChromeOptions options = new ChromeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.EAGER);
			options.addArguments("--disable-notifications");
			options.addArguments("--start-maximized");
			options.addArguments("ignore-certificate-errors");
			options.addArguments("user-data-dir=C:\\Users\\Santosh\\AppData\\Local\\Google\\Chrome\\User\\Profile 1");
			
			driver = new ChromeDriver(options);
		}
		else if(browserName.equals("Mozilla"))
		{
			
		}
		
	}
	

}
