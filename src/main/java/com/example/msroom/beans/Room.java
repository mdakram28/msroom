package com.example.msroom.beans;

import java.util.ArrayList;

public class Room {
	private final int id;
	private final String name;
	private final int floor;
	private final int size;
	private final ArrayList<Duration> schedule;
	private final String accessGroup;

	public Room(int id, String name, int floor, int size, String accessGroup) {
		super();
		this.id = id;
		this.name = name;
		this.floor = floor;
		this.size = size;
		this.accessGroup = accessGroup;
		schedule = new ArrayList<Duration>();
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getFloor() {
		return floor;
	}

	public int getSize() {
		return size;
	}

	public ArrayList<Duration> getSchedule() {
		return schedule;
	}
	
	public String getAccessGroup() {
		return accessGroup;
	}

	public boolean hasDurationFree(Duration duration) {
		for(Duration occDuration : schedule) {
			if(duration.isClash(occDuration))return false;
		}
		return true;
	}
	
	public boolean bookDuration(Duration duration) {
		if(hasDurationFree(duration)){
			schedule.add(duration);
			return true;
		}else{
			return false;
		}
	}

}
