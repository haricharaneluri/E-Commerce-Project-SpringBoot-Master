package com.jtspringproject.JtSpringProject.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jtspringproject.JtSpringProject.models.User;

@Repository
public class userDao {
	private final SessionFactory sessionFactory;

	public userDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<User> getAllUser() {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from CUSTOMER", User.class).list();
	}

	@Transactional
	public User saveUser(User user) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(user);
		return user;
	}

	@Transactional
	public boolean userExists(String username) {
		Query<User> query = sessionFactory.getCurrentSession().createQuery("from CUSTOMER where username = :username",
				User.class);
		query.setParameter("username", username);
		return !query.getResultList().isEmpty();
	}

	@Transactional
	public User getUserByUsername(String username) {
		Query<User> query = sessionFactory.getCurrentSession().createQuery("from CUSTOMER where username = :username",
				User.class);
		query.setParameter("username", username);

		try {
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Transactional
	public User getUserById(int id) {
		return this.sessionFactory.getCurrentSession().get(User.class, id);
	}
}