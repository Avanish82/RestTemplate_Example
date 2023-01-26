package com.apiconsume.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.apiconsume.entity.RestConsumeEntity;
import com.apiconsume.entity.RestEntity;
import com.apiconsume.repository.RestTemplateRepository;
import com.google.common.net.HttpHeaders;

import io.micrometer.core.ipc.http.HttpSender.Response;

@Service
public class RestConsumeService {

	private static final String get_by_Id_User_URL = "http://localhost:8000/rest/getuser/{id}";
	
	@Autowired
	RestTemplateRepository restTemplateRepository;
	
	RestTemplate restTemplate= new RestTemplate();
	
	public RestConsumeEntity addConsumeData(RestConsumeEntity  restConsumeEntity) {
		//Second way working fine
		Long userId=restConsumeEntity.getId();
		String id=userId+"";            //Long to string conversion
		Map<String, String> param = new HashMap<String, String>();
		param.put("id", id);	 
		ResponseEntity<RestEntity> str=restTemplate.getForEntity(get_by_Id_User_URL, RestEntity.class, param);
		RestEntity obj=str.getBody();
		restConsumeEntity.setUname(obj.getName());
		restConsumeEntity.setUemail(obj.getEmail());
		restConsumeEntity.setUphone(obj.getPhone());
		

		return restTemplateRepository.save(restConsumeEntity);
	}
		/*first way working fine 
		  * String id="9";
		Map<String, String> param = new HashMap<String, String>();
		param.put("id", id);
		org.springframework.http.HttpHeaders th=new org.springframework.http.HttpHeaders();		 
		ResponseEntity<RestEntity> str=restTemplate.getForEntity(get_by_Id_User_URL, RestEntity.class, param);
		RestEntity obj=str.getBody();
		//Response response=new Response(th, obj);
		restConsumeEntity.setMultiplevaluestore(obj.getName());
 	
		return restTemplateRepository.save(restConsumeEntity);
	}
	*/
		
//		public ResponseEntity<RestEntity> getUserById(String id) {
//			Map<String, String> param = new HashMap<String, String>();
//			param.put("id", id);
//			return restTemplate.getForEntity(get_by_Id_User_URL, RestEntity.class, param);
//			
//
//		}	 
		
	//}

	public RestConsumeEntity userAdd(RestConsumeEntity user) {
		        return  restTemplateRepository.save(user);
		    
	}

	public List<RestConsumeEntity> getAllUserDetails() {
		return restTemplateRepository.findAll();
	}

	 


}
