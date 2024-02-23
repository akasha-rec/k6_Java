package com.ruby.java.ch04배열;

public class Test34 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10, 20, 30, 40, 50};
		for(int i = 0; i < arr.length; i++)
		System.out.println(arr[i]);
		
		for(int num : arr) { 
			//배열의 모든 원소 출력할 때, 인덱스 사용이 필요하지 않을 때 [확장 for문]
			//for(데이터 타입 변수 - 참조변수의 데이터타입에 따라 달라 : 참조변수) { 실행문 }
			System.out.println(num);
		}
		
/*		for (String st : stx) {
			System.out.println(stx);*/
//		}
	}

}
