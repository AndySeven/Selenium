package com.syntax.class04.homework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.syntax.util.BaseClass;

// TC 3: Syntax Demo input boxes count: 
// Open chrome browser
// Go to “http://jiravm.centralus.cloudapp.azure.com:8081/index.html”
// Click on “Input Forms” links
// Click on “Simple Form Demo” links
// Get all input boxes from the page
// Enter “Hello” to each text box
// Close browser

public class CountInputBoxes extends BaseClass {
	static WebDriver driver;

	/**
	 * Method performs test case, insertion Hello into every text box
	 * checks the insertion and makes output in console the result
	 * 
	 * @author robespierre
	 * 
	 */
	public static void performTestCase() {
		WebElement inputForms = driver.findElement(By.xpath("//a[contains(text(),'Forms')][@data-toggle='dropdown']"));
		inputForms.click();
		WebElement simpleFormDemo = driver
				.findElement(By.xpath("//a[text()='Simple Form Demo'][@href='basic-first-form-demo.html']"));
		simpleFormDemo.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		List<WebElement> listInput = driver.findElements(By.cssSelector("input.form-control"));
		for (WebElement input : listInput) {
			input.clear();
			input.sendKeys("Hello");
		}

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int count = 0;
		for (WebElement input : listInput) {
			if (input.getAttribute("value").equals("Hello")) {
				System.out.println(++count + "->Hello is in the Box");
			}
		}

	}

	public static void main(String[] args) throws InterruptedException {

		driver = setUpBrowser();
		performTestCase();

		tearDown();

	}

}
