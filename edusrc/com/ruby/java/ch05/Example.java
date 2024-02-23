package com.ruby.java.ch05; // 24. 2. 8일 강의

public class Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("1");

		String num = takeoff(true, false); // takeoff 메소드가 리턴하는 값을 num에 저장
		System.out.println(num);
		
//		System.out.println(takeoff()); // 윗 2줄과 같은 의미
		
		System.out.println("2");
	}
	static String takeoff(boolean num1, boolean num2) {
		System.out.println("takeoff");
		
		return num1 + "===>" + num2;
	}
}
