package TestAmazon;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POMamazon.Homepage;
import POMamazon.HomepageFunctions;
import POMamazon.Signinpage;
import POMamazon.Signinpage1;

public class TestHomepageFunctions {
	WebDriver driver;
	HomepageFunctions homefun;
	Select s;
	WebElement english;
	Homepage home;
	SoftAssert soft;
	 //boolean select;
	 String actual;
	 String expected;
	
	@BeforeClass
	public void openbrowser() {
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\lahan\\Downloads\\chromedriver_win32\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	    }
	
	@BeforeMethod
	public void signin() throws InterruptedException, EncryptedDocumentException, IOException {
		System.out.println("Before Method");
		driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3F%26ext_vrnc%3Dhi%26tag%3Dgooghydrabk1-21%26ref%3Dnav_signin%26adgrpid%3D60571832564%26hvpone%3D%26hvptwo%3D%26hvadid%3D486453138860%26hvpos%3D%26hvnetw%3Dg%26hvrand%3D2569969405577487013%26hvqmt%3De%26hvdev%3Dc%26hvdvcmdl%3D%26hvlocint%3D%26hvlocphy%3D1007780%26hvtargid%3Dkwd-296458789801%26hydadcr%3D14452_2154371%26gclid%3DCj0KCQjw1vSZBhDuARIsAKZlijSq5SQAs7cCLdNP3-TAYjKDUaP7lZ5kiz3ebPSBz-EbibtuAdk5BeIaAge_EALw_wcB&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&");
		Signinpage sign = new Signinpage(driver); 
		sign.entermobile();
		sign.clickcontinuu();
		
		Signinpage1 sign1 = new Signinpage1(driver);
		sign1.enterpassword();
		sign1.clicksubmit();
		homefun = new HomepageFunctions(driver);
		home = new Homepage(driver);
		//Select s = new Select((WebElement) driver);
		SoftAssert soft = new SoftAssert();
		
	}
	
	@Test  (enabled=false)
	public void testsearchlistbox() throws InterruptedException {
		homefun.searchlistoptions();
		
		Thread.sleep(2000);
		
			//Assert.assertEquals(, "Alexa Skills");
	}
	
	@Test   (enabled=false)
	public void testlanguage() throws InterruptedException {
		  homefun.selectenglish(driver);
		  boolean select = english.isSelected(); //isSelected method
		   System.out.println(select);
		   //Assert.assertEquals(select, true);
	}
	
	@Test   (enabled=false)
	public void testdeliverylocation() throws InterruptedException {
		homefun.selectdeliverylocation();
		Thread.sleep(2000);
		Assert.assertEquals(actual , expected);
		System.out.println("testdeliverylocation Test Case pass");
	}
	
	@Test (priority=4)
	public void testsearchinput() throws InterruptedException {
		homefun.typeinsearchbar();
	}
	
	@AfterMethod 
	public void signout() throws InterruptedException {
		System.out.println("After Method");
	    home.movetoprofile(driver);
	   Thread.sleep(2000);
	    homefun.clicksignout();
	    System.out.println();
	}
	
	@AfterClass
	public void closebrowser() {
		driver.close();
	}

}
