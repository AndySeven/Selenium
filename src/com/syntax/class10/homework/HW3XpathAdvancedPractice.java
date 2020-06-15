package com.syntax.class10.homework;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

/**
 *  TC 4: HRMS 	Logi
 *  Navigate to “http://166.62.36.207/humanresources/symfony/web/index.php/auth”
	Login to the application by writing xpath based on “following and preceding siblings”
	click login button using JS executer.
 */

import com.syntax.util.CommonMethods;
import com.syntax.util.ConfigsReader;

public class HW3XpathAdvancedPractice extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {

		setUpBrowser();
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth");

		// fe using uniquely identified Parent
		driver.findElement(By.xpath("//div[@id='divUsername']/input"))
				.sendKeys(ConfigsReader.getValueOfProperty("username"));

		// using preceding sibling method
		// waitForVisibilityLocator(By.xpath("")).sendKeys(ConfigsReader.getValueOfProperty("username"));

		// element by using following sibling
		waitForVisibilityLocator(
				//By.xpath("//span[text()='Password']/preceding-sibling::input"))
							
											//or improvisation:
				
				By.xpath("//input[@id='txtPassword']/following-sibling::span/preceding-sibling::input"))
						.sendKeys(ConfigsReader.getValueOfProperty("password"));

		// !!!!!!!!using unique brother of Parent and his flowing sibling command and then traverse to the child
		WebElement button = waitForClickabilityLocator(By.xpath("//div[@id='divLoginHelpLink']/following-sibling::div/input"));

		// Grandparent
		//WebElement button = waitForClickabilityLocator(By.xpath("//form[@id='frmLogin']/div[5]/input"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", button);

		TakesScreenshot ts = (TakesScreenshot) driver;
		File photo = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(photo, new File("screenshots/MyPractice/shot.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Thread.sleep(5000);
		tearDown();
	}

}
