package com.syntax.class04;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebElementCommands {
static WebDriver driver;
static String URL = "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx";
public static String userName = "Tester";
public static String password = "tester";

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
		driver = new FirefoxDriver();
		driver.get(URL);
		
		WebElement userNam = driver.findElement(By.xpath("//input[contains(@id,'username')]"));
		userNam.sendKeys("Tester");
		// clear() clear the textBox, otherwise - concatenate. Always - good practice!
		userNam.clear();
		userNam.sendKeys(userName);
		Thread.sleep(1000);
		WebElement passwor = driver.findElement(By.cssSelector("input#ctl00_MainContent_password"));
		passwor.clear();	
		passwor.sendKeys(password);
		Thread.sleep(1000);
		WebElement loginBtn = driver.findElement(By.cssSelector("input#ctl00_MainContent_login_button"));
		// wait next page fully loaded
		loginBtn.click();
		
		
		boolean LogoIsDispleed = driver.findElement(By.xpath("//h1[text()='Web Orders']")).isDisplayed();
		
		if(LogoIsDispleed) {
			System.out.println("Logo is Displayed - test case passed");
		}else {
			System.out.println("Logo is NOT Displayed - test case faild");
		}
		
		WebElement loginInfo = driver.findElement(By.xpath("//div[@class='login_info']"));
		String innerText = loginInfo.getText(); 
		System.out.println(innerText);
		if(innerText.contains("Tester")) {
			System.out.println("User Successfully logged, Test case passed");
		}else {
			System.out.println("Test case failed");
		}
		
		
		
		Thread.sleep(3000);
		
		driver.quit();
		System.exit(0);
	}
}