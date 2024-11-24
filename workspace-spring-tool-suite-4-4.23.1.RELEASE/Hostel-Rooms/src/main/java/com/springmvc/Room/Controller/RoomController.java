package com.springmvc.Room.Controller;

import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.Room.Model.Room;
import com.springmvc.Room.service.RoomService;

@RestController
@RequestMapping("room")
public class RoomController {
	@Autowired
    private RoomService roomService;

    @PostMapping("add")
    public ResponseEntity<Room> addRoom(@RequestBody Room room) {
        return roomService.addRoom(room);
    }

    @GetMapping("allRooms")
    public ResponseEntity<List<Room>> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("room/{roomId}")
    public ResponseEntity<Room> getRoomById(@PathVariable int roomId) {
        return roomService.getRoomById(roomId);
    }

    @DeleteMapping("room/{roomId}")
    public ResponseEntity<String> deleteRoom(@PathVariable int roomId) {
        return roomService.deleteRoom(roomId);
    }
    @GetMapping("roomForCus/{noOfPersons}/{capacity}/{roomType}")
    public ResponseEntity<List<Room>> getRoomForCustomer(@PathVariable int noOfPersons,@PathVariable int capacity,@PathVariable String roomType){
    	return roomService.getRoomForCustomer(noOfPersons,capacity,roomType);
    	
    }
    @PutMapping("updateVal/{roomId}")
    public ResponseEntity<Boolean> updateOccupency(@PathVariable int roomId){
    	return roomService.updateOccupency(roomId);
    }
    @PutMapping("decreaseOccupency/{roomId}")
    public ResponseEntity<Boolean> decreaseOccupency(@PathVariable int roomId){
    	return roomService.decreaseOccupency(roomId);
    }
}
