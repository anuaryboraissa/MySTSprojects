package com.example.demo.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Files")
public class UserFiles implements Serializable {
	private static final long serialVersionUID = 4929196767512235295L;
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	@Column(name="FileName",nullable=false)
    private String name;
	@Column(name="FileType")
   private String type;
	@Column(name="ModifiedFileName")
	private String ModifiedFileName;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	
	public UserFiles() {
		super();
	}
	public UserFiles(long id, String name, String modifiedFileName) {
		super();
		this.id = id;
		this.name = name;
		ModifiedFileName = modifiedFileName;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getModifiedFileName() {
		return ModifiedFileName;
	}
	public void setModifiedFileName(String modifiedFileName) {
		ModifiedFileName = modifiedFileName;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
