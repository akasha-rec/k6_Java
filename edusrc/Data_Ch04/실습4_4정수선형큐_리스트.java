package Data_Ch04; //4번 학습순서이자 선행학습
//선형 큐 구현
import java.util.Scanner;

/*
 * Queue of ArrayList
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//int형 고정 길이 큐

class Queue4 {
	private List<Integer> que;//원형큐로 구현하지 않는다 
	private int capacity; // 큐의 크기 - 배열의 length
	private int front; // 맨 처음 요소 커서
	private int rear; // 맨 끝 요소 커서
	//	private int num; // 현재 데이터 개수


	//--- 실행시 예외: 큐가 비어있음 ---//
	public class EmptyQueueException extends RuntimeException {
		public EmptyQueueException() {}
	}

	//--- 실행시 예외: 큐가 가득 찼음 ---//
	public class OverflowQueueException extends RuntimeException {
		public OverflowQueueException() {}
	}

	//--- 생성자(constructor) ---//
	public Queue4(int maxlen) {
		this.capacity = maxlen;
		front = rear = 0;
		try {
			que = new ArrayList<>();
		} catch (OutOfMemoryError e) {
			capacity = 0;
		}
	}

	//--- 큐에 데이터를 인큐 ---//
	public void enque(int x) throws OverflowQueueException {
		if (isFull())
			throw new OverflowQueueException();
		que.add(x);
		rear++;
	}

	//--- 큐에서 데이터를 디큐 ---//
	public int deque() throws EmptyQueueException {
		if (isEmpty())
			throw new EmptyQueueException();
//		front++;
		rear--;
		int x = que.remove(front);
		return x;
	}

	//--- 큐에서 데이터를 피크(프런트 데이터를 들여다봄) ---//
	public int peek() throws EmptyQueueException {
		if (isEmpty())
			throw new EmptyQueueException();
		return que.get(front);
	}

	//--- 큐를 비움 --- peek() 처럼 예외 발생 구현//
	public void clear() throws EmptyQueueException {
		/*
		 * queue을 empty로 만들어야 한다.
		 * queue이 empty일 때 clear()가 호출된 예외 발생해야 한다 
		 */
		if (isEmpty()) // queue이 빔
			throw new EmptyQueueException();
		else {
			while (!isEmpty()) {
				rear--;
				que.remove(0);
			}
		}
	}
	
	public void dump() throws EmptyQueueException {
		if (isEmpty()) {
			throw new EmptyQueueException();
		} else {
			for (int i = front; i < rear; i++)
				System.out.print(que.get(i) + " ");
		}
			System.out.println();
	}
	
	//--- 큐에서 x를 검색하여 인덱스(찾지 못하면 –1)를 반환 ---//
	public int indexOf(int x) {
		for (int i = 0; i < que.size(); i++) {
			int idx = (i + front) % capacity;
			if (que.get(idx) == x) // 검색 성공
				return idx;
		}
		return -1; // 검색 실패
	}

	//--- 큐의 크기를 반환 ---//
	public int getCapacity() {
		return capacity;
	}

	//--- 큐에 쌓여 있는 데이터 개수를 반환 ---//
	public int size() {
		int data = rear-front;
		return data;
	}

	//--- 큐가 비어있는가? ---//
	public boolean isEmpty() {
	if (front == rear)
		return true;
	else
		return false;
	}

	//--- 큐가 가득 찼는가? ---//
	public boolean isFull() {
		if(rear >= capacity) 
			return true;
		else
			return false;
	}


}
public class 실습4_4정수선형큐_리스트 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		Queue4 oq = new Queue4(4); // 최대 64개를 인큐할 수 있는 큐
		Random random = new Random();
		int rndx = 0, p = 0;
		while (true) {
			System.out.println(" "); // 메뉴 구분을 위한 빈 행 추가
			System.out.printf("현재 데이터 개수: %d / %d\n", oq.size(), oq.getCapacity());
			System.out.print("(1)인큐　(2)디큐　(3)피크　(4)덤프　(5)clear  (0)종료: ");
			int menu = stdIn.nextInt();
			switch (menu) {
			case 1: // 인큐
				rndx = random.nextInt(20);
				System.out.print("입력데이터: (" + rndx +")");
				try {
					oq.enque(rndx);
				} catch(Queue4.OverflowQueueException e) {
					System.out.println("queue이 가득 차있습니다."+e.getMessage());
					e.printStackTrace();
				}
				break;

			case 2: // 디큐
				try {
					p = oq.deque();
					System.out.println("디큐한 데이터는 " + p + "입니다.");
				} catch (Queue4.EmptyQueueException e) {
					System.out.println("큐가 비어 있습니다."+e.getMessage());
					e.printStackTrace();
				}
				break;

			case 3: // 피크
				try {
					p = oq.peek();
					System.out.println("피크한 데이터는 " + p + "입니다.");
				} catch (Queue4.EmptyQueueException e) {
					System.out.println("큐가 비어 있습니다."+e.getMessage());
					e.printStackTrace();
				}
				break;
			case 4: // 덤프
					try {
						oq.dump();
					} catch (Queue4.EmptyQueueException e) {
						System.out.println("큐가 비어 있습니다."+e.getMessage());
						e.printStackTrace();
					}
				break;
			case 5: //clear
				try {
					oq.clear();
				} catch (Queue4.EmptyQueueException e) {
					System.out.println("큐가 비어 있습니다."+e.getMessage());
					e.printStackTrace();
				}
				break;
				
			default:
				break;
			}
		}
	}
}