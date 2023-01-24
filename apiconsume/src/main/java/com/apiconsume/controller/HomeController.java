package com.apiconsume.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apiconsume.service.ServiceLayer;

import io.swagger.annotations.Api;
 

@RestController
@Api(tags = "UserController", value = "UserController", description = "Controller for UserController Queries")
public class HomeController {
	
	private final ServiceLayer serviceLayer;
	
	
	public HomeController(ServiceLayer serviceLayer) {
		this.serviceLayer = serviceLayer;
	}


	@GetMapping("/getdata")
	public String getData() {
      return serviceLayer.consumeAPI();
	}
	
	@GetMapping("/show")
	public String viewInfo() {
		return serviceLayer.viewStudent();
	}
	
}


