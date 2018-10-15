package com.shopnow.core.product;

/**
 * 
 * @author mohamed.thaiseer
 *
 */
public class Product {
	
	private long id;
	private Category category;
	private String productName;
	private float unitPrice;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public float getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", category=" + category + ", productName=" + productName + ", unitPrice="
				+ unitPrice + "]";
	}
	
	
	

}
