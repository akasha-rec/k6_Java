package com.ruby.java.ch14.Lambda;

interface Calculator {
	int func();
}

public class Test09 {
	
	static int num1 = 10; //필드라서 값 사용과 수정이 모두 가능
	int num2 = 20;
	
	public static void main(String[] args) {
		Test09 test = new Test09(); //test, num3 : 람다식이 있는 메서드의 지역변수이므로 값 변경 불가능
		int num3 = 30;
		
		Calculator calc = () -> {//람다식이 구현된 메서드
			int num4 = 40;
			Test09.num1++;
			test.num2++;
//			num3++; 
			num4++;
			return num4;
		};
	}

}
