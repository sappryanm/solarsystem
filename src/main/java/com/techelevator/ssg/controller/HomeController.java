package com.techelevator.ssg.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLEngineResult.Status;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.techelevator.ssg.model.forum.ForumDao;
import com.techelevator.ssg.model.forum.ForumPost;
import com.techelevator.ssg.model.forum.JdbcForumDao;
import com.techelevator.ssg.model.store.CartItem;
import com.techelevator.ssg.model.store.JdbcProductDao;
import com.techelevator.ssg.model.store.Product;
import com.techelevator.ssg.model.store.ProductDao;

@Controller
@SessionAttributes("cart")
public class HomeController {

	@Autowired
	ForumDao forumDAO;
	@Autowired
	ProductDao productDAO;
	
	@RequestMapping("/")
	public String displayHomePage() {
		return "homePage";
	}
	
	@RequestMapping("/alienWeight")
	public String handleAlienWeight(){
		
		
		return "alienWeight";
	}
	
	//--------------------------------------------------------------------------------
	@RequestMapping(path="/spaceForumInput", method=RequestMethod.GET)
	public String handlespaceForumInput(){
		
		return "spaceForumInput";
	}
	@RequestMapping(path="/spaceForumInput", method=RequestMethod.POST)
	public String handlespaceForumInputSubmission(@RequestParam String username,
												@RequestParam String subject,
												@RequestParam String message){

			ForumPost post = new ForumPost();
			post.setMessage(message);
			post.setUsername(username);
			post.setSubject(subject);
			post.setDatePosted(LocalDateTime.now());
			forumDAO.save(post);
		return "redirect:/spaceForumResult";
	}
	
	@RequestMapping("/spaceForumResult")
	public String handleSpaceResult(HttpServletRequest request){
		
		List<ForumPost> posts = forumDAO.getAllPosts();
		request.setAttribute("posts", posts);
		
		return "spaceForumResult";
		
	}
	
	//--------------------------------------------------------------------------------

	@RequestMapping("/alienWeightResult")
	public String handleAlienWeightResult(HttpServletRequest request){
		
		Map<String, Double> gravAccel = new HashMap<String, Double>();
		gravAccel.put("mercury", 3.59);
		gravAccel.put("venus", 8.87);
		gravAccel.put("earth", 9.81);
		gravAccel.put("mars", 3.77);
		gravAccel.put("jupiter", 25.95);
		gravAccel.put("saturn", 11.08);
		gravAccel.put("uranus", 10.67);
		gravAccel.put("neptune", 14.07);
		gravAccel.put("pluto", 0.42);
		
		String plannet = request.getParameter("plannet");
		Double weight = Double.valueOf(request.getParameter("weight"))/2.2;
		
		Double mass = weight/9.81;
		Double grav = gravAccel.get(plannet);
		
		Double spaceWeight = (double)Math.round(grav*mass*2.2);
		request.setAttribute("spaceWeight", spaceWeight);
		return "alienWeightResult";
	}
	
	@RequestMapping("/alienAge")
	public String handleAlienAge(){
		
		
		return "alienAge";
	}
	
	@RequestMapping("/alienAgeResult")
	public String handleAlienAgeResult(HttpServletRequest request){
		
		Map<String, Double> orbitalDays = new HashMap<String, Double>();
		orbitalDays.put("mercury", 87.96);
		orbitalDays.put("venus", 224.68);
		orbitalDays.put("earth", 365.26);
		orbitalDays.put("mars", 686.98);
		orbitalDays.put("jupiter", 4332.49);
		orbitalDays.put("saturn", 10758.98);
		orbitalDays.put("uranus", 32533.69);
		orbitalDays.put("neptune", 60198.29);
		orbitalDays.put("pluto", 90474.72);
		
		String plannet = request.getParameter("plannet");
		Double earthAge = Double.valueOf(request.getParameter("age"));
		
	
		Double plannetDays = orbitalDays.get(plannet);
		Double spaceAge = (double)Math.round(earthAge*365.26/plannetDays);
		
		request.setAttribute("spaceAge", spaceAge);
		
		return "alienAgeResult";
	}
	
	@RequestMapping("/travelTime")
	public String handleTravelTime(){
		
		
		return "travelTime";
	}
	
	@RequestMapping("/travelTimeResult")
	public String handleTravelTimeResult(HttpServletRequest request){
		
		Map<String, Double> speedMap = new HashMap<String, Double>();
		speedMap.put("walking", 3.0);
		speedMap.put("car", 100.);
		speedMap.put("bulletTrain", 200.);
		speedMap.put("boeing", 570.);
		speedMap.put("concorde", 1350.);
		
		Map<String, Double> spaceDistance = new HashMap<String, Double>();
		spaceDistance.put("mercury", 56974146.);
		spaceDistance.put("venus", 25724767.);
		spaceDistance.put("earth", 0.00);
		spaceDistance.put("mars", 48678219.);
		spaceDistance.put("jupiter", 390674710.);
		spaceDistance.put("saturn", 792248270.);
		spaceDistance.put("uranus", 1692662530.);
		spaceDistance.put("neptune", 2703959960.);
		
		String plannet = request.getParameter("plannet");
		String travelMethod = request.getParameter("travelMethod");
		
		Double time = spaceDistance.get(plannet)/speedMap.get(travelMethod);
		Double totalTime = (double) Math.round(Double.valueOf(request.getParameter("age") + time));
		
		request.setAttribute("travelTime", time);
		request.setAttribute("travelAge", totalTime);
		
		return "travelTimeResult";
	}

	@RequestMapping("/productList")
	public String displayProductList(HttpServletRequest request) {
		List<Product> products = new ArrayList<Product>(productDAO.getAllProducts());
		
		
		request.setAttribute("products", products);
		
		
		return "productList";
	}
	
	@RequestMapping(path="/productDetail")
	public String productDetail(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			
			String productIdParam = request.getParameter("productId");			
			Long Id = Long.parseLong(productIdParam);
			request.setAttribute("product", productDAO.getProductById(Id));
			return "productDetail";
			
			
		} catch (NumberFormatException | IndexOutOfBoundsException e) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
	}
	@RequestMapping(path="/shoppingCart", method=RequestMethod.GET)
	public String handleShoppingCartView(){ 
	
		
		return "shoppingCart";
	}
	
	
	@RequestMapping(path="/shoppingCart", method=RequestMethod.POST)
	public String handleShoppingCartRedirect(@RequestParam Long productId, 
									@RequestParam int quantity, 
									ModelMap map){
		
		Product product = productDAO.getProductById(productId);
		CartItem item = new CartItem();
		item.setProduct(product);
		item.setQuantity(quantity);
		
		List<CartItem> items = (List<CartItem>)map.get("cart");
		if(items == null) {
			items = new ArrayList<CartItem>();
		}
		
		items.add(item);
		
		map.addAttribute("cart", items);
		
		return "redirect:/shoppingCart";
	}
	@RequestMapping(path="/endsession", method=RequestMethod.GET)
	public String nextHandling(SessionStatus status) {
	status.setComplete();
	return "endsession";
	}
	

}
