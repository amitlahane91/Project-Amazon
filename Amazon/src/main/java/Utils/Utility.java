package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import net.bytebuddy.utility.RandomString;

public class Utility {
	
	
	public static void captureScreenshot(WebDriver driver, int Testid) throws IOException {
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String dateFormat = new SimpleDateFormat("dd_MM_yyyy HH_mm_ss").format(new Date());
		Date date = new Date();
		String date1 = dateFormat.formatted(date);
		File dest = new File("C:\\Users\\lahan\\OneDrive\\Pictures\\Screenshots\\Homepage"+Testid+date1+".jpg");
		FileHandler.copy(source, dest);
	}
	
	public static String getDataFromExcel(String sheet, int row, int cell) throws EncryptedDocumentException, IOException {
		
		FileInputStream file = new FileInputStream("C:\\Users\\lahan\\OneDrive\\Documents\\Parameter\\Mydata.xlsx");
		Cell data = WorkbookFactory.create(file).getSheet("Sheet1").getRow(row).getCell(cell);
		
	    String z;
		try {
			z=data.getStringCellValue();
		
		}
		catch(ArithmeticException e) {
			 
			double d = data.getNumericCellValue();
			       z = String.valueOf(d); 
		}
	return z;
	}


}