package Data_Ch06;

import java.util.Random;
import java.util.Scanner;

interface MaxHeap {
	public void Insert(int x);
	public int DeleteMax();
}

class Heap implements MaxHeap {
	final int heapSize = 100;
	private int[] heap;
	private int n; // current size of MaxHeap
	private int MaxSize; // Maximum allowable size of MaxHeap
	
	public Heap(int sz) {//생성자
		this.MaxSize = sz;
		n = 0; //아무 데이터도 없다.
		heap = new int[MaxSize+1];
	}

	public void display() {//출력
		int i;
		for (i = 1; i <= n; i++) {
			System.out.println("i" + heap[i]);
		}
	}
	@Override
	public void Insert(int x) {
		int i;
		if (n == MaxSize) {
			HeapFull();
			return;
		}
		n++; //데이터가 추가됐다.
		for (i = n; i>=1; i /= 2) {//for문에 break...?
			if (i == 1) {//root
				break;
			} else if (x <= heap[i / 2]) {
				heap[i] = heap[i / 2]; //값 교환
				break;
			}
			}
		heap[i] = x;
	}
	
	@Override
	public int DeleteMax() {
		int i, j, k;
		if(n ==0) {
			HeapEmpty();
			return 0;
		}
		i = heap[1];//root
		k = heap[n];//k는 트리의 마지막 노드?
		n--;
		i = 1;
		for (j = 2; j <= n; j*=2) {
			if (j < n) {
				if (heap[j] < heap[j + 1]) {
					j++;
				} else if (k >= heap[j]) {
						break;
				}
				heap[i] = heap[j];
				i = j;
			}
		}
		heap[i] = k;
		return k;
	}

	private void HeapEmpty() {
		System.out.println("Heap Empty");
	}

	private void HeapFull() {
		System.out.println("Heap Full");
	}
}
public class Chap6_Test_HeapSort {
	 static void showData(int[] d) {
	     for (int i = 0; i < d.length; i++)
	         System.out.print(d[i] + " ");
	     System.out.println();
	 }
	public static void main(String[] args) {
		Random rnd = new Random();
		int select = 0;
		Scanner stdIn = new Scanner(System.in);
		Heap heap = new Heap(20);
	    final int count = 10;
	    int[] x = new int[count+1];
	    int []sorted = new int[count];

		do {
			System.out.println("Max Tree. Select: 1 insert, 2 display, 3 sort, 4 exit => ");
			select = stdIn.nextInt();
			switch (select) {
			case 1: //입력
				int value = rnd.nextInt();
				System.out.println("input value : ");
				heap.Insert(value);
				heap.display();
				break;
			case 2: //출력
				heap.display();
				break;
			case 3: //정렬 for loop로 delete 계속? root만 남을 때까지 반복한다는 것 같아
				System.out.println("delete element : ");
				break;

			case 4: //종료
				return;

			}
		} while (select < 5);//왜 5?

		return;
	}
}
