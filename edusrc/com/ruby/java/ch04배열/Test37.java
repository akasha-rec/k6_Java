package com.ruby.java.ch04배열;

import java.util.Random;

public class Test37 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 난수 생성
		Random rnd = new Random();
		int [] score = new int[20];
		int sum = 0;
		double avg = 0.0;
		int max = 0;
		int min = 999; // score 배열에 저장된 값들보다 큰 수로 초기화함으로써 최솟값을 판단할 때 score 배열의 첫 번째 요소 값을 무조건 저장하기 위해서

//		for (int num : score) {
//			System.out.println(num);
//		}
		for (int i = 0; i < score.length; i++)
			score [i] = rnd.nextInt(20); //초기화?
		
		for (int i = 0; i < score.length; i++) {
			System.out.print(score [i]+" ");
			if (i % 5 == 4)
			System.out.println();
		}
		
		for (int i = 0; i < score.length; i++) {
			score[i] = rnd.nextInt(20); // nextInt n까지의 정수
						
			sum += score[i];
			if(max < score[i])
				max = score[i];
			if(min > score[i])
				min = score[i];
		}
		avg = (double) sum / score.length;
		// sum, score.length 모두 정수라서 결과가 자세히 X > 둘 중 하나만 double을 걸어줘도 자동으로 바뀐다?
		// 전체 괄호해서 double 변환하면 괄호 안에서는 이미 정수라서 소용X?
		System.out.println("총점 : " + sum);
		System.out.println("평균 : " + avg);
		System.out.println("최대값 : " + max);
		System.out.println("최소값 : " + min);
		
	}

}
