package com.ruby.java.ch08.innerClass;

class OuterClass { //하나의 자바파일에는 public은 하나 > public 지워주면 돼
	
	class InstanceClass {
		int a;
	
	void method2() {
		System.out.println("Instance Class : " + a);
	}
	}
	
	static class StaticClass {
		int b;
		static int c;
		void method3() {
			System.out.println("Static Class : " + b);
		}
		static void method4() {
			System.out.println("Static Class : " + c);
		}
	}


	public static void main(String[] args) {
	OuterClass outer = new OuterClass();
	OuterClass.InstanceClass inner01 = outer.new InstanceClass(); //클래스 내의 클래스라서 outer 붙여줬다?
	//outer.InstanceClass inner02 = outer.new InstanceClass(); // 참조변수 앞에 클래스 정보가 와야 하는데 객체가 오면 오류
	inner01.a = 123;
	inner01.method2();
	OuterClass.StaticClass inner02 = new OuterClass.StaticClass();
	inner02.b = 456;
	inner02.method3();
	OuterClass.StaticClass.c = 789;
	OuterClass.StaticClass.method4();
}
}
