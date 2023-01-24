package com.apiconsume.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apiconsume.entity.RestEntity;
import com.apiconsume.service.RestTemplateService;
 
 

@RestController
public class RestTemplateController {
	
	@Autowired
	private RestTemplateService restTemplateService;
	
	@GetMapping("/getAll")
	public ResponseEntity<String> getALlData() {
		return restTemplateService.allEmployee();
	}

	 @PostMapping("/AddUser")
	 public ResponseEntity<RestEntity> createUser(@RequestBody RestEntity restEntity){
		 return restTemplateService.saveByUser(restEntity);
	 }
	 
	 @GetMapping("/getuser/{id}")
	    public ResponseEntity<RestEntity> getUser(@PathVariable String id){
	        return restTemplateService.getUserById(id);
	        
	    }

	 //another way to update
	 @PutMapping("/updateUser/{id}")
	    public RestEntity updateUser(@RequestBody RestEntity restEntity, @PathVariable String id){
	          restTemplateService.updataUserData(restEntity, id);
	       return restEntity;  
	 }
	 
	 @DeleteMapping("/DeleateByUser/{id}")
	    public void DeleateByUser(@PathVariable String id){
		 restTemplateService.DeleateByUser(id);
	    }
	 
	 
}
