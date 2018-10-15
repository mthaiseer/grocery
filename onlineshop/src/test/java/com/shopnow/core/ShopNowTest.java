package com.shopnow.core;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;

import com.shopnow.core.product.Category;
import com.shopnow.core.product.Product;
import com.shopnow.core.users.Customer;
import com.shopnow.core.users.Customer.CustomerBuilder;


public class ShopNowTest {

	@Test
	public void test_all_cases_success() {

		Shop shop = new Shop();
		Customer customer = createEmployeeCustomer();
		shop.login(customer);
		customer.startSession(shop);

		customer.addProductToCart(rice());
		customer.addProductToCart(mobile());
		
		float expectedPayableAmount = 340.0f;
		float netPayableAmount = shop.checkout(customer.getCart());
		
		System.out.println("Total payable amount1 : " + netPayableAmount);
		assertNotNull(customer.getCart());
		assertEquals(expectedPayableAmount, netPayableAmount, 0);
	}
	
	@Test
	public void test_regular_member_purchase() {

		Shop shop = new Shop();
		Customer customer = createNormalMemberCustomer();
		shop.login(customer);
		customer.startSession(shop);

		float expectedPayableAmount = 480.0f;
		customer.addProductToCart(rice());
		customer.addProductToCart(mobile());
		
		float netPayableAmount = shop.checkout(customer.getCart());
		System.out.println("Total payable amount by member : " + netPayableAmount);
		assertNotNull(customer.getCart());
		assertEquals(expectedPayableAmount, netPayableAmount, 0);
	}
	
	@Test
	public void test_Affiliate_member_purchase() {

		Shop shop = new Shop();
		Customer customer = createAffiliateCustomer();
		shop.login(customer);
		customer.startSession(shop);

		customer.addProductToCart(rice());
		customer.addProductToCart(mobile());
		
		float expectedPayableAmount = 435.0f;
		
		float netPayableAmount = shop.checkout(customer.getCart());
		System.out.println("Total payable amount by affiliate member : " + netPayableAmount);
		assertNotNull(customer.getCart());
		assertEquals(expectedPayableAmount, netPayableAmount, 0);
	}
	
	@Test
	public void test_Normal_user_grocery_purchase() {
		
		Shop shop = new Shop();
		Customer customer = createNormalMemberCustomer();
		shop.login(customer);
		customer.startSession(shop);
		
		float expectedPayableAmount = 945.0f;
		
		customer.addProductToCart(tablet());
		
		float netPayableAmount = shop.checkout(customer.getCart());
		System.out.println("Total payable amount by normal member : " + netPayableAmount);
		assertNotNull(customer.getCart());
		assertEquals(expectedPayableAmount, netPayableAmount, 0);
		
	}
	

	private Product rice() {

		Category category = new Category();
		category.setId(100);
		category.setName("Grocery");

		Product product = new Product();
		product.setCategory(category);
		product.setId(1000);
		product.setProductName("rice");
		product.setUnitPrice(5.0F);

		return product;
	}

	private Product mobile() {

		Category category = new Category();
		category.setId(101);
		category.setName("Electronics");

		Product product = new Product();
		product.setCategory(category);
		product.setId(1001);
		product.setProductName("nokia");
		product.setUnitPrice(500.0F);

		return product;
	}
	
	private Product tablet() {

		Category category = new Category();
		category.setId(101);
		category.setName("Electronics");

		Product product = new Product();
		product.setCategory(category);
		product.setId(1001);
		product.setProductName("nokia");
		product.setUnitPrice(990.0F);

		return product;
	}

	private Customer createEmployeeCustomer() {
		CustomerBuilder customerBuilder = Customer.getCustomerBuilder();
		return customerBuilder.withId(100L)
				.withName("thaiseer")
				.withTypeEmployee(true)
				.build();

	}
	
	private Customer createAffiliateCustomer() {
		CustomerBuilder customerBuilder = Customer.getCustomerBuilder();
		return customerBuilder.withId(100L)
				.withName("thaiseer")
				.withTypeAffiliate(true)
				.build();

	}
	
	private Customer createNormalMemberCustomer() {
		CustomerBuilder customerBuilder = Customer.getCustomerBuilder();
		return customerBuilder.withId(100L)
				.withName("thaiseer")
				.withYearsOfMemberShip(0)
				.build();

	}
	
	private Customer createPermenantMemberCustomer() {
		CustomerBuilder customerBuilder = Customer.getCustomerBuilder();
		return customerBuilder.withId(100L)
				.withName("thaiseer")
				.withYearsOfMemberShip(0)
				.build();

	}

}
