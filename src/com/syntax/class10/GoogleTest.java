package com.syntax.class10;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.syntax.util.CommonMethods;

public class GoogleTest extends CommonMethods {

	public static void main(String[] args) {
		setUpBrowser();
		driver.get("http://www.google.com");
		driver.findElement(By.name("q")).sendKeys("iPhone");
		wait(5);
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
		wait(3);
		tearDown();
	}

}
