package com.citi.gpa.repository;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.citi.gpa.document.EtsApp;


public interface EtsAppRepository extends MongoRepository<EtsApp, Serializable> {

}
