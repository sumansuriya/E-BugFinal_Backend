package com.ebug.project.entities;

public class BugReport {
	
	private int totalBugs;
	private int completedBugs;
	private int pendingBugs;
	private float completedPercentage;
	

	public BugReport() {
		super();
	}
	
	
	public BugReport(int totalBugs, int completedBugs, int pendingBugs, float completedPercentage) {
		super();
		this.totalBugs = totalBugs;
		this.completedBugs = completedBugs;
		this.pendingBugs = pendingBugs;
		this.completedPercentage = completedPercentage;
	}


	public int getTotalBugs() {
		return totalBugs;
	}


	public void setTotalBugs(int totalBugs) {
		this.totalBugs = totalBugs;
	}


	public int getCompletedBugs() {
		return completedBugs;
	}


	public void setCompletedBugs(int completedBugs) {
		this.completedBugs = completedBugs;
	}


	public int getPendingBugs() {
		return pendingBugs;
	}


	public void setPendingBugs(int pendingBugs) {
		this.pendingBugs = pendingBugs;
	}


	public float getCompletedPercentage() {
		return completedPercentage;
	}


	public void setCompletedPercentage(float completedPercentage) {
		this.completedPercentage = completedPercentage;
	}


	
	@Override
	public String toString() {
		return "BugReport [totalBugs=" + totalBugs + ", completedBugs=" + completedBugs + ", pendingBugs=" + pendingBugs
				+ ", completedPercentage=" + completedPercentage + "]";
	}


	
	
}

