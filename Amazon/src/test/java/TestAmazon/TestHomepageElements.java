package TestAmazon;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import POMamazon.Homepage;
import POMamazon.Signinpage;
import POMamazon.Signinpage1;
import POMamazon.Signoutpage;
import Utils.Utility;
import setup.BaseorBrowser;

public class TestHomepageElements extends BaseorBrowser {
	WebDriver driver;
	Homepage home;
	Signinpage sign;
	Signinpage1 sign1;
	int Testid;
	
	@Parameters ("browser")
	@BeforeTest
	public void openbrowser(String browserName) {
		System.out.println(browserName);
		
		if(browserName.equals("Chrome")) {
	    
			driver = openChromebrowser();
	    }
		
		if(browserName.equals("Firefox")) {
		   
			driver = openFirefoxbrowser();
	    }
		driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3F%26ext_vrnc%3Dhi%26tag%3Dgooghydrabk1-21%26ref%3Dnav_signin%26adgrpid%3D60571832564%26hvpone%3D%26hvptwo%3D%26hvadid%3D486453138860%26hvpos%3D%26hvnetw%3Dg%26hvrand%3D2569969405577487013%26hvqmt%3De%26hvdev%3Dc%26hvdvcmdl%3D%26hvlocint%3D%26hvlocphy%3D1007780%26hvtargid%3Dkwd-296458789801%26hydadcr%3D14452_2154371%26gclid%3DCj0KCQjw1vSZBhDuARIsAKZlijSq5SQAs7cCLdNP3-TAYjKDUaP7lZ5kiz3ebPSBz-EbibtuAdk5BeIaAge_EALw_wcB&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	} 
	
	@BeforeClass
	public void createobject(){
		sign = new Signinpage(driver);
		sign1 = new Signinpage1(driver);
		home = new Homepage(driver);
	}
	
	@BeforeMethod
	public void signin() throws InterruptedException, EncryptedDocumentException, IOException {
		System.out.println("Before Method");
		
		sign.entermobile();
		sign.clickcontinuu();
		sign1.enterpassword();
		sign1.clicksubmit();
		
		
	}
	
	@Test (priority=1)
	public void testgiftcards() {
		Testid=001;
		home.clickgiftcards();
		String title = driver.getTitle();
		System.out.println(title);  
		//Assert.assertEquals(title, "Gift Cards & Vouchers Online : Buy Gift Vouchers & E Gift Cards Online in India - Amazon.in"); 
	    System.out.println("testgiftcards Test Case Pass");
	}
	
	@Test  (priority=2)
	public void testbaby() {
		Testid=002;
		home.clickbaby();
		String title = driver.getTitle();
		System.out.println(title);
		//Assert.assertEquals(title, "Baby Products: Buy New Born Baby Products online at best prices in India - Amazon.in");
		System.out.println("testbaby Test Case Pass");
	}
	
	@Test  (priority=3)
	public void testbrowsinghistory() {
		Testid=003;
		home.clickbrowsinghistory();
		String title = driver.getTitle();
		System.out.println(title);
		//Assert.assertEquals(title, "Your Browsing History");
		System.out.println("testbrowsinghistory Test Case Pass");
	}
	
	@Test  (priority=4)
	public void testbuyagain() {
		Testid=004;
		home.clickbuyagain();
		String title = driver.getTitle();
		System.out.println(title);
		//Assert.assertEquals(title, "Buy Again");
		System.out.println("testbuyagain Test Case Pass");
	}
	
	@Test  (priority=5)
	public void testpetsupplies() {
		Testid=005;
		home.clickpetsupplies();
		String title = driver.getTitle();
		System.out.println(title);
		//Assert.assertEquals(title, "Pet Supplies: Buy Pet Supplies Online at Best Prices in India - Amazon.in");
		System.out.println("testpetsupplies Test Case Pass");
	}
	
	@AfterMethod
	public void signout(ITestResult result) throws InterruptedException, IOException {
		System.out.println("After Method");
		if(ITestResult.FAILURE == result.getStatus()) {
			
			Utility.captureScreenshot(driver, Testid);
		}
	    home.movetoprofile(driver);
	    Thread.sleep(2000);
	    home.clicksignout()
	    ;
	    System.out.println();
	}
	
	@AfterClass
	public void clearobject() {
		sign = null;
		sign1 = null;
		home = null;
		//driver = null;
	}
	
	@AfterTest
	public void closebrowser() {
		driver.close();	
		System.gc();
	}
	
	
	

}
