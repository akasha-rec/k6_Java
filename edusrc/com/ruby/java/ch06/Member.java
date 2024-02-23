package com.ruby.java.ch06;

public class Member {
	private String name;
	private int age;
	
	public Member() { //Member class의 생성자 <
//		System.out.println("Member() 생성자 실행");
		this("guest");
	}
	
	public Member(String name) {
//		System.out.println("Member(String) 생성자 실행 : ");
//		System.out.println(name);
		this(name, 0);
	}
	public Member(String name, int age) {
//		System.out.println("Member(String, int) 생성자 실행 : ");
//		System.out.println(name + " : " + age);
		this.name = name;
		this.age = age;
	}
	public void setName(String name) {
	System.out.println();	
	}
	
	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + "]";
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("main() 메서드 실행");
		Member m1 = new Member(); // < 실행
		Member m2 = new Member("Amy");
		Member m3 = new Member("Amy", 23);
		
		System.out.println("m1:" + m1); //System.out.println(m1.toString());
		System.out.println("m2:" + m2);//System.out.println(m2.toString());
		System.out.println("m3:" + m3);//System.out.println(m3.toString())
	}

}
