package com.syntax.class06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.syntax.util.BaseClass;

public class FramesHomeTask extends BaseClass {
	/**
	 * TC 2: Syntax Frame verification Open chrome browser Go to
	 * “http://jiravm.centralus.cloudapp.azure.com:8081/index.html” Click on
	 * “Others” link Click on “Iframe” link Click on the “Home” link inside the
	 * first frame Verify “Syntax logo” is displayed in second frame Quit browser
	 * 
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		setUpBrowser();

		driver.findElement(By.xpath("//a[@class='dropdown-toggle'][contains(text(),'Others')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Iframe')]")).click();
		Thread.sleep(2000);
		// To handle iFrames wee should to switch to this iFrame
		WebElement iframe = driver.findElement(By.cssSelector("iframe[src='./index.html']"));
		Thread.sleep(2000);
		driver.switchTo().frame(iframe);
		WebElement homeB = driver.findElement(By.xpath("//a[text()='Home' and @href='./index.html']"));
		Thread.sleep(2000);
		homeB.isEnabled();
		String textHB = homeB.getText();
		System.out.println(textHB + " :button is Enabled");
		Thread.sleep(2000);
		homeB.click();

		// To switch to another Frame we need to get the default window
		driver.switchTo().defaultContent();
		driver.switchTo().frame("FrameTwo");
		Thread.sleep(2000);
		WebElement logo = driver.findElement(By.cssSelector("img[alt='Syntax Technologies']"));
		System.out.println("Is Logo Displayed: " + logo.isDisplayed());

		driver.switchTo().defaultContent();

		tearDown();

	}

}
