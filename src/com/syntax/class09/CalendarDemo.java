package com.syntax.class09;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.syntax.util.CommonMethods;
import com.syntax.util.ConfigsReader;

public class CalendarDemo extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		setUpBrowser();
		
		// login to app
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth");
		sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getValueOfProperty("username"));
		sendText(driver.findElement(By.id("txtPassword")), ConfigsReader.getValueOfProperty("password"));
		WebElement sub = waitForClickability(driver.findElement(By.id("txtPassword")));
		sub.submit();
		
		//Navigate to leave list
		waitForClickability(driver.findElement(By.linkText("Leave"))).click();
		waitForClickability(driver.findElement(By.id("menu_leave_viewLeaveList"))).click();
		
		// click on calendar
		waitForClickability(driver.findElement(By.id("calFromDate"))).click();
		
		WebElement mDD = waitForClickability(driver.findElement(By.cssSelector("select.ui-datepicker-month")));
		CommonMethods.selectDDValue(mDD, "Apr");
		WebElement yDD = waitForClickability(driver.findElement(By.cssSelector("select.ui-datepicker-year")));
		CommonMethods.selectDDValue(yDD, "2021");
		
		
		List<WebElement> calendarDays = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		
		for(WebElement fromDay: calendarDays) {
			if(fromDay.getText().equals("15")) {
				fromDay.click();
				break;
			}
		}
		
		Thread.sleep(3000);
		tearDown();
	}

}
