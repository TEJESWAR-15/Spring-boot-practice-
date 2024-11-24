package com.springmvc.Hosteller.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springmvc.Hosteller.Model.Hosteller;

@Repository
public interface HostellerRepository extends JpaRepository<Hosteller,Integer>{

}
