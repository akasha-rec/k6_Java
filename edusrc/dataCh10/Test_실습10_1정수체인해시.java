package dataCh10;//먼저 이해하고 오픈해시

import java.util.Scanner;
//체인법에 의한 해시
//--- 해시를 구성하는 노드 ---//

class Node {
    int key; // 키값
    Node next;// 뒤쪽 포인터(뒤쪽 노드에 대한 참조)
    
    Node(int k) {//생성자
    	key = k;
    	next = null;
    }
}

class SimpleChainHash {
 private int    size;         // 해시 테이블의 크기
 private Node[] table;        // 해시 테이블(해시값을 인덱스로 하여 원래의 키값을 저장한 배열)


public SimpleChainHash(int capacity) {
	// TODO Auto-generated constructor stub
	try {
		table = new Node[capacity];
		size = capacity;
	} catch (OutOfMemoryError e) { //테이블을 생성할 수 없음
		size = 0;
	}
}

public int hashValue(int key) {
	return key % size;
}

//--- 키값이 key인 요소를 검색(데이터를 반환) ---//
 public int search(int key) {//key가 찾고자 하는 데이터
	 int hash = hashValue(key);//hash가 table의 index
	 Node p = table[hash];//선택한 노드
	 if (p == null) {
		 System.out.println("검색 실패");
		 return -1;
	 }
	 while (p != null) {
		 if(p.key == key) {
			 return 1; //검색 성공
		 }
		 p = p.next; //다음 노드 선택
	 }
	 return -1;
 }

 //--- 키값이 key인 데이터를 data의 요소로 추가 ---//
 public int add(int key) {
	 int hash = hashValue(key);
	 Node p = table[hash];
	 Node temp = new Node(key);//값을 저장할 노드를 새로 만들어
	 
	 if (p == null) {
		 table[hash] = temp;//넣을 hash값에 대입
		 return 1;
	 }
	 while (p != null) {
		 if (p.key == key) {
			 return 0; //이미 존재
		 }
		 p = p.next;
	 }
	 temp.next = table[hash];
	 table[hash] = temp;
	 return 1;
 }

 //--- 키값이 key인 요소를 삭제 ---//
 public int delete(int key) {
	 int hash = hashValue(key);
	 Node p = table[hash];
	 Node q = null;
	 
	 while(p != null) {
		 if(p.key == key) {
			 if(q == null)
				 table[hash] = p.next;
			 else
				 q.next = p.next;
			 return 1;
		 }
		 q= p;
		 p = p.next;
	 }
	 return -1; //키 값은 없다.
 }

 //--- 해시 테이블을 덤프(dump) ---//
 public void dump() {
	 for (int i = 0; i < size; i++) {
		 Node p = table[i];
		 while(p != null) {
			 System.out.print(p.key + ">");
			 p = p.next;
		 }
	 }
 }
}

public class Test_실습10_1정수체인해시 {

	enum Menu {
		Add("삽입"), Delete("삭제"), Search("검색"), Show("출력"), Exit("종료");

		private final String message; // 표시할 문자열

		static Menu MenuAt(int idx) { // 순서가 idx번째인 열거를 반환
			for (Menu m : Menu.values())
				if (m.ordinal() == idx)
					return m;
			return null;
		}

		Menu(String string) { // 생성자(constructor)
			message = string;
		}

		String getMessage() { // 표시할 문자열을 반환
			return message;
		}
	}
		// --- 메뉴 선택 ---//
		static Menu SelectMenu() {
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
			return Menu.MenuAt(key);
		}


//체인법에 의한 해시 사용 예
 public static void main(String[] args) {
	 	Menu menu;
		SimpleChainHash hash = new SimpleChainHash(11);
		Scanner stdIn = new Scanner(System.in);
		int select = 0, result = 0, val = 0;
		final int count = 15;
		do {
			switch (menu = SelectMenu()) {
			case Add:

				int[] input = new int[count];
				for (int ix = 0; ix < count; ix++) {
					double d = Math.random();
					input[ix] = (int) (d * 20);
					System.out.print(" " + input[ix]);
				}
				for (int i = 0; i < count; i++) {
					if ((hash.add(input[i])) == 0)
						System.out.println("Insert Duplicated data");
				}
				break;
			case Delete:
				// Delete
				System.out.println("Search Value:: ");
				val = stdIn.nextInt();
				result = hash.delete(val);
				if (result == 1)
					System.out.println(" 검색 데이터가 존재한다");
				else
					System.out.println(" 검색 데이터가 없음");
				System.out.println();
				break;
			case Search:
				System.out.println("Search Value:: ");
				val = stdIn.nextInt();
				result = hash.search(val);
				if (result == 1)
					System.out.println(" 검색 데이터가 존재한다");
				else
					System.out.println(" 검색 데이터가 없음");
				System.out.println();
				break;

			case Show:
				hash.dump();
			break;
		}
	} while (menu != Menu.Exit);

	}
}
