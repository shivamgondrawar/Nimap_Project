package com.nimap.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nimap.demo.entity.Category;
import com.nimap.demo.entity.Product;
import com.nimap.demo.repository.CategoryRepository;
import com.nimap.demo.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	CategoryRepository cateRepository;
	@Autowired
	ProductRepository prodRepository;
	//GET_Page
	public List<Product> getProductPage(int page, int pageSize) {
		Pageable p=PageRequest.of(page, pageSize);
		Page<Product> prodPage=prodRepository.findAll(p);
		return prodPage.getContent();
	}
	//POST
	public Product postProduct(Product prod) {
		Category cate=cateRepository.findBycateId(prod.getCate().getCateId());
		prod.setCate(cate);
		return prodRepository.save(prod);
	}
	//GET_ID
	public Product getProductId(int prodId) {
		return prodRepository.findById(prodId).get();
	}
	//PUT
	public Product putProduct(Product prod, int prodId) {
		Product p=prodRepository.findById(prodId).get();
		p.setProdName(prod.getProdName());
		Category c=cateRepository.findBycateId(prod.getCate().getCateId());
		p.setCate(c);
		return prodRepository.save(p);
	}
	//DELETE
	public void deleteProduct(int prodId) {
		prodRepository.deleteById(prodId);
	}
	
}
