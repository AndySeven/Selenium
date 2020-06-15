package com.syntax.class04;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GetAttributeMethod {
static WebDriver driver;
static String URL = "http://166.62.36.207/humanresources/symfony/web/index.php/recruitment/viewCandidates";


	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
		driver = new FirefoxDriver();
		driver.get(URL);
		
		WebElement userName = driver.findElement(By.name("txtUsername"));
		userName.sendKeys("Admin");
		String text = userName.getAttribute("value");
		System.out.println(text);                       // i retrieve the value that i just send "Admin"
		
		
		
	}

}
