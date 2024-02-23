package Ch07_inheritance;

public class Employee extends Person {
	private String dept;
	
	public String getDept() {
		return dept;
	}
	
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	public String toString() {
//		return getName() + ":" + getAge() + ":" + dept;
		return super.toString() + ":" + dept;
	}
	public Employee() {
		System.out.println("Employee 생성자 실행!");
	}
	public Employee(String name, int age, String dept) {
		super(name, age);
		this.dept = dept;
		System.out.println("Employee(name, age, dept) 생성자 실행!");
	}
//	}
//	private String name; // Person이라는 부모 클래스를 생성해서 상속하였으므로(extends Person) 중복 코드 제거
//	private int age;
		
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public int getAge() {
//		return age;
//	}
//
//	public void setAge(int age) {
//		this.age = age;
//	}

	}