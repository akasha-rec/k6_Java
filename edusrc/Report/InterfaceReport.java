package Report; // 과제3 인터페이스 형성 정답 > 연습 / 이거 참고해서 Test_Object 풀기 
/*
 * 인터페이스 다형성 실습 코드
 */
interface Vehicle { //객체 생성 X > 배열 만든?
	public abstract void showVehicle();
}
class Truck implements Vehicle {
	int weight;
	public Truck(int weight) {
		this.weight=weight;
	}
	public void showVehicle() {
		System.out.println("Truck: weight="+weight);
	}
}
class Car implements Vehicle {
	int vehicleOccupants;
	public Car(int vehicleOccupants) {
		this.vehicleOccupants=vehicleOccupants;
	}
	public void showVehicle() {
		System.out.println("Car: vehicleOccupants="+vehicleOccupants);	
	}
}
class Taxi extends Car {
	int mileage;
	public Taxi(int vehicleOccupants, int mileage ) { //Car의 생성자
		super(vehicleOccupants);
		this.mileage=mileage;
	}
	public void showVehicle() {
		super.showVehicle();
		System.out.println("Taxi: mileage="+mileage);
		//super.showVehicle(); < 상속관계에서 부모 클래스에서 가져와 재정의해서 사용하는데 중복 코딩을 막기 위해서 super를 써준다.
		// System.out.println("Car: vehicleOccupants="+vehicleOccupants);
		
	}
}
class MotorCycle implements Vehicle{
	int price;
	public MotorCycle(int price) {
		this.price=price;
	}
	public void showVehicle() {
		System.out.println("MotorCycle: price="+price);
	}
}
public class InterfaceReport {
	public static void displayVehicles(Vehicle [] a) {
		for (Vehicle v : a) {
			v.showVehicle();
		}
	}
public static void main(String[] args) {
	Vehicle [] arr = new Vehicle[10]; //배열 생성
//	arr[5] = new Vehicle(); > // 생성자인데 Vehicle 자체는 인터페이스라서 객체 생성 X
	
	arr[0] = new Truck(33);
	arr[1] = new Car(4);
	arr[2] = new Taxi(2, 9000);
	arr[3] = new Truck(22);
	arr[4] = new MotorCycle(12000);
	displayVehicles(arr);
}
}
