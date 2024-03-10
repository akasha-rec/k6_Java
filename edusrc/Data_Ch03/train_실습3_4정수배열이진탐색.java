package Data_Ch03;

//3장 - 1번 실습 과제 > 2번 실습: 스트링 객체의 정렬과 이진 탐색 > 3번 실습: 객체 정렬과 이진 탐색
//comparator 구현 실습
/*
 * 함수(메소드)에 parameter 전달 방식을 표현하는 능력의 숙달 훈련
 * 함수(메소드) 전체를 작성하는 훈련 
 */
import java.util.Arrays;
import java.util.List;
import java.util.Random;
public class train_실습3_4정수배열이진탐색 {

	public static void main(String[] args) {
		int []data = new int[10];
		inputData(data);// 구현 반복 숙달 훈련

		showList("정렬 전 배열[]:: ", data);
		sortData(data);// 구현 반복 숙달 훈련
		//Arrays.sort(data);
		showList("정렬 후 배열[]:: ", data);// 구현 반복 숙달 훈련

		int key = 13;
		//Arrays.binarySearch
		int resultIndex = linearSearch(data, key);//교재 99-100:실습 3-1 참조, 교재 102: 실습 3-2
		//Arrays 클래스에 linear search는 없다
		System.out.println("\nlinearSearch(13): result = " + resultIndex);

		key = 19;
		/*
		 * 교재 109~113
		 */
		resultIndex = binarySearch(data, key);
		System.out.println("\nbinarySearch(19): result = " + resultIndex);

		key = 10;
		/* 교재 115 Arrays.binarySearch에 의한 검색
		 * 검색 실패 시 key가 있어야 할 위치(삽입 포인트)를 추정할 수 있는 값을 반환 > 삽입포인트 x면 return -x-1
		 */
		resultIndex = Arrays.binarySearch(data, key);
		System.out.println("\nArrays.binarySearch(10): result = " + resultIndex);

	}

	static void sortData(int[]data) {
		Arrays.sort(data);
	}

	static int linearSearch(int[]item, int key) {
		for (int i = 0; i < item.length; i++) {
			if (item[i] == key) {
				return i; //검색 성공 시 인덱스 반환
			}
		}
		return -1; //검색 실패
	}

	static int binarySearch(int[]item, int key) {
		int pl = 0; //맨 처음 인덱스
		int pr = item.length-1; //맨 마지막 인덱스

		while (pl <= pr) {
			int pc = (pl + pr) / 2;
			if (item[pc] == key) { //찾았다!
				return pc;
			} else if (item[pc] < key) { //pc 값보다 찾고자 하는 값이 클 때
				pl = pc + 1; //검색 범위를 pc보다 오른쪽으로 넓힌다.
			} else {
				pr = pc - 1;
			}
		}
		return -1; //검색 실패
	}


	static void inputData(int[] data) {
		Random rnd = new Random();
		for (int i = 0; i < data.length; i++) {
			data[i] = rnd.nextInt(20);
		}
	}

	static void showList(String str, int[] list) {
		System.out.println(str);
		for (int i : list) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
