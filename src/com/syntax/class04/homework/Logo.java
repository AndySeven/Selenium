package com.syntax.class04.homework;

import com.syntax.settings.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// TC 1: HRMS Application Login: 
// Open chrome browser
// Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
// Enter valid username and password
// Click on login button
// Then verify Syntax Logo is displayed.
public class Logo {
	public static WebDriver driver;
	public static String sourseUrl;

	public static String logIn(String name, String pass) throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input#txtUsername")).sendKeys(name);
		driver.findElement(By.cssSelector("input#txtPassword")).sendKeys(pass);
		driver.findElement(By.cssSelector("input#txtPassword")).submit();
		String curUrl = driver.getCurrentUrl();
		String message;
		if (curUrl.equalsIgnoreCase("http://166.62.36.207/humanresources/symfony/web/index.php/dashboard")) {
			message = "User logged in Successfully";
		} else {
			message = "Test case LogIn Faild";
		}
		return message;
	}
	public static String checkLogo() {
		WebElement we = driver.findElement(By.xpath("//img[@alt='OrangeHRM']"));
		if(we.isDisplayed()) return "Logo is displayed";
		else return "Test case LOGO Faild";
		
	}
	public static void main(String[] args) throws InterruptedException {
		sourseUrl = Sourse.getURL("humanresources");
		driver = Sourse.browser("chrome");
		driver.get(sourseUrl);
		Thread.sleep(3000);
		System.out.println(logIn("admin","Hum@nhrm123"));
		System.out.println(checkLogo());
		
		Thread.sleep(2000);
		driver.quit();
		System.exit(0);
	}
}

