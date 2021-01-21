package com.app1;

public class Car extends Vehicle {
	private double restOil;
	private int curWeight;

//	Car car = new Car();

	public Car() {
		// TODO Auto-generated constructor stub
	}

	public Car(int maxWeight, double oilTankSize, double efficiency) {
		super(maxWeight, oilTankSize, efficiency);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getOilTankSize() {
		// TODO Auto-generated method stub
		return super.getOilTankSize();
	}

	// getoiltanksize ¸Â³ª?
	public void addOil(int oil) {
		if (oil <= getOilTankSize()) {
			this.restOil += oil;
		}
	}
	
	@Override
	public int getMaxWeight() {
		// TODO Auto-generated method stub
		return super.getMaxWeight();
	}

	public void addWeight(int weight) {
		if (weight <= getMaxWeight()) {
			this.curWeight += weight;
		}
//		double result = weight / 100;
//		setEfficiency(result);
	}

//	@Override
//	public double getEfficiency() {
//		// TODO Auto-generated method stub
//		return super.getEfficiency();
//	}

	@Override
	public void setEfficiency(double efficiency) {
		// TODO Auto-generated method stub
		super.setEfficiency(efficiency);
	}

	public void moving(int distance) {
//		this.restOil =  restOil - 0.2*distance;
	}

	public double getRestOil() {
		return restOil;
	}

	public void setRestOil(double restOil) {
		this.restOil = restOil;
	}

	public int getCurWeight() {
		return curWeight;
	}

	public void setCurWeight(int curWeight) {
		this.curWeight = curWeight;
	}

	@Override
	public double getEfficiency() {
		// TODO Auto-generated method stub
		return super.getEfficiency();
	}

	@Override
	public String toString() {
		return "Car [restOil=" + restOil + ", curWeight=" + curWeight + super.toString() + "]";
	}

}
