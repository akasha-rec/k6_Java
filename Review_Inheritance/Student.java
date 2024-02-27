package Review_Inheritance;

public class Student extends Person { 
	private String major;
	
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
		
		public String toString() {
//			return getName() + ":" + getAge() + ":" + major;
			return super.toString() + ":" + major;
		}
		public Student(String name, int age, String major) {
			super(name, age);
			this.major = major;
			System.out.println("Student(name, age, major) 생성자 실행!");
		}
//	private String name; // Person이라는 부모 클래스를 생성해서 상속하였으므로(extends Person) 중복 코드 제거
//	private int age;
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public int getAge() {
//		return age;
//	}
//	public void setAge(int age) {
//		this.age = age;
	}
