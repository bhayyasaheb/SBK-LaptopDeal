package com.sbk.shoppingbackend.dao;

import java.util.List;

import com.sbk.shoppingbackend.dto.Category;

public interface CategoryDAO {

	// get single category by id
	Category get(int id);

	// get List of All Category
	List<Category> list();

	// add Category
	boolean add(Category category);

	// update category
	boolean update(Category category);

	// delete category
	boolean delete(Category category);
}
