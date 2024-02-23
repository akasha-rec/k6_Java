package com.ruby.java.ch11;

import java.io.FileInputStream;

public class Test04 {
	public static void test() throws Exception {//예외 여러개 던진다
		int t = 10/0;
		
		//FileInputStream fi = new FileInputStream("a1.txt");
		//int c = fi.read();
		//System.out.println((char)c);

	}
	public static void main(String[] args) {
		System.out.println("Start");
		try {
			test();
		} catch (Exception e) {
			System.out.println(e.getMessage());
//			e.printStackTrace();
		}
		System.out.println("End");
	}
}
