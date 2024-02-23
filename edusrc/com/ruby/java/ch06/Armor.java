package com.ruby.java.ch06; //getter, setter

public class Armor {
	private String name;
	private int height;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
}

//객체 : 전산화하려는 모든 것
//클래스 : 객체를 만드는 설계도
//인스턴스 : 클래스 이용해서 new 명령어(연산자)를 통해 생성된 객체. 객체=인스턴스