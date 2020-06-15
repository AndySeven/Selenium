package com.syntax.class06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.syntax.util.BaseClass;

public class FrameDemo extends BaseClass{
	public static void main(String[] args) throws InterruptedException {
	
		setUpBrowser();
		driver.get("http://uitestpractice.com/Students/Switchto");
		String text = driver.findElement(By.xpath("//h3[text()='click on the below link: ']")).getText();
		System.out.println(text);
		
		 /*
		  * switch focus of SeleniumDriver to frame u
		  * sing
		  * 3 diff ways:
		  * 1. By Index
		  * 2. By ID or Name
		  * 3. By WebElement
		  */
		
		// By Index
		driver.switchTo().frame(0);
		WebElement name = driver.findElement(By.id("name"));
		name.sendKeys("Vital");
		// switching to main window/ default content
		driver.switchTo().defaultContent();
		
		// By Name or ID
		driver.switchTo().frame("iframe_a"); //switch method is used to switch to a frame
		name.clear();
		name.sendKeys("Tom");
		driver.switchTo().defaultContent();
		
		
		// By WebElement
		WebElement firstFrame = driver.findElement(By.xpath("//iframe[@src='/Demo.html']"));
		driver.switchTo().frame(firstFrame);
		name.clear();
		name.sendKeys("Asel");
		driver.switchTo().defaultContent();
		
		
		Thread.sleep(2000);
		tearDown();
		
	}
}
