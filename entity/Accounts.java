package com.hiber.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "custommer")
public class Accounts {
	@Id
	@Column(name = "username")
	String userName;

	@Column(name = "password")
	String passWord;

	@Column(name = "namecustommer")
	String nameCustommer;

	@Column(name = "phone")
	Integer phone;

	@Column(name = "email")
	String email;

	@Column(name = "local")
	String local;

	@Column(name = "role")
	Integer role;

	@OneToMany(mappedBy = "account")
	List<product> products;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getNameCustommer() {
		return nameCustommer;
	}

	public void setNameCustommer(String nameCustommer) {
		this.nameCustommer = nameCustommer;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public List<product> getProducts() {
		return products;
	}

	public void setProducts(List<product> products) {
		this.products = products;
	}
}
