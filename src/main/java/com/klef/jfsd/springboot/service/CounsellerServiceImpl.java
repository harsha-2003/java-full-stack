package com.klef.jfsd.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Counseller;
import com.klef.jfsd.springboot.model.Student;
import com.klef.jfsd.springboot.repository.CounsellerRepository;
import com.klef.jfsd.springboot.repository.StudentRepository;

@Service
public class CounsellerServiceImpl {
	@Autowired
	private CounsellerRepository counsellerRepository;
	@Autowired
	private StudentRepository studentRepository;
	
	public String addCounseller(Counseller c)
	{
		counsellerRepository.save(c);
		return "Registered successfully";
	}
	public Counseller dashboard(String email,String pwd)
	{
		return counsellerRepository.dashboard(email, pwd);
	}
}
