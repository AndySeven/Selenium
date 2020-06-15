package com.syntax.class07;

import org.openqa.selenium.chrome.ChromeOptions;

import com.syntax.util.BaseClass;

public class WaitMy extends BaseClass{

	public static void main(String[] args) throws InterruptedException {
		
		setUpBrowser();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-fullscreen");
		
		
		Thread.sleep(2000);
		tearDown();
	}

}
