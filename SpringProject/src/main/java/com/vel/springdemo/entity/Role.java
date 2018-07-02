package com.vel.springdemo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(schema = "bbs", name = "role")
public class Role {

	 @Id
	   @SequenceGenerator(name = "bbsSeq", sequenceName = "BBS.BBS_SEQ")
	   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bbsSeq")
	   @Column(name = "ID")
	   private Long id;

	   @Column(name = "DESCRIPTION")
	   private String description;

	   @Column(name = "ACTIVE")
	   @Type(type = "yes_no")
	   private boolean active;

	   @Column(name = "MOD_USER")
	   private String modUser = "BBS_USER";

	   @Column(name = "MOD_DATE")
	   private Date modDate = new Date();

	   
	   
	@Override
	public String toString() {
		return "Role [id=" + id + ", description=" + description + ", active=" + active + ", modUser=" + modUser
				+ ", modDate=" + modDate + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getModUser() {
		return modUser;
	}

	public void setModUser(String modUser) {
		this.modUser = modUser;
	}

	public Date getModDate() {
		return modDate;
	}

	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}
	
	   
}
