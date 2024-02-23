package com.ruby.java.ch07.inheritance;

public class Person {
	private String name;
	private int age;
//public Person(String name, int age) {
//	this.name = name;
//	this.age = age;
	public Person(String name, int age) { //책에서는 String name, int age가 반복되서 제거해주려고
	this.name = name; //필드값 초기화는 생성자의 몫 > name, age 값을 인자로 받아 필드를 초기화하는 생성자 선언
	this.age = age;
	System.out.println("Person 생성자");
}
	
	public String getName() {
		return name;
	}

public void setName(String name) {
	this.name = name;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

public String toString() {
	return name + " : " + age;
}
}
