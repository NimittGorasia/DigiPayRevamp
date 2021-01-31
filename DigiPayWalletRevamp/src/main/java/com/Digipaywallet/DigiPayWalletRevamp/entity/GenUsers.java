package com.Digipaywallet.DigiPayWalletRevamp.entity;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the gen_users database table.
 * 
 */
@Entity
@Table(name="gen_users")
@NamedQuery(name="GenUsers.findAll", query="SELECT g FROM GenUsers g")
public class GenUsers implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="users_id")
	private long usersId;

	@Column(name="created_on")
	private Date createdOn;

	private String email;

	@Column(name="user_name")
	private String userName;

	private String isactive;

	@Column(name="last_login")
	private Date lastLogin;

	private String password;

	private int phone;

	public GenUsers() {
		// empty constructor
	}

	public long getUsersId() {
		return this.usersId;
	}

	public void setUsersId(long usersId) {
		this.usersId = usersId;
	}

	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getIsactive() {
		return this.isactive;
	}

	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}

	public Date getLastLogin() {
		return this.lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPhone() {
		return this.phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

}