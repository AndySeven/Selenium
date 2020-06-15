package com.syntax.class06;

import com.syntax.util.BaseClass;

public class AuthentificationAlert {

	public static void main(String[] args) {
		
		BaseClass.setUpBrowser();
		
		/**
		 * // Actual URL --> http://abcdatabase.com/basicauth
		 * userName = test
		 * password = test
		 */
		// web site with poping up box for userName and password
		BaseClass.driver.get("http://test:test@abcdatabase.com/basicauth");

	}

}
