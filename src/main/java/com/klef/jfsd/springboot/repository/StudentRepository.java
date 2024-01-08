package com.klef.jfsd.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.klef.jfsd.springboot.model.Counseller;
import com.klef.jfsd.springboot.model.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	@Query("select S from Student S where email=?1 and password=?2")
	public Student dashboard(String email,String pwd);
	
	@Query("select S from Student S where assignedCounselor.id=?1")
	public List<Student> viewStudentsByCid(int cid);
}
