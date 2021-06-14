package com.hrynchuk.dyplom.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hrynchuk.dyplom.dao.ProductDAO;
import com.hrynchuk.dyplom.entity.Product;
import com.hrynchuk.dyplom.entity.ProductForm;
import com.hrynchuk.dyplom.utils.ImageUtil;


@Controller
@RequestMapping("/stuff")
public class StuffController {
	@Autowired
	ProductDAO productDAO;
	@GetMapping("/newStuff")
	public String newSutff(Model model) {
		model.addAttribute("product", new ProductForm());
		
		return "/newStuff";
	}
	
	@GetMapping("/view{id}")
	public String viewStuff(@PathVariable("id") int id, Model model) {
		model.addAttribute("product", productDAO.findById(id));
		model.addAttribute("imgUtil", new ImageUtil());
		
		return "/viewStuff";
	}
	
	@PostMapping()
	public String newStuff(@ModelAttribute("product") ProductForm productForm) {
		
		Product product = new Product();
		
		product.setName(productForm.getName());
		product.setPrice(productForm.getPrice());
		product.setDescription(productForm.getDescription());
		try {
			product.setImage(productForm.getFileData().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		productDAO.save(product);
		
		return "redirect:";
	}
}
