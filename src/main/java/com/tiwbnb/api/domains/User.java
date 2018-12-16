package com.tiwbnb.api.domains;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	private String email;
	private String name;
	private String surname;
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	private boolean admin;
	
	@OneToMany (mappedBy="owner", cascade=CascadeType.REMOVE, orphanRemoval = true)
	Set<House> houses = new LinkedHashSet<House>();
	
	@OneToMany (mappedBy="invoiced", cascade=CascadeType.REMOVE, orphanRemoval = true)
	Set<Transaction> transactions = new LinkedHashSet<Transaction>();
	
	@OneToMany (mappedBy="receiver", cascade=CascadeType.REMOVE, orphanRemoval = true)
	Set<Message> messagesReceived = new LinkedHashSet<Message>();
	
	@OneToMany (mappedBy="sender", cascade=CascadeType.REMOVE, orphanRemoval = true)
	Set<Message> messagesSent = new LinkedHashSet<Message>();

	public User() {
	}
	
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean isAdmin) {
		this.admin = isAdmin;
	}
	
	public Long getId() {
		return this.id;
	}


}