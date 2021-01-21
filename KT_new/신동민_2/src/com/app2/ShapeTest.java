package com.app2;

public class ShapeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape shape[] = new Shape[6];
		shape[0] = new Triangle(7, 5, "Blue");
		shape[1] = new Rectangle(4, 6, "Blue");
		shape[2] = new Triangle(6, 7, "Red");
		shape[3] = new Rectangle(8, 3, "Red");
		shape[4] = new Triangle(9, 8, "White");
		shape[5] = new Rectangle(5, 7, "White");

		String[] shape_names = new String[] { "Triangle", "Rectangle", "Triangle", "Rectangle", "Triangle",
				"Rectangle" };

		System.out.println("기본정보");
		for (int i = 0; i < shape.length; i++) {
			System.out.println(shape_names[i] + "\t" + shape[i].getArea() + "\t" + shape[i].getColors());
		}

		System.out.println("사이즈를 변경 후 정보");
		for (int i = 0; i < shape.length; i++) {
			System.out.println(shape_names[i] + "\t" + shape[i].getArea() + "\t" + shape[i].getColors());
		}
		
		

	}

}
