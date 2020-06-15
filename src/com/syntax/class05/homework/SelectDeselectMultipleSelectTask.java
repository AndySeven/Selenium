package com.syntax.class05.homework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.syntax.util.BaseClass;

/**
 * TC 2: Select and Deselect values Open chrome browser Go to
 * “http://jiravm.centralus.cloudapp.azure.com:8081/index.html” Click on “Input
 * Forms” links Click on “Select Dropdown List” links Select value from “Select
 * List Demo” section Verify value has been selected Select 4 options from
 * “Multi Select List Demo” Deselect 1 of the option from the dd Quit browser
 */
public class SelectDeselectMultipleSelectTask extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		setUpBrowser();
		driver.findElement(By.xpath("//a[contains(text(),'Input')]")).click();
		driver.findElement(
				By.xpath("//a[contains(text(),'Select Dropdown List') and @href='basic-select-dropdown-demo.html']"))
				.click();

		WebElement dd = driver.findElement(By.xpath("//select[@id='select-demo']"));

		Select select = new Select(dd);

		select.selectByValue("Monday");

		List<WebElement> options = select.getOptions();
		for (WebElement opt : options) {
			if (opt.isSelected()) {
				System.out.println(opt.getText() + " is Selected--TEST CASE PASSED");
			} else {
				System.out.println(opt.getText() + " is NOT Selected");
			}
		}

		System.out.println("--------Multi Select DropDown------------");

		WebElement msdd = driver.findElement(By.id("multi-select"));
		select = new Select(msdd);

		options = select.getOptions();
		if (select.isMultiple()) {
			for (WebElement opt : options) {
				String optStr = opt.getText();
				if (optStr.equals("Florida") | optStr.equals("New York") | optStr.equals("Pennsylvania")
						| optStr.equals("California")) {
					opt.click();
				}
			}
		}

		select.deselectByIndex(1);

		for (WebElement opt : options) {
			if (opt.isSelected()) {
				System.out.println("Selected option: " + opt.getText());
			}
		}

		Thread.sleep(2000);
		tearDown();
	}

}
