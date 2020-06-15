package com.syntax.class10.homework;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.syntax.util.CommonMethods;
/**
 * TC 2: Upload file and Take Screenshot Navigate to
 * “http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwFileUpload”
 * Upload file Verify file got successfully uploaded and take screenshot
 */
public class HW2UploadFile extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		setUpBrowser();
		driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwFileUpload");
		
		WebElement chooseFileB = waitForClickabilityLocator(By.cssSelector("input#gwt-debug-cwFileUpload"));
		chooseFileB.sendKeys("/Users/robespierre/Downloads/IMG_6200.JPG");
		
		//waitForClickabilityLocator(By.cssSelector("button.gwt-Button")).click();;
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sShot = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(sShot, new File("screenshots/MyPractice/shot1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		Thread.sleep(2000);
		tearDown();
	}

}
