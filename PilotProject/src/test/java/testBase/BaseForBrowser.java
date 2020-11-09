package testBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.edge.edgehtml.EdgeHtmlDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;

public class BaseForBrowser 
{
	
	WebDriver driver;
	
	
	public WebDriver launchBrowser(String browserName)
	{
		
		if(browserName.equals("Chrome"))
		{
			/*
			 * Setting up System Properties
			 */
			System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
			System.setProperty(ChromeDriverService.CHROME_DRIVER_VERBOSE_LOG_PROPERTY, "BrowserLogs\\Chrome.log");
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			/*
			 * Using Chrome options for disable notifications and certificate errors
			 */
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
			
			System.setProperty("webdriver.gecko.driver", "Drivers\\geckodriver.exe");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "BrowserLogs\\Firefox.log");
			
			FirefoxOptions options = new FirefoxOptions();
			options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe"); // use this line when there is an error binary is not found
			
			ProfilesIni profile = new ProfilesIni();
			FirefoxProfile prof = profile.getProfile("SeleniumProfile");
			prof.setPreference("dom.webnotifications.enabled", false );
			prof.setAssumeUntrustedCertificateIssuer(true);
			prof.setAssumeUntrustedCertificateIssuer(false);
			
			options.setProfile(prof);
			
			driver = new FirefoxDriver(options);
		}
		else if (browserName.equals("Edge")) 
		{
			
			System.setProperty("webdriver.edge.driver", "Drivers\\msedgedriver.exe");
			System.setProperty(EdgeDriverService.EDGE_DRIVER_LOG_PROPERTY, "BrowserLogs\\Edge.log");
			System.setProperty(EdgeHtmlDriverService.EDGE_DRIVER_VERBOSE_LOG_PROPERTY, "true");
			
			EdgeOptions options = new EdgeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.EAGER);
			options.addArguments("--start-maximized");
			options.addArguments("ignore-certificate-errors");
			
			driver = new EdgeDriver(options);
			
		}
		else if (browserName.equals("IE")) 
		{
			System.setProperty("webdriver.ie.driver", "Drivers\\IEDriverServer.exe");
			System.setProperty(InternetExplorerDriverService.IE_DRIVER_LOGFILE_PROPERTY, "BrowserLogs\\IE.log");
			//InternetExplorerOptions IeOptions = new InternetExplorerOptions();
			
			//DesiredCapabilities cap = new DesiredCapabilities();
			
			driver = new InternetExplorerDriver();
			//driver.get("javascript:document.getElementById('overridelink').click();");
			
		}
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		return driver;
	}
	

}
