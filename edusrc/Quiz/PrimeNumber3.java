package Quiz;

import java.util.Scanner;

public class PrimeNumber3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("입력 자릿수 : ");
		int num = sc.nextInt();

		int s = (int)Math.pow(10.0, (double)(num-1));
		int e = (int)Math.pow(10.0, (double)(num))-1;

		for(int i = s; i <= e; i++) {
			String str = String.valueOf(i); //i를 String으로 만들어
			Boolean flag = false;

			for(int j = 1; j <= str.length(); j++) {
				String tstr = str.substring(0, j);
				//System.out.println("tstr" + j + ":" + tstr);
				int val = Integer.valueOf(tstr);

				if (isPrime(val) == false) {
					flag = true;
					break;
				}
			}
			if (flag == false) {
				System.out.println(i);
			}
		}
	}
	   static boolean isPrime(int number) {
	        if (number < 2) {
	            return false;
	        }
	        for (int i = 2; i <= Math.sqrt(number); i++) {
	            if (number % i == 0) {
	                return false;
	            }
	        }
	        return true;
	    }
	}