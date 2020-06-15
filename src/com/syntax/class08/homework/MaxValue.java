package com.syntax.class08.homework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.syntax.util.BaseClass;

public class MaxValue extends BaseClass{

	public static void main(String[] args) {
		
		setUpBrowser();
		driver.get("http://demo.guru99.com/test/web-table-element.php");
		
		//WebElement table = driver.findElement(By.xpath("//table[@class='dataTable']"));
		//List<WebElement> col = table.findElements(By.tagName("td[2]"));
		
		// getting all elements of column number 4 of the table
		List<WebElement> col4 = driver.findElements(By.xpath("//table[@class='dataTable']//td[4]"));
		System.out.println(col4.size());
		
		double max = 0;
		for(int i=0; i<col4.size(); i++) {
			String str = col4.get(i).getText();
			//System.out.println(str);
			double a = Double.parseDouble(str); // no down casting here because of parseDouble
			if(a>max) {
				max=a;
			}
		}
		System.out.println("Max value in col 4 is --> "+max);
	
		// we are define variable with assigning the value of first element
		double min = Double.valueOf(col4.get(0).getText());
	
		for(int i=0; i<col4.size(); i++) {
			String str = col4.get(i).getText();
			//System.out.println(str);
			double a = Double.valueOf(str);  //Down Casting Double --> double
			if(a<=min) {
				min=a;
			}
		}
		System.out.println("Min value in col 4 is --> "+min);
		
		// LOOP all elements of table
		
		// Location of rows
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));
		// Number of rows
		//System.out.println(rows.size());
		// Location all col 
		
		
		// First way print all elements of table
		List<WebElement> cols = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr[1]/td"));
		//System.out.println(cols.size());
		
		// always need to look: is there <th> 
		for(int r=0; r<rows.size(); r++) {
			for(int c=0; c<cols.size(); c++) {
				String str = driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+(r+1)+"]/td["+(c+1)+"]")).getText();
				System.out.print(str+" <---> ");
			}
			System.out.println();
		}
		
		
		
		
		//Second Way print all elements
		System.out.println("=====================TagName================");
		
		// locating the whole table
		WebElement table = driver.findElement(By.xpath("//table[@class='dataTable']/tbody"));
		// getting all rows
		List<WebElement> rows2 = table.findElements(By.tagName("tr"));
		
		// looping through rows
		for(int i=0; i<rows2.size(); i++) {
			
			// finding columns using <td>
			List<WebElement> cols2 = rows2.get(i).findElements(By.tagName("td"));
			
			// looping by row and capturing of elements of that row using their column position
			for(int j=0; j<cols2.size(); j++) {
				String cellDAta = cols2.get(j).getText();
				System.out.print(cellDAta+"\t || ");
			}
			System.out.println();
		}
		
		
		
		driver.close();
	}

}
