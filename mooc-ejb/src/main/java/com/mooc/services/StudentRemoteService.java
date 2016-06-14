package com.mooc.services;

import javax.ejb.Remote;

import com.mooc.domain.Student;

@Remote
public interface StudentRemoteService extends EntityRemoteService<Student> {

	Student findStudentById(Integer id);
}
