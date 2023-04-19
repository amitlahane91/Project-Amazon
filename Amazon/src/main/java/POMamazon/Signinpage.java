package POMamazon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.Utility;

public class Signinpage {
	WebDriver driver;
	
	@FindBy (xpath="//span[@class='nav-line-2 ']")
	private WebElement profile;
	
	@FindBy (xpath="(//span[text()='Sign in'])[1]")
	private WebElement signin;
	
	@FindBy (xpath="//input[@type='email']")
	private WebElement mobile;
	
	@FindBy (xpath="//input[@id='continue']")
	private WebElement continuu;



public Signinpage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public void clickprofile(WebDriver driver) {
	Actions act = new Actions(driver);
	act.moveToElement(profile).perform();
	//profile.click();
	
}
public void clicksignin() {
	signin.click();
}

public void entermobile() throws EncryptedDocumentException, IOException{
	String mob = Utility.getDataFromExcel("sheet1", 1, 0);
	mobile.sendKeys(mob);
}
public void clickcontinuu() {
	continuu.click();
}




}