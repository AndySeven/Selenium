package com.syntax.class11;

class Singleton {
	private static Singleton s;

	private Singleton() {

	}

	public static Singleton getInstance() {
		if (s == null)
			s = new Singleton();
		return s;
	}
}
public class MainClass{
	public static void main(String[] args) {
		
		// Constructor is private
		// Singleton s1 = new Singleton(); 
		
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		
		
		System.out.println(s1);
		System.out.println(s2);
	}

}
