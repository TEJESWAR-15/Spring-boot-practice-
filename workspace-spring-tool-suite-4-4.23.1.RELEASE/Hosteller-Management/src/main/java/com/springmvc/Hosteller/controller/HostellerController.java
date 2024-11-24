package com.springmvc.Hosteller.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.Hosteller.Model.Hosteller;
import com.springmvc.Hosteller.Service.HostellerService;

@RestController
@RequestMapping("Hosteller")
public class HostellerController {
	
	@Autowired
	HostellerService hostellerService;
	
	@GetMapping("health")
	public String healthCheck() {
		return "Hllo world Its working ";
	}
	
	@GetMapping("allHostellers")
	public ResponseEntity<List<Hosteller>> getAllHostellers(){
		return hostellerService.getAllHostellers();
	}
	@PostMapping("add")
	public ResponseEntity<String> addHosterller(@RequestBody Hosteller hosteller){
		return hostellerService.addHosteller(hosteller);
	}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteHosteller(@RequestParam int id){
		return hostellerService.deleteHosteller(id);
	}
}
