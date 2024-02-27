package Quiz;

public class Gugudan {
	public void print(int i) {
		System.out.println(i + "단");

		//구구단 만들기			
			for (int k = 1; k < 10; k++) {
			System.out.println(i + "*" + k + "=" + (i*k));
			}
	}
		public void printHorizontal() {
			for (int i = 1; i < 10; i++) {
				for (int j = 2; j < 10; j++) {
					System.out.print(j + "*" + i + "=" + (j*i)+"\t");
				}
			System.out.println();
		}
	}
		public void printColumn(int col) { //3개씩 끊기
			
		}
}
