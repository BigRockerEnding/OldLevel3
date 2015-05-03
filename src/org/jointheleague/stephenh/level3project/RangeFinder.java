package org.jointheleague.stephenh.level3project;

import java.util.Scanner;

public class RangeFinder {
	private static final int SENTINEL = 0;
	private final Scanner intReader = new Scanner(System.in);
	
	public static void main(String[] args) {
		new RangeFinder().run();
	}

	private void run() {
		int i = readNextInt();
		if (i == SENTINEL) {
			System.out.println("No values entered");
			return;
		}
		int max = i, min = i;
		while (i != SENTINEL) {
			if (i < min) min = i;
			if (i > max) max = i;
			i = readNextInt();
		}
		System.out.println("smallest: " + min + "\nlargest: " + max);
	}

	private int readNextInt() {
		int i = 0;
		boolean isValid = false;
		while (!isValid) {
			try {
				i = Integer.parseInt(intReader.next());
				isValid = true;
				
			} catch (NumberFormatException e) {
				System.out.println("Value is not an int");
				i = 0;
				isValid = false;
			}
		}
		return i;
	}
}
