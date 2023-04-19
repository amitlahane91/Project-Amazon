package POMamazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Signoutpage {
	
	WebDriver driver;
	
//	@FindBy (xpath="//span[@class='nav-line-2 ']")
	private WebElement profile;
	
	@FindBy (xpath="//span[text()='Sign Out']")
	private WebElement signout;
	
	public Signoutpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void movetoprofile() throws InterruptedException {
		profile=driver.findElement(By.xpath("//span[@class='nav-line-2 ']"));
		Actions act = new Actions(driver);
		act.moveToElement(profile).build().perform();
		//Thread.sleep(5000);
		//act.moveToElement(x).build().perform();
	}
	public void clicksignout() {
		signout.click();
	}

}
