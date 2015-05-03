package org.jointheleague.stephenh.level3project;

public class ClimbInfo {
	String peakName;
	int climbTime;
	
	public ClimbInfo(String peakName, int climbTime) {
		this.peakName = peakName;
		this.climbTime = climbTime;
	}

	public String getName() {
		return peakName;
	}

	public int getTime() {
		return climbTime;
	}

	public void setName(String name) {
		peakName = name;
	}

	public void setTime(int time) {
		climbTime = time;
	}
	
}
