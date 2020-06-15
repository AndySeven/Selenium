package com.syntax.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathAndCSS {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
		
		// 1. Xpath by absolute xpath
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/form/div[2]/input")).sendKeys("admin");
		// 2. Xpath original by relative xpath
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Hum@nhrm123");
		// 4. Xpath by relative by contains function attribute
		driver.findElement(By.xpath("//input[contains(@value,'LOGIN')]")).click();
		
		Thread.sleep(2000);
		// 3. Xpath original by using inner text
		driver.findElement(By.xpath("//a[text()='Welcome Admin']")).click();
		Thread.sleep(2000);
		// 5. Xpath usinf contains function text()
		driver.findElement(By.xpath("//a[contains(text(),'Abou')]")).click();
		// 6. 7. Starts-with and Ends-with the same, switch them with contains
		
		
		// CSS Selectors
		
		Thread.sleep(2000);
		// 11. CSS Selector by Tag and Class
		driver.findElement(By.cssSelector("a.close")).click();
		
		// 8. 10. 12. CSS Selector by ORIGINAL Tag and id     and Class the same   and other attributes the same
		driver.findElement(By.cssSelector("a[id='menu_admin_viewAdminModule']")).click();
		
		// 9. CSS Selector by using Tag an id simple
		driver.findElement(By.cssSelector("input#searchSystemUser_userName")).sendKeys("Bob");
		
		Thread.sleep(2000);
		// 13. 14. 15. 17.  ^ $ * Starts, End, Contains       and two attributes at the time
		driver.findElement(By.cssSelector("a[id$='PimModule']")).click();
		
		Thread.sleep(2000);
		
		// 16. 6. two attributes at a time and + starts-with xpath 6
		driver.findElement(By.xpath("//input[starts-with(@id,'emps') and @name='empsearch[id]']")).sendKeys("Good Night");
		
		Thread.sleep(2000);
	
		driver.quit();
		System.exit(0);
	}

}
