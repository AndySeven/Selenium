package com.syntax.class02.myclasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RadioBauttonsAndCheckBoxes {
static WebDriver driver;
static WebElement radio1;
static WebElement radio2;
static WebElement radio3;

static WebElement checkBox1;
static WebElement checkBox2;
static WebElement checkBox3;

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
		driver = new FirefoxDriver();
		driver.get("http://demo.guru99.com/test/radio.html");
		
		//testing Radio buttons
		radio1 = driver.findElement(By.cssSelector("input[value='Option 1']"));
		radio1.click();
		radio2 = driver.findElement(By.cssSelector("input[value='Option 2']"));
		radio2.click();
		radio3 = driver.findElement(By.cssSelector("input[value='Option 3']"));
		radio3.click();
		
		
		
		//Thread.sleep(300);
		//testing check boxes
		checkBox1 = driver.findElement(By.xpath("//*[@id=\"vfb-6-0\"]"));
		
		for(int i=0; i<2; i++) {
			checkBox1.click();
			System.out.println("checkBox1: "+checkBox1.isSelected());
		}
		checkBox2 = driver.findElement(By.id("vfb-6-1"));
		
		for(int i=0; i<2; i++) {
			checkBox2.click();
			System.out.println("checkBox2: "+checkBox2.isSelected());
		}
		checkBox3 = driver.findElement(By.id("vfb-6-2"));
		
		for(int i=0; i<2; i++) {
			checkBox3.click();
			System.out.println("checkBox3: "+checkBox3.isSelected());
		}
		
		
		driver.quit();
		System.exit(0);
		
		
	}
}
