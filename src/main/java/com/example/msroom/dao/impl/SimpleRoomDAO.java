package com.example.msroom.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.client.RestTemplate;

import com.example.msroom.beans.Duration;
import com.example.msroom.beans.MsUser;
import com.example.msroom.beans.Room;
import com.example.msroom.beans.UserDetails;
import com.example.msroom.dao.RoomDAO;

public class SimpleRoomDAO implements RoomDAO {
	private final HashMap<Integer, Room> rooms;
	
	@Autowired
	private MsUser msUser;

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

	@Override
	public Stream<Room> getAllAccessibleRoomsStream() {
	    
	    UserDetails details = msUser.getUserDetails();
	    
		return rooms.values().stream()
				.filter((room) -> {
					String[] allowedUserGroups = room.getAccessGroup().split(";");
					String userGroup = details.getUserGroup();
					boolean allowed = Arrays.binarySearch(allowedUserGroups, userGroup) >= 0;
					return allowed;
				});
	}
}
