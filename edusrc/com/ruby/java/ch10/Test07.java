//숙달 훈련 필요   - 실습 대상 - 파이썬 dictionary 2월 22일
package com.ruby.java.ch10;
//MAP에 iterator 사용 실습 - iterator 사용 실습 
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Test07 {

	public static void main(String[] args) {

		HashMap<String, String> dic = new HashMap<>();

		dic.put("고진감래", "고생 끝에 즐거움이 옴");
		dic.put("분골쇄신", "몸이 부서질정도로 노력을 다함");
		dic.put("권토중래", "실패를 발판삼아 재기함");
		dic.put("교학상자", "가르치고 배우면서 서로 성장함");
		dic.put(null, null); // HashMap은 null 값 저장 가능

// 방법1 -iterator 사용 ★★★★
		System.out.println("\n방법1:" + dic.keySet()); //[null, 권토중래, 분골쇄신, 교학상자, 고진감래]
		Iterator<String> keys = dic.keySet().iterator();
		while (keys.hasNext()) {
			String key = keys.next();
			System.out.println(String.format("%s : %s", key, dic.get(key)));
		}

// 방법2 - 확장형 for 문 - Entry 객체
		System.out.println("\n방법2:");
		for (Map.Entry<String, String> elem : dic.entrySet()) {//Map(인터페이스)내부 인터페이스 Entry라서 Map.entry
			System.out.println(String.format("%s : %s", elem.getKey(), elem.getValue()));
		}

// 방법3 - 확장형 for 문 - key 값 사용 
		System.out.println("\n방법3:");
		for (String key : dic.keySet()) {
			System.out.println(String.format("%s : %s", key, dic.get(key)));
		}
	}
}