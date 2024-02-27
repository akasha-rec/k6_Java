package Review_InnerClass;
//지금까지의 클래스는 필드와 생성자, 메서드로 구성 > 멤버
// +) 또 다른 클래스도 멤버가 될 수 있다 > 내부 클래스

public class MyLinkedList { //외부 클래스 와 내부클래스는 서로의 멤버들에 쉽게 접근할 수 있다?

	private Node head = null;
	
	private class Node { //내부클래스 : 클래스면서 외부 클래스인 MyLinkedList의 멤버
		private String data;
		private Node link;
		
		public Node(String data) {
			this.data = data;
		}
	}
	
	public void add(String data) {
		Node newNode = new Node(data);
		if (head==null) {
			head = newNode;
		} else {
			Node next = head;
			while (next.link != null) {
				next = next.link; //
			}
			next.link = newNode; //마지막으로 생성된 Node의 link에 새로 생성된 인스턴스 값을 저장
		}
	}
	
	public void print() { //내부 객체인 Node의 data값 출력함
		if (head == null) {
			System.out.println("등록된 데이터가 없습니다");
		} else {
			System.out.println("등록된 데이터는 다음과 같습니다.");
			Node next = head;
			while (next != null) {
				System.out.println(next.data);
				next = next.link;
			}
		}
	}
}
