package com.ruby.java.ch11;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String s = new String("java");
			int len = s.length();
			s = null;
			s.length(); //참조변수가 null인데 접근하려고 해서 NullPointerException
			int arr[] = new int[3];
			arr[3] = 30;
			System.out.println("OK");
		}	catch(ArrayIndexOutOfBoundsException e1) {
			System.out.println(e1.getMessage());
		} catch(NullPointerException e2) {
			e2.printStackTrace();
		} catch(Exception e) {
			System.out.println("오류 발생 : " + e);
		}
		System.out.println("GOOD");
	}
}