package com.ruby.java.ch14;

interface MyInterface {
	public void print();
}

class MyClass1 implements MyInterface {
	@Override
	public void print() {
		System.out.println("MyClass1");
	}
}

class MyClass2 implements MyInterface {
	@Override
	public void print() {
		System.out.println("MyClass2");
	}
}

public class Test01 {

	public static void test(MyInterface mi) {
		// TODO Auto-generated method stub
		mi.print();
	}

	public static MyInterface test2() {
		MyInterface mi = new MyInterface() {			
			@Override
			public void print() {
				// TODO Auto-generated method stub
				System.out.println("test2()메서드에서 반환된 MyInterface");
			}
		};
		return mi;
	}

	public static void main(String[] args) {

		MyClass1 mc1 = new MyClass1(); //인터페이스를 구현한 클래스의 인스턴스를 생성 ↓
		MyClass2 mc2 = new MyClass2();
		mc1.print(); //한 후 참조변수를 이용해 호출
		mc2.print();
		
		//익명클래스로 인터페이스를 구현할 때는 별도로 클래스 선언할 필요 X > 인터페이스 구현과 동시에 인스턴스 생성 O
		MyInterface mi = new MyInterface() { //익명 클래스는 이름 X > 변수의 타입은 인터페이스 타입으로 생성

			@Override
			public void print() {
				// TODO Auto-generated method stub
				System.out.println("익명클래스로 구현");	
			}
		};
		test(mc1); //익명 클래스로 구현
		test(mi); //익명 클래스로 구현

		mi.print(); //익명 클래스로 구현

		(new MyInterface() {

			@Override
			public void print() {
				// TODO Auto-generated method stub
				System.out.println("선언, 생성, 호출을 한번에 처리");
			}
		}).print(); // 선언, 생성, 호출을 한번에 처리 > 딱 한 번만 사용하고 끝낼 때

		MyInterface mi2 = test2();
		mi2.print(); //test2() 메서드에서 반환된 MyInterface
	}

}
