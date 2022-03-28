package com.example.demo.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="Users")
public class User implements Serializable{
	private static final long serialVersionUID = -4965271644489474714L;
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	@Column(name="First_Name",nullable=false)
	private String name;
	@Column(name="Last_Name",nullable=false)
	private String last;
	@Column(name="Location")
	private String location;
	@Column(name="Address")
	private String address;
	@Column(name="gender")
	private String genda;
	@Column(name="Age")
	private double age;
	@Column(name="email")
	private String email;
	@Column(name="Password",nullable=false)
	private String Password;
	public User() {
		super();
	}
	
	@Transient
	private List<MultipartFile> files=new ArrayList<MultipartFile>();
	@Transient
	private List<String> images=new ArrayList<String>();
	
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGenda() {
		return genda;
	}
	public void setGenda(String genda) {
		this.genda = genda;
	}
	public double getAge() {
		return age;
	}
	public void setAge(double age) {
		this.age = age;
	}
	public List<MultipartFile> getFiles() {
		return files;
	}
	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}

}
