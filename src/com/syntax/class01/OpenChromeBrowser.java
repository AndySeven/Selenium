package com.syntax.class01;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenChromeBrowser {
	public static void main(String[] args) throws InterruptedException {
		// I'm not implementing OOPs concept.To ahieve it i have 
		// to do upcasting.
		// ChromeDriver driver = new ChromeDriver();
		// "obj" is not preferred way to call the reference variable
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver(); // default constructor will be created
											   // go ahead and open chrome browser
		
		Thread.sleep(2000);
		driver.close();
	}

}
