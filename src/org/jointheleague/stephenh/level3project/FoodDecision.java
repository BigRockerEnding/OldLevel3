package org.jointheleague.stephenh.level3project;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FoodDecision {
	List<String> foodList = new ArrayList<String>();
	String[] daysOfWeek;
	
	public static void main(String[] args) {
		new FoodDecision().run();
	}

	private void run() {
		foodList.add("Pizza"); foodList.add("Burger"); foodList.add("Chicken"); foodList.add("Pasta"); foodList.add("Hot Dog");
		foodList.add("Taco"); foodList.add("Burrito"); foodList.add("Fish"); foodList.add("Potato"); foodList.add("Beef");
		daysOfWeek = new String[] {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		
		for (String day : daysOfWeek) {
			String selectedFood = foodList.get(new Random().nextInt(foodList.size()));
			System.out.println("On " + day + " you should eat " + selectedFood);
		}
	}
}
