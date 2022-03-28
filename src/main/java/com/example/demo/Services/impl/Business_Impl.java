package com.example.demo.Services.impl;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Entity.Business;
import com.example.demo.Exceptions.ResourceNotFound;
import com.example.demo.Repository.DBLogics;
import com.example.demo.Services.Services;
@Service
public class Business_Impl implements Services{
	@Autowired
private DBLogics database;
@Override
public Business SaveBusiness(Business business) {
	return database.save(business);
}
@Override
public List<Business> selectAll() {
	return  database.findAll();
}
@Override
public Business getById(long id) {
	/*
	Optional<Business> business=database.findById(id);
	if(business.isPresent()) {
		return  business.get();
	}
	else {
		throw new ResourceNotFound("Business","Id",id);
	}
	*/
	return database.findById(id).orElseThrow(() -> new ResourceNotFound("Business","Id",id)); 
}
@Override
public void Delete(long id) {
	 database.deleteById(id);
}
}

 

