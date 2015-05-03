package org.jointheleague.stephenh.level3project;

import java.util.ArrayList;

public class OncogeneDetector {

	public boolean isOncogene(ArrayList<String> healthySequences,
			ArrayList<String> cancerSequences, String canidate) {
		int canidateSize = canidate.length();
		ArrayList<String> canidateChars = new ArrayList<String>();
		for (char c : canidate.toCharArray())
			canidateChars.add("" + c);
		
		return false;
	}

}
