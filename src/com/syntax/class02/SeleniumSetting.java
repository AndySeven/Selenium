package com.syntax.class02;

import java.io.*;
import java.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
public class SeleniumSetting {
	private static String browserC;
	private static String browserF;
	private static String chromeS;
	private static String fireFoxS;
	private static String cDriverPath;
	private static String fDriverPath;
	private static String pUrl;
	private static String userName;
	private static String pwd;
	public static void readFile() throws IOException {
		String filePath="C:\\Users\\sz\\Eclipse-Syntax\\SeleniumJavaPractice\\configs\\Selenium.properties";
		FileInputStream fileInput = new FileInputStream(filePath);
		Properties prop = new Properties();
		prop.load(fileInput);
		browserC=prop.getProperty("browserC");
		browserF=prop.getProperty("browserF");
		chromeS=prop.getProperty("chromeP");
		fireFoxS=prop.getProperty("fireFoxP");
		cDriverPath=prop.getProperty("chromeDriverPath");
		fDriverPath=prop.getProperty("fireFoxDriverPath");
		pUrl=prop.getProperty("ProjectUrl");
		userName=prop.getProperty("userName");
		pwd=prop.getProperty("password");
	}
	public static void driver(String browser) {
		try {
			readFile();
		} catch (IOException e) {
			System.out.println("Config file not readable");
		}
		if(browser.equalsIgnoreCase(browserC)) {
			System.setProperty(chromeS, cDriverPath);
		}else if(browser.equalsIgnoreCase(browserF)) {
			System.setProperty(fireFoxS, fDriverPath);
		}
	}
	public static String getpUrl() {
		try {
			readFile();
		} catch (IOException e) {
			System.out.println("Config file not readable");
		}
		return pUrl;
	}
	public static String getUserName() {
		try {
			readFile();
		} catch (IOException e) {
			System.out.println("Config file not readable");
		}
		return userName;
	}
	public static String getPwd() {
		try {
			readFile();
		} catch (IOException e) {
			System.out.println("Config file not readable");
		}
		return pwd;
	}
}