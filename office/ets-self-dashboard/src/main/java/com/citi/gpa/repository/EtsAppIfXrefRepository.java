package com.citi.gpa.repository;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.citi.gpa.document.EtsAppIfXref;


public interface EtsAppIfXrefRepository extends MongoRepository<EtsAppIfXref, Serializable> {

}
