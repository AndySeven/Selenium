package com.syntax.class07;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.syntax.util.BaseClass;

public class WindowHandleMy {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = BaseClass.setUpBrowser();
		
		driver.get("https://demoqa.com/automation-practice-switch-windows-2/");
		driver.manage().window().fullscreen();
		Thread.sleep(1000);
		String parentW = driver.getWindowHandle();
		driver.findElement(By.id("button1")).click();
		driver.findElement(By.cssSelector("button[onclick='newBrwTab()']")).click();
		Thread.sleep(2000);
		Set<String> setW = driver.getWindowHandles();
		System.out.println("size: "+setW.size());
		Thread.sleep(2000);
		for(String w: setW) {
			if(!w.equals(parentW)) {
				System.out.println(w);
				if(w.contains("54DBB3599F"))
				Thread.sleep(2000);	
				driver.switchTo().window(w);
				Thread.sleep(2000);
				System.out.println(driver.getTitle());
				
				//WebElement logo = driver.findElement(By.cssSelector("img[class='preload-me lazyloading']"));
				//System.out.println("Logo on first child window is displayed: "+logo.isDisplayed());
				driver.close();
			}else {
				driver.switchTo().window(w);
				Thread.sleep(2000);
				WebElement pic = driver.findElement(By.cssSelector("img[class='preload-me lazyloading']"));
				System.out.println("Pic is displayed on second child window"+pic.isDisplayed());
				driver.close();
			}
			
		}
		Thread.sleep(2000);
		driver.switchTo().window(parentW);
		driver.findElement(By.xpath("//a[@title='Tooltip and Double click']")).click();
		Thread.sleep(2000);
		driver.close();
		
	}

}
