package com.syntax.class09.homework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.syntax.util.CommonMethods;

/**
 * 
 * TC 1: Calendar headers and rows verification Open chrome browser Go to
 * “https://www.aa.com/homePage.do” Enter From and To Select departure as July
 * 14 of 2020 Select arrival as November 8 of 2020 Close browser Depart Month
 * Year Xpath: "//div[contains(@class, 'ui-corner-left')]/div" 
 * Depart Month Days Xpath: //div[contains(@class,'ui-corner-left')]/following-sibling::table/tbody/tr/td 
 * Next Button Xpath://a[@title='Next'] 
 * Return Month Xpath: //span[@class='ui-datepicker-month']
 * Return Days Xpath: //table[@class='ui-datepicker-calendar']/tbody/tr/td 
 * You
 * can put the logic the way you want.
 *
 */
public class Calendar extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {

		setUpBrowser();
		driver.get("https://www.aa.com/homePage.do");
		// Choosing Depart Date
		chooseDates(1, "July", "19");
		// Choosing Return Date
		chooseDates(2, "November", "22");

		Thread.sleep(2000);
		tearDown();
	}

	public static void chooseDates(int nCalend, String month1, String date) {
		WebElement calendar = waitForPresenceOfElLocated(
				By.xpath("(//button[@class='ui-datepicker-trigger'])[" + nCalend + "]"));
		calendar.click();

		WebElement month = waitForPresenceOfElLocated(By.xpath("(//span[@class='ui-datepicker-month'])[1]"));

		while (!month.getText().equals(month1)) {
			WebElement next = waitForClickabilityLocator(By.xpath("//a[@title='Next' and @data-handler='next']"));
			next.click();
			month = waitForPresenceOfElLocated(By.xpath("(//span[@class='ui-datepicker-month'])[1]"));
		}
		List<WebElement> dates = driver.findElements(By.xpath("(//table[@class='ui-datepicker-calendar'])[1]//td"));
		for (int i = 0; i < dates.size(); i++) {
			if (dates.get(i).getText().equals(date)) {
				dates.get(i).click();
				break;
			}
		}

	}

}
