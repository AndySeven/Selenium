package com.practice.set01;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class PG2 {
	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver",
				"/Users/robespierre/eclipse-workspace/Selenium/drivers/chromedriver");
	WebDriver driver = new ChromeDriver();
	
	String baseURL = "https://www.facebook.com";
	String tagName = "";
	
	driver.get(baseURL);
	tagName = driver.findElement(By.id("email")).getTagName();
	System.out.println(tagName);
	
	driver.navigate().to("https://www.google.com");
	System.out.println("The title is: " + driver.getTitle());
	driver.navigate().back();
	
	driver.close();
	System.exit(0);

	}

}
