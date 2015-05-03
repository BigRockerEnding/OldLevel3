package org.jointheleague.stephenh.level3project;

import java.util.ArrayList;

public class LearningArrayLists {

	public static Object createArrayList() {
		return new ArrayList();
	}

	public static void addToArrayList(ArrayList testList, String string) {
		testList.add(string);
	}

	public static Object getNumberOfItems(ArrayList testList) {
		return testList.size();
	}

	public static String getItem(ArrayList testList, int index) {
		return (String) testList.get(index);
	}

	public static String iterateOver(ArrayList testList) {
		String items = "";
		for (Object object : testList) {
			items += (String) object;
		}
		return items;
	}

	public static int findItemOnList(ArrayList testList, String string) {
		return testList.indexOf(string);
	}

	public static void insertItem(ArrayList testList, int i, String string) {
		testList.add(i, string);
	}
	
	public static void replaceItem(ArrayList testList, int i, String string) {
		insertItem(testList, i, string);
		testList.remove(i + 1);
	}

	public static ArrayList<Integer> createTypedArrayList() {
		return new ArrayList<Integer>();
	}

	public static Integer addAllInteger(ArrayList<Integer> testList) {
		Integer result = new Integer(0);
		for (Integer integer : testList) {
			result = new Integer(result.intValue() + integer.intValue());
		}
		return result;
	}

	public static ArrayList<String> createStringTypedArrayList() {
		return new ArrayList<String>();
	}

	public static String addAllString(ArrayList<String> testList) {
		String items = "";
		for (String string : testList) {
			items += string;
		}
		return items;
	}

}
