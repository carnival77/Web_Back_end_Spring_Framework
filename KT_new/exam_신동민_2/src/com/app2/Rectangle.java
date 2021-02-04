package com.app2;

public class Rectangle extends Shape implements Resize {

	public Rectangle(int width, int height, String colors) {
		super(width, height, colors);
		// TODO Auto-generated constructor stub
	}

	public Rectangle() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setResize(int size) {
		// TODO Auto-generated method stub
		setWidth(getWidth() + size);
	}

	@Override
	public void setWidth(int width) {
		// TODO Auto-generated method stub
		super.setWidth(width);
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return super.getWidth();
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return super.getHeight();
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub

		return getWidth() * getHeight();
	}

}
