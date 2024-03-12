package Data_Ch02;

import java.util.Arrays;

//5번 실습 - 2장 실습 2-14를 수정하여 객체 배열의 정렬 구현
class PhyscData implements Comparable<PhyscData>{//Comparable 인터페이스를 구현할 때 어떤 타입의 객체끼리 비교할 것인지 명시
	String name;
	int height;
	double vision;

	public PhyscData(String name, int height, double vision) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.height = height;
		this.vision = vision;
	}

	@Override
	public String toString() { //객체의 정보를 문자열로 출력
		return "[" + name + ", " + height + ", " + vision + "]";
	}

	@Override
	public int compareTo(PhyscData p) {
		if (this.name.compareTo(p.name) > 0) 
			return 1;
		 else if (this.name.compareTo(p.name) < 0) 
			return -1;
		 else 
			return 0;
	}

	public int equals(PhyscData p) {
		if (this.name.compareTo(p.name) == 0) 
			return 0;
		else
			return -1;
	}
}
	
		public class Report_ObjectArray {
			static void swap(PhyscData[]arr, int ind1, int ind2) {
				PhyscData t = arr[ind1];
				arr[ind1] = arr[ind2];
				arr[ind2] = t;
			}

			static void sortData(PhyscData []arr) {
				for (int i = 0; i < arr.length; i++)
					for (int j = 0; j < arr.length; j++)
//						if(arr[i] < arr[j]) 오류
						if (arr[i].compareTo(arr[j])<0) //compareTo 사용 > 오름차순
							swap(arr, i, j);					
			}

			public static void main(String[] args) {
				PhyscData[] data = {
						new PhyscData("홍길동", 162, 0.3), //객체
						new PhyscData("홍동", 164, 1.3),
						new PhyscData("홍길", 152, 0.7),
						new PhyscData("김홍길동", 172, 0.3),
						new PhyscData("이길동", 182, 0.6),
						new PhyscData("박길동", 167, 0.2),
						new PhyscData("최길동", 169, 0.5),
				};
				showData(data);
				sortData(data);
				//Arrays.sort(null, null);//comparator가 필요하다 
				showData(data);
			}

			static void showData(PhyscData[]arr) {
				for (PhyscData i : arr) {
					System.out.println(i + " ");
				}
				System.out.println();
			}

		}
