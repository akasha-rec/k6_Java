package com.ruby.java.ch09; //실습1 2.20일
class MyObject { //MyObject의 root = Object
		public MyObject() {}
		@Override //코드주석 달기 > 컴파일러에게 알려줌
		public String toString() {//Object의 toString을 override(재정의)함
		return "MyObject2";
	}
		}
public class Test01 {
	public static void main(String[] args) {
		Object obj1 = new Object();
		Object obj2 = new Object();
		Object obj3 = new Object();

		//obj1.hashCode();
		System.out.println("obj1.hashCode()=" + obj1.hashCode());//출력이 정수
		System.out.println(Integer.toHexString(obj1.hashCode()));//16진법으로 표현
		System.out.println(obj2.hashCode());
		System.out.println(obj3.hashCode());

		Class c = obj1.getClass();//클래스명 출력
		System.out.println(c.getName());
		
		//java.lang.Object@372f7a8d 객체식별자를 찍는 method > toString()
		//println을 사용하면 변수를 String을 요구함 String s =  obj1 > 바꿔주는 게 toString() : Object의 method
		System.out.println(obj1);//toString() 결과와 같은 이유는 자동적인 타입 캐스팅 때문임 > 정수를 hexa로 변경한 것
		System.out.println(obj1.toString());//399 페이지 하단의 클래스 이름이 string
		System.out.println(obj2);//명시하지 않아도 toString()
		System.out.println(obj3);

		MyObject obj4 = new MyObject();
		System.out.println("MyObject 출력 : " + obj4);
		MyObject obj5 = new MyObject();
		//obj4.equals(obj5); //MyObject의 equals()가 실행됨
		if (obj4.equals(obj5)) {//hashcode가 다르면 다른 객체로 본다 -기준은 hashcode를 갖고 판단한다
			System.out.println("동일 객체이다.");//MyObject 클래스에서 equals()를 재정의한 경우
		} else {
			System.out.println("다른 객체이다.");//Object의 equal() 사용시에는, 403페이지 내용 
		}
		System.out.println(obj4.hashCode() + ":" + obj5.hashCode());
		if (obj4 == obj5) {
			System.out.println("동일 객체이다.");
		} else {
			System.out.println("다른 객체이다.");
		}
		System.out.println("obj4 = " + obj4);
		MyObject mo2 = new MyObject();//402페이지의 toString() 오버라이딩
		System.out.println(mo2);
	}
}
