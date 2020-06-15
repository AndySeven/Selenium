package com.syntax.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchChromeBrowser {
	public static void main(String[] args) {
		// Making connection to the driver
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		//opening the browser by calling the constructor of ChromeDriver class and upcasting
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		String url = driver.getCurrentUrl();
		// "err" same color as the errors
		// System.err.println(url);  
		System.out.println(url);  
		String tittle = driver.getTitle();
		if(tittle.contentEquals("Google")) {
			System.out.println("Right Title: "+tittle);
		}
		if(url.equalsIgnoreCase("https://www.google.com/")) {
			System.out.println("Right url: "+url);
		}else {
			System.out.println("Wrong URL is returned");
		}
		driver.close();
	}
}
