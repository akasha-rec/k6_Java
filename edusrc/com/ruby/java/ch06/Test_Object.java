package com.ruby.java.ch06;
//하나의 java file에 Student 객체를 정의하고 구현하는 실습
/*
 * static 멤버 함수 구현
 * toString() 함수 구현과 사용
 * 객체 배열 사용
 */
abstract class InterfaceStudents {
	public abstract void showObject();
}
class Student extends InterfaceStudents {
	static int countStudents;//객체수
	int sid;//학번
	String sname; //학생 이름
	String city; //주소 도시
	
	public Student() {
		//		sid = 0; sname = null; city=null;
		countStudents++;
	}
	
	public Student(int sid) {
		// TODO Auto-generated constructor stub
		this();
		this.sid = sid;
		//sname = null;
		//city = null;
		//countStudents++;
	}
	public Student(int sid, String sname, String city) {
		// TODO Auto-generated constructor stub
		this(sid);
		this.sname = sname;
		this.city = city;
	}

	public String toString() { 
		return "sid="+sid + ", sname=" + sname + ", city=" + city;
	}
	public void showObject() {
		System.out.println("["+sid +", " + sname + ", " + city+"]");
	}
	static void showNumberObjects() {//생성된 객체수를 출력한다.
		System.out.println(" 생성객체수=" + countStudents);
	}
}
class WorkStudent extends Student {
	String eno;
	String company;
	public WorkStudent(int sid, String sname, String city, String eno, String company) {
		// TODO Auto-generated constructor stub
		super(sid, sname, city);
		this.eno = eno;
		this.company = company;
	}
	public WorkStudent() {
		// TODO Auto-generated constructor stub
	}
	public String toString() {
		super.toString();
		return "eno="+eno + ", company=" + company;
	}
	public void showObject() {
		super.showObject();
		//Student 출력 코드 추가
		System.out.println("["+eno +", " + company + "]");
	}
}
class CodingWorkStudent extends WorkStudent {
	String language;
	public String toString() {
		super.toString();
		return "language="+language;
	}
	public void showObject() {
		super.showObject();
		//WorkStudent 출력 코드 추가 
		System.out.println("["+language+"]");
	}
}
// 생성자 구현한다.
public class Test_Object {
	static void showObjects(InterfaceStudents is) {
		is.showObject();
	}
	public static void main(String[] args) {
		Student arry[] = new Student[5];
		Student.showNumberObjects();
		arry[0] = new Student();
		arry[1] = new Student(202301);
		arry[2] = new Student(202301, "Hong", "Busan");
		arry[3] = new WorkStudent(1234, "Hong", "Busan", "e1", "naver");
		arry[4] = new CodingWorkStudent();
		Student.showNumberObjects();
		for (Student s : arry) {
			System.out.println(s.toString());
		}
		for (Student sx : arry) { 
		showObjects(sx); // 
		}
	}

}
