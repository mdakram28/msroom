package com.example.msroom.rest.controller;

import java.sql.Date;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.msroom.beans.Duration;
import com.example.msroom.beans.Room;
import com.example.msroom.dao.RoomDAO;

@RestController
public class RoomController {
	private static final String message = "Welcome Mr. %s.!";

	@Autowired
	private RoomDAO roomDAO;

	@GetMapping("/")
	public String test() {
		return "Rooms microservice is running";
	}

	@PostMapping("/add")
	@ResponseBody
	public void addRoom(@RequestParam int roomId, @RequestParam String name, @RequestParam int floor,
			@RequestParam int size, @RequestParam String accessGroup) {
		Room room = new Room(roomId, name, floor, size, accessGroup);
		roomDAO.createNewRoom(room);
	}

	@GetMapping("/all")
	@ResponseBody
	public Stream<Room> getAllRooms() {
		return roomDAO.getAllRoomsStream();
	}
	
	@GetMapping("/accessible")
	@ResponseBody
	public Stream<Room> getAllAccessibleRooms() {
		return roomDAO.getAllAccessibleRoomsStream();
	}

	@GetMapping("/roomAvailable")
	@ResponseBody
	public boolean roomAvailable(@RequestParam int roomId, @RequestParam long startTime, @RequestParam long endTime) {
		return roomDAO.roomAvailable(roomId, new Duration(startTime, endTime));
	}

	@PostMapping("/bookRoom")
	@ResponseBody
	public void bookRoom(@RequestParam int roomId, @RequestParam long startTime, @RequestParam long endTime) {
		roomDAO.bookRoom(roomId, new Duration(startTime, endTime));
	}
}
