package com.ruby.java.ch08.innerClass;
interface Messenger {
	String getMessage();
	void setMessage(String msg);
}

class GalaxyMessenger implements Messenger {
		public String getMessage() {
			return "test";

		}

		public void setMessage(String msg) {
			System.out.println("test에서 메시지를 설정합니다 : " + msg);
		}
}

	public class MessengerTest {
		public static void main(String[] args) {
			//Messenger test = new Messenger(); // Messenger는 interface라서 객체 생성X > 오류
			GalaxyMessenger galaxy = new GalaxyMessenger();
			Messenger test = new Messenger() { // >
				public String getMessage() {
					return "test";

				}

				public void setMessage(String msg) {
					System.out.println("test에서 메시지를 설정합니다 : " + msg);
				}
			}; // < new 인터페이스 + 인터페이스 구현한 내용? 익명클래스! == 인터페이스 구현, 클래스(Messenger) 이름은 없어
}