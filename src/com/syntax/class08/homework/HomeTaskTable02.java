package com.syntax.class08.homework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.syntax.util.CommonMethods;
import com.syntax.util.ConfigsReader;

/**
 * TC 2: Delete Employee Open chrome browser Go to
 * “http://166.62.36.207/humanresources/symfony/web/index.php/auth” Login into
 * the application Add Employee Verify Employee has been added Go to Employee
 * List Delete added Employee Quit the browser
 */

public class HomeTaskTable02 extends CommonMethods {
	public static void main(String[] args) throws InterruptedException {
		setUpBrowser();
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth");

		sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getValueOfProperty("username"));
		sendText(driver.findElement(By.id("txtPassword")), ConfigsReader.getValueOfProperty("password"));
		WebElement sub = waitForClickability(driver.findElement(By.id("txtPassword")));
		
		sub.submit();

		WebElement pm = waitForClickability(driver.findElement(By.id("menu_pim_viewPimModule")));
		//Thread.sleep(2000);
		//Actions action = new Actions(driver);
		//action.moveToElement(pm).build().perform();
		//Thread.sleep(1000);
		pm.click();
		//Thread.sleep(1000);
		waitForClickability(driver.findElement(By.cssSelector("a#menu_pim_viewEmployeeList"))).click();
		Thread.sleep(1000);
		WebElement add = waitForClickability(driver.findElement(By.id("btnAdd")));
		add.click();

		
		waitForVisibility(driver.findElement(By.id("firstName"))).sendKeys("Anver");
		waitForVisibility(driver.findElement(By.id("lastName"))).sendKeys("Mussolini");
		
		driver.findElement(By.id("lastName")).submit();
		//Thread.sleep(1000);
		click(driver.findElement(By.id("menu_pim_viewEmployeeList")));
		//Thread.sleep(1000);
		WebElement serchBox = waitForVisibility(driver.findElement(By.id("empsearch_employee_name_empName")));
		serchBox.sendKeys("Anver Mussolini");
		serchBox.sendKeys(Keys.RETURN);
		//Thread.sleep(1000);
		
		//waitForClickability(driver.findElement(By.cssSelector("div.ac_results"))).click();
		//Thread.sleep(1000);
		click(driver.findElement(By.id("searchBtn")));
		//Thread.sleep(2000);
		WebElement check = driver.findElement(By.xpath("//a[contains(text(),'Anver')]"));
		if (check.getText().contains("Anver")) {
			System.out.println("Perfecto");
		}
		//Thread.sleep(2000);

		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='resultTable']//tr"));
		for (int i = 1; i < rows.size(); i++) {
			System.out.println(rows.get(i).getText());

			if (rows.get(i).getText().contains("Mussolini")) {
		//		Thread.sleep(1000);
				driver.findElements(By.xpath("//table[@id='resultTable']//td[1]")).get(i - 1).click();
			}
		}

		//Thread.sleep(2000);
		click(driver.findElement(By.id("btnDelete")));

		//Thread.sleep(3000);
		click(driver.findElement(By.id("dialogDeleteBtn")));
		// Alert alert = driver.switchTo().alert();
		// Thread.sleep(3000);
		// alert.accept();

		//Thread.sleep(3000);
		driver.close();
	}
}
