package com.syntax.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

//Using xPath ONLY
//TC 2: Mercury Tours Registration: 
//Open chrome browser
//Go to “http://newtours.demoaut.com/”
//Click on Register Link
//Fill out all required info (skip dropdowns)
//Click Submit
//User successfully registered

public class InHomeTaskXpath {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		String url = "http://newtours.demoaut.com/";
		driver.get(url);
		
		driver.findElement(By.xpath("//a[contains(text(),'GIS')]")).click();
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Bobby");
		driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[3]/td[2]/input")).sendKeys("Shuster");
		driver.findElement(By.xpath("//input[@name='phone' and @size='15']")).sendKeys("3434-34-34-34");
		driver.findElement(By.xpath("//input[@name='userName' and @id='userName']")).sendKeys("asa@gmail.com");
		
		driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("2345 87th St");
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Bronx");
		driver.findElement(By.xpath("//input[@name='state']")).sendKeys("New York");
		driver.findElement(By.xpath("//input[@name='postalCode' and @size='15']")).sendKeys("123456");
		WebElement element = driver.findElement(By.xpath("//select[@name='country']"));
		Select select = new Select(element);
		select.selectByVisibleText("BRAZIL");
			
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("Bibs");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("2323uu");
		driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("2323uu");
		driver.findElement(By.xpath("//input[@src='/images/forms/submit.gif']")).click();
		
		Thread.sleep(4000);
		driver.close();
		System.exit(0);
		
	}

}
