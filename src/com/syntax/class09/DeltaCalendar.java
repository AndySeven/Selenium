package com.syntax.class09;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.syntax.util.CommonMethods;

public class DeltaCalendar extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		setUpBrowser();
		
		driver.get("http://www.delta.com");
		waitForClickability(driver.findElement(By.cssSelector("span.calDepartLabelCont"))).click();
		
		String dayMonth = driver.findElement(By.xpath("//span[@class='dl-datepicker-month-0']")).getText();
		
		
		while(!dayMonth.equals("August")) {
			driver.findElement(By.xpath("//a[@class='dl-datepicker-1']")).click();
			Thread.sleep(2000);
			dayMonth = driver.findElement(By.xpath("//span[@class='dl-datepicker-month-0']")).getText();
		}
		
		List<WebElement> fromCells = driver.findElements(By.xpath("//tbody[@class='dl-datepicker-tbody-0']/tr/td"));
		for(WebElement fromCell: fromCells) {
			String fromText = fromCell.getText();
			if(fromText.equals("15")){
				fromCell.click();
				break;
			}
		}
//		List<WebElement> departCells = driver.findElements(By.xpath("//tbody[@class='dl-datepicker-tbody-1']/tr/td"));
//		for(WebElement departCell: departCells) {
//			String departText = departCell.getText();
//			if(departText.equals("7")){
//				departCell.click();
//				break;
//			}
//		}
		
		// grab the text of return month and check ii if it equals to October
		
		String returnMonth = driver.findElement(By.xpath("//span[@class='dl-datepicker-month-1']")).getText();
		
		while(!returnMonth.equals("October")) {
			driver.findElement(By.xpath("//span[text()='Next']")).click();
			Thread.sleep(3000);
			returnMonth = driver.findElement(By.xpath("//span[@class='dl-datepicker-month-1']")).getText();
		}
		
		List<WebElement> returnCells = driver.findElements(By.xpath("//tbody[@class='dl-datepicker-tbody-1']/tr/td"));
		for(WebElement returnCell: returnCells) {
			String returnText = returnCell.getText();
			if(returnText.equals("9")) {
				returnCell.click();
				break;
			}
		}
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("button.donebutton")).click();
		Thread.sleep(3000);
		tearDown();
	}
}
