package Quiz;

import java.util.Scanner;

public class Quiz01 {
	static int getNumber(Scanner sc) {
		int num;
		do {
			System.out.print("10~100사이 정수[마치려면 0]: ");
			num = sc.nextInt();
		} while (num != 0 && (num < 10 || 100 < num));
		return num;
	}
	public static int calc(int a, int b, int c) {
		return a * 2 + b * 3 + c * 5;
	}

	public static void main(String[] ars) {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
			int num = getNumber(sc);
			if (num == 0) break;
			
			System.out.println("입력값 : " + num);
			
			int cnt = 0;
			for (int i = 1; i < 11; i++) {
				for (int j = 1; j < 11; j++) {
					for (int k = 1; k < 11; k++) {
						if (num == calc(i, j, k)) {
							cnt++;
							System.out.print("("+i+","+j+","+k+")");
						}
					}
				}
			}
			System.out.println();
			System.out.println("Count:" + cnt);
		}
		sc.close();
		System.out.println("프로그램을 종료합니다.");
	}
}