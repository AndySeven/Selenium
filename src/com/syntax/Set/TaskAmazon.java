package com.syntax.Set;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Go to amazon.com
	 * select books from the search dropdown
	 * type Harry potter
	 * and click on Search
	 * check Unofficial CookBook checkbox on the left under Book Series
 */
import com.syntax.util.BaseClass;
public class TaskAmazon extends BaseClass {
	public static void main(String[] args) throws InterruptedException {
		
		setUpBrowser();
		
		driver.get("http://www.amazon.com");
		Select select = new Select(driver.findElement(By.id("searchDropdownBox")));
		Thread.sleep(2000);
		
		
		
		
		select.selectByVisibleText("Books");
		Thread.sleep(1000);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Harry Potter");
		Thread.sleep(2000);
		driver.findElement(By.className("nav-input")).click();
		
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//span[@class='a-size-base a-color-base'][text()='Unofficial Cookbook']")).click();
		
		
		List<WebElement>listCheckBox = driver.findElements(By.className("a-spacing-micro"));
		Thread.sleep(1000);
		for(WebElement check: listCheckBox) {
			
			String s = check.getText();
			System.out.println(s);
			if(s.equals("Unofficial Cookbook")) {
			check.click();
			break;
			}
		}
		
		Thread.sleep(2000);
		WebElement one = driver.findElement(By.xpath("//span[contains(text(),'Unof') and @class='a-color-base a-text-bold']")); 
		WebElement two = driver.findElement(By.cssSelector("span[class='a-color-state a-text-bold']")); 
		Thread.sleep(2000);
		System.out.println("------------------------");
		String textOne = one.getText();
		String textTwo = two.getText();
		System.out.println(textOne);
		System.out.println(textTwo);
		System.out.println("------------------------");
		if(textTwo.contains("Harry Potter") && textOne.equals("Unofficial Cookbook")) {
			System.out.println("Correctly");
		}else {
			System.out.println("Error");
		}
		
//		List<WebElement> listLinks = driver.findElements(By.tagName("a"));
//		for(WebElement link: listLinks) {
//			String l = link.getText();
//			System.out.println(l);
//			if(l.equals("Books")) {
//				link.click();
//			}
//		}
		
		
		tearDown();
		
		
		
	}

}
