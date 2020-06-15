package com.syntax.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathAndCSSSelector2 {
static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
		
		driver.findElement(By.cssSelector("input#txtUsername")).sendKeys("admin");
		driver.findElement(By.cssSelector("input[name='txtPassword']")).sendKeys("Hum@nhrm123");
		driver.findElement(By.cssSelector("input[value^='LOG']")).click();
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[starts-with(text(),'Wel')]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		
		
		Thread.sleep(4000);
		driver.close();
		System.exit(0);
	}

}
