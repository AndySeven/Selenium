package com.syntax.class10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.syntax.util.CommonMethods;

public class ActionsDragAndDrop extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		setUpBrowser();
		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(0);
		WebElement drag  =waitForClickabilityLocator(By.id("draggable"));
		WebElement drop  =waitForClickabilityLocator(By.id("droppable"));
		
		Actions action = new Actions (driver);
		
		// long way(drag file and drop in the source)
		action.clickAndHold(drag).moveToElement(drop).release().perform();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		
		//short way
		//waitForClickability(drag);
		action.dragAndDrop(waitForClickabilityLocator(By.id("draggable")), drop).perform();
		
		Thread.sleep(2000);
		tearDown();
		
	}

}
