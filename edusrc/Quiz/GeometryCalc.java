package Quiz;

import java.util.function.Function;

abstract class Geometry { //부모 클래스 생성 > 면적을 구하고자 하는 메서드 선언 > 코드의 간결성을 위해 > 추상 메서드가 되어 자식클래스에서 강제 구현해야
	abstract double getArea();
}

class Circle extends Geometry { // radius*radius*3.14 > 강제 구현할 메서드를 오버라이드 생성
	int radius;
	public Circle(int radius) {
		this.radius = radius;
	}

	@Override
	double getArea() {
		// TODO Auto-generated method stub
		return Math.PI * radius * radius;
	}
}

class Rectangle extends Geometry {// width * height
	int width;
	int height;

	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	double getArea() {
		// TODO Auto-generated method stub
		return (double)(width * height);
	}
}

class Triangle extends Geometry {// width * height /2
	int width;
	int height;

	public Triangle(int width, int height) {
		this.width = width;
		this.height = height;
	}
	@Override
	double getArea() {
		// TODO Auto-generated method stub
		return (double)(width * height * 0.5);
	}
}

public class GeometryCalc {
	public static void main(String[] args) {
		Function<Geometry, Double> func = (g) -> {
			return g.getArea();
		};
		System.out.println("원 면적 : " + func.apply(new Circle(5)));
		System.out.println("사각형 면적 : " + func.apply(new Rectangle(5, 10)));
		System.out.println("삼각형 면적 : " + func.apply(new Triangle(5, 10)));
	}
}