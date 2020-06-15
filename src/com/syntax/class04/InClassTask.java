package com.syntax.class04;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

// TC 1: Amazon link count: 
// Open chrome browser
// Go to “https://www.amazon.com/”
// Get all links
// Get number of links that has text
// Print to console only the links that has text

public class InClassTask {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.com/");
		int count=0;
		List<WebElement> listLinks = driver.findElements(By.tagName("a"));
		System.out.println(listLinks.size());
		for(WebElement link: listLinks) {
			String linkText = link.getText();
			if(!linkText.isEmpty()) {
				System.out.println(linkText);
				count++;
			}
		}
		System.out.println("Number links with Text: "+count);
		
		
		driver.quit();
		System.exit(0);
	}
}
