package org.jointheleague.stephenh.level3project;

import java.util.ArrayList;
import java.util.Iterator;

//Copyright Wintriss Technical Schools 2013

public class RemovingStuffFromArrayLists {
	
	public static void main(String[] args) {

		class Stuff {}
		class Worm extends Stuff {}
		class Dirt extends Stuff {}
		ArrayList<Stuff> stuffIFoundInTheYard = new ArrayList<Stuff>();
		stuffIFoundInTheYard.add(new Worm());
		stuffIFoundInTheYard.add(new Dirt());
		stuffIFoundInTheYard.add(new Dirt());
		stuffIFoundInTheYard.add(new Dirt());
		stuffIFoundInTheYard.add(new Worm());
		stuffIFoundInTheYard.add(new Dirt());

		System.out.println(stuffIFoundInTheYard.size());
		
		for (Iterator<Stuff> i = stuffIFoundInTheYard.iterator(); i.hasNext();) {
			Stuff stuff = i.next();
			if (stuff instanceof Dirt) {
				i.remove();
			}
		}
		
		System.out.println(stuffIFoundInTheYard.size());	//should be 2

		ArrayList<Character> truth = new ArrayList<Character>();
		truth.add('#');
		truth.add('g');
		truth.add('u');
		truth.add('#');
		truth.add('n');
		truth.add('s');
		truth.add(' ');
		truth.add('s');
		truth.add('#');
		truth.add('u');
		truth.add('#');
		truth.add('#');
		truth.add('c');
		truth.add('k');
		
		for (Iterator<Character> i = truth.iterator(); i.hasNext();) {
			Character character = i.next();
			if (character.charValue() == '#') {
				i.remove();
			}
		}
		for (Character character : truth) {
			System.out.print(character);
		}
	}
}