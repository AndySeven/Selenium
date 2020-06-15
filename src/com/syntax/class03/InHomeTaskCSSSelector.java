package com.syntax.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

//Using CSS ONLY
//TC 2: Mercury Tours Registration: 
//Open chrome browser
//Go to “http://newtours.demoaut.com/”
//Click on Register Link
//Fill out all required info (skip dropdowns)
//Click Submit
//User successfully registered
public class InHomeTaskCSSSelector {
public static WebDriver driver;
public static Select select;
public static final String URL = "http://newtours.demoaut.com/";
public static final String driverKey = "webdriver.chrome.driver";
public static final String driverPath = "drivers/chromedriver";

	public static void main(String[] args) throws InterruptedException {
		System.setProperty(driverKey, driverPath);
		driver = new ChromeDriver();
		driver.get(URL);
		
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("a[href*='ryregister']")).click();
		driver.findElement(By.cssSelector("input[name='firstName']")).sendKeys("Bo");
		driver.findElement(By.cssSelector("input[name^='las']")).sendKeys("Bofro");
		
		driver.findElement(By.cssSelector("input[name='phone']")).sendKeys("1235668");
		driver.findElement(By.cssSelector("input#userName")).sendKeys("bbv@gmil.com");
		driver.findElement(By.cssSelector("input[name$='ss1']")).sendKeys("Grand St");
		driver.findElement(By.cssSelector("input[name*='it']")).sendKeys("Stamford");
		driver.findElement(By.cssSelector("input[name$='ate']")).sendKeys("CT");
		driver.findElement(By.cssSelector("input[name='postalCode']")).sendKeys("232334");
		
		
		
		Select select = new Select(driver.findElement(By.cssSelector("select[name='country']")));
		select.selectByVisibleText("RUSSIA");
		
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input#email")).sendKeys("Shosha");
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys("12345r");
		driver.findElement(By.cssSelector("input[name^='conf'][type*='wor']")).sendKeys("12345r");
		driver.findElement(By.cssSelector("input[name='register']")).click();
		
		
		Thread.sleep(3000);
		driver.quit();
		System.exit(0);
		

	}

}
