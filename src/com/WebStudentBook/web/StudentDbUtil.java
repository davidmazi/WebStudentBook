package com.WebStudentBook.web;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

public class StudentDbUtil {

	private static final String PERSISTENCE_UNIT_NAME = "JSFJPA";
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	private static EntityManager em = factory.createEntityManager();

	@SuppressWarnings("unchecked")
	public List<Student> getStudents() {
		List<Student> results = new ArrayList<Student>();
		try {
			results = em.createQuery("SELECT s FROM Student s").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return results;
	}

	public void addStudent(Student student) {
		Student newStudent = new Student(student.getFirstname(),student.getLastname(),student.getEmail());
		try {
			em.getTransaction().begin();
			em.persist(newStudent);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Student fetchStudent(int id) {
		Student studentEntity = em.find(Student.class, id);
		return studentEntity;
	}

	public void updateStudent(Student stu) {
		String fn = stu.getFirstname();
		String ln = stu.getLastname();
		String ema = stu.getEmail();
		int i= stu.getId();
		Student studentEntity = em.find(Student.class, i);
		try {
		em.getTransaction().begin();
		studentEntity.setFirstname(fn);
		studentEntity.setLastname(ln);
		studentEntity.setEmail(ema);
		em.getTransaction().commit();
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void deleteStudent(int id) {
		Student student = em.find(Student.class, id);
		try {
			em.getTransaction().begin();
			em.remove(student);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}