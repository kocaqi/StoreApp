package com.localweb.thelogin.thelogin.controller;

import com.localweb.thelogin.thelogin.entities.Product;
import com.localweb.thelogin.thelogin.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping("/")
	public String showProducts(Model model) {

		List<Product> products = productService.findAll();
		model.addAttribute("products", products);

		return "product/products";
	}

	@GetMapping("/add")
	public String showAddForm(Model model){
		Product product = new Product();
		model.addAttribute("product", product);
		return "product/product-form";
	}

	@PostMapping("/saveProduct")
	public String saveProduct(@ModelAttribute("product") Product product){
		product.setDateCreated(LocalDate.now());
		product.setDateUpdated(LocalDate.now());
		productService.save(product);
		return "redirect:/products/";
	}

}
