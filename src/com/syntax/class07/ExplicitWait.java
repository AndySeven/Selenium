package com.syntax.class07;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.syntax.util.BaseClass;

public class ExplicitWait {

	public static void main(String[] args) {

		WebDriver driver = BaseClass.setUpBrowser();
		driver.get("http://166.62.36.207/syntaxpractice/dynamic-data-loading-demo.html");
		// waits while loaded and click on Get New User, otherwise doesn't work
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.id("save")).click();

		//boolean isDisp = driver.findElement(By.xpath("//p[contains(text(),'First Name')]")).isDisplayed();

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'First Name')]")));
		WebElement ele = driver.findElement(By.xpath("//p[contains(text(),'First Name')]"));
		System.out.println(ele.isDisplayed());

		BaseClass.tearDown();
	}

}
