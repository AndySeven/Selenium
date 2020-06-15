package com.syntax.class04;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RadioDemo {
static WebDriver driver;
static String URL = "https://demoqa.com/automation-practice-form/";
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
		driver = new FirefoxDriver();
		driver.get(URL);
		WebElement maleRadio = driver.findElement(By.xpath("//input[@id='sex-0']"));
		//System.out.println("attribute: "+maleRadio.getAttribute("class"));
		System.out.println(maleRadio.isDisplayed()); //true
		System.out.println(maleRadio.isEnabled()); //true
		System.out.println("Radio Button is selected: "+maleRadio.isSelected()); //false
		System.out.println();
		Thread.sleep(3000);
		//first way to click on Radio Button
		maleRadio.click();
		System.out.println("Radio Button is selected: "+maleRadio.isSelected()); //true
		// Years of experience
		//List<WebElement> listRadioB = driver.findElements(By.xpath("//input[@name='exp']"));
		//int listSize=listRadioB.size();
		//System.out.println("Size of CheckBoxes Years of Experience are:: "+listSize);
		//Sex
		List<WebElement> listRadioSex = driver.findElements(By.xpath("//input[@name='profession']"));
		int listSize2=listRadioSex.size();
		System.out.println("Size of CheckBoxes Years of Experience are:: "+listSize2);
		
		String valueToBeSelected = "Manual Tester";
		for(WebElement profession: listRadioSex) {    
			if(profession.isEnabled()) {                   // checking available
				String value = profession.getAttribute("value"); // get value
				System.out.println(value);
				if(value.equals(valueToBeSelected)) {
					profession.click();
					break;
				}
			}
		}
		
		
		Thread.sleep(3000);
		driver.quit();
		System.exit(0);
	}
}