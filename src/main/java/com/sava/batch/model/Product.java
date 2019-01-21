package com.sava.batch.model;

public class Product {
	private Integer product_id;
	private String name;
	private String condition;
	private String state;
	private Float price;

	public Product() {
	}

	public Product(Integer product_id, String name, String condition, String state, Float price) {
		this.product_id = product_id;
		this.name = name;
		this.condition = condition;
		this.state = state;
		this.price = price;
	}

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", name=" + name + ", condition=" + condition + ", state=" + state
				+ ", price=" + price + "]";
	}

}
