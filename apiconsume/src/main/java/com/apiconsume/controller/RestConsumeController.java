package com.apiconsume.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apiconsume.entity.RestConsumeEntity;
import com.apiconsume.service.RestConsumeService;
 
 

@RestController
public class RestConsumeController {
	
	@Autowired
	RestConsumeService restConsumeService;
 
	
	 @PostMapping("/SaveConsumeApi")
	 public RestConsumeEntity addConsumeData(@RequestBody RestConsumeEntity restConsumeEntity){
		 return restConsumeService.addConsumeData(restConsumeEntity);
	 }

	 // @RequestMapping(value = "/addAllInformation", method= RequestMethod.POST ,produces = "application/json")
	   @PostMapping("/addAllInformation")
	    public RestConsumeEntity userAddData(@RequestBody RestConsumeEntity user){
	        return restConsumeService.userAdd(user);
	    }
	   
	   @GetMapping("/getAllUser")
	    public List<RestConsumeEntity> getAllUser(){
	        return restConsumeService.getAllUserDetails();
	    }
}
