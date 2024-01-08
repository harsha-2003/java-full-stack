package com.klef.jfsd.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.klef.jfsd.springboot.model.Counseller;
import com.klef.jfsd.springboot.model.University;

@Repository
public interface UniversityRepository extends JpaRepository<University, Integer> {
	
}
