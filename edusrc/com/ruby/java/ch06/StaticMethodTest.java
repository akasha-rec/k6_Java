package com.ruby.java.ch06;

public class StaticMethodTest {
	
	static int num = 123;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StaticMethodTest.print1();
//		print1();
		StaticMethodTest exam = new StaticMethodTest();
		exam.print2();
	}
	
	public static void print1() {
		int num2 = num;
		System.out.println("Hello");
	}
	
	public void print2() {
		int num3 = num;
		System.out.println("java");
	}
}



