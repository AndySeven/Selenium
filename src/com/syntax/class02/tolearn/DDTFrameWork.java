package com.syntax.class02.tolearn;

import java.io.*;
import java.util.*;
import java.util.Map.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import com.syntax.Set.Selenium;
public class DDTFrameWork {
	/**
	 * initializing Webdriver to write test case.
	 * Declaring a String variable for verification
	 */
	public static WebDriver driver = Selenium.driver("Chrome");
	public static String name = null;
	/**
	 * This Method will read Excel file from specified path and
	 * Convert data into List of Map;
	 * @param path
	 * @return List of Map<String, String>
	 * @throws IOException
	 */
	public static List<Map<String, String>> dataFromExcel(String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet("Sheet1");
		int rows = sheet.getPhysicalNumberOfRows();
		int cols = sheet.getRow(0).getLastCellNum();
//		System.out.println("Row= " + rows + " and Col= " + cols);
		List<Map<String, String>> mapList = new ArrayList<>();
		for (int r = 1; r < rows; r++) {
			Map<String, String> map = new LinkedHashMap<>();
			for (int c = 0; c < cols; c++) {
				String key = sheet.getRow(0).getCell(c).toString();
				String value = sheet.getRow(r).getCell(c).toString();
				map.put(key, value);
			}
			mapList.add(map);
		}
		return mapList;
	}
	/**
	 * This Method will take an url and open registration Page of specified webSite
	 * 
	 * @param url(http://newtours.demoaut.com/)
	 */
	public static void openRegistrationPage(String url) {
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[contains(text(), 'Register')]")).click();
	}
	/**
	 * This Method will take Header and data and input those information
	 * into registration form of (http://newtours.demoaut.com/).
	 * this method is intended to use inside loop/iteration of Map<String, String>
	 * @param key
	 * @param value
	 * @throws InterruptedException
	 */
	public static void registration(String key, String value) throws InterruptedException {
		switch (key.toLowerCase()) {
		case "firstname":
			driver.findElement(By.xpath("//input[contains(@name,'firstName')]")).sendKeys(value);
			name = value + " ";
			break;
		case "lastname":
			driver.findElement(By.xpath("//input[starts-with(@name,'last')]")).sendKeys(value);
			name += value;
			break;
		case "phone":
			driver.findElement(By.xpath("//input[contains(@name,'phone')]")).sendKeys(value);
			break;
		case "email":
			driver.findElement(By.xpath("//input[starts-with(@name,'user')]")).sendKeys(value);
			break;
		case "address1":
			driver.findElement(By.xpath("//input[starts-with(@name,'address1')]")).sendKeys(value);
			break;
		case "address2":
			driver.findElement(By.xpath("//input[contains(@name,'address2')]")).sendKeys(value);
			break;
		case "city":
			driver.findElement(By.xpath("//input[@name='city']")).sendKeys(value);
			break;
		case "state":
			driver.findElement(By.xpath("//input[starts-with(@name,'state')]")).sendKeys(value);
			break;
		case "postalcode":
			driver.findElement(By.xpath("//input[starts-with(@name,'postal')]")).sendKeys(value);
			break;
		case "country":
			driver.findElement(By.xpath("//select[@name='country'] //option[@value=" + value + "]")).click();
			break;
		case "username":
			driver.findElement(By.xpath("//input[@id='email']")).sendKeys(value);
			break;
		case "password":
			driver.findElement(By.xpath("//input[contains(@name,'password')]")).sendKeys(value);
			break;
		case "confirmpassword":
			driver.findElement(By.xpath("//input[starts-with(@name,'confirm')]")).sendKeys(value);
			break;
		default:
			System.out.println("Web Element not found");
			break;
		}
	}
	/**
	 * This Method will throw an Exception.
	 * it is intended to Click register button to test url 
	 * and verify registration.
	 * @throws InterruptedException
	 */
	public static void comleteRegistration() throws InterruptedException {
		driver.findElement(By.xpath("//input[starts-with(@name,'register')]")).click();
		if (driver.findElement(By.xpath("//font/b[contains(text()," + "'" + name + "'" + ")]")) != null) {
			System.out.println("User: " + name + " successfully registered");
		} else {
			System.out.println("User Registration not successfull");
		}
		driver.manage().deleteAllCookies();
	}
	/**
	 * this method is to close Browser after test.
	 * in case of multiple data. this method will close browser if run inside loop/iteration.
	 * @throws InterruptedException
	 */
	public static void closeBrowser() throws InterruptedException {
		Thread.sleep(1000);
		driver.close();
	}
	
}
