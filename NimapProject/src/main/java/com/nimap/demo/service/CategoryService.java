package com.nimap.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nimap.demo.entity.Category;
import com.nimap.demo.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository cateRepository;
	//GET_Page
	public List<Category> getCategoryPage(int page, int pageSize) {
		Pageable p=PageRequest.of(page, pageSize);
		Page<Category> catePage=cateRepository.findAll(p);
		return catePage.getContent();
	}
	//POST
	public Category postCategory(Category cate) {
		return cateRepository.save(cate);
	}
	//GET_ID
	public Category getCategoryId(int cateId) {
		return cateRepository.findById(cateId).get();
	}
	//PUT
	public Category putCategory(Category cate, int cateId) {
		Category c=cateRepository.findById(cateId).get();
		c.setCateName(cate.getCateName());
		return cateRepository.save(c);
	}
	//DELETE
	public void deleteCategory(int cateId) {
		cateRepository.deleteById(cateId);
	}
}
