package com.shopnow.core.users;

import java.util.ArrayList;
import java.util.List;

import com.shopnow.core.ApplicationConstants;
import com.shopnow.core.Shop;
import com.shopnow.core.product.Product;

/**
 * 
 * @author mohamed.thaiseer
 *
 */
public class Customer {

	private long id;
	private String name;
	private int yearsOfMembership;
	private boolean isEmployee;
	private boolean isAffiliate;
	private int offerRate;
	private Shop shop;
	private List<Product> cart;
	private float grossTotal;
	private int totalDiscountPercentage;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYearsOfMembership() {
		return yearsOfMembership;
	}

	public void setYearsOfMembership(int yearsOfMembership) {
		this.yearsOfMembership = yearsOfMembership;
	}

	public boolean isEmployee() {
		return isEmployee;
	}

	public void setEmployee(boolean isEmployee) {
		this.isEmployee = isEmployee;
	}

	public boolean isAffiliate() {
		return isAffiliate;
	}

	public void setAffiliate(boolean isAffiliate) {
		this.isAffiliate = isAffiliate;
	}

	public int getOfferRate() {
		return offerRate;
	}

	public void setOfferRate(int offerRate) {
		this.offerRate = offerRate;
	}

	public List<Product> getCart() {
		return cart;
	}

	public void setCart(List<Product> cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", yearsOfMembership=" + yearsOfMembership + ", isEmployee="
				+ isEmployee + ", isAffiliate=" + isAffiliate + ", offerRate=" + offerRate + "]";
	}

	public static class CustomerBuilder {

		private long id;
		private String name;
		private int yearsOfMembership;
		private boolean isEmployee;
		private boolean isAffiliate;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getYearsOfMembership() {
			return yearsOfMembership;
		}

		public void setYearsOfMembership(int yearsOfMembership) {
			this.yearsOfMembership = yearsOfMembership;
		}

		public boolean isEmployee() {
			return isEmployee;
		}

		public void setEmployee(boolean isEmployee) {
			this.isEmployee = isEmployee;
		}

		public boolean isAffiliate() {
			return isAffiliate;
		}

		public void setAffiliate(boolean isAffiliate) {
			this.isAffiliate = isAffiliate;
		}

		public CustomerBuilder withId(Long id) {
			setId(id);
			return this;
		}

		public CustomerBuilder withName(String name) {
			setName(name);
			return this;
		}

		public CustomerBuilder withYearsOfMemberShip(int years) {
			setYearsOfMembership(years);
			return this;
		}

		public CustomerBuilder withTypeEmployee(boolean isEmployee) {
			setEmployee(isEmployee);
			return this;
		}

		public CustomerBuilder withTypeAffiliate(boolean isAffiliate) {
			setAffiliate(isAffiliate);
			return this;
		}

		public Customer build() {
			Customer customer = null;
			if (isEmployee) {

				customer = new EmployeeCustomer();
				customer.setId(this.getId());
				customer.setName(this.getName());
				customer.setOfferRate(ApplicationConstants.EMPLOYEE_DISCOUNT_RATE);

			} else if (isAffiliate) {
				customer = new AffiliateCustomer();
				customer.setId(this.getId());
				customer.setName(this.getName());
				customer.setOfferRate(ApplicationConstants.AFFILIATE_DISCOUNT_RATE);
			}else {
				customer = new MemberCustomer();
				customer.setId(this.getId());
				customer.setName(this.getName());
				customer.setYearsOfMembership(this.getYearsOfMembership());
				if(this.getYearsOfMembership() >2) {
					  customer.setOfferRate(ApplicationConstants.MEMBER_YEAR_MORE_THAN_TWO_YEAR_DISCOUNT);
				}else {
					  customer.setOfferRate(ApplicationConstants.MEMBER_YEAR_LESS_THAN_TWO_YEAR_DISCOUNT);
				}
				
			}

			return customer;
		}

	}

	public static CustomerBuilder getCustomerBuilder() {
		return new CustomerBuilder();
	}

	public void startSession(Shop shop) {

		this.shop = shop;

	}

	public void addProductToCart(Product product) {

		if (cart == null) {
			cart = new ArrayList<Product>();
		}
		cart.add(product);

	}

}
