package com.shopnow.core.users;
/**
 * 
 * @author mohamed.thaiseer
 *
 */
public class AffiliateCustomer extends Customer {

	private int offerRate;

	@Override
	public void setOfferRate(int offerRate) {
		this.offerRate =  offerRate;

	}
	
	public int getOfferRate() {
		return offerRate;
	}
}
