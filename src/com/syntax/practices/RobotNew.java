package com.syntax.practices;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.syntax.util.CommonMethods;

public class RobotNew extends CommonMethods{

	public static void main(String[] args) {
		setUpBrowser();
		driver.get("http://www.google.com");
		wait(3);
		
		Actions action = new Actions(driver);
		WebElement r = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
		action.moveToElement(r).sendKeys("asasas").perform();
		wait(2);
		action.sendKeys(Keys.ENTER).perform();
		wait(2);
		
		WebElement e = driver.findElement(By.name("q"));
		action.click(e)
		.keyDown(e,Keys.COMMAND)
		.sendKeys("a")
		.keyUp(Keys.COMMAND)
		.sendKeys("x")
		.keyDown(e, Keys.COMMAND)
		.sendKeys("v")
		.keyUp(Keys.COMMAND)
		.sendKeys(Keys.RETURN)
		.build()
		.perform();
		wait(2);
		//action.moveToElement(driver.findElement(By.name("q"))).sendKeys(Keys.).perform();
		
	
		
		
		
		
//		action.sendKeys(Keys.TAB).perform();						
//		action.sendKeys(Keys.TAB).perform();
//		action.sendKeys(Keys.TAB).perform();
//		action.sendKeys(Keys.TAB).perform();
//		action.sendKeys(Keys.TAB).perform();
//		action.sendKeys(Keys.TAB).perform();
//		action.sendKeys(Keys.TAB).perform();
//		action.sendKeys(Keys.TAB).perform();
//		action.sendKeys(Keys.TAB).perform();
//		action.sendKeys(Keys.TAB).perform();
//		action.sendKeys(Keys.TAB).perform();
//		action.sendKeys(Keys.TAB).perform();
//		action.sendKeys(Keys.TAB).perform();
//		action.sendKeys(Keys.TAB).perform();
//		action.sendKeys(Keys.TAB).perform();
		wait(3);
		
		
//		try {
//		Robot robot = new Robot();
//		
//		
//	
//	    robot.keyPress(KeyEvent.VK_TAB);
//	    robot.keyPress(KeyEvent.VK_TAB);
//	    robot.keyPress(KeyEvent.VK_TAB);
//	    robot.keyPress(KeyEvent.VK_TAB);
//	    
//	    robot.keyPress(KeyEvent.VK_ENTER);
//	    
//	  
//		}catch(AWTException e) {
//			e.printStackTrace();
//		}
		
		tearDown();
	}
}