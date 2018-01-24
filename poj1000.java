package com.dy.poj1000;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		long sum = (long) a + (long) b;
		System.out.println(sum);
		scanner.close();
	}
}

