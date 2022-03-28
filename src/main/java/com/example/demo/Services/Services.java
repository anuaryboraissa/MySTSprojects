package com.example.demo.Services;


import java.util.List;

import com.example.demo.Entity.Business;

public interface Services {
	Business SaveBusiness(Business business);
	Business getById(long id);
	List<Business> selectAll();
	void Delete(long id);
}
