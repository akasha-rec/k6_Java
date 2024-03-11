package Data_Ch03; //숫자가 아니니까 if(compareTo()) 사용해라

//comparator 구현 실습
/*
* 교재 121 실습 3-6 
* 함수(메소드)에 parameter 전달 방식을 표현하는 능력의 숙달 훈련
* 함수(메소드) 전체를 작성하는 훈련 
*/
import java.util.Arrays;
public class train_실습3_6_0스트링배열정렬이진탐색 {


	static void reverse(String[] a) {//교재 67페이지
		for (int i = 0; i < a.length / 2; i++)
			swap(a, i, a.length-1-i);
	}
	
	static void swap(String[] a, int i, int j) {
		// TODO Auto-generated method stub
		String str = a[i];
		a[i] = a[j];
		a[j] = str;
	}

	public static void main(String[] args) {
		String []data = {"사과","포도","복숭아", "감", "산딸기", "블루베리", "대추", "수박", "참외"};//홍봉희 재배 과수

		showData("정렬전", data);
		sortData(data);
		showData("정렬후", data);
		reverse(data);//역순으로 재배치
		showData("역순 재배치후", data);
		Arrays.sort(data);//Arrays.sort(Object[] a);
		showData("Arrays.sort()로 정렬후",data);
      
		String key = "포도";
		int resultIndex = linearSearch(data, key);
		System.out.println("\nlinearSearch(포도): result = " + resultIndex);

		key = "배";
		/*
		 * 교재 109~113
		 */
		resultIndex = binarySearch(data, key);
		System.out.println("\nbinarySearch(배): result = " + resultIndex);
		key = "산딸기";
		/*
		 * 교재 115 Arrays.binarySearch에 의한 검색
		 */
		resultIndex = Arrays.binarySearch(data, key);
		System.out.println("\nArrays.binarySearch(산딸기): result = " + resultIndex);

	}

	private static int binarySearch(String[] data, String key) {
		// TODO Auto-generated method stub
		int pl = 0;
		int pr = data.length - 1;
		while (pl <= pr) {
			int pc = (pl + pr) / 2;
			if (data[pc].equals(key)) { //찾았다!
				return pc;
			} else if (data[pc].compareTo(key) < 0) { //pc 값보다 찾고자 하는 값이 클 때
				pl = pc + 1; //검색 범위를 pc보다 오른쪽으로 넓힌다.
			} else {
				pr = pc - 1;
			}
		}
		return -1; //검색 실패
	}

	private static int linearSearch(String[] data, String key) {
		// TODO Auto-generated method stub
		for (int i = 0; i < data.length; i++) {
			if (data[i] == key) {
				return i; //검색 성공 시 인덱스 반환
			}
		}
		return -1; //검색 실패
	}

	private static void sortData(String[] data) {
		// TODO Auto-generated method stub
		for (int i = 0; i < data.length; i++)
			for (int j = i+1; j < data.length; j++) {
				if (data[i].compareTo(data[j]) > 0) {
					swap(data, i, j);
				}
			}
	}

	private static void showData(String string, String[] data) {
		// TODO Auto-generated method stub
		System.out.println(string);
		for (String str : data)
			System.out.print(str + " ");
		System.out.println();
	}

}
