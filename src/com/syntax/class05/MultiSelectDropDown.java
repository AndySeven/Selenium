package com.syntax.class05;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.syntax.util.BaseClass;

public class MultiSelectDropDown extends BaseClass{
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = setUpBrowser();
		driver.navigate().to("https://demoqa.com/automation-practice-form/");
		WebElement multiSelectDropDown = driver.findElement(By.id("continentsmultiple"));
		Select select = new Select(multiSelectDropDown);
		boolean isMultiple = select.isMultiple();
		System.out.println("This DropDown is Multi Select? -"+isMultiple);
		
		if(isMultiple) {
			select.selectByIndex(1);
			select.selectByVisibleText("North America");
			Thread.sleep(2000);
			select.deselectByValue("EU");
		}
		List<WebElement>listSelected = select.getAllSelectedOptions();
		for(WebElement selected: listSelected) {
			System.out.println(selected.getText()); //must be North America only
		}
		
		select.deselectAll();
		
		
		
		tearDown();
	}

}
