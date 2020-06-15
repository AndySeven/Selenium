package com.syntax.class07;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;

import com.syntax.util.BaseClass;

public class SimpleWindowHandle extends BaseClass{

	public static void main(String[] args) {
		setUpBrowser();
		driver.get("https://accounts.google.com/signup");
		String signUpTitle = driver.getTitle();
		System.out.println("Main sign up page is: "+signUpTitle);
		driver.findElement(By.linkText("Help")).click();
		
		/**
		 * How to get window handle?
		 * In Selenium we have two methods to get the 
		 * hand of window
		 * 1. getWindowHandle() - to get main window
		 * 2. getWindowHandle() - to iterate all open windows, all windows
		 * opened with this webdriver
		 */
		// getWindowandles returns Set of string IDs of all currently opened
		// by current instance
		Set<String>allWindowHandles = driver.getWindowHandles();
		System.out.println("Number of windows opened are: "+allWindowHandles.size());
		Iterator<String>it = allWindowHandles.iterator();
		String mainWindowHandle = null;
		String childWindowHandle = null;
		while(it.hasNext()) {
			mainWindowHandle = it.next(); // Returns the id of Main Window
			System.out.println("Id of main indow: "+mainWindowHandle);
			childWindowHandle = it.next(); // Returns the id of Child Window
			System.out.println("Id of main indow: "+childWindowHandle);
		}
		driver.switchTo().window(childWindowHandle);
		String childWindowTitle = driver.getTitle();
		System.out.println("Child page title: "+childWindowTitle);
		// will close the window on which the driver focus is. Close the browser
		// if it is last window opened
		driver.close();
		
		// doesn't work for now
		// driver.getWindowHandle();
		// System.out.println("Using getWindowHandle: "+driver.getTitle());
		//tearDown();

	}
}
