package com.syntax.class02;
//Properties file:
//browserC=Chrome
//browserF=Firefox
//chromeP=webdriver.chrome.driver
//fireFoxP=webdriver.gecko.driver
//chromeDriverPath=C:\\Users\\sz\\Eclipse-Syntax\\SeleniumJavaPractice\\Drivers\\chromedriver.exe
//fireFoxDriverPath=C:\\Users\\sz\\Eclipse-Syntax\\SeleniumJavaPractice\\Drivers\\geckodriver.exe
//ProjectUrl=http://newtours.demoaut.com/
//userName=saifuz
//password=Saifuz123

import java.io.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import com.syntax.class02.SeleniumSetting;
public class InHomeReadFileSelenium {
	public static void main(String[] args) throws IOException, InterruptedException {
		SeleniumSetting.driver("chrome");
		WebDriver driver=new ChromeDriver();
		driver.get(SeleniumSetting.getpUrl());
		driver.findElement(By.name("userName")).sendKeys(SeleniumSetting.getUserName());
		driver.findElement(By.name("password")).sendKeys(SeleniumSetting.getPwd());
		driver.findElement(By.name("login")).click();
		Thread.sleep(5000);
		driver.close();
	}
}