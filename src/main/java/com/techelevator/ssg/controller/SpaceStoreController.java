package com.techelevator.ssg.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.ssg.model.store.JdbcProductDao;
import com.techelevator.ssg.model.store.Product;

@Controller
@RequestMapping("/sapceStore")
@SessionAttributes("shoppingCart")
public class SpaceStoreController {
	
	JdbcProductDao productDao;
	
	@RequestMapping(path={"/"}, method=RequestMethod.GET)
	public String displayPersonalInformationInput(HttpServletRequest request) {
		
		List<Product> products = productDao.getAllProducts();
		
		request.setAttribute("products", products);
		
		return "spaceStore";
	}
	
	

}
