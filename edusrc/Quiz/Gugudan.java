package Quiz;

public class Gugudan {
	public void print(int i) {
		System.out.println(i + "단");

		//구구단 만들기			
			for (int k = 1; k < 10; k++) {
				System.out.println(i + "*" + k + "=" + (i*k) );
			}
		}
	}
