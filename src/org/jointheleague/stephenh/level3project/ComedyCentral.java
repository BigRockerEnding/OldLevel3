package org.jointheleague.stephenh.level3project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ComedyCentral {
	List<String> jokeStart = new ArrayList<String>();
	List<String> punchLine = new ArrayList<String>();
	
	public static void main(String[] args) {
		new ComedyCentral().run();
	}

	private void run() {
		jokeStart.add("Why is six afraid of seven?");
		punchLine.add("Because seven ate nine!");
		jokeStart.add("Why did the pilgrim's pants fall down?");
		punchLine.add("Because his belt was around his hat!");
		jokeStart.add("Why didn't the spider go to school?");
		punchLine.add("Because she learned everything on the web!");
		jokeStart.add("What's black and white and red all over?");
		punchLine.add("An embarrassed zebra!");
		
		int randJoke = new Random().nextInt(jokeStart.size());
		speak(jokeStart.get(randJoke));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		speak(punchLine.get(randJoke));
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