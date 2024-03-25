package Data_Ch08;

import java.util.Random;
import java.util.Scanner;

class Node1 {
	int data;
	Node1 link;

	public Node1(int element) {//생성자
		data = element;
		link = null;
	}
}

class LinkedList1 {
	Node1 first;

	public LinkedList1() {
		first = null;
	}

	public int Delete(int element) // delete the element
	{

	}

	public void Show() { // 전체 리스트를 순서대로 출력한다.

	}

	public void Add(int element) // 임의 값을 삽입할 때 리스트가 오름차순으로 정렬이 되도록 한다
	{//예시보다 작은 값을 추가하고 싶을 때의 코딩 + 끝났는데 값을 추가하고 싶을 때 코딩
		Node1 temp = new Node1(element);
		if (first == null) {
			first = temp;
			return;
		} else { //null이 아니면 값을 비교하는 과정이 필요 > 삽입할 위치 찾기
			Node1 p = first, q = null;
			while (p!= null) {
				if (element > p.data)
					q = p; //
					p = p.link;
				else {//insert 해야 p 앞의 값을 가리킬 q
					temp.link = p;
					q.link = temp;
				}
			}
//			if (element > p.data) { //삽입하고자 하는 element가 p의 데이터보다 크다면 == 오른쪽에 삽입
//				p.link = temp;
//			} else {
//				temp.link = p;
//				first = temp;
//			}
		}
	}

	public boolean Search(int data) { // 전체 리스트를 순서대로 출력한다.
		return true;
	}
}
public class 실습9_1정수연결리스트_test {
	enum Menu {
		Add("삽입"), Delete("삭제"), Show("인쇄"), Search("검색"), Exit("종료");

		private final String message; // 표시할 문자열

		static Menu MenuAt(int idx) { // 순서가 idx번째인 열거를 반환 enum class의 method, return type이 Menu
			for (Menu m : Menu.values()) //enum class에 정의된 객체 : values - Add, Delete ... 
				if (m.ordinal() == idx) //.ordinal : 정의된 메서드
					return m;
			return null;
		}

		Menu(String string) { // 생성자(constructor), 언제 호출되는가?
			message = string;
		}

		String getMessage() { // 표시할 문자열을 반환
			return message;
		}
	}

	// --- 메뉴 선택 ---//
	static Menu SelectMenu() {//static Method
		Scanner sc = new Scanner(System.in);
		int key;
		do {
			for (Menu m : Menu.values()) {
				System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
				if ((m.ordinal() % 3) == 2 && m.ordinal() != Menu.Exit.ordinal())
					System.out.println();
			}
			System.out.print(" : ");
			key = sc.nextInt();
		} while (key < Menu.Add.ordinal() || key > Menu.Exit.ordinal());
		return Menu.MenuAt(key);//key는 정수
	}

	public static void main(String[] args) {
		Menu menu; // 메뉴
		Random rand = new Random();
		System.out.println("Linked List");
		
		LinkedList1 l = new LinkedList1();
		Scanner sc = new Scanner(System.in);
		int data = 0;
		System.out.println("inserted");
		l.Show();
		do {
			switch (menu = SelectMenu()) {
			case Add: // 머리노드 삽입
				data = rand.nextInt(20);
				//double d = Math.random();
				//data = (int) (d * 50);
				l.Add(data);
				break;
			case Delete: // 머리 노드 삭제
				data = sc.nextInt();
				int num = l.Delete(data);
				System.out.println("삭제된 데이터는 " + num);
				break;
			case Show: // 꼬리 노드 삭제
				l.Show();
				break;
			case Search: // 회원 번호 검색
				int n = sc.nextInt();
				boolean result = l.Search(n);
				if (!result)
					System.out.println("검색 값 = " + n + "데이터가 없습니다.");
				else
					System.out.println("검색 값 = " + n + "데이터가 존재합니다.");
				break;
			case Exit: // 꼬리 노드 삭제
				break;
			}
		} while (menu != Menu.Exit);
	}
}
