package com.syntax.class10;

public class xPathAccess {

	public static void main(String[] args) {
		
		/**
		 * if one element is unique you can identify the next following 
		 * sibling;
		 * 
		 * Example:
		 *  //input[@id='calFromDate']/following-sibling::img  - only the next element
		 *  
		 *  it finds all img tags after, so use Index [i]
		 *  //input[@id='calFromDate']/following::img     add [i]
		 *
		 * Using preceding:
		 * if you want tom identify preceding tag by the current element/tag
		 * use following syntax
		 * 
		 * //input[@id='calToDate']/preceding-sibling::label
		 * 
		 * without sibling just the tag
		 * //input[@id='calToDate']/preceding::label[1]
		 * 
		 * if you ewant to identify your incestor tag form a 
		 * child one use below example
		 * //input[@id='calToDate']/ancestor::form
		 * 
		 * 
		 * CSS
		 *  add insted following an so on
		 *  >div:nth-child(1) 
		 * 
		 * 
		 */

	}

}
