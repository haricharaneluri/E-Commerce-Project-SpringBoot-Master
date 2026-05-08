package com.jtspringproject.JtSpringProject.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jtspringproject.JtSpringProject.models.Category;

@Repository
public class categoryDao {
	private final SessionFactory sessionFactory;

	public categoryDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public Category addCategory(String name) {
		Category category = new Category();
		category.setName(name);
		this.sessionFactory.getCurrentSession().saveOrUpdate(category);
		return category;
	}

	@Transactional
	public List<Category> getCategories() {
		return this.sessionFactory.getCurrentSession().createQuery("from CATEGORY", Category.class).list();
	}

	@Transactional
	public Boolean deleteCategory(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Category category = session.get(Category.class, id);

		if (category != null) {
			session.delete(category);
			return true;
		}
		return false;
	}

	@Transactional
	public Category updateCategory(int id, String name) {
		Category category = this.sessionFactory.getCurrentSession().get(Category.class, id);
		if (category == null) {
			return null;
		}
		category.setName(name);

		this.sessionFactory.getCurrentSession().update(category);
		return category;
	}

	@Transactional
	public Category getCategory(int id) {
		return this.sessionFactory.getCurrentSession().get(Category.class, id);
	}
}
