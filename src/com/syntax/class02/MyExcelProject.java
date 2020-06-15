package com.syntax.class02;
// 2. Using xl file that we created to new tour application 
// (http://www.newtours.demoaut.com/) create a data driven test: 
// Register to an account using 3-4 different sets of data 
//(exclude passing values to the drop down and try to use 
// different locators that you know if possible)

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class MyExcelProject {
	public static final String PATH = System.getProperty("user.dir");
	public static final String PATHCONFIG = PATH + "/configs/MyExcelProjCinfigs.properties";
	public static final String PATHDATA = PATH + "/TestData/MyExcelProjData.xlsx";
	static FileInputStream fis;
	static FileInputStream fisData;
	static Properties prop;
	static String actualURL;
	static WebDriver driver;
	static String chromeDriverPath;
	static String geckoDriverPath;
	static String geckoDriver;
	static String chromeDriver;
	static Workbook book;
	static Sheet sheet;
	static Row row;
	static Cell cell;
	static int rows;
	static int cols;
	static List<Map<String, String>> excelMaps;

	static void getDriver(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty(chromeDriver, chromeDriverPath);
			driver = new ChromeDriver();
			System.out.println("chrome works");
			
		}else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty(geckoDriver, geckoDriverPath);
			driver = new FirefoxDriver();
		}
	}
	
	static List<Map<String, String>> getExcellData() {
		List <Map<String,String>> listMaps = new ArrayList<>();
		for(int r=1; r<rows; r++) {
			Map<String, String> map = new LinkedHashMap<>();
			for(int c=0; c<cols; c++) {
				String key = sheet.getRow(0).getCell(c).toString();
				String value = sheet.getRow(r).getCell(c).toString();
				map.put(key, value);
			}	
			listMaps.add(map);
		}
		return listMaps;
	}
	
	static String testWebsite() throws InterruptedException {
		driver.get(actualURL);
		driver.navigate().to(prop.getProperty("urlNavigate"));
		
		Thread.sleep(3000);
		
		for(Map<String,String> map: excelMaps) {
			Set<String> setKeys = map.keySet();
			Iterator<String> iter = setKeys.iterator();
			while(iter.hasNext()){
				driver.findElement(By.name("firstName")).sendKeys(map.get(iter.next()));
				driver.findElement(By.name("lastName")).sendKeys(map.get(iter.next()));
				driver.findElement(By.name("phone")).sendKeys(map.get(iter.next()));
				driver.findElement(By.id("userName")).sendKeys(map.get(iter.next()));
				driver.findElement(By.name("address1")).sendKeys(map.get(iter.next()));
				driver.findElement(By.name("city")).sendKeys(map.get(iter.next()));
				driver.findElement(By.name("state")).sendKeys(map.get(iter.next()));
				driver.findElement(By.name("postalCode")).sendKeys(map.get(iter.next()));
				Select tonga = new Select(driver.findElement(By.name("country")));
				tonga.selectByVisibleText("TONGA");
				driver.findElement(By.id("email")).sendKeys(map.get(iter.next()));
				driver.findElement(By.name("password")).sendKeys(map.get(iter.next()));
				driver.findElement(By.name("confirmPassword")).sendKeys(map.get(iter.next()));
				
			}
			driver.findElement(By.name("register")).click();
			driver.navigate().back();
		}
		return "Good";
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		fis = new FileInputStream(PATHCONFIG);
		prop = new Properties();
		prop.load(fis);
		actualURL= prop.getProperty("url");
		chromeDriverPath = prop.getProperty("chromedriverPath");
		geckoDriverPath = prop.getProperty("geckodriverPath");
		chromeDriver = prop.getProperty("chromed");
		geckoDriver = prop.getProperty("geckod");
		
		fisData = new FileInputStream(PATHDATA);
		book = new XSSFWorkbook(fisData);
		sheet = book.getSheet("Sheet1");
		rows = sheet.getPhysicalNumberOfRows();
		cols = sheet.getRow(0).getLastCellNum();
		
		excelMaps = getExcellData();
		System.out.println(excelMaps);
		
		getDriver(prop.getProperty("browser"));
		System.out.println(testWebsite());
		
		book.close();
		driver.quit();
		System.exit(0);
	}
}
