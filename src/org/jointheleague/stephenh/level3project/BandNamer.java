package org.jointheleague.stephenh.level3project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BandNamer {
	List<String> bandAdj = new ArrayList<String>();
	List<String> bandNoun = new ArrayList<String>();
	
	public static void main(String[] args) {
		new BandNamer().run();
	}

	private void run() {
		bandAdj.add("Purple"); bandAdj.add("Slimy"); bandAdj.add("Muddy"); bandAdj.add("Crusty"); bandAdj.add("Electric");
		
		bandNoun.add("Silverware"); bandNoun.add("Pants"); bandNoun.add("Dots"); bandNoun.add("Rabbits"); bandNoun.add("Thunderbolts");
		
		Random r = new Random();
		int randAdj = r.nextInt(bandAdj.size());
		int randNoun = r.nextInt(bandNoun.size());
		speak(bandAdj.get(randAdj) + " " + bandNoun.get(randNoun));
	}
	
	private void speak(String words) {
		try {
			Runtime.getRuntime().exec("say " + words).waitFor();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
