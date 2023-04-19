package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseorBrowser {
	
	public static WebDriver openChromebrowser() {
		System.out.println("chrome browser running");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\lahan\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	    
	    return driver;
		
	}
	
	public static WebDriver openFirefoxbrowser() {
		System.out.println("Firefox browser running");
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\lahan\\Downloads\\geckodriver-v0.31.0-win32\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		return driver;
	}

}
