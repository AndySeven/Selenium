package com.syntax.review;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.syntax.util.CommonMethods;

public class HandlingAlerts extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		setUpBrowser();
		driver.get("http://www.seleniumframework.com/Practiceform/");
		
		WebElement alertButton = waitForClickability(driver.findElement(By.id("alert")));
		alertButton.click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		alert.accept();
		
		WebElement timingAlertB = driver.findElement(By.cssSelector("button#timingAlert"));
		timingAlertB.click();
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.alertIsPresent());
		Thread.sleep(2000);
		alert.accept();
	
		tearDown();
		Thread.sleep(5000);
	}

}
