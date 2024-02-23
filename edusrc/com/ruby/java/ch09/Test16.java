
package com.ruby.java.ch09; //p440 Array Class

import java.util.Arrays;

public class Test16 {

	public static void main(String[] args) {
		int score[] = { 85, 90, 95, 100, 75 };
		//배열을 통쨰로 복사↓
		int score2[] = Arrays.copyOf(score, score.length);
		//배열을 일부 복사 ↓
		int score3[] = Arrays.copyOfRange(score, 3, 5);

		int score4[] = new int[score.length];
		System.arraycopy(score, 0, score4, 0, score.length);
		System.out.println(score); // 참조변수(score) 주소가 출력
		System.out.println(Arrays.toString(score)); // 배열 출력
		System.out.println(Arrays.toString(score2));
		System.out.println(Arrays.toString(score3));
		System.out.println(Arrays.toString(score4));

		System.out.println(Arrays.equals(score, score2));

		Arrays.sort(score);
		System.out.println(Arrays.toString(score));
		System.out.println(Arrays.equals(score, score2));

		int index = Arrays.binarySearch(score, 100);
		System.out.println(index);
	}
}