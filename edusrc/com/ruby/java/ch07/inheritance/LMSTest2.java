package com.ruby.java.ch07.inheritance;

public class LMSTest2 {
	public static void main(String[] args) {

				Professor p = new Professor("홍길동", 30, "자바");
				//new Professor("홍길동", 30, "자바");객체를 만듦과 동시에 바로 데이터 할당하려고

				p.setName("김푸름");
				p.setAge(52);
				p.setSubject("빅데이터");

				System.out.println(p.toString());

	}

}
