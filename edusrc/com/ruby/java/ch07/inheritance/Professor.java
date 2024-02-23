package com.ruby.java.ch07.inheritance;

public class Professor extends Person {
	private String subject;

	public String getSubject() {
		return subject;
	}

//	public Professor(String name, int age, String subject) {
//		super(name, age);
//		super.setName(name);
//		super.setAge(age);
//		this.subject = subject;
		public Professor(String name, int age, String subject) {
		//부모 생성자를 호출하는 super()문에 인자값을 지정하여 부모 생성자에 전달
		//↓ 부모클래스의 String name, int age를 받아서 출력할 수 있으니까
		//↓ super.setName, super.setAge는 없어져야 한다. (= 중복 제거)
		super(name, age);
		super.setName(name); //name, age는 부모 클래스로부터 상속받은 필드인데 private라서
		super.setAge(age); // 접근을 못하니까 setter로 접근
		this.subject = subject; // 내 거에서 가져오고
		//이름, 나이, 과목 출력하고 싶은데 기본생성자만 있어서 이름, 나이, 과목을 받을 매개변수가 없다.
		//매개변수를 넣어보자

		System.out.println("Professor 생성자");
}
	public void setSubject(String subject) {
		this.subject = subject;
	}
//홍길동 30 자바
@Override // 부모클래스로부터 상속된 메서드
public String toString() {
	// TODO Auto-generated method stub
	return super.toString() + " : " + subject; // 홍길동 : 30 : 자바
	// = return 
}
}
