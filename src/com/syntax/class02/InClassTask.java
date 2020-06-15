package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

// TC 2: Mercury Tours Registration: 
// Open chrome browser
// Go to “http://newtours.demoaut.com/”
// Click on Register Link
// Fill out all required info
// Click Submit
// User successfully registered
// (Create 2 scripts using different locators)
public class InClassTask {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		String actualURL = "http://newtours.demoaut.com/";
		
		driver.get(actualURL);
		driver.findElement(By.linkText("REGISTER")).click();
		driver.findElement(By.name("firstName")).sendKeys("Bobby");
		driver.findElement(By.name("lastName")).sendKeys("Smith");
		driver.findElement(By.name("phone")).sendKeys("1212121212");
		driver.findElement(By.id("userName")).sendKeys("bobby67@gmail.com");
		driver.findElement(By.name("address1")).sendKeys("1213 99th St");
		driver.findElement(By.name("address2")).sendKeys("bsmt");
		driver.findElement(By.name("city")).sendKeys("Brooklyn");
		driver.findElement(By.name("state")).sendKeys("New York");
		driver.findElement(By.name("postalCode")).sendKeys("113344");
		Select country = new Select (driver.findElement(By.name("country")));
		country.selectByVisibleText("SERBIA");
		driver.findElement(By.id("email")).sendKeys("asasa@gmail.com");
		driver.findElement(By.name("password")).sendKeys("koba123");
		driver.findElement(By.name("confirmPassword")).sendKeys("koba123");
		//driver.findElement(By.name("register")).click();
		

	}

}
