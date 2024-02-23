package Quiz;

//하나의 java file에 Student 객체를 정의하고 구현하는 실습

/*

 * static 멤버 함수 구현

 * toString() 함수 구현과 사용

 * 객체 배열 사용

 */

abstract class InterfaceStudents {// showObject라는 abstract method를 갖고 있는 abstract class

	public abstract void showObject();

}

class Student extends InterfaceStudents {

// 추상메서드인 InterfaceStudents를 상속받은 Student class

 static int countStudents;//객체수, static 변수

 // 객체가 생성될 때마다 호출되어 증가 > 추적

 int sid;//학번 > 클래스 필드 or 필드변수 : 클래스 내부에서 선언된 변수

 String sname; //학생 이름

 String city; //주소 도시



 public Student() {

		// TODO Auto-generated constructor stub

		countStudents++;

	}

 

 public Student(int sid) {

	//생성자는 객체를 초기화하고 이는 주로 값을 할당하거나 기본값으로 설정 > 객체를 사용할 수 있는 상태로 만드는 과정 

	// TODO Auto-generated constructor stub

	 this(); //다른 생성자를 호출하는 코드 > countsStudents 호출, 매개변수가 없으므로 디폴트 생성자 countStudents를 호출

	 this.sid = sid;

//	 sname = null;

//	 city = null;

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

// Student class 상속받은 WorkStudent

class WorkStudent extends Student {

	String eno;

	String company;

	 public String toString() {//메서드 오버라이딩

		 super.toString();

		 return "eno="+eno+", company=" + company;

	 }

	 public void showObject() {//메서드 오버라이딩

		 //Student 출력 코드 추가

		 super.showObject();

		 System.out.println("["+eno +", " + company + "]");

	 }

}

class CodingWorkStudent extends WorkStudent {

	String language;

	 public String toString() {//메서드 오버라이딩

		 super.toString();

		 return "language="+language;

	 }

	 public void showObject() {//메서드 오버라이딩

		 //WorkStudent 출력 코드 추가 

		 System.out.println("["+language+"]");

	 }

}

 // 생성자 구현한다.

public class Ha {

	 static void showObjects(InterfaceStudents is) {

		 is.showObject();

	 }

	 public static void main(String[] args) {

	 Student arry[] = new Student[5];

	 Student.showNumberObjects();

	 arry[0] = new Student();

	 arry[1] = new Student(202301);

	 arry[2] = new WorkStudent();

	 arry[3] = new CodingWorkStudent();

	 arry[4] = new WorkStudent();

	 Student.showNumberObjects();

	 for (Student s : arry) {

		 System.out.println(s.toString());

	 }

	 for (Student sx : arry) {

		 showObjects(sx);

	 }

 }



}