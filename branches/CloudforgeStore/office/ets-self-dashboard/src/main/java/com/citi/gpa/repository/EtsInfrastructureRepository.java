package com.citi.gpa.repository;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.citi.gpa.document.EtsInfrastructure;


public interface EtsInfrastructureRepository extends MongoRepository<EtsInfrastructure, Serializable> {

}
