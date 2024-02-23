package com.ruby.java.ch04배열;

public class Test32 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] score;
		score = new int[] {90, 85, 78, 100, 98}; // {} 자동으로 할당할테니 int[]안에 숫자 넣을 필요X
		int num = score.length; //length : 요소수 구함. 내장변수 : 프로그램 기본 저장되어 있는 변수 
		System.out.println("num = " + num);
		
		String str = "Nice Day";
		int snum = str.length(); //String class에서 쓰이는 함수? - length?
		System.out.println(snum);
		
		int[] arr = new int[5]; //int[] = 데이터 타입 / arr = 참조 변수(메모리의 주소값) / new 공간 할당 명령어 - 자동으로 초기화가 이루어져
								// 1. 데이터 타입 [] arr(참조변수) = new 데이터 타입[인덱스]
								// 2. 데이터 타입 [] arr(참조변수) = {} - 더 많이 사용한다.
		
		arr[0] = 10; // 공간 5개를 할당했지만, 0부터 시작이라서 0~4로 매기기
		arr[1] = 20;
		arr[2] = 30;
		arr[3] = 40;
		arr[4] = 50;
		
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);
		System.out.println(arr[4]);
		
	}

}
