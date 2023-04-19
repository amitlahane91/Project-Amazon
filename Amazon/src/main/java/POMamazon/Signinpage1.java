package POMamazon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.Utility;

public class Signinpage1 {
	
	@FindBy (xpath="//input[@type='password']")
	private WebElement password;
	
	@FindBy (xpath="//input[@id='signInSubmit']")
	private WebElement signin;
	
	public Signinpage1(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterpassword() throws EncryptedDocumentException, IOException {
		String pswd = Utility.getDataFromExcel("sheet1", 1, 1);
		password.sendKeys(pswd);
	}
	
	public void clicksubmit() {
		signin.click();
	}

}
