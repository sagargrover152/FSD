package com.ibm.takehome.bean;

public class Products {
	int productId;
	String productName;
	int productPrice;
	int productQuantity;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public String toString() {
		return getProductId() + "\t" + getProductName() + "\t" + getProductPrice() + "\t" + getProductQuantity();
	}
}
