package com.ruby.java.ch13; 

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME) //선언하려는 어노테이션의 범위 지정, 실행 시에도 유지
@interface Check {
	String name();
	int val();
}

public class AnnoTest {
	
	@Check(name = "first", val = 123) // < Check 어노테이션 유지
	public static void test() {
		AnnoTest obj = new AnnoTest();
		try {
			Class<?> c = obj.getClass();
			Method m = c.getMethod("test"); 
			
			Check check = m.getAnnotation(Check.class);
			System.out.println(check.name() + " : " + check.val());
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		test();
	}
}
