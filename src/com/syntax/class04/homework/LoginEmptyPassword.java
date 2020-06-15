package com.syntax.class04.homework;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.syntax.settings.Sourse;
//TC 2: HRMS Application Negative Login: 
//Open chrome browser
//Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
//Enter valid username
//Leave password field empty
//Verify error message with text “Password cannot be empty” is displayed.

public class LoginEmptyPassword {
	static String s;
	
	public static WebDriver driver;
	public static String logInEmptyPassword(String userName) {
		String mess;
		WebElement user = driver.findElement(By.xpath("//input[contains(@id,'tUser')]"));
		user.clear();
		user.sendKeys(userName);
		user.submit();
		WebElement message = driver.findElement(By.xpath("//span[contains(text(),'empty')]"));
		if(message.isDisplayed()) {
			mess = "Message is displayed, Test Case is Passed";
		}else {
			mess = "Test Case Has Not Been Passed";
		}
		return mess;
	}
	

	public static void main(String[] args) {
		
		driver = Sourse.browser("chrome");
		String url = Sourse.getURL("humanresources");
		driver.get(url);
		System.out.println(logInEmptyPassword(Sourse.HUSERNAME));
		driver.quit();
		System.exit(0);
	}

}
