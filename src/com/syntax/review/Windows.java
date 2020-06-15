package com.syntax.review;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.syntax.util.CommonMethods;

public class Windows extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		setUpBrowser();
		driver.get("http://www.seleniumframework.com/Practiceform/");
		WebElement button = driver.findElement(By.cssSelector("button[onclick='newBrwTab()']"));
		
		String parentWindow = driver.getWindowHandle();
		button.click();
		//driver.close();
		Set<String> winds = driver.getWindowHandles();
		for(String w: winds) {
			if(!w.equals(parentWindow)) {
				driver.switchTo().window(w);
			}
		}
		WebElement text = 
				waitForPresenceOfElLocated(By.xpath("//strong[contains(text(),'Agile')]"));
		System.out.println(text.getText());
		driver.close();
		driver.switchTo().window(parentWindow);
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		tearDown();
	}

}
