package com.klef.jfsd.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.klef.jfsd.springboot.model.Notice;

public interface NoticeRepository extends JpaRepository<Notice, Long> {
	@Query("select N from Notice N where counselor.id=?1")
	public List<Notice> listNotices(int id);
}
