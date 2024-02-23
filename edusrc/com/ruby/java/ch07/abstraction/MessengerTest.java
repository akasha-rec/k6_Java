package com.ruby.java.ch07.abstraction;

public class MessengerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IPhoneMessenger iphone = new IPhoneMessenger();
		GalaxyMessenger galaxy = new GalaxyMessenger();
		//Messenger 어쩌고로 바뀔 수 있다 > 다형성?
		
		System.out.println("메신저 최소 문자 크기" + Messenger.MIN_SIZE);
		System.out.println("메신저 최대 문자 크기" + Messenger.MAX_SIZE);
		
		iphone.setLogin(true);
		iphone.getMessage();
		iphone.setMessage("hello");
		iphone.clearMessage();
		
		galaxy.setLogin(true);
		galaxy.getMessage();
		galaxy.setMessage("hi");
		galaxy.changeKeyboard();
		
		galaxy.fileDownload();
		galaxy.fileUpload();
	}

}
