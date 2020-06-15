package com.syntax.class05.homework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.syntax.util.BaseClass;

/**
 * TC 1: Amazon Department List Verification Open chrome browser Go to
 * “http://amazon.com/” Verify how many department options available. Print each
 * department Select Computers Quit browser
 */

public class AmazonDD extends BaseClass {

	public static void main(String[] args) {

		setUpBrowser();
		driver.get("http://amazon.com/");
		WebElement dd = driver.findElement(By.id("searchDropdownBox"));
		Select select = new Select(dd);

		List<WebElement> listDD = select.getOptions();
		int numOptions = listDD.size();
		System.out.println("Number of options in Departments DD is: " + numOptions);

		for (WebElement opt : listDD) {
			System.out.println(opt.getText());
			if (opt.getText().equalsIgnoreCase("Computers")) {
				//opt.click();
				select.selectByVisibleText("Computers");
				if (opt.isSelected()) {
					System.out.println("Fantastic---------------------------------->");
				} else {
					System.out.println("Try Test Again----------------------------->");
				}

			}
		}

		tearDown();

	}

}
