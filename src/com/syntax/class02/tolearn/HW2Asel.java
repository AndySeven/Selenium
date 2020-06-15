package com.syntax.class02.tolearn;
import java.io.*;
import java.util.*;
import java.util.Map.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import com.syntax.class02.tolearn.DDTFrameWork;
import com.syntax.Set.Selenium;
public class HW2Asel {
	public static void main(String[] args) throws IOException, InterruptedException {
		String path = System.getProperty("user.dir") + "/TestData/TestData.xlsx";
		System.out.println(path);
		//Reading Data from Excel file and convert into List of Map
		List<Map<String, String>> mapList = DDTFrameWork.dataFromExcel(path);
		//Retrieving data from Map
		for (Map<String, String> map : mapList) {
			//Method for Setting up Test properties ans opening Registration Page
			//DDTFrameWork.openRegistrationPage(Selenium.getUrl());
			for (Entry<String, String> s : map.entrySet()) {
				String key = s.getKey();
				String value = s.getValue();
				//Method for enter data into registration form
				DDTFrameWork.registration(key, value);
			}
			Thread.sleep(1000);
			//Method for clicking Register Button and verifying registration.
			DDTFrameWork.comleteRegistration();
		}
		//Method for closing browser
		DDTFrameWork.closeBrowser();
	}
}