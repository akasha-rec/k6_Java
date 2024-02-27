package Review_Inheritance;

public class Person { // 공통점 모아놓음
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String toString() {
		return name + ":" + age;
		
	}
	public Person() {
		System.out.println("Person 생성자 실행!");
	}
	public Person(String name, int age) { //생성자 만들만큼 매개변수 넣어주기
		// super.setName, super.setAge 중복 제거를 위해서 Person 생성자를 만들어서 처리(필드값 초기화는 생성자의 몫)
		// 부모 클래스의 생성자에서 name, age 저장 > 각 필드에 super(인자값) 형식으로 바꿔주기
		this.name = name;
		this.age = age;
	}
	}

