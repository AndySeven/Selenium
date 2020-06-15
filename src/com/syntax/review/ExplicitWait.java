package com.syntax.review;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.syntax.util.CommonMethods;

public class ExplicitWait extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		setUpBrowser();
		driver.get("https://www.seleniumeasy.com/test/jquery-download-progress-bar-demo.html");
		
		WebElement startDownloadButton = waitForClickabilityLocator(By.id("downloadButton"));
		startDownloadButton.click();
		
		
		//WebElement textComplete  = waitForPresenceOfElLocated(By.xpath("//div[contains(text(),'Complete!')]"));
		//WebElement textComplete  = waitForVisibility(driver.findElement(By.xpath("//div[contains(text(),'Complete!')]")));
		WebElement textComplete  = waitForVisibilityLocator(By.xpath("//div[contains(text(),'Complete!')]"));
		System.out.println("Is text Element is Displyed? -> "+textComplete.isDisplayed());
		System.out.println("Displaying text is -> "+textComplete.getText());
		
		//startDownloadButton.click();
		WebElement closeButton = waitForClickabilityLocator(By.xpath("//button[text()='Close']"));
		System.out.println(closeButton.getText());
		closeButton.click();
		
		
		
		Thread.sleep(3000);
		tearDown();

	}

}
