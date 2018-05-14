package com.example.msroom.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Stream;

import com.example.msroom.beans.Duration;
import com.example.msroom.beans.Room;
import com.example.msroom.dao.RoomDAO;

public class SimpleRoomDAO implements RoomDAO {
	private final HashMap<Integer, Room> rooms;
	
	public SimpleRoomDAO() {
		rooms = new HashMap<Integer, Room>();
	}

	@Override
	public void createNewRoom(Room room) {
		rooms.put(room.getId(), room);
	}

	@Override
	public Room findByRoomId(int roomId) {
		return rooms.get(roomId);
	}

	@Override
	public boolean roomAvailable(int roomId, Duration duration) {
		return rooms.get(roomId).hasDurationFree(duration);
	}

	@Override
	public Stream<Room> getAllRoomsStream() {
		return rooms.values().stream();
	}
	
	@Override
	public boolean bookRoom(int roomId, Duration duration) {
		return findByRoomId(roomId).bookDuration(duration);
	}
}
