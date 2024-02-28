package Quiz;

import java.util.Scanner;

public class LeafYear {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자를 입력하세요 : ");
		int n = sc.nextInt();
		if (n % 4 == 0) { //윤년
			if (n % 100 != 0) { //윤년
				System.out.println("윤년");
			} else if (n % 400 == 0) {
				System.out.println("윤년");
			}
			} else {
				System.out.println("평년");
			}
		}
	}