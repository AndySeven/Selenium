package com.syntax.class08.homework;

public class NewClass {

	public static void main(String[] args) {

		int a = 0;
		int b = 1;
		int c;
		for (int i = 0; i <= 10; i++) {
			System.out.print(a + " ");
			c = a + b;
			a = b;
			b = c;
		}
	}
}
