package Ch07_inheritance;

public class Professor extends Person {
	
	private String subject;
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String toString() {
//		return getName() + ":" + getAge() + ":" + subject;
		return super.toString() + ":" + subject;
	}
		public Professor(String name, int age, String subject) {
			super(name, age);
			this.subject = subject;
			System.out.println("Professor(name, age, subject) 생성자 실행!");
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
//	}
	}
