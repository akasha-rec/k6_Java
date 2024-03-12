package Data_Ch03;

import java.util.Arrays;
import java.util.Comparator;

//5번 실습 - 2장 실습 2-14를 수정하여 객체 배열의 정렬 구현
class PhyscData3 {
	String name;
	int height;
	double vision;

	public PhyscData3(String name, int height, double vision) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.height = height;
		this.vision = vision;
	}
		@Override
		public String toString() {
			return "[" + name + ", " + height + ", " + vision + "]";
}
}

class CompName implements Comparator<PhyscData3>{ //인터페이스를 구현한 클래스 CompName은 compare만 구현할 뿐 그 외의 아무것도 가지지 않음
	public int compare(PhyscData3 p1, PhyscData3 p2) {
		if (p1.name.compareTo(p2.name) > 0)
			return 1;
		else if (p1.name.compareTo(p2.name) < 0) 
			return -1;
		else {
			return 0;
	}
	}
}

	class CompHeight implements Comparator<PhyscData3>{
		public int compare(PhyscData3 p1, PhyscData3 p2) {
			if (p1.height > p2.height) 
				return 1;
			else if (p1.height < p2.height) 
				return -1;
			else {
				return 0;
		}
		}
	}
		
public class train실습3_8객체비교연산자 {	
	static final Comparator<PhyscData3> HEIGHT_ORDER = new CompName();

	public static void main(String[] args) {
		PhyscData3[] data = {
				new PhyscData3("홍길동", 162, 0.3),
				new PhyscData3("홍동", 164, 1.3),
				new PhyscData3("홍길", 152, 0.7),
				new PhyscData3("김홍길동", 172, 0.3),
				new PhyscData3("길동", 182, 0.6),
				new PhyscData3("길동", 167, 0.2),
				new PhyscData3("길동", 167, 0.5),
		};
		//객체를 던져준다?
//		Arrays.binarySearch(data,  key, new CompName()); //key 찾고자 하는 요소
		
		showData("정렬전 객체 배열", data);
		Arrays.sort(data, HEIGHT_ORDER);
		
		showData("정렬후 객체 배열", data);
		PhyscData3 key = new PhyscData3("길동", 167, 0.2);
		Arrays.binarySearch(data,  key, new CompHeight());
		
		int idx = Arrays.binarySearch(data, key, HEIGHT_ORDER);
		
		if (idx >= 0) {
			System.out.println("\nArrays.binarySearch(): result = " + idx);
		} else {
			System.out.println("\nArrays.binarySearch(): result = " + ((-idx)-1));
		}
	}

	private static void showData(String string, PhyscData3[] data) {
		// TODO Auto-generated method stub
		System.out.println(string);
		for (PhyscData3 str : data)
			System.out.print(str + " ");
		System.out.println();
	}

}
