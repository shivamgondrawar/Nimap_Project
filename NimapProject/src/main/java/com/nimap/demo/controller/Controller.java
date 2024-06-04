package com.nimap.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nimap.demo.entity.Category;
import com.nimap.demo.entity.Product;
import com.nimap.demo.service.CategoryService;
import com.nimap.demo.service.ProductService;

@RestController
public class Controller {
	@Autowired
	CategoryService cateService;
	@Autowired
	ProductService prodService;
	
	//======Category======
	//GET_Page
	@GetMapping("/api/categories")
	public List<Category> getCategoryByPage(@RequestParam (value="page", defaultValue = "0", required = false)int page){
		return cateService.getCategoryPage(page, 1);
	}
	//POST
	@PostMapping("/api/categories")
	public Category insertCategory(@RequestBody Category cate) {
		return cateService.postCategory(cate);
	}
	//GET_ID
	@GetMapping("/api/categories/{di}")
	public Category getCategoryById(@PathVariable("di") int cateId) {
		return cateService.getCategoryId(cateId);
	}
	//PUT
	@PutMapping("/api/categories/{di}")
	public Category updateCategoryId(@RequestBody Category cate, @PathVariable("di") int cateId) {
		return cateService.putCategory(cate, cateId);
	}
	//DELETE
	@DeleteMapping("/api/categories/{di}")
	public void deleteCategoryId(@PathVariable("di") int cateId) {
		cateService.deleteCategory(cateId);
	}
	
	//======Product======
	//GET_Page
	@GetMapping("/api/products")
	public List<Product> getProductByPage(@RequestParam (value="page", defaultValue = "0", required = false)int page){
		return prodService.getProductPage(page, 1);
	}
	//POST
	@PostMapping("/api/products")
	public Product insertProduct(@RequestBody Product prod) {
		return prodService.postProduct(prod);
	}
	//GET_ID
	@GetMapping("/api/products/{di}")
	public Product getProductById(@PathVariable("di") int prodId) {
		return prodService.getProductId(prodId);
	}
	//PUT
	@PutMapping("/api/products/{di}")
	public Product updateProductId(@RequestBody Product prod, @PathVariable("di") int prodId) {
		return prodService.putProduct(prod, prodId);
	}
	//DELETE
	@DeleteMapping("/api/products/{di}")
	public void deleteProductId(@PathVariable("di") int prodId) {
		prodService.deleteProduct(prodId);
	}
}
