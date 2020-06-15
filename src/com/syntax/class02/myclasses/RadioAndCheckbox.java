package com.syntax.class02.myclasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RadioAndCheckbox {
static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
		driver = new FirefoxDriver();
		driver.get("http://demo.guru99.com/test/radio.html");
		
		
			List<WebElement> listRadio = driver.findElements(By.cssSelector("input[type='radio']"));
		
			for(int i=0; i<listRadio.size(); i++) {
			WebElement elem = listRadio.get(i);
			boolean b = elem.isSelected();
			System.out.println("radio button ("+i+") is selected: "+b);
			elem.click();
			b = elem.isSelected();
			System.out.println("radio button ("+i+") after clicking: "+b);
			
		}
			
			List<WebElement> listRadioAndCheckbox = driver.findElements(By.cssSelector("input[name='webform']"));
			System.out.println(listRadioAndCheckbox);
			
			
			
			for(WebElement x : listRadioAndCheckbox) {
				if((x.getAttribute("value")).startsWith("Opt")) {
					
					System.out.println("radio before: "+x.isSelected());
					x.click();
					System.out.println("radio after clicking: "+x.isSelected());
				}else {
					System.out.println("checkbox before: "+x.isSelected());
					x.click();
					System.out.println("checkbox after cliking: "+x.isSelected());
				}
			}
			
			
			System.out.println("---------------------After Test --------------------------");
			for(WebElement x: listRadioAndCheckbox) {
				if((x.getAttribute("value")).startsWith("Opt")) {
					System.out.println("radio After test: "+x.isSelected());
				}else {
					System.out.println("checkbox after test: "+x.isSelected());
			}
			}
			
			
			Thread.sleep(3000);
			driver.quit();
			System.exit(0);

	}

}
