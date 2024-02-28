package com.ruby.java.ch14;

interface NumberFunc {
	int func(int n);
}

public class Test05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberFunc sum = (n) -> {
			int result = 0;
			for (int i = 0; i <= n; i++) {
				result += 1;
			}
			return result;
		};

		NumberFunc esum = (n) -> {
			int result = 0;
			for (int i = 0; i <= n; i++) {
				if ((i % 2) == 0) {
					result += i;
				}
			}
			return result;
		};

		NumberFunc osum = (n) -> {
			int result = 0;
			for (int i = 0; i <= n; i++) {
				if ((i % 2) == 1) {
					result += i;
				}
			}
			return result;
		};

		System.out.println("1부터 10까지의 합 : " + sum.func(10));
		System.out.println("1부터 100까지의 합 : " + sum.func(100));

		System.out.println("1부터 10까지의 짝수 합 : " + esum.func(10));
		System.out.println("1부터 100까지의 짝수 합 : " + esum.func(100));

		System.out.println("1부터 10까지의 홀수 합 : " + osum.func(10));
		System.out.println("1부터 100까지의 홀수 합 : " + osum.func(100));
	}


}
