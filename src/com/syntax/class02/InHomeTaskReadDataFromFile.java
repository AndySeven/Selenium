package com.syntax.class02;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InHomeTaskReadDataFromFile {
	
	static WebDriver driver;
	public static void main(String[] args) throws IOException, InterruptedException {
		String filePath = System.getProperty("user.dir")+"/configs/ConfigTest.properties";
		FileInputStream fis = new FileInputStream(filePath);
		Properties prop = new Properties();
		prop.load(fis);
		
		String browser = prop.getProperty("browser");
		System.out.println(browser);
		String url = prop.getProperty("url");
		String userName = prop.getProperty("userName");
		String password = prop.getProperty("password");
		
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
			driver = new ChromeDriver();
		}else {
			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
			driver = new FirefoxDriver();
		}
		driver.get(url);
		Thread.sleep(3000);
		driver.findElement(By.id("email")).sendKeys(userName);
		driver.findElement(By.id("pass")).sendKeys(password);
		Thread.sleep(3000);
		driver.quit();
		System.exit(0);	
	}
}
