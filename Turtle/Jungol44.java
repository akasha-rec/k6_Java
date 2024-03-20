package Turtle; //정올 반복제어문1 - 형성평가

import java.util.Scanner;

public class Jungol44 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//0 이 입력될 때까지 정수를 계속 입력받아 3의 배수와 5의 배수를 제외한 수들의 개수를 출력하는 프로그램을 작성하시오.
		Scanner sc = new Scanner(System.in);
		System.out.println("정수를 입력하세요 : " + " ");
		int count = 0;
		while (true) {
			int a = sc.nextInt();
			if (a % 3 != 0 && a % 5 != 0) {
				count++;				
			}
			if (a == 0) {
				break;				
			}
		}
		System.out.println(count);
		
	}

}
