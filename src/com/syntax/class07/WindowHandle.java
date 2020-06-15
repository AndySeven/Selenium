package com.syntax.class07;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.syntax.util.BaseClass;

public class WindowHandle {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = BaseClass.setUpBrowser();
		driver.get("http://166.62.36.207/syntaxpractice/window-popup-modal-demo.html");
		String signUpTitle = driver.getTitle();
		System.out.println("Main page itle is: "+ signUpTitle);
		// id of very first patent window
		String parentWindowHandle = driver.getWindowHandle();
		
		driver.findElement(By.linkText("Follow On Instagram")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Like us On Facebook")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Follow Instagram & Facebook")).click();
		Thread.sleep(1000);
		
		Set<String> allWHandles = driver.getWindowHandles();
		System.out.println("Num of Windows opened: "+allWHandles.size());
		Iterator<String>it=allWHandles.iterator();
		
		while(it.hasNext()) {
			String handle = it.next();
			if(!handle.equals(parentWindowHandle)) {
				driver.switchTo().window(handle);
				System.out.println("Title of page: "+driver.getTitle());
				driver.close();
				Thread.sleep(2000);
			}
		}
		
		

	}

}
