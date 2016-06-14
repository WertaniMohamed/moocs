package com.mooc.services;

import javax.ejb.Stateless;

import com.mooc.domain.Student;

@Stateless
public class StudentRemoteServiceImpl extends GenericRemoteService<Student> implements StudentRemoteService {

	public StudentRemoteServiceImpl() {
		super(Student.class);
	}

	@Override
	public Student findStudentById(Integer id) {
		// TODO Auto-generated method stub

		return entityManager.find(Student.class, id);
	}

}
