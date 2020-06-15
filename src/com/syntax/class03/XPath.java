package com.syntax.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class XPath {
static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
		driver = new FirefoxDriver();
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/dashboard");
		
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Hum@nhrm123");
		driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
		
		//  //a[text()='Welcome Admin']
		//driver.findElement(By.xpath("//a[text()='Welcome Admin']")).click();
		driver.findElement(By.xpath("//a[contains(@class,'panel')]")).click();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//a*[@id='menu_time_viewTimeModule']")).click(); // * is used
		driver.findElement(By.xpath("//a[starts-with(text(),'Log')]")).click();
		
		driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Hum@nhrm123");
		driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
		
		
		
		
	}

}
