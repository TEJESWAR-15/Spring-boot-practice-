package com.springmvc.Room.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;

import com.springmvc.Room.Model.Room;

public interface RoomDao extends JpaRepository<Room,Integer>{
	
	@Query(value="select * from Room r where capacity= :capacity and current_occupants=:noOfPersons and room_type = :roomType",nativeQuery=true)
	List<Room> getRoomForCustomers(int noOfPersons, int capacity,String roomType);

}
