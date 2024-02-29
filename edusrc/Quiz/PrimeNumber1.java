package Quiz;

import java.util.Scanner;

public class PrimeNumber1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 숫자 하나 입력 받자
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하세요");
		int num = sc.nextInt();
		// 소수 : 1과 자기자신을 제외하고 나누어지지 않는 수
		// 2부터 자기자신보다 하나 작은 수까지 나누어서 나누어지지 않으면 소수
		boolean flag = false;
		for (int i = 2 ; i < num ; i++) {
			if (num % i ==0 ) {
				flag = true;
				break;
			}
		}
		System.out.println(flag?"소수가 아닙니다.":"소수입니다.");
	}

}
