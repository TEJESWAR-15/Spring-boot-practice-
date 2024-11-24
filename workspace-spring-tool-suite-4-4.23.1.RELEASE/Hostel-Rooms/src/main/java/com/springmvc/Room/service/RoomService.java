package com.springmvc.Room.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springmvc.Room.Model.Room;
import com.springmvc.Room.Repository.RoomDao;
@Service
public class RoomService {
	
	@Autowired
	RoomDao roomDao;

	public ResponseEntity<Room> addRoom(Room room) {
		roomDao.save(room);
		return new ResponseEntity(room,HttpStatus.OK);
	}

	public ResponseEntity<List<Room>> getAllRooms() {
		
		return new ResponseEntity(roomDao.findAll(),HttpStatus.OK);
	}

	public ResponseEntity<Room> getRoomById(int roomId) {
		return new ResponseEntity(roomDao.findById(roomId),HttpStatus.OK);
	}

	public ResponseEntity<String> deleteRoom(int roomId) {
		roomDao.deleteById(roomId);
		return new ResponseEntity("Deleted",HttpStatus.OK);
	}

	public ResponseEntity<List<Room>> getRoomForCustomer(int noOfPersons, int capacity,String roomType) {
		return new ResponseEntity(roomDao.getRoomForCustomers(noOfPersons,capacity,roomType),HttpStatus.OK);
	}

	public ResponseEntity<Boolean> updateOccupency(int roomId) {
		Room room =roomDao.getById(roomId);
		room.setCurrentOccupants(room.getCurrentOccupants()+1);
		roomDao.save(room);
		return new ResponseEntity(true,HttpStatus.OK);
	}

	public ResponseEntity<Boolean> decreaseOccupency(int roomId) {
		Room room =roomDao.getById(roomId);
		room.setCurrentOccupants(room.getCurrentOccupants()-1);
		roomDao.save(room);
		return new ResponseEntity(true,HttpStatus.OK);
	}

}
