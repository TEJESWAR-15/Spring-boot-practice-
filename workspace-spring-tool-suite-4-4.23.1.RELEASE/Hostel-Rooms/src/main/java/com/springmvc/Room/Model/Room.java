package com.springmvc.Room.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roomid; 
    private String roomNumber; 
    private String roomType; 
    private int capacity; 
    private int currentOccupants; 

}
