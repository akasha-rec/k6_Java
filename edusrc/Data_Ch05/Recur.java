package Data_Ch05;

import java.util.Scanner;

class Recur {

	static void recur(int n) {
		while (true) {//2. while (n > 0) //1. if (n > 0) {
			if (n > 0) {
				s.push(n);//2. recur(n - 1);
				n = n - 1;
				continue;
			}
			if (s.isEmpty() != true) {//stack에 넣어서?
				n = s.pop();
				System.out.println(n); //n값 출력 전
				n = n - 2; //1. recur(n-2)
				continue;
			}
			break;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner stdIn = new Scanner(System.in);

		System.out.println("정수를 입력하세요 : ");
		int x = stdIn.nextInt();

		recur(x);

	}

}
