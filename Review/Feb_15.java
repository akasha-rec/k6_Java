package edu1;

public class Feb_15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int i = 0; //변수 선언 및 초기화
//		while(i < 10) { // 조건식
//			System.out.println(i); // 실행문
//			i++; // 증감식
//		}
//		System.out.println("OK");
	// do-while 반복문 잘 안 쓰이지만, 알아둬야
	//반복 블록을 먼저 실행하고 조건식이 나와서 무조건 한 번은 실행됨
		
		// for 반복문
		for (int i = 10; i < 10; i++) {
		System.out.println("for OK");
		}
		// while 반복문
		int j = 10; //변수선언 및 초기화
		while (j < 10) { // 조건식
		System.out.println("while OK"); //실행문
		j++; // 증감식
	}
		//do-while문 변수 선언 및 초기화 > do { 실행문 > 증감식 } > 조건식;
		int k = 10; // 변수 선언 및 초기화
		do {
			System.out.println("do-while OK"); //실행문
			k++; //증감식
		} while (k < 10); // 조건식
	}
}
