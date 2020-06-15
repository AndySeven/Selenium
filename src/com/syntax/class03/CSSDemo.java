package com.syntax.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		String url = "http://166.62.36.207/humanresources/symfony/web/index.php/dashboard";
		driver.get(url);
		
		//using simple 
		driver.findElement(By.cssSelector("input[id='txtUsername']")).sendKeys("Admin");
		// using contains(*) (add * after attribute name and then we can use not completed value)
		driver.findElement(By.cssSelector("input[name*='txtPassw']")).sendKeys("Hum@nhrm123");
		// using starts with (^)
		driver.findElement(By.cssSelector("input[value^='LO']")).click();
		Thread.sleep(2000);
		
		// ends with ($)
		driver.findElement(By.cssSelector("a[class$='Trigger']")).click();
		Thread.sleep(2000);
		// css cannot support text
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		//driver.close();
		
		
		
		// input#firstName            with id
		// double atributed ccs s
		// input.formInputText        with class name. Class Should not has spaces. Space remove with dot (.)
										//But spaces work with regular css 
		}

}
