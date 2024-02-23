package com.ruby.java.ch08;

public class MyLinkedList {
	
	private Node head; // head는 Node를 가리키는 참조변수, MyLinkedList의 필드는 head 1개 > heap?
	private class Node { 
		private String data;
		private Node link;
		public Node(String data) {
			//생성자는 필드가 2개이므로 heap에 필드 공간 2개 할당
			this.data = data;
			link = null;
		}

	}
	public void add(String data) {
		Node newNode = new Node(data);
		if (head == null)
			head = newNode;
		else {
		Node next = head;
		while (next.link != null) {
			next = next.link;
		}
		next.link = newNode;
	}
	}

public void print() {

}
	public MyLinkedList() {
		this.head = null;
	}
}

