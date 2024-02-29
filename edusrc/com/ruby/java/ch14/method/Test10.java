package com.ruby.java.ch14.method;

interface StringFunc {
	String modify(String s);
}

public class Test10 {

	String func(String s) {
		String result = "";
		char c;
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if(c==',')
				result += " ";
			else
				result += c;
		}
		return result;
	}

	public static void main(String[] args) { //StringFunc 함수형 인터페이스를 구현한 거라서 리턴 타입과 파라미터 데이터타입이 같아야 성립 가능

		//StringFunc sf = Test10::func; Static 메서드 참조
		Test10 obj = new Test10(); //인스턴스 메서드 참조
		StringFunc sf = obj::func;

		String str = "Korea,Australia,China,Germany,Spain,Turkey";
		String result = sf.modify(str);
		System.out.println(result);

		String str2 = "서울,북경,도쿄,뉴욕,발리";
		result = sf.modify(str2);
		System.out.println(result);
	}
}
