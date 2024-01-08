package com.klef.jfsd.springboot.model;

import jakarta.persistence.*;

@Entity
@Table(name="universities")
public class University {
	@Id
    @Column(name="university_id")
    private int id;
    @Column(name="university_name",nullable=false,length = 100)
    private String name;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
