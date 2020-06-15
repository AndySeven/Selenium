package com.syntax.class01;
//TC 2: Opening Page on Firefox Browser
//Open Firefox browser
//Navigate to “https://www.redfin.com/”
//Verify that you have navigated to (https://www.redfin.com/)
//End the Session (close the browser).

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InHomeTask02 {
	public static void main(String[] args) {
	String url = "https://www.redfin.com/";	
	System.setProperty("webdriver.gecko.driver","drivers/geckodriver");
	WebDriver driver = new FirefoxDriver();
	driver.get(url);
	
	if(url.equalsIgnoreCase(driver.getCurrentUrl())) {
		System.out.println("Good");
	}else {
		System.out.println("No Good");
	}
	driver.close();
	
	
	}

}
