package com.syntax.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.syntax.util.BaseClass;
/**
 * Class stores the web elements from the Login PAge
 * @author robespierre
 */
public class LoginPage extends BaseClass {
	
	// login elements
	public WebElement userName = driver.findElement(By.id("txtUsername"));
	public WebElement password = driver.findElement(By.id("txtPassword"));
	public WebElement loginBtn = driver.findElement(By.id("btnLogin"));
	
	
	public WebElement logo = driver.findElement(By.xpath("//div[@id='divLogo']/img"));
	
	
}
