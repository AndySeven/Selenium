package com.syntax.class02;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HrmsLogin {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/dashboard");
		
		driver.findElement(By.name("txtUsername")).sendKeys("Bobby");
		driver.findElement(By.id("txtPassword")).sendKeys("1231fdw");
		driver.findElement(By.className("button")).click();
	}

}
