package com.techelevator.ssg.model.store;

import java.util.List;

public class CartItem {

	private int quantity;
	private Product product;
	
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public DollarAmount getTotal(){
		DollarAmount total = new DollarAmount(0);
		DollarAmount temp =new DollarAmount(0);
		for(int i=0; i<quantity; i++){
			
			
			total = total.plus(product.getPrice());
		}
		//System.out.println(total);
		return total;
		
	}
	
	
}
