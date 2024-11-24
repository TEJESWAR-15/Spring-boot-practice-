package com.springmvc.Hosteller;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableFeignClients
public class HostellerManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(HostellerManagementApplication.class, args);
	}

}
