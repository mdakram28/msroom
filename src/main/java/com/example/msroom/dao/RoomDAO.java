package com.example.msroom.dao;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import com.example.msroom.beans.Duration;
import com.example.msroom.beans.Room;

public interface RoomDAO {

	public void createNewRoom(Room room);

	public Room findByRoomId(int roomId);

	boolean roomAvailable(int roomId, Duration duration);

	Stream<Room> getAllRoomsStream();
	
	Stream<Room> getAllAccessibleRoomsStream();

	boolean bookRoom(int roomId, Duration duration);
	
}
