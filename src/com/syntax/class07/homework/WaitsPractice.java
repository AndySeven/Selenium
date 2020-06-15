package com.syntax.class07.homework;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * TC 3: Windows Handling
Open chrome browser
Go to “http://jiravm.centralus.cloudapp.azure.com:8081/index.html”
Click on “Javascript Alerts” link
Click on “Window Popup Modal” link
Click on the “ Follow On Instagram” button
Verify title of the page is “Syntax Technologies (@syntaxtechs) • Instagram photos and videos” 
Click on the “Like us On Facebook ” button
Verify title of the page is “Go to Facebook Home” 
Quit the browser

 */
import com.syntax.util.CommonMethods;

public class WaitsPractice extends CommonMethods{
static String title = "Syntax Technologies (@syntaxtechs) • Instagram photos and videos";
static String title2 = "Go to Facebook Home";
	public static void main(String[] args) throws InterruptedException {
			//System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "true");
			setUpBrowser();
			driver.get("http://jiravm.centralus.cloudapp.azure.com:8081/index.html");
			WebDriverWait wait = new WebDriverWait(driver, 30);
			//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"navbar-brand-centered\"]/ul[2]/li[2]/a"))));
			click(driver.findElement(By.xpath("//*[@id=\"navbar-brand-centered\"]/ul[2]/li[2]/a")));
			//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"navbar-brand-centered\"]/ul[2]/li[2]/ul/li[3]/a"))));
			click(driver.findElement(By.xpath("//*[@id=\"navbar-brand-centered\"]/ul[2]/li[2]/ul/li[3]/a")));
			//wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[contains(text(),'Follow On Instagram')]"))));
			
			click(driver.findElement(By.xpath("//a[contains(text(),'Follow On Instagram')]")));
			
			
			//String parent = getParentWindoeHandle();
		
			switchToChildWindow();
			
			checkTitle(title);
			System.out.println();
			
			//driver.switchTo().window(parent);
		
			
			click(driver.findElement(By.xpath("//a[contains(text(),'Like us On Facebook')]")));
			switchToChildWindow();
			
			checkTitle(title2);
			
			
			tearDown();
			
			

	}

}
