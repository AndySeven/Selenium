package com.syntax.practices;

import java.awt.Robot;
 
import java.awt.event.KeyEvent;
 
import java.awt.AWTException;

import com.syntax.util.CommonMethods;

public class RobotDemo extends CommonMethods {

public static void main(String[] args) throws AWTException {
		
		setUpBrowser();
		Robot robot = new Robot();
		
		robot.keyPress(KeyEvent.VK_TAB);
		wait(2);
		robot.keyRelease(KeyEvent.VK_DOWN);
		wait(2);
		robot.keyPress(KeyEvent.VK_3);
		wait(2);
		
	}
}
