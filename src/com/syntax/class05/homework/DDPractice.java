package com.syntax.class05.homework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.syntax.util.BaseClass;

public class DDPractice extends BaseClass{

	public static void main(String[] args) {
	setUpBrowser();
	
	driver.get("http://jiravm.centralus.cloudapp.azure.com:8081/basic-select-dropdown-demo.html");
		
	WebElement dd = driver.findElement(By.id("select-demo"));
	
	Select select = new Select(dd);
	System.out.println("DD is multiple? "+select.isMultiple());
	select.selectByIndex(1);
	//System.out.println(select.getFirstSelectedOption().getText());
	
	List<WebElement> listOptions = select.getOptions();
	for(WebElement opt: listOptions) {
		//String s = (opt.getAttribute("value"));
		//System.out.println(s);
		//System.out.println("-------------");
		//System.out.println(opt.getText());
		
		if(opt.isSelected()) {
			System.out.println(opt.getText()+" is Selected");
		}
	}
	
	
	WebElement mdd  =driver.findElement(By.id("multi-select"));
	select = new Select(mdd);
	
	if(select.isMultiple()) {
		List<WebElement> listMOptions = select.getOptions();
		for(WebElement opt: listMOptions) {
			String o = opt.getText();
			if(o.equals("Ohio") | o.equals("Texas")) {
				opt.click();
			}
		}
	}
	
	List<WebElement>selectedOpt = select.getAllSelectedOptions();
	for(WebElement so: selectedOpt) {
		System.out.println("Selected options are: " +so.getText());
	}
	
	
	
	
	tearDown();
	}

}
