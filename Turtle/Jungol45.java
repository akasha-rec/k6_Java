package Turtle;

import java.util.Scanner;

public class Jungol45 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		while (true) {
				System.out.print("Base = ");
				int b = sc.nextInt();
				System.out.print("Height =  ");
				int h = sc.nextInt();
				double width = (double) (b * h) * 1/2;
				System.out.printf("Triangle width = %.1f\n", width);
				System.out.print("Continue? ");
				char t = sc.next().charAt(0);
				if ((t == 'Y') || (t == 'y')) {
					continue;
				} else
					break;
			}
		}
	}
