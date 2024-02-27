package Axis.DataDriven;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ReadExcel {
	
	WebDriver driver;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;
	
	@Test
	public void fblogin() throws IOException, InterruptedException {
		
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			
		  WebDriver driver = new ChromeDriver();
			
			driver.get("https://www.facebook.com/login/");
			
			driver.manage().window().maximize();
			
			// import excel sheet 
			
			File src = new File("C:\\Users\\DELL\\eclipse-workspace\\DataDriven\\TestData.xlsx");
			
			//load the file 
			
			FileInputStream fis = new FileInputStream(src);
			
			//load the workbook 
			
			workbook = new XSSFWorkbook(fis);
			
			//access the sheet from the work book 
			
			sheet = workbook.getSheetAt(0);
			
			for (int i = 1; i<=sheet.getLastRowNum(); i++) {
				
				//import the data for the email 
				
				cell = sheet.getRow(i).getCell(0);
				
				driver.findElement(By.xpath("//input[@name = 'email']")).clear();
				
				driver.findElement(By.xpath("//input[@name = 'email']")).sendKeys(cell.getStringCellValue());
				
				Thread.sleep(1000);
				
				//import the data for the password
				
				cell = sheet.getRow(i).getCell(1);
				
                driver.findElement(By.xpath("//input[@name = 'pass']")).clear();
				
				driver.findElement(By.xpath("//input[@name = 'pass']")).sendKeys(cell.getStringCellValue());
				
				Thread.sleep(1000);
				
				//login 
				
				WebElement login = driver.findElement(By.xpath("//button[@id = 'loginbutton']"));
				
				login.click();
				
			}
			
			
		
	}
	

}
