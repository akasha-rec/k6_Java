package Data_Ch03;

/*
 * Comparable 구현
 */
/*
 * 함수(메소드)에 parameter 전달 방식을 표현하는 능력의 숙달 훈련
 * 함수(메소드) 전체를 작성하는 훈련 
 */
import java.util.Arrays;

//5번 실습 - 2장 실습 2-14를 수정하여 객체 배열의 정렬 구현
class PhyscData2 implements Comparable<PhyscData2>{
	String name;
	int height;
	double vision;

	public PhyscData2(String name, int height, double vision) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.height = height;
		this.vision = vision;
	}

	@Override
	public String toString() {
		return "[" + name + ", " + height + ", " + vision + "]";
	}

	@Override
	public int compareTo(PhyscData2 p) {
		if (vision > p.vision)
			return 1;
		else if (vision < p.vision)
			return -1;
		else
			return name.compareTo(p.name); //시력이 같다면 다음으로 이름을 기준으로 정렬
	}
	
	public int equals(PhyscData2 p) {
		if (name == p.name)
			return 0;
		else
			return -1;
	}
}

public class train_실습3_6_1객체배열이진탐색 {

	static void sortData(PhyscData2[] arr) { //확장 for문은 index가 없어서 index를 이용한 비교 X > swap()도 당연히 못 하지
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if(arr[i].compareTo(arr[j]) > 0 )
					swap(arr, i, j);
			}
		}
	}

	public static void main(String[] args) {
		PhyscData2[] data = {
				new PhyscData2("홍길동", 162, 0.3),
				new PhyscData2("나동", 164, 1.3),
				new PhyscData2("최길", 152, 0.7),
				new PhyscData2("김홍길동", 172, 0.3),
				new PhyscData2("박동", 182, 0.6),
				new PhyscData2("이동", 167, 0.2),
				new PhyscData2("길동", 167, 0.5),
		};

		showData("정렬전", data);
		sortData(data);
		showData("정렬후", data);
		reverse(data);
		showData("역순 재배치후", data);
		Arrays.sort(data);//사용된다 그 이유는?
		showData("Arrays.sort() 정렬후", data);

		PhyscData2 key = new PhyscData2("길동", 167, 0.2);
		int resultIndex = linearSearch(data, key);
		System.out.println("\nlinearSearch(<길동,167,02>): result = " + resultIndex);

		key = new PhyscData2("박동", 182, 0.6);
		/*
		 * 교재 109~113
		 */
		resultIndex = binarySearch(data, key);//comparable를 사용
		System.out.println("\nbinarySearch(<박동,182,0.6>): result = " + resultIndex);
		key = new PhyscData2("이동", 167, 0.6);
		/*
		 * 교재 115 Arrays.binarySearch에 의한 검색
		 */
		resultIndex = Arrays.binarySearch(data, key);//comparable를 사용
		System.out.println("\nArrays.binarySearch(<이동,167,0.6>): result = " + resultIndex);
	}

	private static void reverse(PhyscData2[] data) {
		// TODO Auto-generated method stub
		for (int i = 0; i < data.length / 2; i++)
			swap(data, i, data.length - 1 - i);
	}

	private static void swap(PhyscData2[] data, int i, int j) {
		// TODO Auto-generated method stub
		PhyscData2 t = data[i];
		data[i] = data[j];
		data[j] = t;
	}

	private static int binarySearch(PhyscData2[] data, PhyscData2 key) {
		// TODO Auto-generated method stub
		int pl = 0;
		int pr = data.length -1;
		while (pl <= pr) {
			int pc = (pl + pr) / 2;
			if (data[pc].compareTo(key) == 0) {
				return pc;				
			} else if (data[pc].compareTo(key) < 0) {
				pl = pc + 1;				
			} else {
				pr = pc - 1;
		}
	}
		return -1;
	}

	private static int linearSearch(PhyscData2[] data, PhyscData2 key) {
		// TODO Auto-generated method stub
		for (int i = 0; i < data.length; i++) {
			if (data[i] == key) {
				return i;				
			}
		}
		return -1;
	}

	private static void showData(String string, PhyscData2[] data) {
		// TODO Auto-generated method stub
		System.out.println(string);
		for (PhyscData2 str : data)
			System.out.print(str + " ");
		System.out.println();
	}

}
