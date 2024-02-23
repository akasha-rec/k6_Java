package com.ruby.java.ch11;

public class Test02_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			try {
				System.out.println("1");
				String s = null;
				s.length();
				System.out.println("2");
				System.out.println("3");
			} catch(Exception e)  { //polymorhism으로 인해 Exception이 모든 종류의 예외를 처리 = Exception이 모든 예외의 상위 개체
				System.out.println("오류 발생");
				return; // finally 밑의 출력문이 나오지 X
			} finally {
				System.out.println("OK");
			}
			System.out.println("4");
	}

}
