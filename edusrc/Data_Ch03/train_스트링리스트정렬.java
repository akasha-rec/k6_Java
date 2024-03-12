package Data_Ch03;

import java.util.ArrayList; //new ArrayList<>() > 원소 추가/삭제 O
//Arrays.asList() : Arrays의 static class인 ArrayList return.
import java.util.Arrays; 
import java.util.List;
public class train_스트링리스트정렬 {

	    public static String[] removeElement1(String[] arr, String item) {
	    	//현재 배열에서 중복 제거하려고 하면 길이가 길어진다.
	    	//array(size 고정 => 동적 추가/삭제 X) > Arrays.asList로 List화 > Arrays.asList 또한 크기 고정 리스트 > new ArrayList<>() 처리 > remove 메서드 사용 가능
	    	List<String> list = new ArrayList<>(Arrays.asList(arr));
	    	list.remove(item); //삭제되면 사라지니까
	    	return list.toArray(new String[0]); //다시 새 리스트에 넣어준다. 공간 할당은 했는데 0은 아니다?
	    }
	    
	    static void getList(List<String> list) {
			list.add("서울");	 list.add("북경");
			list.add("상해");	 list.add("서울");
			list.add("도쿄");	 list.add("뉴욕");


			list.add("런던");	 list.add("로마");
			list.add("방콕");	 list.add("북경");
			list.add("도쿄");	 list.add("서울");

			list.add(1, "LA");
	    }
	    
	    static void showList(String topic, List<String> list) {
	    	System.out.println(topic);
	    	for (String st : list) {
	    		System.out.println(st);
	    	}
	    }
	    
	    static void sortList(List<String> list) {
	    	//방법 1 : list.sort(null);
	    	//방법 2 : list > String array로 변환 / list.toArray() <-> list.asList()
	    	list.sort(null);
	    	//Collections.sort(list); - 2
//	    	String[] array = list.toArray(new String[0]); - 3
//	    	Arrays.sort(array);
//	    	list.clear();
//	    	list.addAll(Arrays.asList(array));
	    }
	    
	    static String[] removeDuplicateList(List<String> list) {
		    String cities[] = new String[0];
		    cities = list.toArray(cities);
		    // list > array cities[]로 변환
		    // for 문으로 도시가 중복인 것을 확인 > compareTo 이용 > removeElement로 제거까지
		    //While문으로 바꿔야...
		    
		    for (int i = 0; i < cities.length; i++) {
		    	int j = i+1;
		    	while (j < cities.length) {
		    		if(cities[i].compareTo(cities[j])==0) {
		    			cities = removeElement1(cities, cities[j]);
		    		} else {
		    			j++;
		    		}
		    	}
		    }
		    return cities;
	    }
	    
		public static void main(String[] args) {
			ArrayList<String> list = new ArrayList<>();
			getList(list);
			showList("입력후", list);
			//sort - 오름차순으로 정렬, 내림차순으로 정렬, 중복 제거하는 코딩

//		    Collections.sort(list);

//배열의 정렬
			sortList(list);
		    System.out.println();
		    showList("정렬후", list);
		    
// 배열에서 중복제거
		    System.out.println();
		    System.out.println("중복제거::");
		  
		    String[] cities = removeDuplicateList(list);
	        ArrayList<String> lst = new ArrayList<>(Arrays.asList(cities));
		    showList("중복제거후", lst);
		}
	}
