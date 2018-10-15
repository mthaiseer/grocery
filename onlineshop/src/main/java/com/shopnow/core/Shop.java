package com.shopnow.core;

import java.util.List;

import com.shopnow.core.product.Product;
import com.shopnow.core.users.Customer;
/**
 * This class is master class which manage Products and Users
 * @author mohamed.thaiseer
 *
 */
public class Shop {
	
	private static final String GROCERY = "Grocery";
	private Customer customer;
	
	/**
	 * 
	 * @param customer
	 */
	public void login(Customer customer) {
		this.customer = customer;
		
	}
	
	/**
	 * This method used to checkout and generate net payable amount
	 * @param cart
	 * @return
	 */
	public float checkout(List<Product> cart) {
		System.out.println("Offer with customer "+ customer.getOfferRate());
		if (cart != null && cart.size() > 0) {
			
			float grossTotal = 0;
			for(Product product: cart) {
				grossTotal = calculatePercentageDiscount(grossTotal, product);
				
			}
			
			//For every $100 on the bill, there would be a $ 5 discount (e.g. for $ 990, you get $ 45
			//		as a discount).
			int cashDiscount = (int) (grossTotal/100)*5;
			return grossTotal - cashDiscount;
		}

		return 0.0f;
	}

	/**
	 * Calculate percentage discount based on user
	 *  1. If the user is an employee of the store, he gets a 30% discount
	    2. If the user is an affiliate of the store, he gets a 10% discount
		3. If the user has been a customer for over 2 years, he gets a 5% discount.
	 * @param grossTotal
	 * @param product
	 * @return
	 */
	private float calculatePercentageDiscount(float grossTotal, Product product) {
		//if Item is grocery, percentage discount not applied
		if(product.getCategory().getName().equals(GROCERY)) {
			grossTotal += product.getUnitPrice();
		}else {
			//calculate percentage 
			int percentage = 100 - customer.getOfferRate();
			grossTotal+= (percentage * product.getUnitPrice())/100;
		}
		return grossTotal;
	}


}
