package com.syntax.class04.homework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.syntax.util.BaseClass;

// TC 4: Radio Buttons Practice  
// Open chrome browser
// Go to “http://jiravm.centralus.cloudapp.azure.com:8081/index.html”
// Click on “Input Forms” links
// Click on “Radio Buttons Demo” links
// Click on any radio button in “Radio Button Demo” section.
// Verify correct radio is clicked
// Click on any radio button in “Group Radio Buttons Demo” section.
// Verify correct checkbox is clicked
// Quit browser

public class RadioButtonPractice extends BaseClass {
	static WebDriver driver;

	public static void main(String[] args) {
		driver = setUpBrowser();
		testRadioButtonsDemo();
		testGroupRadioButtonDemo();
		tearDown();
	}

	/**
	 * Method
	 * 
	 * @author robespierre
	 *
	 */
	public static void testRadioButtonsDemo() {
		driver.findElement(By.xpath("//a[contains(@class,'drop') and contains(text(),'Inp')]")).click();
		driver.findElement(
				By.xpath("//a[contains(text(),'Radio Buttons Demo')][contains(@href,'basic-radiobutton-demo.html')]"))
				.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<WebElement> listRadio = driver.findElements(By.cssSelector("input[type=radio][name=optradio]"));
		boolean isSelected = listRadio.get(0).isSelected();
		if (isSelected) {
			listRadio.get(1).click();
			if (listRadio.get(1).isSelected()) {
				System.out.println(listRadio.get(1).getAttribute("value") + " - Button Successfully checked");
			}
			listRadio.get(0).click();
			if (listRadio.get(0).isSelected()) {
				System.out.println(listRadio.get(0).getAttribute("value") + " - Button Successfully checked");
			}
		} else {
			listRadio.get(0).click();
			if (listRadio.get(0).isSelected()) {
				System.out.println(listRadio.get(0).getAttribute("value") + " - Button Successfully checked");
			}
			listRadio.get(1).click();
			if (listRadio.get(1).isSelected()) {
				System.out.println(listRadio.get(1).getAttribute("value") + " - Button Successfully checked");
			}
		}

	}

	public static void testGroupRadioButtonDemo() {
		List<WebElement> listSex = driver.findElements(By.cssSelector("input[type=radio][name=gender]"));
		List<WebElement> listAge = driver.findElements(By.cssSelector("input[type=radio][name=ageGroup]"));

		String valueSexToBeSelected = "Female";
		String valueAgeToBeSelected = "5 - 15";
		for (WebElement sex : listSex) {
			String value = sex.getAttribute("value");
			if (sex.isEnabled() && value.equals(valueSexToBeSelected)) {
				sex.click();
			
			}
			if (sex.isSelected()) {
				System.out.println(value + " - button is Selected, test case is passed");
				break;
			}
			
		}
		try {
			
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for (WebElement age : listAge) {
			String value = age.getAttribute("value");
			if (age.isEnabled() && value.equals(valueAgeToBeSelected)) {
				age.click();
				
			}
			if (age.isSelected()) {
				System.out.println(value + " - button is Selected, test case is passed");
				break;
			}
			
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
