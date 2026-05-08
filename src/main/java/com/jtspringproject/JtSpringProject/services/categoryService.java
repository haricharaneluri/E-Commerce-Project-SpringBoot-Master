package com.jtspringproject.JtSpringProject.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jtspringproject.JtSpringProject.dao.categoryDao;
import com.jtspringproject.JtSpringProject.models.Category;

@Service
public class categoryService {
	private final categoryDao categoryDao;

	public categoryService(categoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	public Category addCategory(String name) {
		return this.categoryDao.addCategory(name);
	}

	public List<Category> getCategories() {
		return this.categoryDao.getCategories();
	}

	public Boolean deleteCategory(int id) {
		return this.categoryDao.deleteCategory(id);
	}

	public Category updateCategory(int id, String name) {
		return this.categoryDao.updateCategory(id, name);
	}

	public Category getCategory(int id) {
		return this.categoryDao.getCategory(id);
	}
}
