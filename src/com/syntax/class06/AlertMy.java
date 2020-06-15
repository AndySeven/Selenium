package com.syntax.class06;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import com.syntax.util.BaseClass;

public class AlertMy extends BaseClass{

	public static void main(String[] args) throws InterruptedException {
		
		setUpBrowser();
		switchWindows();		
		tearDown();
	}
	public static void alert() throws InterruptedException {
		driver.get("http://demo.guru99.com/test/delete_customer.php");
		driver.findElement(By.cssSelector("input[name='cusid']")).sendKeys("weew");
		driver.findElement(By.cssSelector("input[name='cusid']")).submit();
		//driver.findElement(By.cssSelector("input[name='submit']")).click();;
		
		//WebElement alertElement = driver.findElement(By.cssSelector("div.modal"));
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		Thread.sleep(2000);
		alert.accept();
		Thread.sleep(2000);
		}
	public static void switchWindows() throws InterruptedException {
		
		driver.get("http://demo.guru99.com/popup.php");
		Thread.sleep(2000);
		driver.manage().window().fullscreen();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("a[target='_blank']")).click();
		Thread.sleep(2000);
		
		String mainWindow = driver.getWindowHandle();
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();
		while(i1.hasNext()) {
		String childWindow = i1.next();
		if(!mainWindow.equalsIgnoreCase(childWindow)) {
			driver.switchTo().window(childWindow);
			Thread.sleep(2000);
			driver.findElement(By.name("emailid")).sendKeys("dasd@mail.com");
			Thread.sleep(2000);
			driver.findElement(By.name("emailid")).submit();
			Thread.sleep(2000);
			System.out.println(childWindow);
			driver.close();
		}
		}
		Thread.sleep(2000);
		driver.switchTo().window(mainWindow);
	}
}
