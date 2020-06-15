package com.syntax.class04;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AllLinksOfEbay {
static WebDriver driver;
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
		driver = new FirefoxDriver();
		driver.get("https://www.ebay.com");
		
		List<WebElement>allLinks = driver.findElements(By.tagName("a"));
		System.out.println(allLinks.size());
		
		int count=0;
		for(WebElement link: allLinks) {
			String text = link.getText();
			if(!text.isEmpty()) {
				System.out.println(text);
				count++;
			}
		}
		System.out.println("Total nub=mber of links:: "+count);
		
		driver.quit();
			
	}

}
