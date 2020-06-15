package com.syntax.class06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import com.syntax.util.BaseClass;

public class PracticeFrames extends BaseClass{

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = setUpBrowser();
		//System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "true");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "true");
		driver.get("http://166.62.36.207/syntaxpractice/bootstrap-iframe.html");
		
		driver.switchTo().frame("FrameOne");
		boolean logoIsDis = driver.findElement(By.id("hide")).isDisplayed();
		System.out.println("Logo is displayed: "+logoIsDis);
		driver.switchTo().defaultContent();
		// driver.switchTo().parentFrame(); // the same as default
		
		driver.switchTo().frame(1);
		boolean isEn = driver.findElement(By.className("enroll-btn")).isEnabled();
		System.out.println("Enroll button is enabled: "+isEn);
		
		
		
		
		
		Thread.sleep(2000);
		tearDown();

	}

}
