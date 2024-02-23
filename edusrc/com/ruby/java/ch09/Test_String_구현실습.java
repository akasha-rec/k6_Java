package com.ruby.java.ch09;

//구현 실습 코드
import java.util.Scanner;
public class Test_String_구현실습 {
	static void getData(String[] arr) {
		Scanner sc = new Scanner(System.in);
		
		
		for {
			arr[i] = sc.next();
		}
			
			
		
	}
	static void showData(String[] arr) {

	}
	/*
	 * 교재 407 Test02: if (s1 == s2)
	 * 교재 409 Test02: if (s1.equals(s2))
	 * compareTo() 사용 
	 */
	static boolean findString(String[] arr, String st) {
		for (int i = 0; i < arr.length; i++) {
//			if (arr[i] == st)
//			if (arr[i].equals(st));
			if (arr[i].compareTo(st) == 0)
		}
		System.out.println(st + "배열에 없다");
		return false;
	}
	public static void main(String[] args) {
		String[]arr= new String[5];
		//화면에서 입력
		getData(arr);
		showData(arr);
		Scanner sc = new Scanner(System.in);
		String st = sc.next();
		boolean result = findString(arr, st);
		if (result)
			System.out.println();

	}
}
