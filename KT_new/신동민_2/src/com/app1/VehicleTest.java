package com.app1;

public class VehicleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Truck car = new Truck(1000, 100, 5);
		System.out.println(car.toString());
		car.addOil(50);
		System.out.println(car.toString());
		car.moving(50);
		System.out.println(car.toString());
		car.addWeight(100);
		System.out.println(car.toString());
		car.moving(30);
		System.out.println(car.toString());
		System.out.println(car.getCost(30));
		
		
	}

}
