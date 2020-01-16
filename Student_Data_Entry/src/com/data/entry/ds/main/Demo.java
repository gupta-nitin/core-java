package com.data.entry.ds.main;

public class Demo {

	public static void main(String[] args) {

		int sum = 0;
		int num = 50;
		for (int i = 0; i <= num; i++) {
			if (i % 5 == 0) {
				System.out.println("i = " + i);
				sum += i;
			}
		}
		System.out.println("Sum = " + sum);
	}

}
