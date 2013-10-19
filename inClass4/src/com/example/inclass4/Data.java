package com.example.inclass4;
/*
 * Mrunal Nargunde
 * In class assignment 4
 * */
public class Data{

	String name,price,imageUrl;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	@Override
	public String toString() {
		return "Data [name=" + name + ", price=" + price + " imageurl = " + imageUrl+ "]";
	}


	
	
	}
