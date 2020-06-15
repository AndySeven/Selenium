package com.syntax.class04.mypractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.syntax.util.BaseClass;

public class DropDown extends BaseClass{
static WebDriver driver;
	
	
	public static void main(String[] args) throws InterruptedException {
		driver = setUpBrowser();
		getDropDownPracticePage();
		checkDropdown();
		checkDropdownMultiOptions();
		
		
		Thread.sleep(3000);
		tearDown();

	}
	
	public static void getDropDownPracticePage() {
		driver.findElement(By.xpath("//a[contains(text(),'Input Forms') and @data-toggle='dropdown']")).click();
		driver.findElement(By.xpath(" //a[contains(text(),'Select Drop')]")).click();
	}
	
	
	public static void checkDropdown() throws InterruptedException {
		WebElement dropDown = driver.findElement(By.cssSelector(" select#select-demo"));
		Select select = new Select(dropDown);
		
			if(!select.isMultiple()) {
				select.selectByValue("Monday");
			}
			Thread.sleep(2000);
			List<WebElement> listOptions = select.getOptions();
			for(WebElement option: listOptions) {
				if(option.isSelected()) {
					System.out.println(option.getText()+" is selectet, test is have been passed");
				}
			}
			driver.navigate().refresh();
		}
	public static void checkDropdownMultiOptions() {
		WebElement dropDown = driver.findElement(By.cssSelector("select#multi-select"));
		Select select = new Select(dropDown);
	
			select.selectByIndex(1);
			select.selectByValue("Ohio");
			select.selectByVisibleText("Texas");
		
		List<WebElement> listOptions = select.getOptions();
		
		for(WebElement option: listOptions) {
			if(option.isSelected()) {
				System.out.println(option.getText()+" option is selected, test case is have been passed");
			}
		}
		
		select.deselectAll();
		int count = 0;
		for(WebElement option: listOptions) {
			if(option.isSelected()) {
				count++;
			}
		}
		if(count==0) {
			System.out.println("All options is deselected, test case is have been passed");
		}
			
		
	}
}
