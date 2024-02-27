package com.ruby.java.ch13.boundGen;

class Bag<T extends Solid> {
	private T thing;

	public Bag(T thing) {
		this.thing = thing;
	}
	
	public T getThing() {
		return thing;
	}

	public void setThing(T thing) {
		this.thing = thing;
	}
	
	void showType() {
		System.out.println("T의 타입은 " + thing.getClass().getName());
	}
}
class Solid{}
class Liquid{}

class Book extends Solid{}
class PencilCase extends Solid{}
class Notebook extends Solid{}

class Water extends Liquid{}
class Coffee extends Liquid{}

public class BagTest {
	
	public static void main(String[] args) {
	Bag<Book> bag = new Bag<>(new Book());
	Bag<PencilCase> bag2 = new Bag<>(new PencilCase());
	Bag<Notebook> bag3 = new Bag<>(new Notebook());
	
//	Bag<T extends Solid>로 선언했기 때문에 Liquid를 상속받는 것들은 Bag 안으로 들어갈 수 없다.
//	Bag<Water> bag4 = new Bag<>(new Water());
//	Bag<Coffee> bag5 = new Bag<>(new Coffee());
	}

}
