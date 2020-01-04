package com.test;

public class Square implements Shape {

	int width = 10;
	
	@Override
	public int area() {
		return width*width;
	}

}
