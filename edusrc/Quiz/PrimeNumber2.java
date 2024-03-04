package Quiz;

import java.util.Scanner;

public class PrimeNumber2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//입력 자릿수가 3이라면 3자릿수(100~999)
		Scanner sc = new Scanner(System.in);
		System.out.print("자릿수를 입력하세요 : ");
		int num = sc.nextInt();

		int s = (int)Math.pow(10.0, (double)(num-1)); //10
		int e = (int)Math.pow(10.0, (double)(num))-1; //99

		for(int i = s; i <= e; i++) { //10~99
			for(int j = 2; j <=i; j++) {
				if (i % j ==0) { //딱 나눠지면서
					if (i != j) { //1과 나 자신만을 가지는 소수
						break;
					}
					System.out.println(i);
				}
			}
		}
	}
}
