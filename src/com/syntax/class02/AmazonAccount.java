package com.syntax.class02;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AmazonAccount {
	static String filePath;
	static FileInputStream fis;
	static WebDriver driver;
	static Properties prop;
	static String browser;
	static String url;
	static String name;
	static String email;
	static String password;
	
	
	
	
	public static void getBrowser(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
			driver = new ChromeDriver();
			System.out.println("chrome works");
			
		}else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
			driver = new FirefoxDriver();
		}
	}
	public static String test() throws InterruptedException {
		String url2 = "https://www.amazon.com/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2F%3Fref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=usflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&";
		driver.get(url);
		driver.navigate().to(url2);
		driver.manage().window().fullscreen();
		Thread.sleep(300);
		driver.findElement(By.id("createAccountSubmit")).click();
		List<WebElement> s = driver.findElements(By.tagName("input"));
//		for(WebElement x: s) {
//			
//			System.out.println(s.get(1).getAttribute("value"));
//			System.out.println(x);
//		}
			
		WebElement nameOf = driver.findElement(By.id("ap_customer_name"));
		nameOf.sendKeys(name);
		driver.findElement(By.id("ap_email")).sendKeys(email);
		driver.findElement(By.ByXPath.xpath("//*[@id=\"ap_password\"]")).sendKeys(password);
		//driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys(password);
		//driver.findElement(By.id("ap_password")).sendKeys(password);
		//driver.findElement(By.id("continue")).click();
		driver.findElement(By.ByCssSelector.id("ap_password_check")).sendKeys("Bob");
		driver.findElement(By.xpath("//*[@id=\"ap_password\"]"));
		Thread.sleep(3000);
		
		
		
		return "Test done";
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		filePath = System.getProperty("user.dir")+"/configs/AmazonAccountTask.properties";
		fis = new FileInputStream(filePath);
		prop = new Properties();
		prop.load(fis);
		browser = prop.getProperty("browser");
		name = prop.getProperty("name");
		email = prop.getProperty("email");
		password = prop.getProperty("password");
		url = prop.getProperty("url");
		
		
		getBrowser(browser);
		test();
		
		fis.close();
		driver.quit();
		System.exit(0);
		
		
	}
}
