package com.example.msroom.beans;

public class Duration {
	private long startTime;
	private long endTime;
	
	public Duration(long startTime, long endTime) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public long getStartTime() {
		return startTime;
	}
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	public long getEndTime() {
		return endTime;
	}
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}
	
	public long getDuration() {
		return endTime-startTime;
	} 
	
	public int getSlotsCount() {
		return (int)(getDuration()/1800000);
	}
	
	public boolean isClash(Duration d) {
		if(startTime < d.startTime && endTime > d.endTime)return true;
		if(startTime > d.startTime && startTime < d.endTime) return true;
		if(endTime > d.startTime && endTime < d.endTime)return true;
		else return false;
	}
}
