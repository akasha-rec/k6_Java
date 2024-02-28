package com.ruby.java.ch13;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface Mapping {
	String mode();
	int value();
}

@Retention(RetentionPolicy.RUNTIME)
@interface Comment {
	String msg();
}
@Mapping(mode = "class", value = 100)
@Comment(msg = "Annotation2 클래스")
public class AnnoTest2 { //↑ 위의 어노테이션은 AnnoTest2에 적용할 거라서 붙여써야 한다.
	
	@Mapping(mode = "method", value = 200)
	@Comment(msg = "test() 메서드")
	public static void test() {
		AnnoTest2 obj = new AnnoTest2();
		try {
			Class<?> c = obj.getClass();//클래스의 정보를 담고 있는 클래스 > 메타데이터
			Annotation annoList[] = c.getAnnotations();//그 클래스에 선언되어있는 모든 어노테이션 정보를 배열로 가져와
			System.out.println("클래스의 annotation 목록");
			for(Annotation item : annoList)
				System.out.println(item);
			
			Method m = c.getMethod("test");
			annoList = m.getAnnotations();// 그 메서드에 선언되어있는 모든 어노테이션 정보를 배열로 가져와
			System.out.println();
			System.out.println("test()메서드의 annotation 목록");
			for(Annotation item : annoList)
				System.out.println(item);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		test();
	}
}
