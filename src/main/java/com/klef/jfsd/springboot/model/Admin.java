package com.klef.jfsd.springboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="admin_table")
public class Admin {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="admin_id")
    private int id;
    @Column(name="admin_uname",nullable=false,length = 50)
    private String name;
//    @Column(name="counseller_gender",nullable=false,length = 10)
//    private String gender;
    @Column(name="admin_email",nullable=false,unique = true,length = 30)
    private String email;
    @Column(name="admin_password",nullable=false,length = 30)
    private String password;
//    @Column(name="counseller_notices",nullable=false)
//    private List<Notice> notices;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
