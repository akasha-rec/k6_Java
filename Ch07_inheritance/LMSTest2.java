package Ch07_inheritance;


public class LMSTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 보이지 않지만, super()이 생략되어있음 > Person의 기본 생성자 호출됨 > Person 생성자 실행!
		Employee e = new Employee("오정임", 47, "입학처");
		Professor p = new Professor("김푸름", 52, "빅데이터");
		Student s = new Student("김유빈", 20, "컴퓨터 과학");
		
		System.out.println(e.toString());
		System.out.println(p.toString());
		System.out.println(s.toString());
	}

}
