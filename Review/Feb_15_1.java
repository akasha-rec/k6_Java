package Review;

public class Feb_15_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cnt = 0; // 변수선언 및 초기화
		while (true) { //조건식 결과 true 고정 == 무한 반복 
						//> 특정 상황 시 반복문 벗어나게 > break
			System.out.println("OK");
			cnt += 2; // cnt 2씩 증가
			if (cnt == 10) { // cnt가 10이 되면 (특정 상황)
				break; // 벗어나게
			}
		}
	//조건에 따라 명령문 생략 가능 > continue
	for (int i = 0; i < 10; i++) { // 1 ~ 9 출력
		if ((i % 2) == 0) continue; // 짝수인데 continue가 있어서 생략
		System.out.println(i); // > 홀수만 출력됨!!
	}
}
}
