package com.klef.jfsd.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Admin;
import com.klef.jfsd.springboot.model.Counseller;
import com.klef.jfsd.springboot.repository.AdminRepository;
import com.klef.jfsd.springboot.repository.CounsellerRepository;

@Service
public class AdminServiceImpl {
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private CounsellerRepository counsellerRepository;
	public Admin dashboard(String email,String pwd)
	{
		return adminRepository.dashboard(email, pwd);
	}
	public String addCounseller(Counseller c)
	{
		counsellerRepository.save(c);
		return "Counseller added successfully";
	}
}
