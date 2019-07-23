package com.example.epoint.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.epoint.dao.ProductsDAO;
import com.example.epoint.model.Products;

@RestController
public class FormController {

	private static final Logger logger = LogManager.getLogger(FormController.class);

	
	@Autowired
	private ProductsDAO productsDAO;

	@GetMapping("/")
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		List<Products> list = productsDAO.list();
		mav.addObject("products", list);
		logger.debug("Log from home controller");

		return mav;
	}

	 @Autowired
     private MessageSource messageSource;
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
		}
		return mav;
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView submit(@RequestParam(value="checkboxName", required = false)int[] checkboxValue, HttpServletRequest request, HttpServletResponse response,
			HttpServletRequest httpServletRequest,Locale locale, RedirectAttributes redirectAttributes) throws Exception {
		if (checkboxValue==null) {
			redirectAttributes.addFlashAttribute("WARNING_MESSAGE", messageSource.getMessage("label_checked_error", 
					new String[] {""}, locale));
			return new ModelAndView("redirect:/"); 
		}
		else {
		for(int i : checkboxValue) {
			productsDAO.delete(i);
		}
		redirectAttributes.addFlashAttribute("WARNING_MESSAGE", messageSource.getMessage("label_checked_delete", 
				new String[] {""}, locale));
		return new ModelAndView("redirect:/"); 
		}
	}

	@PostMapping("/saveProduct")
		public ModelAndView save(@ModelAttribute("product") @Valid Products product, BindingResult results,ModelAndView model,
				HttpServletRequest httpServletRequest,Locale locale, RedirectAttributes redirectAttributes) {
		if (results.hasErrors()) {
			redirectAttributes.addFlashAttribute("SUCCESS_MESSAGE", messageSource.getMessage("label_price_error", 
					new String[] {""}, locale));
			model.setViewName("redirect:/add?productId="+product.getId()); 
			return model;
			
			}
		else {
			productsDAO.saveOrUpdate(product);
			redirectAttributes.addFlashAttribute("SUCCESS_MESSAGE", messageSource.getMessage("label_user_saved_successfully", 
					new String[] {product.getName()}, locale));
	        return new ModelAndView( "redirect:/");}
		}
		

}
