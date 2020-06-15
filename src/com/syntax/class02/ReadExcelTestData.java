package com.syntax.class02;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadExcelTestData {
	
	static String actualURL = "http://newtours.demoaut.com/";

	public static void main(String[] args) throws IOException, InterruptedException {
		String fileTestDataXLSX = System.getProperty("user.dir") + "/TestData/TestData2.xlsx";
		System.out.println(fileTestDataXLSX);
		FileInputStream fis = new FileInputStream(fileTestDataXLSX);
		Workbook wbook = new XSSFWorkbook(fis);
		Sheet sheet = wbook.getSheet("Sheet1");
		
		int rows = sheet.getPhysicalNumberOfRows();
		int cols = sheet.getRow(0).getLastCellNum();
		//System.out.println(rows+" "+cols);
		
//		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
//		WebDriver driver = new ChromeDriver();
//		driver.get(actualURL);
//		driver.navigate().to("http://newtours.demoaut.com/mercuryregister.php");
//		Thread.sleep(3000);
		
		for(int r=0; r<rows; r++) {
			for(int c=0; c<cols; c++){
				String cellValues = sheet.getRow(r).getCell(c).toString();
				System.out.printf(cellValues+" ");
			}
			System.out.println();
		}
	}

}
