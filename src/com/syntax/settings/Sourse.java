package com.syntax.settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Sourse {
	public static final String HUSERNAME = "admin";
	public static final String HPASSWORD = "Hum@nhrm123";
	
	public static String getURL(String url) {
		String sourseUrl = null;
		if (url.equalsIgnoreCase("humanresources")) {
			sourseUrl = "http://166.62.36.207/humanresources/symfony/web/index.php/auth/login";
		}
		return sourseUrl;
	}

	public static WebDriver browser(String browser) {
		WebDriver dr = null;
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
			dr = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
			dr = new FirefoxDriver();
		}
		return dr;
	}
}
