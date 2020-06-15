package com.syntax.class09;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.syntax.util.CommonMethods;

/**
 * TC 1: Table headers and rows verification Open chrome browser Go to
 * “https://www.aa.com/homePage.do” Enter From and To Select departure as May 14
 * of 2020 Select arrival as November 8 of 2020 Click on search Close browser
 */

public class CalendarTaskInClass extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		setUpBrowser();
		driver.get("https://www.aa.com/homePage.do");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button.ui-datepicker-trigger")).click();

		String fromMonth = driver.findElement(By.cssSelector("span.ui-datepicker-month")).getText();

		while (!fromMonth.equals("May")) {
			driver.findElement(By.xpath("//a[@title='Next']")).click();
			Thread.sleep(3000);
			fromMonth = driver.findElement(By.cssSelector("span.ui-datepicker-month")).getText();
		}

		List<WebElement> fromCell = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));

		for (WebElement cell : fromCell) {
			String t = cell.getText();

			if (t.equals("14")) {
				cell.click();
				break;
			}
		}

		driver.findElement(By.xpath("(//button[@class='ui-datepicker-trigger'])[2]")).click();

		String returnMonth = driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[1]")).getText();
		Thread.sleep(1000);
		while (!returnMonth.equals("November")) {
			driver.findElement(By.xpath("//a[@title='Next']")).click();
			returnMonth = driver.findElement(By.xpath("(//span[@class='ui-datepicker-month'])[1]")).getText();
		}

		List<WebElement> returnCell = driver
				.findElements(By.xpath("(//table[@class='ui-datepicker-calendar'])[1]//td"));

		for (WebElement cell : returnCell) {
			String t = cell.getText();

			if (t.equals("8")) {
				cell.click();
				break;
			}
		}
		
		Thread.sleep(2000);
		tearDown();

	}

}
