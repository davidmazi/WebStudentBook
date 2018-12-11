package com.WebStudentBook.web;

import java.io.Serializable;
import java.util.*;
import javax.faces.bean.*;
import javax.faces.context.*;

@ManagedBean // register the class student as JSF resource
@SessionScoped // creates an instance of Student for each user request

public class StudentManager implements Serializable {

	private static final long serialVersionUID = 1L;

	List<Student> students;

	StudentDbUtil studentDbUtil = new StudentDbUtil();

	public StudentManager() {
		students = new ArrayList<Student>();
	}

	public List<Student> getStudents() {
		return students;
	}

	public void loadStudents() {
		try {
			students = studentDbUtil.getStudents();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addStudent(Student stu) {
		studentDbUtil.addStudent(stu);
	}


	public String loadStudent(int id) {
		Student theStudent = studentDbUtil.fetchStudent(id);
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		Map<String, Object> requestMap = externalContext.getRequestMap();
		requestMap.put("student", theStudent);
		return "Edit-student";
	}

	public String updateStudent(Student student) {
		studentDbUtil.updateStudent(student);
		return "List-students";
	}

	public void deleteStudent(int id) {
		studentDbUtil.deleteStudent(id);
	}
}
