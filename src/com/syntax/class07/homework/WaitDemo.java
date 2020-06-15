package com.syntax.class07.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.syntax.util.CommonMethods;

public class WaitDemo extends CommonMethods {

	public static void main(String[] args) {
		
		setUpBrowser();
		driver.get("https://the-internet.herokuapp.com/dynamic_controls");
		
		// implicit wait
		// driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.cssSelector("input[type='checkbox']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'R')]")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		WebElement btn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(),'Add')]")));
		btn.click();
		
		WebElement textBack = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("p#message")));
		System.out.println(textBack.getText());
		
		//wait.until(ExpectedConditions.stalenessOf(element));
		
	}

}
