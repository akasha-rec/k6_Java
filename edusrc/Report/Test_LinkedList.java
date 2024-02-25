package Report; //과제3 2월 26일까지

class Node3 {
	int data; //필드
	Node3 link;

	public Node3(int data) {
		this.data = data; link = null;
	}
}
class LinkedList3 {
	Node3 first; //필드, heap에 변수 first 생성 > data type : Node

	void append(int data) {
		Node3 p = first, q = null; // p가 현재 노드, q는 이전 노드 연결해나가야 하니까 q = p;
		//추가 코딩을 해야... 
		Node3 newNode = new Node3(data);
		if (p == null) { //생성
			first = newNode;
			return; 
		} else {
			while (p != null) { //끝이 아니라서 다음 노드로 연결을 위해
				q = p;
				p = p.link;//p = null이 되서 > 현재 p의 주소를 p에게 넘기고 다음으로
			}
			q.link = newNode; // q가 새로운 노드를 가리킨다.
		}
	}

	public LinkedList3() { //기본 생성자 참조변수 ll > 참조변수
		first = null;
	}

	void showList() {
		System.out.println();
		Node3 p = first;
		while (p != null) {
			System.out.println(p.data+"");
			p = p.link;
		}
		System.out.println();
	}
	void insert(int data) {
		Node3 newNode = new Node3(data);
		Node3 p = first, q = null;
		if (p == null || p.data > data) { // 리스트가 비어있거나 새로운 노드가 첫 번째 노드보다 작을 때
			newNode.link = first;
			first = newNode;
			return;
		}

		while (p != null && p.data < data) {
			q = p;
			p = p.link;
		}

		newNode.link = p;
		q.link = newNode;
	}
}

public class Test_LinkedList {
	static int getList(int[]data) {
		int count = 0;
		int mid = data.length/2; //// int[]list = new int[10]; > data.length 10 /2 == 5
		for (int i = 0; i <= mid; i++) {
			data[i] = i * 5; count++; //[0, 5, 10, 15, 20, 25]
		}
		return count;
	}

	static void showList(int[]data) {
		System.out.println();
		for (int i=0; i < data.length; i++) 
			System.out.print(" " + i + " ");
		System.out.println();
		for (int i = 0; i < data.length; i++) {
			if (data[i] < 10)
				System.out.print(" ");
			System.out.print(data[i]+ " ");
		}
	}
	static int insertList(int[] data, int count, int x) {
		int indx = 0; //인덱스, 값을 삽입할 위치 찾을 때
		int i = 0; // 값을 옮길 때 사용
		while (indx < count) {
			if (x < data[indx]) {//현재 위치의 값보다 삽입할 값이 작다면
				while (indx < count) { //insert 하면서 옆으로 밀려나, 중간?
					int temp = data[i]; //밀려날 수 임시 저장
					data[i] = x;
					x = temp;
					i++;
					indx++;
				}
				break;
			}
			else {
				indx++;
			}
		}
		return count+1;
	}

	public static void main(String[] args) {
		int[]list = new int[10];
		int count = 0;
		System.out.println("배열로 리스트::");
		count = getList(list);
		showList(list);
		
		count = insertList(list, count, 3); //count는 배열의 개수, 3을 추가하면 맨 앞으로 가고 다른 것들이 밀림
		showList(list);
		
		count = insertList(list, count, 7);
		showList(list);
		//********************* 

		//new : 1. (heap) 메모리에 할당된 2. 주소값 반환
		LinkedList3 ll = new LinkedList3();
		ll.append(5);ll.append(10);ll.append(15);ll.append(20);ll.append(25); // 붙인다
		ll.showList();
		
		ll.insert(3);ll.showList();
		
		ll.insert(7);ll.showList();
	}
}
