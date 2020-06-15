package com.syntax.class10.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.syntax.util.CommonMethods;

/**
 * TC 1: Drag and Drop verification Open chrome browser Go to
 * “http://www.uitestpractice.com/” Click on “Droppable” link Using mouse drag
 * “Drag me to my target” to the “Drop Here” Close the browser
 */

public class HW1DragAndDrop extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		setUpBrowser();
		driver.get("http://www.uitestpractice.com/");
		
		//WebElement drag = waitForClickabilityLocator(By.xpath("//div[@id='draggable']/p"));
		//WebElement drop = waitForClickabilityLocator(By.xpath("//div[@id='draggable']/following-sibling::div"));
		
		Actions action = new Actions(driver);
		
		action.dragAndDrop(waitForClickabilityLocator(By.xpath("//div[@id='draggable']/p")), 
				waitForClickabilityLocator(By.xpath("//div[@id='draggable']/following-sibling::div"))).perform();
		
		driver.navigate().refresh();
		Thread.sleep(1000);
		
		action.dragAndDrop(waitForClickabilityLocator(By.xpath("//div[@id='draggable']/p")), 
				waitForClickabilityLocator(By.xpath("//div[@id='draggable']/following-sibling::div"))).perform();
		//action.dragAndDrop(drag, drop).perform();
		
		Thread.sleep(4000);
		tearDown();
		
		
	}

}
