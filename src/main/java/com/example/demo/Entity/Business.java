package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name="Business")
public class Business {	
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	@Column(name="Name",nullable=false)
	private String name;
	@Column(name="Locaton")
	private String Locaton;
	@Column(name="Owner")
	private String Owner;
	@Column(name="Password")
	private String Password;
	@Column(name="good_Type")
	private String goods;
	@Column(name="amount_p_day")
	private double amount_p_day;

public Business() {
		super();
	
	}

public String getPassword() {
	return Password;
}
public String setPassword(String password) {
	return Password=password;
}

public long getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocaton() {
		return Locaton;
	}
	public void setLocaton(String locaton) {
		Locaton = locaton;
	}
	public String getOwner() {
		return Owner;
	}
	public void setOwner(String owner) {
		Owner = owner;
	}
	public String getGoods() {
		return goods;
	}
	public void setGoods(String goods) {
		this.goods = goods;
	}
	public double getAmount_p_day() {
		return amount_p_day;
	}
	public void setAmount_p_day(double amount_p_day) {
		this.amount_p_day = amount_p_day;
	}

}
