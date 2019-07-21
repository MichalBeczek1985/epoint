package com.example.epoint.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.epoint.dao.ProductsDAO;
import com.example.epoint.model.Products;

@RestController
public class FormController {

	@Autowired
	private ProductsDAO productsDAO;

	@GetMapping("/")
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		List<Products> list = productsDAO.list();
		mav.addObject("products", list);
		return mav;
	}

	@GetMapping("/add")
	public ModelAndView addProduct(@RequestParam("productId") int id, Model model) {
		ModelAndView mav = new ModelAndView();
		if (id==0) {
		
		mav.setViewName("addProduct");
		mav.addObject("product", new Products());
		}
		else {
			mav.setViewName("addProduct");
			mav.addObject("product",productsDAO.get(id));
			System.out.println("existed");
		}
		return mav;
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public String submit(@RequestParam("checkboxName")int[] checkboxValue, HttpServletRequest request, HttpServletResponse response) throws Exception {
		for(int i : checkboxValue) {
			productsDAO.delete(i);
		}

		return "successMember";
	}

	@PostMapping("/saveProduct")
		public ModelAndView save(@ModelAttribute("product") Products product) {
			
			productsDAO.saveOrUpdate(product);
			return homePage();
		}
		
	
	/*
	 * @PostMapping("/addContact") public ModelAndView
	 * save(@ModelAttribute("products") @Valid Products contact,BindingResult
	 * results, ModelAndView model) {
	 * 
	 * if (results.hasErrors()) { model.setViewName("index");
	 * model.addObject("contact", contact); return model;}
	 * contactDAO.saveOrUpdate(contact);
	 * 
	 * return new ModelAndView("index"); }
	 */

}
