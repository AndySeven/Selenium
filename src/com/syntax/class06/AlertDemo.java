package com.syntax.class06;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import com.syntax.util.BaseClass;

public class AlertDemo extends BaseClass{

	public static void main(String[] args) throws InterruptedException {
		
		setUpBrowser();
		// Simple Alert
		driver.get("http://uitestpractice.com/Students/Switchto");
		driver.findElement(By.id("alert")).click();;
		// we cannot click on any element of window in cause of active alert box/PopUp
		// driver.findElement(By.id("confirm")).click();;
		//switch focus on alert box
		Alert simpleAlert = driver.switchTo().alert();	// return one alert object and store in Alert variable
		Thread.sleep(1000);
		System.out.println("Text from Simple Alert Box: "+simpleAlert.getText());
		Thread.sleep(1000);
		simpleAlert.accept();  //simple accept simple alert
		
		
		//Confirmation Alert
		driver.findElement(By.id("confirm")).click();
		Alert confirmAlert = driver.switchTo().alert();
		Thread.sleep(1000);
		String confirmText = confirmAlert.getText();
		System.out.println("This is confirm Alert Text: "+confirmText);
		Thread.sleep(1000);
		confirmAlert.dismiss();
		
		// Handling Prompt Alert/Confirmation alert by providing some confirmation message
		driver.findElement(By.xpath("//button[@id='prompt']")).click();
		Thread.sleep(1000);
		Alert promptAlert = driver.switchTo().alert();
		Thread.sleep(1000);
		System.out.println("This is prompt Alert text: "+promptAlert.getText());
		String name = "John Rambo";
		promptAlert.sendKeys(name);  
		Thread.sleep(3000);
		promptAlert.accept();
		Thread.sleep(3000);
		
		String s = driver.findElement(By.xpath("//div[@id='demo']")).getText();
		System.out.println(s);
		if(s.contains(name)) {
			System.out.println(name+" Text successfully added to prompt alert");
		}else {
			System.out.println(name+" Text has not added");
		}
		
		Thread.sleep(3000);
		tearDown();
	
	}
	

}
