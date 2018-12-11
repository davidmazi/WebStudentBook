package com.WebStudentBook.web;

import java.io.Serializable;

import javax.faces.bean.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "studenttable")

@ManagedBean // register the class student as JSF resource
@RequestScoped // creates an instance of Student for each user request
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	int id;
	String firstname;
	String lastname;
	String email;

	public Student() {
	}

	public Student(int id, String fn, String ln, String e) {
		this.id = id;
		firstname = fn;
		lastname = ln;
		email = e;
	}

	public Student(String fn, String ln, String e) {
		firstname = fn;
		lastname = ln;
		email = e;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String name) {
		this.firstname = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String name) {
		this.lastname = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
