package com.klef.jfsd.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.klef.jfsd.springboot.model.Counseller;
import com.klef.jfsd.springboot.model.Student;
import com.klef.jfsd.springboot.model.University;

@Repository
public interface CounsellerRepository extends JpaRepository<Counseller, Integer>{
	@Query("select c from Counseller c where email=?1 and password=?2")
	public Counseller dashboard(String email,String pwd);
	@Query("SELECT c FROM Counseller c WHERE college=?1 AND gender=?2")
    public List<Counseller> findRandomCounselorByCollegeAndGender(String university, String gender);
}
