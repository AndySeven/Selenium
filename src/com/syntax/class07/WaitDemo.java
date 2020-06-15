package com.syntax.class07;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.syntax.util.BaseClass;

public class WaitDemo {

	public static void main(String[] args) {
		
		/**
		 * 
		 */
		WebDriver driver = BaseClass.setUpBrowser();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		boolean isHomeDis = driver.findElement(By.cssSelector("img#hide")).isDisplayed();
		System.out.println(isHomeDis);
	}

}
