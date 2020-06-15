package com.syntax.class10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.syntax.util.CommonMethods;

public class FileUpload extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		setUpBrowser();
		String filePath = "/Users/robespierre/Desktop/Vincent van Gogh/7 Self-Portrait-With-Pallette.jpg";
		driver.get("https://the-internet.herokuapp.com/upload");
		
	
		// click on choose file
		// driver.findElement(By.cssSelector("input#file-upload")).click();
		
		// click on choose file
		// choosing file
		driver.findElement(By.id("file-upload")).sendKeys(filePath);
		
		// upload button
		driver.findElement(By.cssSelector("input#file-submit")).click();
		
		Thread.sleep(2000);
		tearDown();
		
	}

}
