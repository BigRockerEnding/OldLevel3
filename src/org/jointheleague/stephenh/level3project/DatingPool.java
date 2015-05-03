package org.jointheleague.stephenh.level3project;

import java.util.HashMap;

public class DatingPool {
	HashMap<String, String> elgibleBachelors = new HashMap<String, String>();
	
	public static void main(String[] args) {
		new DatingPool().run();
	}

	private void run() {
		elgibleBachelors.put("Max", "conservative");  
		elgibleBachelors.put("Bob", "conservative"); 
		elgibleBachelors.put("Diego ", "libertarian");
		elgibleBachelors.put("Felix", "independant");
		elgibleBachelors.put("William", " republican");  
		elgibleBachelors.put("Chuck", " republican");  
		elgibleBachelors.put("Matthew ", "liberal");  
		elgibleBachelors.put("Jose ", "democrat");  
		elgibleBachelors.put("Matthew ", "liberal");
		int numLiberals = 0;
		for (String name : elgibleBachelors.keySet()) {
			if (elgibleBachelors.get(name).equals("liberal")) numLiberals++;
		}
		System.out.println("Number of Liberals: " + numLiberals);
	}
}
