package com.syntax.class06;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.syntax.util.BaseClass;

public class Links extends BaseClass{

	public static void main(String[] args) {
		
		setUpBrowser();
		
		driver.get("http://www.ebay.com");
		
		List<WebElement> listLinks = driver.findElements(By.tagName("a"));
		System.out.println("Common number of links: "+listLinks.size()+"---------------------------->");
		int count = 0;
		int countEmp = 0;
		for(WebElement link: listLinks) {
			if(!link.getText().isEmpty()) {
				count++;
				System.out.println(link.getText());	
			}else {
				countEmp++;
			}
			
		}
		System.out.println("We have "+count+" links with text and "+countEmp+" without -------------->");
	}

}
