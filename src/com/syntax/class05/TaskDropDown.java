package com.syntax.class05;
// TC 1: Facebook dropdown verification
// Open chrome browser
// Go to “https://www.facebook.com”
// Verify:
// month dd has 12 month options
// day dd has 31 day options
// year dd has 115 year options
// Select your date of birth	
// Quit browser

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.syntax.util.BaseClass;

public class TaskDropDown extends BaseClass{
	
	public static void main(String[] args) throws InterruptedException {
		
		setUpBrowser();
		
		driver.navigate().to("https://www.facebook.com");
		checkSizeDropDown("month", 12);
		checkSizeDropDown("day", 31);
		checkSizeDropDown("year", 115);
		selectDateOfBirth("Feb", "3", "1986");
		
		tearDown();

	}
	public static void checkSizeDropDown(String DropDownId, int options) {
		WebElement element = driver.findElement(By.id(DropDownId));
		Select select = new Select(element);
		
		List<WebElement> list = select.getOptions();
		int num = list.size();
		System.out.println("DropDown Months has: "+num+" optons");
		if(num!=options) {
			System.out.println("inconsistancy");
		}else {
			System.out.println("very good");
		}
	}
	public static void selectDateOfBirth(String month, String day, String year) throws InterruptedException {

			WebElement element = driver.findElement(By.id("month"));
			Select select = new Select(element);
			select.selectByVisibleText(month);
			Thread.sleep(2000);
			WebElement element2 = driver.findElement(By.id("day"));
			select = new Select(element2);
			select.selectByVisibleText(day);
			Thread.sleep(2000);
			WebElement element3 = driver.findElement(By.id("year"));
			select = new Select(element3);
			select.selectByVisibleText(year);
			Thread.sleep(2000);
		}	
	}