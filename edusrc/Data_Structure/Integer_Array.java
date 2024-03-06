package Data_Structure;

import java.util.Arrays;
//교재 67 - 실습 2-5
//2번 실습
import java.util.Random;
public class Integer_Array {

	public static void main(String[] args) {
		int []data = new int[10];
		inputData(data);
		showData(data);
		/*
		sortData(data); //정렬 프로그램을 직접 코딩
		showData(data);
		 */
		reverse(data);//역순으로 재배치 - 정렬 아님 
		showData(data);

		reverseSort(data);//역순으로 재배치 + 내림차순 정렬 - 정렬 아님
		showData(data);

		Arrays.sort(data); //자바 라이브러리를 사용한 정렬
	}
	static void showData(int[]data) { //data > 참조변수 > 메모리의 주소값을 가지고 > 메서드에서 값을 변경하니까 그 주소값을 갖고 있는 참조변수에도 변경?
		for (int num: data) { //확장형 for문
			System.out.print(num+" ");
		}
		System.out.println();
	}

	static void inputData(int []data) { //난수 생성 데이터 입력
		Random rnd = new Random();
		for(int i = 0; i < data.length; i++)
			data[i] = rnd.nextInt(10);
	}

	static void swap(int[]arr, int ind1, int ind2) {//교재 67페이지
		int t = arr[ind1];
		arr[ind1] = arr[ind2];
		arr[ind2] = t;
	}

	static void sortData(int []arr) {
		for (int i = 0; i < arr.length; i++)
			for (int j = i+1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					swap(arr, i, j);
				}
			}
	}
	
	static void reverse(int[] a) {//교재 67페이지 a[0] = a[6]
		for (int i = 0; i < a.length / 2; i++)
			swap(a, i, a.length-i-1);
	}

	static void reverseSort(int []arr) { //reverse + swap
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if (arr[j] > arr[i]) { //if문만 바꿔줘
					swap(arr, i, j);
				}

			}
		}
	}
}