package Review_Polymorphism;


abstract class Employee {//모두 Employee라는 공통의 superclass를 가짐 > 매개변수 선언을 부모클래스로 하면 자손마다 오버로딩을 할 필요X
	String name;
	int salary;

	public abstract void calcSalary();
	public abstract void calcBonus();
}

class Salesman extends Employee {
	public void calcSalary() {
		System.out.println("Salesman 급여 = 기본급 + 판매 수당");
	}

	public void calcBonus() {
		System.out.println("Salesman 보너스 = 기본급 * 12 * 4");
	}
}

class Consultant extends Employee {
	public void calcSalary() {
		System.out.println("Consultant 급여 = 기본급 + 컨설팅 특별 수당");
	}

	public void calcBonus() {
		System.out.println("Consultant 보너스 = 기본급 * 12* 2");
	}
}

abstract class Manager extends Employee {
	public void calcSalary() {
		System.out.println("Manager 급여 = 기본급 + 팀 성과 수당");
	}
	public void calBonus() {
		System.out.println("Manager 보너스 = 기보급 * 12 * 6");
	}
}

class Director extends Manager {
	public void calcBonus() {
		System.out.println("Director 보너스 = 기본급 * 12 * 6");
	}
}

public class HRSTest {
	public static void calcTax(Employee e) {
		System.out.println("소득세를 계산합니다.");
	}

	public static void main(String[] args) {
		Salesman s = new Salesman();
		Consultant c = new Consultant();
		Director d = new Director();
		//Salesman 소득세 계산
//		calcTax(s); //즉 각각이 아니라 calcTax(Employee e)가 호출되도록 통일
//		//Consultant 소득세 계산
//		calcTax(c);
//		//Director 소득세 계산
//		calcTax(d);
		//s.calcBonus();
		//c.calcBonus();
		//d.calBonus();
		System.out.println(s.toString()); //Object 클래스의 메서드 > 클래스명인스턴스ID(new 명령어에 의해 힙에 생성되는 인스턴스에 부여되는 고유값)
		System.out.println(c.toString()); //인스턴스의 고유한 식별자로 반환
		System.out.println(d.toString());
		
		Salesman s2 = s; //새로운 참조변수 선언 s의 값을 s2에 저장 
		System.out.println(s2.toString());
	
		//Object 클래스의 메서드. 현재 객체와 인자로 전달된 객체가 같은지 판단하여 같으면 true, 다르면 false로 반환 > if문에 사용 가능 
//		if (s.equals(c)) {//리턴타입이 boolean이 아닌 메서드는 조건식으로 사용할 수 없다
//			System.out.println("동일한 객체입니다.");
//		} else {
//			System.out.println("서로 다른 객체입니다.");
//		}
		if (s.equals(s2)) {//참조변수 s, s2가 같은 인스턴스를 참조하는지 판단
			System.out.println("동일한 객체입니다.");
		} else {
			System.out.println("서로 다른 객체입니다.");
		}

	}
}

