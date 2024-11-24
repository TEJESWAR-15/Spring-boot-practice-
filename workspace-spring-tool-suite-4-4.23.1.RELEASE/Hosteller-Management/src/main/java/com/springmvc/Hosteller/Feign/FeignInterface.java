package com.springmvc.Hosteller.Feign;

import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springmvc.Hosteller.Model.Room;

@FeignClient(name="HOSTEL-ROOMS")
public interface FeignInterface {
	@GetMapping("room/roomForCus/{noOfPersons}/{capacity}/{roomType}")
    public ResponseEntity<List<Room>> getRoomForCustomer(@PathVariable int noOfPersons,@PathVariable int capacity,@PathVariable String roomType);
    
	@PostMapping("room/updateVal/{roomId}")
    public ResponseEntity<Boolean> updateOccupency(@PathVariable int roomId);
	
	@PutMapping("room/decreaseOccupency/{roomId}")
	public void decreaseOccupency(int roomId);
}
