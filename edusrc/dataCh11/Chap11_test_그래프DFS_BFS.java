package dataCh11;

/*
 Graph Representation
 Adjacency Lists + BFS + DFS
 */

import java.util.Scanner;

class ListNode {
	int data;
	ListNode link;

	public ListNode(int data) {
		this.data = data;
		link = null;
	}
}

class List {
	ListNode first;

	public List() {
		first = null;
	}
	
	void Insert(int k) {//같은 값을 체크하지 않아 중복 입력됨
		// 구현할 부분
		ListNode temp = new ListNode(k);
		if (first == null) {
			first = temp;
			return;
		}
		ListNode p = first, q = null;
		while (p != null) {
			q =  p;
			p = p.link;
		}
	}

	void Delete(int k) {
		// 구현할 부분
		ListNode tmp = new ListNode(k);
		if (first == null) {
			return;
		}
		ListNode p = first, q = null;
		while (p != null) {
			if (k == p.data) {
				return;
			} else
		}
	}
}

class ListIterator {

	private List list;
	private ListNode current;//현재 어디를 가리키고 있는지 포인터

	public ListIterator(List l) {//생성자
		list = l;
		current = list.first;
	}

	int First() {
		if (current != null)
			return current.data;
		else
			return 0;
	}

	int Next() {//다음으로 이동
		int data = current.data;
		current = current.link;
		return data;
	}

	boolean NotNull() {
		if (current != null)
			return true;
		else
			return false;
	}

	boolean NextNotNull() {//current 다음이 null인지 아닌지
		if (current.link != null)
			return true;
		else
			return false;
	}


}

class QueueNode {
	int data;
	QueueNode link;

	QueueNode(int data, QueueNode link) {
		this.data = data;
		this.link = link;
	}
}

class Queue {
	private QueueNode front, rear;

	void QueueEmpty() {
		front = rear = null;
	}

	public Queue() {
		QueueEmpty();
	}

	boolean IsEmpty() {
		if (front == null)
			return true;
		else
			return false;
	}

	void Insert(int y) {
		// 구현할 부분
	}

	int Delete() {
		// 구현할 부분
	}
}
class StackNode {
	ListNode data;
	StackNode link;

	StackNode(ListNode data, StackNode link) {
		this.data = data;
		this.link = link;
	}
}
class Stack {
	private StackNode top;

	void StackEmpty() {
		top = null;
	}

	public Stack() {
		StackEmpty();
	}

	boolean IsEmpty() {
		if (top == null)
			return true;
		else
			return false;
	}

	void Insert(ListNode y) {
		// 구현할 부분
	}

	ListNode Delete()
	// delete the top node in stack and return its data
	{
		// 구현할 부분
	}
}


class Graph {
	private List[] HeadNodes;
	int n;
	boolean[] visited;

	public Graph(int vertices) {

		int [][]a = new int[3][];//행이 3개인 행렬
		for (int i = 0; i < a.length; i++) {//=> [3][4] 행렬을 만들었다.
			a[i] = new int[4];//한 행에 요소가 4개, 열이 4개
		}

		n = vertices;
		HeadNodes = new List[n];
		visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			HeadNodes[i] = new List(); //linkedList
			visited[i] = false;
		}

	}

	void displayAdjacencyLists() {
		for (int i = 0; i < n; i++) {
			System.out.print("\n" + i + "[ ] ");
			ListNode p = HeadNodes[i].first;//왜 first를 썼을까?
			while (p != null) {
				System.out.print("-> " + p.data);
			}
			// 구현할 부분
		}
	}

	void InsertVertex(int start, int end) {//(0, 1) 전달 시
		if (start < 0 || start >= n || end < 0 || end >= n) {
			System.out.println("the start node number is out of bound.");
			return;
		}
		HeadNodes[start].Insert(end);;
		HeadNodes[end].Insert(start);;

		// 구현할 부분
	}

	void BFS(int v) {
		boolean[] visited = new boolean[n]; // visited is declared as a Boolean 
		for (int i = 0; i < n; i++)
			visited[i] = false; // initially, no vertices have been visited
		// 구현할 부분
		//_BFS(v);//non-recursive. queue를 사용해서 구현
	}
	void ShowList(List l) {
		ListIterator li = new ListIterator(l);
		// 구현할 부분
	}

	// Driver : main에서 호출된 함수
	void DFS(int v) {
		for (int i = 0; i < n; i++)
			visited[i] = false; // initially, no vertices have been visited

		_DFS(v); // start search at vertex 0, recursive
		//_NonRecursiveDFS(v); //Stack을 이용한 non-recursive

	}

	// Workhorse
	void _DFS(int v)
	// visit all previously unvisited vertices that are reachable from vertex v
	{
		visited[v] = true;
		System.out.println(v + ", ");
		ListIterator li = new ListIterator(HeadNodes[v]);//list를 준다. v = 0 > 첫번째 리스트
		if (!li.NotNull())
			return;
		int w = li.First();
		while (true) {
			if (!visited[w]) //방문하지 않았으면 다시 방문. recursive
				_DFS(w);
			if (li.NotNull())
				w = li.Next();
			else
				return;
		}
	}
	// Workhorse 2
	void _NonRecursiveDFS(int v)
	// visit all previously unvisited vertices that are reachable from vertex v
	{
		// 구현할 부분

	}
}
public class Chap11_test_그래프DFS_BFS {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//select : 메뉴 선택 변수 / n : node 개수
		int select = 10, n, startEdge = -1, endEdge = -1;
		int startBFSNode = 0;// the start node to BFS

		System.out.println("vertex 숫자 입력: ");

		n = sc.nextInt();

		Graph g = new Graph(n);

		while (select != '0') {
			System.out.println("\n명령 선택 1: edge 추가, 2: Adjacency Lists 출력, 3: BFS, 4: DFS, 5: 종료 => ");
			select = sc.nextInt();
			switch (select) {
			case 1:
				/*
				System.out.println("edge 추가: from vertext: ");
				startEdge = sc.nextInt();
				System.out.println("to vertex: ");
				endEdge = sc.nextInt();
				if (startEdge < 0 || startEdge >= n || endEdge < 0 || endEdge >= n) {
					System.out.println("the input node is out of bound.");
					break;
				}
				// get smallest start node.
				if (startEdge < startBFSNode)
					startBFSNode = startEdge;
				if (endEdge < startBFSNode)
					startBFSNode = endEdge;
				g.InsertVertex(startEdge, endEdge);
				 */
				int [][] inputData = {{0, 1}, {0, 2}, {0, 3}, {1, 4}, {2, 4}, {3, 4}, {3, 5}, {4, 5}};
				for (int i = 0; i < inputData.length; i++) {
					g.InsertVertex(inputData[i][0], inputData[i][1]);
				}
				break;
			case 2:
				// display
				g.displayAdjacencyLists();
				break;

			case 3:
				System.out.println("Start BFS from node: " + startBFSNode);
				g.BFS(startBFSNode);
				break;
			case 4:
				System.out.println("Start DFS from node: " + startBFSNode);
				g.DFS(startBFSNode);//0번으로 시작
				break;
			case 5:
				System.exit(0);
				break;
			default:
				System.out.println("WRONG INPUT  " + "\n" + "Re-Enter");
				break;
			}
		}

		return;
	}
}
