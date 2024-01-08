package com.klef.jfsd.springboot.model;

import java.sql.Blob;
import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name="notice_table")
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "assigned_counselor_id")
    private Counseller counselor;

    private LocalDateTime publishedDate;

    
    private Blob fileName;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Counseller getCounselor() {
		return counselor;
	}


	public void setCounselor(Counseller counselor) {
		this.counselor = counselor;
	}


	public LocalDateTime getPublishedDate() {
		return publishedDate;
	}


	public void setPublishedDate(LocalDateTime publishedDate) {
		this.publishedDate = publishedDate;
	}


	public Blob getFileName() {
		return fileName;
	}


	public void setFileName(Blob fileName) {
		this.fileName = fileName;
	}

	
}