package com.app2;

public class Triangle extends Shape implements Resize {

	public Triangle(int width, int height, String colors) {
		super(width, height, colors);
		// TODO Auto-generated constructor stub
	}

	public Triangle() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setResize(int size) {
		// TODO Auto-generated method stub
		setHeight(getHeight() + size);
	}

	@Override
	public void setHeight(int height) {
		// TODO Auto-generated method stub
		super.setHeight(height);
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return super.getHeight();
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return getHeight() * getWidth() / 2.0;
	}

}
