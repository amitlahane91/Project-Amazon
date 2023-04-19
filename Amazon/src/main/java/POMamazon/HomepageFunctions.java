package POMamazon;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomepageFunctions {
	 boolean select;
	 WebDriver driver;
	
	@FindBy (xpath="//select[@id='searchDropdownBox']")
	private WebElement searchlistbox;
	
	@FindBy (xpath="//a[@id='icp-nav-flyout']")
	private WebElement language;
	
	@FindBy (xpath="(//span[text()='English'])[1]")
	private WebElement english;
	
	@FindBy (xpath="//a[@id='nav-global-location-popover-link']")
	private WebElement deliverylocation;
	@FindBy (xpath="//input[@id='GLUXZipUpdateInput']")
	private WebElement pincode;
	@FindBy (xpath="//input[@aria-labelledby='GLUXZipUpdate-announce']")
	private WebElement apply;
	@FindBy (xpath="//span[@id='glow-ingress-line2']")
	private WebElement actual;
	@FindBy (xpath="//span[@id='glow-ingress-line2']")
	private WebElement expected;
	
	@FindBy (xpath="//input[@id='twotabsearchtextbox']")
	private WebElement searchbar;

	@FindBy (xpath="//span[text()='Sign Out']") 
	private WebElement signout;
	
	public HomepageFunctions(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void searchlistoptions() throws InterruptedException {
		Select s = new Select(searchlistbox);
		searchlistbox.click();
		//s.selectByVisibleText("Alexa Skills");
		List<WebElement> option = s.getOptions();
		int size = option.size();
		for(int i=0; i<=size-1; i++) {
			System.out.print(option.get(i).getText()+" ");
		}
		s.selectByIndex(5);
		System.out.println();
	}
	
   public void typeinsearchbar() throws InterruptedException {
	   //Select search = new Select(searchbar);
	   searchbar.click();
	   Thread.sleep(2000);
	   searchbar.sendKeys("samsung s22"); 
	   WebDriverWait ref = new WebDriverWait(driver, 10);  //Explicit wait
		WebElement box = ref.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='nav-flyout-searchAjax']")));
		Thread.sleep(3000);
		WebElement ultra = driver.findElement(By.xpath("//div[@aria-label='samsung s22 ultra']"));
		ultra.submit();
	 //  search.selectByVisibleText("samsung s22 ultra");
	   
	   }
	   public void selectenglish(WebDriver driver ) {
		   Actions act = new Actions(driver);
		   act.moveToElement(language).build().perform();
		  // english.click();
		   //boolean select = english.isSelected(); //isSelected method
		   //System.out.println(select);
		    }
	   
      public void selectdeliverylocation() throws InterruptedException {
	   deliverylocation.click();
	   pincode.sendKeys("431001");
	   apply.click();
	  // Thread.sleep(2000);
	   actual.getText();
	   expected.getText();
   }
   public void clicksignout() {
		signout.click();
	}
	
}