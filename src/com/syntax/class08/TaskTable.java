package com.syntax.class08;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.syntax.util.BaseClass;

/**
 * TC 1: Table headers and rows verification
Open chrome browser
Go to “http://166.62.36.207/syntaxpractice/”
Click on “Table” link
Click on “ITable Data Search” link
Verify second table consist of 5 rows and 4 columns
Print name of all column headers 
Print data of all rows
Quit Browser
 */

public class TaskTable extends BaseClass{

	public static void main(String[] args) throws InterruptedException {
		setUpBrowser();
		driver.findElement(By.xpath("//a[contains(text(),'Table') and @class='dropdown-toggle' ]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Table Data Search')]")).click();
		
		System.out.println("------Number of all rows-------");
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table']/tbody/tr"));
		System.out.println("Numbers of rows --> "+rows.size());
		
		System.out.println("------data of All Rows------");
		for(WebElement r: rows) {
			System.out.println(r.getText());
		}
		
		System.out.println("------Number of all COLOMNS-------");
		List<WebElement> cols = driver.findElements(By.xpath("//table[@class='table']/thead[2]/tr/th"));
		System.out.println("Numbers of cols --> "+cols.size());
		
		
		System.out.println("--------Names of Header 2-------");
		List<WebElement> listHeaders = driver.findElements(By.xpath("//table[@class='table']/thead[2]/tr/th")); 
		for(WebElement headerName: listHeaders) {
			System.out.println(headerName.getText());
		}
		
		
		Thread.sleep(5000);
		
		driver.close();
	}

}
