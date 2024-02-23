package com.ruby.java.ch11;

public class Test05 {
	int battery = 0;
	
	public void charge(int time) throws Exception{ //Exception 처리하지 않겠다.
		if (time < 0) {
			time = 0;
			throw new NagativeNumberException("마이너스는 안 돼요");
		}
		battery += time;
		System.out.println("현재 배터리 : " + battery);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test05 test = new Test05();
		
		try { //main에서 처리하는 방법
			test.charge(30);
			test.charge(20);
			test.charge(-10);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
