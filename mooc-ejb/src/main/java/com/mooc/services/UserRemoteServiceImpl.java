package com.mooc.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import com.mooc.domain.Person;

@Stateless
public class UserRemoteServiceImpl extends GenericRemoteService<Person> implements UserRemoteService {

	public UserRemoteServiceImpl() {
		super(Person.class);
	}

	@Override
	public Person findUser(String email, String password) {
		TypedQuery<Person> q = entityManager
				.createQuery("select u from Person u where u.email=?0 and u.password=?1", Person.class)
				.setParameter(0, email).setParameter(1, password);
		List<Person> list = q.getResultList();
		if (list.isEmpty()) {
			return null;
		}
		Person person = findUserById(list.get(0).getId()); 
		
		return person;
	}

	@Override
	public Person findUserById(Integer id) {
		// TODO Auto-generated method stub
		
		return entityManager.find(Person.class, id);
	}

}
