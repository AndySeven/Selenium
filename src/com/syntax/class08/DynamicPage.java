package com.syntax.class08;

import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.syntax.util.BaseClass;

public class DynamicPage extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		
		setUpBrowser();
		driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
		
		String expectValue = "Bob Feather";
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr"));
		
		for (int i = 0; i < rows.size(); i++) {//loop over list  based on the size.
			String rowText=rows.get(i+1).getText();//get text of list and skip first index(first row)
			System.out.println(rowText);
			if(rowText.contains(expectValue)) {//search for Bob Feather
				//get the rows of first column in the table
				driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[1]")).get(i).click();
				break;
			}
			
		
		}
		Thread.sleep(8000);
		driver.close();
		
		
	}

}
