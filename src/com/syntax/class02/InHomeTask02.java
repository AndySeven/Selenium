package com.syntax.class02;
// TC 2: Syntax Page URL Verification: 
// Open chrome browser
// Navigate to “https://www.zillow.com/”
// Navigate to “https://www.google.com/”
// Navigate back to Zillow Page
// Refresh current page
// Verify url contains “Zillow”

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InHomeTask02 {
	public static void main(String[] args) {
System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
WebDriver driver = new FirefoxDriver();
String actualURL = "https://www.zillow.com/";
driver.get(actualURL);
driver.navigate().to("https://www.google.com/");
driver.navigate().back();
driver.navigate().refresh();
String currentURL = driver.getCurrentUrl();

if(currentURL.toLowerCase().contains(("Zillow").toLowerCase())) System.out.println("URL contains Zillow");
else System.out.println("URL doesn't contain Zillow");

driver.close();
//driver.quit();
//System.exit(0);	

	}
}
