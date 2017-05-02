package com.sbk.shoppingbackend.dao;

import java.util.List;

import com.sbk.shoppingbackend.dto.Category;

public interface CategoryDAO {

	
	List<Category> list();
	
	Category get(int id);
}
