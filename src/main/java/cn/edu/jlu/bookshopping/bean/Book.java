package cn.edu.jlu.bookshopping.bean;

import java.io.Serializable;

public class Book implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id ;
	private String name ;
	private float price;
	private String author;
	private int stock_number;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getStock_number() {
		return stock_number;
	}
	public void setStock_number(int stock_number) {
		this.stock_number = stock_number;
	}
	public float getSum() {
		return this.stock_number * this.price;
	}

	
}
