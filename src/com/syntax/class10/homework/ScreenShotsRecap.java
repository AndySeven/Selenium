package com.syntax.class10.homework;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.syntax.util.CommonMethods;

public class ScreenShotsRecap extends CommonMethods{

	public static void main(String[] args) {
		setUpBrowser();
		driver.get("http://www.apple.com");
		WebElement linkWatch = waitForVisibilityLocator(By.xpath("//nav[@id=\"ac-globalnav\"]//a[@class='ac-gn-link ac-gn-link-watch']"));
		linkWatch.click();
		WebElement airPods = waitForVisibilityLocator(By.xpath("//figure[@class='image image-airpods-engraving']"));
		
		// 1. I Created an ref var JSE type and assigned to it and upcasted obj to the JSE type
		JavascriptExecutor js = (JavascriptExecutor)driver;
		// using JSE interface method executeScript i scrolled to the particular element of WebPage
		js.executeScript("arguments[0].scrollIntoView(true)", airPods);
		
		// Using TSS interface we create a ss. First i cast the ChromeDriver obj to TSS type
		TakesScreenshot shot = (TakesScreenshot)driver;
		// create image file using getScreenshotAs() method
		File airPodsPic = shot.getScreenshotAs(OutputType.FILE);
		try {
			// we store the  copy file to destination
			FileUtils.copyFile(airPodsPic, new File("screenshots/MyPractice/airPods.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		tearDown();
		
	}

}
