package org.jointheleague.stephenh.level3project;

import java.util.ArrayList;

public class ClimbingClub {
	ArrayList<ClimbInfo> climbs = new ArrayList<ClimbInfo>();
	
	public void addClimb(String name, int time) {
		for (int i = 0; i < climbs.size(); i++) {
			if (name.compareTo(climbs.get(i).getName()) < 0) {
				climbs.add(i, new ClimbInfo(name, time));
				return;
			}
		}
		climbs.add(new ClimbInfo(name, time));
	}

	public ArrayList<ClimbInfo> getClimbList() {
		return climbs;
	}

}
