package com.syntax.review;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.syntax.util.CommonMethods;

public class WebTablePractice extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		setUpBrowser();
		driver.get("http://testingpool.com/data-types-in-java/");

		List<WebElement> rows = driver.findElements(By.xpath("//div[@class='su-table su-table-alternate']//tr"));
		// Number of rows
		System.out.println("Number cols: " + rows.size());

		List<WebElement> headers = driver
				.findElements(By.xpath("//div[@class='su-table su-table-alternate']//tr[1]/td"));

		for (WebElement header : headers) {
			System.out.println("Headers: " + header.getText());
		}

		for (int i = 2; i <= rows.size(); i++) {
			for (int j = 1; j <= headers.size(); j++) {
				WebElement cellData = driver.findElement(
						By.xpath("//div[@class='su-table su-table-alternate']//tr[" + i + "]/td[" + j + "]"));
				// System.out.print("\t"+cellData.getText()+"\t");
				
				// print just one column 
				if(j==2) {
					System.out.println(cellData.getText());
				}
			}
			System.out.println();
		}
		

		Thread.sleep(3000);
		tearDown();
	}
}
