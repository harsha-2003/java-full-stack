package com.klef.jfsd.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Counseller;
import com.klef.jfsd.springboot.model.University;
import com.klef.jfsd.springboot.repository.UniversityRepository;
@Service
public class UniversityServiceImpl {
	@Autowired
	private UniversityRepository universityRepository;
	public String addUniversity(University u)
	{
		universityRepository.save(u);
		return "University added successfully";
	}
	public List<University> viewuniversities()
	{
		return universityRepository.findAll();
	}
}
