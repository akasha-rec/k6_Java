package com.ruby.java.ch13;

class Bag<T, N> {
	private T thing;
	private N name;
	

	public Bag(T thing, N name) { //parameter를 받는 생성자
		this.thing = thing;
		this.name = name;
	}
	
//	public Bag() { //그래서 parameter가 없는 기본 생성자가 필요
//		
//	}
	
	public T getThing() {
		return thing;
	}

	public void setThing(T thing) {
		this.thing = thing;
	}
	
	public N getName() {
		return name;
	}
	
	public void setName(N name) {
		this.name = name;
	}
	
	void showType() {
		System.out.println("T의 타입은 " + thing.getClass().getName());
		System.out.println("N의 타입은 " + name.getClass().getName());
	}
}

class Book{
	public String toString() {
		return "책";
	}
}

class PencilCase{}
class Notebook{}

public class BagTest {
	
	public static void main(String[] args) {
		
		//제네릭과 매개변수 타입이 일치해야
		//T는 Book, N은 String으로 대체
		Bag<Book, String> bag = new Bag<Book, String>(new Book(), "과학");
		
		bag.showType();
		
		Book book = bag.getThing();
		String name = bag.getName();
		
		System.out.println("Thing is : " + book);
		System.out.println("name is " + name);
		
//		bag = bag2; 타입은 같지만 실제 데이터가 달라서
		
//		Bag<Book> bag = new Bag<>();
//		bag.setThing(new Book());
//		bag.showType();
		
	}

}
