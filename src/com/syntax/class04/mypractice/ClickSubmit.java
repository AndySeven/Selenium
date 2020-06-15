package com.syntax.class04.mypractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.syntax.Set.Selenium;

public class ClickSubmit {

	public static void main(String[] args) {
		WebDriver driver = Selenium.driver("chrome");
		driver.get("https://account.magento.com/");
		
		driver.manage().window().fullscreen();
		driver.navigate().to("https://account.magento.com/customer/account/login?_ga=2.111180935.203851583.1588261258-661003896.1588261258");
		WebElement userName = driver.findElement(By.id("email"));
		userName.clear();
		userName.sendKeys("Charlie");
		WebElement password = driver.findElement(By.cssSelector("input[id='pass'][title='Password']"));
		password.clear();
		password.sendKeys("1234e");
		//WebElement submit = driver.findElement(By.cssSelector("input[id='pass'][title='Password']"));
		password.submit();
		// for click we need to find button type element
		
		
	}
}
