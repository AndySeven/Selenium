package com.syntax.class10;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import com.syntax.util.CommonMethods;
import com.syntax.util.ConfigsReader;

public class JavaScriptExecutorIntro extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		setUpBrowser();
		// driver.get("http://demo.guru99.com/test/web-table-element.php");
		// click(By.xpath("//table[@class='dataTable']//tr[1]/td/a"));

		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth");

		sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getValueOfProperty("username"));
		sendText(driver.findElement(By.id("txtPassword")), ConfigsReader.getValueOfProperty("password"));
		WebElement sub = waitForClickability(driver.findElement(By.id("btnLogin")));
		// sub.submit();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		// change background color
		js.executeScript("arguments[0].style.backgroundColor='red'", driver.findElement(By.id("txtPassword")),
				ConfigsReader.getValueOfProperty("password"));
		// clicking using JSE
		js.executeScript("arguments[0].click()", sub);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click()", driver.findElement(By.id("menu_pim_viewPimModule")));
		Thread.sleep(2000);
		// scroll up and down
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,-1000)");

		// scroll to specific element
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView(true);",
				driver.findElement(By.cssSelector("(//a[@class='tiptip'])[1]")));

		Thread.sleep(2000);
		tearDown();

	}

}
