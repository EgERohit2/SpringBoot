package com.api.hospital.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

@Entity
@Table(name="Hospital")

@Where(clause="is_active")
@SQLDelete(sql ="UPDATE Hospital set is_active=false where id=?")
public class Hospital {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "name shouldn't be null")
	private String name;
	@NotBlank(message = "dept cannot be blank")
	private String dept;
	@NotBlank(message = "email souldn't be null")
	private String email;
	private Boolean isActive=true;
	
	public Hospital(Boolean isActive, Date cretedt, Date updatedAt) {
		super();
		this.isActive = isActive;
		this.cretedt = cretedt;
		this.updatedAt = updatedAt;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Date getCretedt() {
		return cretedt;
	}

	public void setCretedt(Date cretedt) {
		this.cretedt = cretedt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@CreationTimestamp
	private Date cretedt;
	
	@UpdateTimestamp
	private Date updatedAt;
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Hospital(int id, String name, String dept) {
		super();
		this.id = id;
		this.name = name;
		this.dept = dept;
	}

	public Hospital() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Hospital [id=" + id + ", name=" + name + ", dept=" + dept + "]";
	}

	public Hospital(String email) {
		super();
		this.email = email;
	}

	
}
