package com.syntax.class04;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.syntax.Set.Selenium;

public class TaskLinksAmazon {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=Selenium.driver("chrome");
		driver.get("https://www.amazon.com/");
		List<WebElement> allLinks=driver.findElements(By.tagName("a"));
		System.out.println("Total Number of link in Amazon Home page is: "+allLinks.size());
		int count=0;
		for(WebElement link:allLinks) {
			String text=link.getText();
			if(!text.isEmpty()) {
//				System.out.println(text);
				count++;
			}
		}
		System.out.println("Number of non blank link: "+count);
		Thread.sleep(3000);
		driver.quit();
	}
}
