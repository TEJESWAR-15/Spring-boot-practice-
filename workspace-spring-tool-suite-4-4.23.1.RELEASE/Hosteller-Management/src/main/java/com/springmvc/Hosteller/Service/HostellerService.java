package com.springmvc.Hosteller.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springmvc.Hosteller.Feign.FeignInterface;
import com.springmvc.Hosteller.Model.Hosteller;
import com.springmvc.Hosteller.Repository.HostellerRepository;

@Service
public class HostellerService {
	
	@Autowired
	HostellerRepository hostelDao;
	
	@Autowired
	FeignInterface feignCom;
	
	public ResponseEntity<List<Hosteller>> getAllHostellers() {
		
		return new ResponseEntity(hostelDao.findAll(),HttpStatus.OK);
	}

	public ResponseEntity<String> addHosteller(Hosteller hosteller) {
		hostelDao.save(hosteller);
		feignCom.updateOccupency(hosteller.getRoomId());
		return new ResponseEntity("Success",HttpStatus.ACCEPTED);
	}

	public ResponseEntity<String> deleteHosteller(int id) {
		
		hostelDao.deleteById(id);
		feignCom.decreaseOccupency(hostelDao.getById(id).getRoomId());
		return new ResponseEntity("deleted",HttpStatus.OK);
	}
	
}
