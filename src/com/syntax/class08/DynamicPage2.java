package com.syntax.class08;

import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.syntax.util.BaseClass;

public class DynamicPage2 extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		
		setUpBrowser();
		driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
		
		String expectValue = "Bob Feather";
		WebElement table = driver.findElement(By.xpath("//*[@id='ctl00_MainContent_orderGrid']"));
		System.out.println(table);
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		
		for(int i=0; i<rows.size(); i++) {
			String rowText = rows.get(i).getText();
			System.out.println(rowText);
			if(rowText.contains(expectValue)) {
				driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr["+(i+1)+"]/td[1]")).click();
				break;
			}
			
		}
		
		Thread.sleep(5000);
		
		driver.close();
		
		
	}

}
