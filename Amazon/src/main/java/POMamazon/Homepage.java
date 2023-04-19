package POMamazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	WebDriver driver;
	
	@FindBy (xpath="//a[text()='Fresh']")
	private WebElement fresh;
	
	@FindBy (xpath="//a[text()='Gift Cards']")
	private WebElement giftcards;
	
	@FindBy (xpath="//a[text()='Baby']")
	private WebElement baby;
	
	@FindBy (xpath="//span[text()='Browsing History']")
	private WebElement browsinghistory;
	
	@FindBy (xpath="//a[text()='Buy Again']")
	private WebElement buyagain;
	
	@FindBy (xpath="//a[text()='Pet Supplies']")
	private WebElement petsupplies;
	
	@FindBy (xpath="//a[@id='nav-link-accountList']")
	private WebElement profile; 
	
	@FindBy (xpath="//span[text()='Sign Out']")
	private WebElement signout;
	
	public Homepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickfresh() {
		fresh.click();
	}
	public void clickgiftcards() {
		giftcards.click();
	}
	public void clickbaby() {
		baby.click();
	}
	public void clickbrowsinghistory() {
		browsinghistory.click();
	}
	public void clickbuyagain() {
		buyagain.click();
	}   
	public void clickpetsupplies() {
		petsupplies.click();
	}
	public void movetoprofile(WebDriver driver) throws InterruptedException {
		//profile.click();
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.moveToElement(profile).build().perform();
	}
	public void clicksignout() {
		signout.click();
	}

}
