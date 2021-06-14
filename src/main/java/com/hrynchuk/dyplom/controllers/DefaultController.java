package com.hrynchuk.dyplom.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hrynchuk.dyplom.dao.ProductDAO;
import com.hrynchuk.dyplom.entity.Product;
import com.hrynchuk.dyplom.utils.ImageUtil;

@Controller
public class DefaultController {
	
	@Autowired
	private ProductDAO productDAO;
	
	@GetMapping(value = {"/", "/index"})
	public String index(Model model) {
		
		List<Product> productList = productDAO.getAll();
		
		model.addAttribute("products", productList);
		model.addAttribute("imgUtil", new ImageUtil());
		
		return "/index";
	}
}
