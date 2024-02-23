package edu;

import java.util.Scanner;

public class Test25_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Num : ");
		int num = sc.nextInt(); //nextInt 숫자 받으려고 대기
		
		int sum1 = 0; //홀수 합
		int sum2 = 0; //짝수 합
		for(int i = 0; i <= num; i++) {
			
			if (i % 2 == 0) {
			sum2 += i;
			System.out.println("e-> " + sum2);
		}
		else {
			sum1 += i;
			System.out.println("o-> " + sum1);
			}
		}
		System.out.println("OK:" + sum1 + "," + sum2);
		}
}