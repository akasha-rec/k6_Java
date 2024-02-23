package com.ruby.java.ch05; // 24. 2. 8일 강의
//접근제한자(private / (default) / public) 이해하기
class Armor {
	private String name = "홍길동";
	private int height = 180;
	private int weight = 100;
	String color = "Red";
	
	private void takeoff() { 	System.out.println("Take off");}
	private void land() {	System.out.println("Land");}
	private void shootLaser() {	System.out.println("Shoot Laser");}
		
	}
public class ArmorTest {
	public static void main(String[] args) {
		Armor armor = new Armor();
		
		armor.color = "파랑";
	}
}