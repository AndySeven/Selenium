package com.syntax.class05;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.syntax.util.BaseClass;

public class DropDownIntro 	{
static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver = BaseClass.setUpBrowser();
		//testDropDown();
		dropDown2();
		Thread.sleep(3000);
		BaseClass.tearDown();
	}
	
	/**
	 * 
	 */
	public static void testDropDown() throws InterruptedException {
		
		driver.navigate().to("http://jiravm.centralus.cloudapp.azure.com:8081/basic-select-dropdown-demo.html");
		WebElement weekDD = driver.findElement(By.id("select-demo"));
		Select select = new Select(weekDD);
		//using index
		//select.selectByIndex(3);
		List<WebElement> options = select.getOptions();
		System.out.println("Number of Ootions in the DD: "+options.size());
		
		for(int i=0; i<options.size(); i++) {
			select.selectByIndex(i);
			Thread.sleep(1000);
		}
		
		// By visible Text
		select.selectByVisibleText("Friday");
		
		
		
	}
	
	public static void dropDown2() throws InterruptedException {
		driver.navigate().to("https://demoqa.com/automation-practice-form/");
		WebElement continents =driver.findElement(By.id("continents"));
		Select select = new Select(continents);
		List<WebElement>options = select.getOptions();
		for(WebElement option: options) {
			String text = option.getText();
			//System.out.println(text);
			if(text.equals("Africa")) {
				// can use diff options to select
				option.click();
				String text2 = option.getText();
				if(text2.equals("Africa")) {
					System.out.println(text2+" is selected: "+option.isSelected());
				}else {
					System.out.println("Africa is not selected");
				}
				
				//select.selectByVisibleText("Europe");
				//select.selectByValue("NA");
			}
				
		}
		
		boolean isMultiple = select.isMultiple();
		System.out.println(isMultiple);
		
	}
	

}
