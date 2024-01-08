package com.klef.jfsd.springboot.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Counseller;
import com.klef.jfsd.springboot.model.Student;
import com.klef.jfsd.springboot.repository.CounsellerRepository;
import com.klef.jfsd.springboot.repository.StudentRepository;

@Service
public class StudentServiceImpl {
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private CounsellerRepository counsellerRepository;
	public String addStudent(Student s)
	{
		List<Counseller> matchingCounselors = (List<Counseller>) counsellerRepository.findRandomCounselorByCollegeAndGender(s.getCollege(), s.getGender());
		
	        if (!matchingCounselors.isEmpty()) {
	            Random random = new Random();
	            Counseller assignedCounselor = matchingCounselors.get(random.nextInt(matchingCounselors.size()));
	            s.setAssignedCounselor(assignedCounselor);
	        }
		studentRepository.save(s);
		return "Registered Successful";
	}
	public Student dashboard(String email,String pwd)
	{
		return studentRepository.dashboard(email, pwd);
	}
	public List<Student> viewStudentsByCid(int cid)
	{
		return studentRepository.viewStudentsByCid(cid);
	}
}
