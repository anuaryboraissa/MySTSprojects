package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Entity.Business;

public interface DBLogics extends JpaRepository<Business, Long>{

}
