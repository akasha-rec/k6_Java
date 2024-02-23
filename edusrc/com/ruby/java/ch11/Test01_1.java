package com.ruby.java.ch11;

public class Test01_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test1();
		System.out.println("GOOD");
	}
	
	private static void test1() {
		System.out.println("test1 Start!");
		test2();
		System.out.println("test1 end");
	}
	
	private static void test2() {
		System.out.println("test2 Start!");
		try {
			int temp = 10/0;
//			String s = new String("java");
//			int len = s.length();
//			s = null;
//			s.length(); //참조변수가 null인데 접근하려고 해서 NullPointerException
			int arr[] = new int[3];
			arr[3] = 30;
			System.out.println("OK");
		}	catch(ArrayIndexOutOfBoundsException e1) {
			System.out.println(e1.getMessage());
			e1.printStackTrace();
		} catch(NullPointerException e2) {
			e2.printStackTrace();
		} catch(Exception e) { //switch case문에서 default와 같은, 정의해놓은 오류 외에 오류 발생 시 실행
			System.out.println("오류 발생 : " + e);
		}
		System.out.println("test2 end");
	}
}
