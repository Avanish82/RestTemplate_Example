package com.apiconsume.service;

import java.util.Arrays;
import java.util.HashMap; 
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.apiconsume.entity.RestEntity;
 
 

@Service
public class RestTemplateService {

	private static final String get_All_User_URL = "http://localhost:8000/rest/getAllUser";
	private static final String create_All_User_URL = "http://localhost:8000/rest/list";
	private static final String get_by_Id_User_URL = "http://localhost:8000/rest/getuser/{id}";
	private static final String update_by_Id_User_URL = "http://localhost:8000/rest/updateUser/{id}";
	private static final String delete_by_Id_User_URL = "http://localhost:8000/rest/deleteUser/{id}";
	
	
	//Method to get all employee 
	RestTemplate restTemplate= new RestTemplate();
	
	public ResponseEntity<String> allEmployee(){
	
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        
	    HttpEntity<String> entity =new HttpEntity<String>("parameters", headers);
	    
	    ResponseEntity<String> response = restTemplate.exchange(get_All_User_URL, HttpMethod.GET, entity, String.class);
	   
	    return response;
	
	}
// persist data thirdparty api 
	public ResponseEntity<RestEntity> saveByUser(RestEntity restEntity) {
		return restTemplate.postForEntity(create_All_User_URL, restEntity, RestEntity.class);
	 
	}

//Get value by user id	
	public ResponseEntity<RestEntity> getUserById(String id) {
		Map<String, String> param = new HashMap<String, String>();
		param.put("id", id);
		return restTemplate.getForEntity(get_by_Id_User_URL, RestEntity.class, param);
		

	}
	public RestEntity updateByUser(RestEntity restEntity) {
		 restTemplate.put(update_by_Id_User_URL, restEntity);
		return null;
	}
	
	public void DeleateByUser(String id) {
		restTemplate.delete(delete_by_Id_User_URL, id);
		
	}
	public void updataUserData(RestEntity restEntity, String id) {
		 restTemplate.put(update_by_Id_User_URL, restEntity, id);
		 
	}
//	public Optional<RestEntity> getUserById(String id) {
//		 restTemplate.postForObject(get_by_Id_User_URL, id, RestEntity.class); //(get_by_Id_User_URL, id);
//		return null;
//	}
	 
 
}
