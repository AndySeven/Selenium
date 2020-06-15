package com.syntax.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.syntax.util.BaseClass;

public class FacebookHW extends BaseClass {
	public static void main(String[] args) throws InterruptedException {
//		Go to facebook.com
//		Verify "Create a new account" is Displayed
//		Fill out First name, lastname, email, new password
//		Select your birthday from given dropdowns
//		Select gender
//		Click sign up
		setUpBrowser();
		driver.get("http://www.facebook.com");
		WebElement firstName = driver.findElement(By.xpath("//input[@name = 'firstname']"));
		firstName.sendKeys("John");
		WebElement lastName = driver.findElement(By.cssSelector("input[type = 'text'][name = 'lastname']"));
		lastName.sendKeys("Smith");
		WebElement email = driver.findElement(By.cssSelector("input[name='reg_email__']"));
		email.sendKeys("JohnSmith@yahoo.com");
		WebElement reEmail = driver.findElement(By.cssSelector("input[name='reg_email_confirmation__']"));
		reEmail.sendKeys("JohnSmith@yahoo.com");
		WebElement password = driver.findElement(By.cssSelector("input[type='password'][name = 'reg_passwd__']"));
		password.sendKeys("Smith7687John");
		Thread.sleep(2000);
		WebElement monthSlct = driver.findElement(By.xpath("//select[@id = 'month']"));
		Select selectMonth = new Select(monthSlct);
		selectMonth.selectByVisibleText("Jul");
		WebElement daySlct = driver.findElement(By.xpath("//select[@id = 'day']"));
		Select selectDay = new Select(daySlct);
		selectDay.selectByIndex(5);
		WebElement yearSlct = driver.findElement(By.xpath("//select[@id = 'year']"));
		Select selectYear = new Select(yearSlct);
		selectYear.selectByValue("1991");
		driver.findElement(By.cssSelector("input[name = 'sex'][value='2']")).click();
		
		WebElement signUpButton = driver.findElement(By.xpath("//*[@name = 'websubmit']"));
		signUpButton.click();
		Thread.sleep(25000);
		WebElement text = driver.findElement(By.cssSelector("[class = 'uiHeaderTitle']"));
		System.out.println(text.getText());
	}
}