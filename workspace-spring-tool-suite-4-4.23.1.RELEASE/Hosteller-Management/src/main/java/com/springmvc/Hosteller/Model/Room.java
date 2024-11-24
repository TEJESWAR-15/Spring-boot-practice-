package com.springmvc.Hosteller.Model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class Room {
	@Id
	private int roomId;
	private String roomNumber;
	private String roomType;
	private int capacity;
	private int currentOccupants;
}
