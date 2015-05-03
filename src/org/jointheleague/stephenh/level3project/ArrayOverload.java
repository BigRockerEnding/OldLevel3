package org.jointheleague.stephenh.level3project;

import java.util.ArrayList;

public class ArrayOverload {
	class Heavyweight {};
	ArrayList<Heavyweight> list2Overload = new ArrayList<Heavyweight>();
	
	public static void main(String[] args) {
		new ArrayOverload().run();
	}

	private void run() {
		Heavyweight aWeight = new Heavyweight();
		for (int i = 1; i > 0; i++) {
			list2Overload.add(aWeight);
		}
	}
}
