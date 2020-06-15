package com.syntax.class08;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.syntax.util.BaseClass;

public class MyTaskDynamicTable extends BaseClass{

	public static void main(String[] args) throws InterruptedException {
		setUpBrowser();
		driver.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
		
		String expValue = "Susan McLaren";
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr"));
		List<WebElement> cols = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr[2]/td"));
		
		System.out.println("Number Rows -> "+rows.size()+", Number Cols -> "+cols.size());
		WebElement checkBoxToBeSelected = null;
		for(int i=1; i<rows.size(); i++) {
			
			String rowText = rows.get(i).getText();
			//System.out.println(rowText);
			if(rowText.contains(expValue)) {
				System.out.println("here");
				checkBoxToBeSelected = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr["+(i+1)+"]/td[1]"));
				checkBoxToBeSelected.click();
				break;
			}
			
		}
		
		if(checkBoxToBeSelected.isSelected()) {
			//System.out.println(expValue+ " has been checked successfully");
		}else {
			//System.out.println(expValue+" has NOT been Selected");
		}
		
		
		
		Thread.sleep(7000);
		driver.close();
	}

}
