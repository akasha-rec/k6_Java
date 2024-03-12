package Data_Ch03; //while(p) while(q) 하고 또 while(p) while(q)?? 

/*
 * 함수(메소드)에 parameter 전달 방식을 표현하는 능력의 숙달 훈련
 * 함수(메소드) 전체를 작성하는 훈련 
 */
import java.util.Arrays;
import java.util.List;
public class Test_스트링배열합병 {
    static void showList(String topic, String [] list) {
    	System.out.println(topic);
    	for (String item : list)
    		System.out.println(item + " ");
    	System.out.println();
    }
    static String[] mergeList(String[]s1, String[] s2) {
    	int i = 0, j = 0, k =0;
    	String[] s3 = new String[10];
    	s3 = new String[s1.length + s2.length];
    	while (i < s1.length && j < s2.length) { //둘 모두 끝나기 전까지
    		if(s1[i].compareTo(s2[j]) < 0) { //s1요소가 s2요소보다 먼저라면
    			s3[k++] = s1[i++]; //s1요소가 s3 안으로 들어가고
    		} else {
    			s3[k++] = s2[j++]; // 반대면 s2 요소가 s3 안으로 들어가고 다음 비교를 위해서 인덱스가 올라가?
    		}
    	}
    	while (i < s1.length) { //s1 배열이 남았다면
    		s3[k++] = s1[i++];
    	}
    	while (j < s2.length) {
    		s3[k++] = s2[j++];
    	}
    	return s3;
    }
    
    public static void main(String[] args) {
	String[] s1 = { "홍길동", "강감찬", "을지문덕", "계백", "김유신" };
	String[] s2 = {"독도", "울릉도", "한산도", "영도", "우도"};
	Arrays.sort(s1);//comparable, comparator interface 없다 > comparable의 compareTo() 사용하자
	Arrays.sort(s2);
	//후속 코딩은 객체들의 정렬 : ~ 클래스를 만들고 정렬
	showList("s1배열 =a ", s1);
	showList("s2배열 = ", s2);

	String[] s3 = mergeList(s1,s2);
	showList("스트링 배열 s3 = s1 + s2:: ", s3);
}
}
