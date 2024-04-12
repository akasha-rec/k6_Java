package Data_Ch08;
//단순한 linked list에서 insert, delete하는 알고리즘을 코딩: 1단계

import java.util.Random;
import java.util.Scanner;

class Node1 {
	int data;
	Node1 link;

	public Node1(int element) {
		data = element;
		link = null;
	}
}

class LinkedList1 {
	Node1 first;

	public LinkedList1() {
		first = null;
	}

	public boolean Delete(int data) //전달된 element 값이 존재 하면 삭제하고 true로 리턴
	{	Node1 p = first; //p는 현재 노드를 가리키는 포인터이자 참조변수, first는 첫번째 노드를 가리킴
		Node1 q = null;//q는 이전 노드를 가리키는 포인터이자 참조변수

	if(first == null) {
		System.out.println("데이터가 없습니다.");
		return false;
	}
<<<<<<< HEAD
	if (p.data == data) {//첫번째 노드를 삭제할 경우
		first = p.link;
		return true;
	}
=======
>>>>>>> branch 'main' of https://github.com/akasha-rec/k6_java.git
	while (p != null) {
		if(p.data == data) {
			if (q == null) {//첫번째 노드를 삭제하는 경우
			first = p.link; //first를 다음 노드의 주소값을 가지고 있는 p.link를 할당하여 다음 노드를 새로운 첫 노드로 만듦
		} else {
		q.link = p.link;//이전 노드 q와 p의 다음 노드를 연결
		}
		return true; //삭제 성공
		}
		q = p;
		p = p.link; //
	}
	 return false;
	}

	public void Show() { // 전체 리스트를 순서대로 출력한다.
		Node1 p = first;
		int num = 1;
		if(first == null) {
			System.out.println("빈 노드입니다.");
			return;
		}
		while (p != null) {
			System.out.println(num + "번째 데이터 "+ p.data + "입니다.");
			p = p.link;
			num++;
		}
	}

	public void Add(int element) // 임의 값을 삽입할 때 리스트가 오름차순으로 정렬이 되도록 한다
	{
		Node1 newNode = new Node1(element);
		if (first == null) {//데이터가 하나도 없을 때
			first = newNode;
			return;
		} else { //데이터가 1개 이상 있을 때
			Node1 p = first;
			Node1 q = null;

			if(p.data >= newNode.data) {
				newNode.link = first;
				first = newNode;
				return;
			}

			while (p != null) {
				if(p.data <= newNode.data) {
					q = p;
					p = p.link;
				} else {
					q.link = newNode;
					newNode.link = p;
					return;
				}
			}
			q.link = newNode;
		}	

	}

	public boolean Search(int data) {//전달된 data 값을 찾아 존재하면 true로 리턴, 없으면 false로 리턴
		Node1 p = first;
		if (first == null) {
			System.out.println("빈 데이터입니다.");
			return false;
		}
		while (p != null) {
			if(data == p.data) {
				return true;
			}
			p = p.link;
		}

		return false;
	}

	void Merge(LinkedList1 b) {
		/*
		 * 연결리스트 a,b에 대하여 a = a + b
		 * merge하는 알고리즘 구현으로 in-place 방식으로 합병/이것은 새로운 노드를 만들지 않고 합병하는 알고리즘 구현
		 * 난이도 등급: 최상
		 * a = (3, 5, 7), b = (2,4,8,9)이면 a = (2,3,4,5,8,9)가 되도록 구현하는 코드
		 */
	}
}

public class 실습9_1정수연결리스트 {
	enum Menu {
		Add("삽입"), Delete("삭제"), Show("인쇄"), Search("검색"), Merge("합병"), Exit("종료");

		private final String message; // 표시할 문자열
		//		Menu class로 간주하고 Add, Delete, Show, Search, Exit가 Menu의 객체
		static Menu MenuAt(int idx) { // 순서가 idx번째인 열거를 반환
			for (Menu m : Menu.values())//생성자가 호출되는 곳. values는 java library의 method
				//			> Menu.values(Add("삽입"), Delete("삭제"), Show("인쇄"), Search("검색"), Exit("종료"))는 list로 갖고 있어
				if (m.ordinal() == idx)
					return m;
			return null;
		}
		//"Add" 상수가 정의될 때 Menu("삽입") 생성자가 호출되어 message 필드가 "삽입"으로 초기화
		//생성자는 각 상수가 정의될 때 호출되며, 해당 상수의 message 필드를 초기화하는 역할
		//enum 상수가 언제 정의되는가를 찾아 보아야 한다 
		Menu(String string) { // 생성자(constructor)가 언제 호출되는지 파악하는 것이 필요하다 
			message = string;
			System.out.println("\nMenu 생성자 호출:: " + string);
		}

		String getMessage() { // 표시할 문자열을 반환
			return message;
		}
	}

	// --- 메뉴 선택 ---//
	static Menu SelectMenu() {//Static Method
		Scanner sc = new Scanner(System.in);
		int key;
		do {
			for (Menu m : Menu.values()) {//Menu 생성자 호출됨
				System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());//(0) 삽입  (1) 삭제  (2) 인쇄 (3) 검색  (4) 종료   : 출력되는 곳
				//n%3은 3으로 나누어 나머지를 계산한다 
				if ((m.ordinal() % 3) == 2 && m.ordinal() != Menu.Exit.ordinal())////Add Delete Show \n Search Exit 형식으로 출력
					System.out.println();
			}
			System.out.print(" : ");
			key = sc.nextInt();//메뉴 선택 번호로 입력된 값이 key이다 
		} while (key < Menu.Add.ordinal() || key > Menu.Exit.ordinal());//입력된 key가 음수이거나 Exit에 대한 enum 숫자보다 크면 다시 입력받는다 
		return Menu.MenuAt(key);
	}

	public static void main(String[] args) {
		Menu menu; // 메뉴 참조 변수일 뿐이다 
		Random rand = new Random();
		LinkedList1 l = new LinkedList1();
		Scanner sc = new Scanner(System.in);
		int count = 3; //난수 생성 갯수
		int data = 0;
		do {
			l.Show();
			switch (menu = SelectMenu()) {//Menu 생성자 호출 - menu 객체를 리턴한다 
			case Add: // 0일 때 난수를 삽입하는데 올림차순으로 정렬되도록 구현
				for (int i =0; i < count; i++) {
					data = rand.nextInt(20);
					l.Add(data);
				}
				break;
			case Delete://1일 때
				System.out.println("삭제할 값을 입력: ");
				data = sc.nextInt();
				boolean tag = l.Delete(data);
				System.out.println("삭제 데이터 존재여부: " + tag);
				break;
			case Show: //리스트 전체를 출력
				l.Show();
				break;
			case Search: //입력 숫자 n을 검색한다.
				int n = sc.nextInt();
				boolean result = l.Search(n);
				if (!result)
					System.out.println("검색 값 = " + n + " 데이터가 없습니다.");
				else
					System.out.println("검색 값 = " + n + " 데이터가 존재합니다.");
				break;
			case Merge://리스트 l과 l2를 합병하여 올림차순 정렬이 되게 구현한다 
				LinkedList1 l2 = new LinkedList1();
				for (int i =0; i < count; i++) {
					data = rand.nextInt(20);
					l2.Add(data);
				}
				l.Merge(l2);//merge 실행후 show로 결과 확인 - 새로운 노드를 만들지 않고 합병 - 난이도 상
				break;
			case Exit: // 꼬리 노드 삭제
				break;
			}
		} while (menu != Menu.Exit);
	}
}
