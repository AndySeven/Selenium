package com.syntax.class07;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.syntax.util.BaseClass;

public class WindowHandleWithLoop {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = BaseClass.setUpBrowser();
		
		driver.get("https://demoqa.com/automation-practice-switch-windows-2/");
		String signUpTitle = driver.getTitle();
		System.out.println("Main page itle is: "+ signUpTitle);
		// id of very first patent window
		String parentWindowHandle = driver.getWindowHandle();
		
		for(int i=1; i<=3; i++) {
			driver.findElement(By.id("button1")).click();
			Thread.sleep(2000);
		}
		
		Set<String> allWHs = driver.getWindowHandles();
		
		for(String handle: allWHs) {
			System.out.println("id of the window: "+handle);
			driver.switchTo().window(handle);
			driver.get("http://www.google.com");
			Thread.sleep(2000);
			driver.close();
		}
	}

}
