package com.apiconsume.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apiconsume.entity.RestConsumeEntity;
 
 

@Repository
public interface RestTemplateRepository extends JpaRepository<RestConsumeEntity, Long>{

 
	

}
