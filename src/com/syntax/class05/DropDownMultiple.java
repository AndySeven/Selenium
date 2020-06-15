package com.syntax.class05;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.syntax.util.BaseClass;

public class DropDownMultiple extends BaseClass{

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = setUpBrowser();
		driver.navigate().to("https://demoqa.com/automation-practice-form/");
		WebElement dropDown = driver.findElement(By.id("continents"));
		
		Select select = new Select(dropDown);
		
		select.selectByValue("AUS");
		List<WebElement>listOptions = select.getOptions();
		
		Iterator<WebElement> iterOptions = listOptions.iterator();
		
		while(iterOptions.hasNext()) {
			WebElement option = iterOptions.next();
			String text = option.getText();
			System.out.println(text);
		}
		Thread.sleep(2000);
		tearDown();
		
		
	}

}
