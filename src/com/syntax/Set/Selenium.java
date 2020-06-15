package com.syntax.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium {
	
	public static WebDriver driver(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
			return new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) 
			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
			return new FirefoxDriver();
	}
}
