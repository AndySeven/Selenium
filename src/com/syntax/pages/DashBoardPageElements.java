package com.syntax.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.util.BaseClass;

public class DashBoardPageElements {

	@FindBy(id="welcome")
	public WebElement welcome;
	@FindBy(xpath="//div[@id='branding']/a[1]")
	public WebElement logo;
	@FindBy(xpath="//a[@id='menu_pim_viewPimModule']/b")
	public WebElement btnPim;
	@FindBy(id="menu_pim_addEmployee")
	public WebElement btnAddEmp;
	
	public DashBoardPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	
	
}
