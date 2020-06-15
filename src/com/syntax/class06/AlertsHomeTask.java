package com.syntax.class06;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import com.syntax.util.BaseClass;

/**
TC 1: JavaScript alert text verification
Open chrome browser
Go to “http://jiravm.centralus.cloudapp.azure.com:8081/index.html”
Click on “Alerts & Modals” links
Click on “Javascript Alerts” links
Click on button in “Java Script Alert Box” section
Verify alert box with text “I am an alert box!” is present
Click on button in “Java Script Confirm Box” section
Verify alert box with text “Press a button!” is present
Click on button in “Java Script Alert Box” section
Enter text in the alert box
Quit browser
 */

public class AlertsHomeTask extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		
		setUpBrowser();
		
		driver.findElement(By.xpath("//a[@class='dropdown-toggle' and contains(text(),'Alerts & Modal')]")).click();
		driver.findElement(By.xpath("//a[@href='javascript-alert-box-demo.html' and contains(text(),'Javascript Alerts')]")).click();
		
		// clicking to call the Simple Alert
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btn btn-default']")).click();
		// now we are working on Alert window we should switch to it
		// it returns us the Alert
		Thread.sleep(3000);
		Alert simpleAlert = driver.switchTo().alert();
		// to get text of alert use getText() method
		String textSimpleAlert = simpleAlert.getText();
		Thread.sleep(2000);
		if(textSimpleAlert.equals("I am an alert box!")) {
			System.out.println(textSimpleAlert+" :text is Avaliable at PopUp");
		}else {
			System.out.println("Text is NOT matching");
		}
		// accepting PopUp alert
		Thread.sleep(2000);
		simpleAlert.accept();
		// switching back to default window
		driver.switchTo().defaultContent();
		
		//Switching to Confirmation alert window
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		Thread.sleep(2000);
		Alert confirmAlert = driver.switchTo().alert();
		String ct = confirmAlert.getText();
		if(ct.equals("Press a button!")) {
			System.out.println(ct+" :text is Avaliable");
		}else {
			System.out.println("Text is NOT matching");
		}
		Thread.sleep(2000);
		confirmAlert.accept();
		
		driver.switchTo().defaultContent();
		
		// Switching to Prompt Alert box with the textBox
		driver.findElement(By.cssSelector("button[class='btn btn-default btn-lg'][onclick='myPromptFunction()']")).click();
		
		String name = "Charlie";
		Thread.sleep(2000);
		Alert promptAlert = driver.switchTo().alert();
		promptAlert.sendKeys(name);
		Thread.sleep(2000);
		promptAlert.accept();
		
		String textAfterAdding = driver.findElement(By.id("prompt-demo")).getText();
		if(textAfterAdding.contains(name)) {
			System.out.println(name+" is successfully added");
		}else {
			System.out.println(name+" is NOT added");
		}
		
		
		
		
		
		tearDown();
		
		
		
	}

}
