package edu;

public class Test29 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 0; i < 10; i++) {
			if ((i % 2 == 0))
				continue; // if 한 줄이면 중괄호 생략 가능하고, 디버깅까지 생각하면 밑에 입력하는 게 낫다
			System.out.println(i);
		}
	}

}
