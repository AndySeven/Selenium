package com.syntax.class07.homework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.syntax.util.BaseClass;

/**
TC 1: Verify element is clickable
Open chrome browser
Go to “https://the-internet.herokuapp.com/”
Click on “Click on the “Dynamic Controls” link
Select checkbox and click Remove
Click on Add button and verify “It's back!”
text is displayed   
Close the browser
 */
public class DynamicControls extends BaseClass{
static String expectedText = "It's back!";
	
public static void main(String[] args) {
	
		setUpBrowser();
		driver.get("https://the-internet.herokuapp.com/");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		click(driver.findElement(By.xpath("//a[contains(text(),'Controls')]")));
		
		checkSingleCheckBox(driver.findElement(By.cssSelector("input[type='checkbox']")));
		
		click(driver.findElement(By.xpath("//button[contains(text(),'R')]")));
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Add')]")));	
		driver.findElement(By.xpath("//button[contains(text(),'Add')]")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("p#message")));
		WebElement message = driver.findElement(By.cssSelector("p#message"));
		verify(message);
		
		driver.quit();

	}
	
	public static WebDriverWait getWaitObj() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait;
	}
	public static void waitForVisibility(WebElement element) {
		getWaitObj().until(ExpectedConditions.visibilityOf(element));
	}
	public static void waitForClickability(WebElement element) {
		getWaitObj().until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void click(WebElement element) {
		waitForClickability(element);
		element.click();
	}
	public static void checkSingleCheckBox(WebElement element) {
		waitForVisibility(element);
		if(!element.isSelected()) {
			element.click();
		}else {
			System.out.println(element.getText()+" -> element already selected");
		}
	}
	
	public static void verify(WebElement element) {
		
		if(element.getText().contains(expectedText)) {
			System.out.println("Text from WebSite -> "+element.getText());
		}else {
			System.out.println("Test Faild");
		}
	}

}
