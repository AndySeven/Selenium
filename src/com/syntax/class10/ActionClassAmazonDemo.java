package com.syntax.class10;

import javax.swing.JButton;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Sleeper;

import com.syntax.util.BaseClass;

public class ActionClassAmazonDemo {

	public static void main(String[] args) throws InterruptedException {
		
		
		BaseClass.setUpBrowser();
		WebDriver driver = BaseClass.driver;
		driver.get("http://www.amazon.com");
		
		WebElement account = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
		Actions action  = new Actions(driver);
		
		action.moveToElement(account).perform();
		// hover the mouse
		WebElement text = driver.findElement(By.xpath("//div[@id='nav-flyout-ya-newCust']"));
		
		if(text.getText().contains("Start")) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
		
		// right click on element
		action.contextClick(text).perform();
		
		// send keys using actions
		WebElement searchbox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		action.moveToElement(searchbox).click().sendKeys("Movies").doubleClick().perform();
		
		// another way
		// action.moveToElement(searchbox).click().keyUp(Keys.SHIFT).sendKeys("movies").perform();
		
		
		
		Thread.sleep(5000);
		BaseClass.tearDown();
	}

}
