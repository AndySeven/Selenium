package com.syntax.Set;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.syntax.util.BaseClass;

/**
 * Go to facebook.com Verify “Create a new account” is Displayed Fill out First
 * name, lastname, email, new password Select your birthday from given dropdowns
 * Select gender Click sign up
 */

public class TaskHomeFaceBook extends BaseClass {
	public static void main(String[] args) throws InterruptedException {
		
		setUpBrowser();
		driver.get("http://www.facebook.com");
		WebElement signUp = driver.findElement(By.className("_8est"));
		System.out.println("is Sign Up sign desplayed? --> " + signUp.isDisplayed());
		System.out.println(signUp.getText());
		Thread.sleep(2000);
		driver.findElement(By.id("u_0_m")).sendKeys("Bob");
		driver.findElement(By.id("u_0_o")).sendKeys("Smith");
		driver.findElement(By.id("u_0_r")).sendKeys("bobby2345178@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.id("u_0_u")).sendKeys("bobby2345178@gmail.com");
		driver.findElement(By.id("u_0_w")).sendKeys("123Qwerty");
		Thread.sleep(1000);
		WebElement month = driver.findElement(By.id("month"));
		Select selectM = new Select(month);
		Thread.sleep(1000);
		List<WebElement> listM = selectM.getOptions();
		for (WebElement opt : listM) {
			String o = opt.getText();
			if (o.equals("Jan")) {
				opt.click();
				break;
			}
		}
		for (WebElement opt : listM) {
			if (opt.isSelected()) {
				System.out.println("Month - " + opt.getText() + " is Selected");
			}
		}

		WebElement day = driver.findElement(By.id("day"));
		Select select = new Select(day);
		select.selectByValue("5");
		List<WebElement> listD = select.getOptions();
		for (WebElement opt : listD) {
			if (opt.isSelected()) {
				System.out.println("Day - " + opt.getText() + " is Selected");
			}
		}

		WebElement year = driver.findElement(By.id("year"));
		Select selectY = new Select(year);
		selectY.selectByVisibleText("1986");
		List<WebElement> listY = select.getOptions();
		for (WebElement opt : listY) {
			if (opt.isSelected()) {
				System.out.println("Year - " + opt.getText() + " is Selected");
			}
		}
		Thread.sleep(2000);
		
		List<WebElement> listR = driver.findElements(By.className("_8esa"));
		for(WebElement radioB: listR) {
			if(radioB.getAttribute("value").equals("2")) {
				radioB.click();
				System.out.println(radioB.isSelected());
				break;
			}
		}
		
		Thread.sleep(1000);
		for(WebElement radioB: listR) {
			if(radioB.isSelected()) {
				System.out.println("Male Radio Button is Selected");
				break;
			}
		}
		
		driver.findElement(By.id("u_0_13")).click();
		
		
		WebElement message = driver.findElement(By.xpath("//div[contains(text(),'We')]"));
		if(message.getText().contains("We Need")) {
			System.out.println(message.getText()+"--> Test Case is done");
		}else {
			System.out.println("Test Case Failed");
		}
		
		Thread.sleep(25000);
		
		
		
		tearDown();

	}

}
