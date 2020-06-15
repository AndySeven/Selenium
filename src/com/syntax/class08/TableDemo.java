package com.syntax.class08;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class TableDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "true");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://166.62.36.207/syntaxpractice/table-search-filter-demo.html");

		System.out.println("---------Row Data---------");
		List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"task-table\"]/tbody/tr"));
		System.out.println("Number of rows --> "+rows.size());
		
		Iterator<WebElement> it = rows.iterator();
		while(it.hasNext()) {
			String rowText = it.next().getText();
			System.out.println(rowText);
		}
		
		List<WebElement> cols = driver.findElements(By.xpath("//*[@id=\"task-table\"]/thead/tr/th"));
		System.out.println("Number of columns --> "+cols.size());
		
		for(WebElement c: cols) {
			String colText = c.getText();
			System.out.println(colText);
		}
		Thread.sleep(6000);
		driver.close();
	}

}
