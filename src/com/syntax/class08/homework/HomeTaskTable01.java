package com.syntax.class08.homework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.syntax.util.CommonMethods;

/**
 * TC 1: Table headers and rows verification Open chrome browser Go to
 * “http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx”
 * Login to the application Verify customer “Susan McLaren” is present in the
 * table Click on customer details Update customers last name and credit card
 * info Verify updated customers name and credit card number is displayed in
 * table Close browser
 */
public class HomeTaskTable01 extends CommonMethods {
	static String expCastomer = "Susan McLaren";
	static String newCastomer = "Susan Brady";
	static String cardNumber = "9876543241";

	public static void main(String[] args) throws InterruptedException {
		setUpBrowser();
		driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");

		sendText(driver.findElement(By.id("ctl00_MainContent_username")), "Tester");
		sendText(driver.findElement(By.id("ctl00_MainContent_password")), "test");
		click(driver.findElement(By.id("ctl00_MainContent_login_button")));

		// Element to click directly EASY
		// WebElement el7$13 =
		// driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr[6]/td[13]"));
		// click(el7$13);

		// Locate rows
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr"));

		for (int i = 0; i < rows.size(); i++) {
			if (rows.get(i).getText().contains(expCastomer)) {
				List<WebElement> col13 = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[13]"));
				col13.get(i - 1).click();
				break;
			}
		}
		Thread.sleep(2000);
		sendText(driver.findElement(By.cssSelector("input#ctl00_MainContent_fmwOrder_txtName")), newCastomer);
		sendText(driver.findElement(By.cssSelector("input#ctl00_MainContent_fmwOrder_TextBox6")), cardNumber);

		List<WebElement> radio = driver
				.findElements(By.cssSelector("input[name='ctl00$MainContent$fmwOrder$cardList']"));
		checkRadio(radio, "American Express");

		click(driver.findElement(By.cssSelector("a#ctl00_MainContent_fmwOrder_UpdateButton")));

		// Verification
		List<WebElement> rows2 = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr"));
		for (int i = 0; i < rows2.size(); i++) {

			if (rows2.get(i).getText().contains(newCastomer) && rows2.get(i).getText().contains(cardNumber)) {
				System.out.println("Last Name and Card Number has changed");
			}
		}
		
		Thread.sleep(5000);
		driver.close();
	}

	public static void checkRadio(List<WebElement> list, String value) {
		String actualValue;
		for (WebElement l : list) {
			actualValue = l.getAttribute("value").trim();
			if (actualValue.equalsIgnoreCase(value) && !l.isSelected() && l.isEnabled()) {
				l.click();
				break;
			}
		}
	}

}
