package com.citi.gpa.repository;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.citi.gpa.document.EtsAppDatIntXref;


public interface EtsAppDatIntXrefRepository extends MongoRepository<EtsAppDatIntXref, Serializable> {
	
	EtsAppDatIntXref findOneByAppDatIntXrefId(long appDatIntXrefId);
	
}
