package com.syntax.class07.homework;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.syntax.util.CommonMethods;

public class DynamicControls2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "true");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/");
		//driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 15);
		//forClick(driver, 10, By.xpath("//a[text()='Dynamic Controls']")).click();
		WebElement dynContrLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Dynamic Controls']")));
		dynContrLink.click();
		//WebDriverWait wait = new WebDriverWait(driver, 90);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Enable']")));
		WebElement enableB = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Enable']")));
		enableB.click();
	
		wait.until(ExpectedConditions.elementToBeSelected(By.xpath("//input[@type='text']")));
		
		
//		WebDriverWait wait = new WebDriverWait(driver, 15);
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='text']")));
		//Thread.sleep(6000);
		
		
		//Boolean w = wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath("//input[@type='text']"))));
		//System.out.println(w);
		//w.sendKeys("Hello");
		
		//WebElement textB = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='text']")));
		//Thread.sleep(3000);
		
		//textB.sendKeys("HELOO");
		
		//System.out.println(textB.getAttribute("value"));
		
		//driver.quit();
	}
	
//	public static WebElement forClick(WebDriver driver, int timeOutInSeconds, By locator) {
//		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
//		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
//	}
//	public static WebElement forText(WebDriver driver, int timeOutInSeconds, By locator) {
//		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
//		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
//		
//	}
//	public static WebElement forCliclByClickability(WebDriver driver, int timeOutInSeconds, WebElement element) {
//		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
//		return wait.until(ExpectedConditions.elementToBeClickable(element));
//	}
//	public static WebElement forTextByVisibility(WebDriver driver, int timeOutInSeconds, WebElement element) {
//		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
//		return wait.until(ExpectedConditions.visibilityOf(element));
//	}
//	
//	public static void checkTextPresenceInBox(WebElement element, String text) {
//		if(element.getAttribute("value").contains(text)){
//			System.out.println("Text "+text+" have been input successfully");
//		}else {
//			System.out.println(text+" have not been input");
//		}
//	}

}
