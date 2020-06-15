package com.syntax.class10;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.syntax.util.CommonMethods;
import com.syntax.util.ConfigsReader;

public class ScreenShotDemo extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		setUpBrowser();
		
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth");
		sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getValueOfProperty("username"));
		sendText(driver.findElement(By.id("txtPassword")), ConfigsReader.getValueOfProperty("password"));
		WebElement sub = waitForClickability(driver.findElement(By.id("txtPassword")));
		sub.submit();
		
		Thread.sleep(2000);
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File sourseFile = ts.getScreenshotAs(OutputType.FILE);
		try {
		FileUtils.copyFile(sourseFile, new File("screenshots/HRMS/dashboard.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
		tearDown();
		
	}

}
