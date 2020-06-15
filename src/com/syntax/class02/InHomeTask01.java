package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

// TC 1: Facebook sign up: 
// Open chrome browser
// Go to “https://www.facebook.com/”
// Enter first name
// Enter last name
// Enter mobile number
// Click on sign up button

public class InHomeTask01 {
	public static void main(String[] args) {
System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
WebDriver driver = new ChromeDriver();

driver.get("https://www.facebook.com/");
driver.findElement(By.id("u_0_m")).sendKeys("Richardo");
WebElement name;
name = driver.findElement(By.id("u_0_m"));
String tagName = name.getTagName();
System.out.println("tagName is: " +tagName);

driver.findElement(By.id("u_0_o")).sendKeys("Stivensson");
driver.findElement(By.id("u_0_r")).sendKeys("2342323233");

Select select = new Select(driver.findElement(By.id("month")));
select.selectByVisibleText("Aug");

WebElement signUpButton = driver.findElement(By.id("u_0_13"));
signUpButton.click();
String s = signUpButton.getText();

System.out.println(s);
//System.out.println("---------------------");
//System.out.println(driver.getPageSource());
//System.out.println("---------------------");
driver.quit();
System.exit(0);

	}
}
