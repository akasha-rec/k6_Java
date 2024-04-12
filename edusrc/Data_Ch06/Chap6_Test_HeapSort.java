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
		heap = new int[MaxSize+1];//인덱스 1부터 시작이라서 +1 > 더 알아보자
	}

	public void display() {//출력
		int i;
		for (i = 1; i <= n; i++) {
			System.out.print(i + " : " + heap[i] + "   ");
		}
		System.out.println();
	}
	@Override
	public void Insert(int x) {
		int i;
		if (n == MaxSize) {
			HeapFull();
			return;
		}
		n++; //데이터가 추가됐다.
		for (i = n; i>=1; i /= 2) {
			if (i == 1) break;//root
			else if (x <= heap[i / 2]) break;
			else {
				heap[i] = heap[i / 2]; //값 교환				
			}
			}
		heap[i] = x;
	}
	
	@Override
	public int DeleteMax() {
		if(n ==0) {
			HeapEmpty();
			return 0;
		}
		int x = heap[1];//root
		int k = heap[n];//k는 트리의 마지막 노드?
		n--;
		int i = 1;
		for (int j = 2; j <= n;) {
			if (j < n) {
				if (heap[j] < heap[j + 1]) {
					j++;
				} else if (k >= heap[j]) {
						break;
				}
				heap[i] = heap[j];
				i = j;
				j*=2;
			}
		}
		heap[i] = k;
		return x;
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
	    final int count = 10; //정렬된 배열의 크기?
	    int[] x = new int[count+1];
	    int []sorted = new int[count]; //정렬된 결과의 배열

		do {
			System.out.println("Max Tree. Select: 1 insert, 2 display, 3 sort, 4 exit => ");
			select = stdIn.nextInt();
			switch (select) {
			case 1: //입력
				int value = rnd.nextInt(10);
				System.out.print("input value : ");
				System.out.println(value);
				heap.Insert(value);
				heap.display();
				break;
			case 2: //출력
				heap.display();
				break;
			case 3: //정렬 for loop로 delete 계속? root만 남을 때까지 반복한다는 것 같아
				int value1 = rnd.nextInt(10);
				System.out.println("delete element : ");
				System.out.println(value1);
				for (int i = 1; i <= count; i++) {
					sorted[i-1] = heap.DeleteMax();
				}
				break;

			case 4: //종료
				return;

			}
		} while (select < 5);//왜 5?
		
		return;
	}
}
