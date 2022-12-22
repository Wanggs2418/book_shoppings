package cn.edu.jlu.bookshopping.bean;

import java.util.ArrayList;
import java.util.Iterator;

public class ShoppingCart {
	/**
	 *购物车动态数组,Book容器
	 */
	private ArrayList<Book> cart;
	private float total;
	/*
	 * private float total;
	 */
	public ShoppingCart() {
		cart = new ArrayList<Book>();
	}

	/**
	 *构造方法
	 */
	public ArrayList<Book> getCart() {
		return cart;
	}

	/**
	 *添加书到购物车中
	 */
	public void addBook(Book item) {
		Book oldItem = null;
		if (item != null) {
			for (int i = 0; i < cart.size(); i++) {
				oldItem = cart.get(i);
				if (oldItem.getId()==item.getId()) {
					oldItem.setStock_number(oldItem.getStock_number() + item.getStock_number());
					return;
				}
			}
			cart.add(item);
		}
	}

	/**
	 *将书移出购物车
	 */
	public boolean removeBook(int id) {
		Book item = null;
		for (int i = 0; i < cart.size(); i++) {
			item = cart.get(i);
			if (item.getId() == id) {
				cart.remove(i);
				return true;
			}
		}
		return false;
	}

	/**
	 * 购物车商品总价汇总
	 */
	public float getTotal() {
		Iterator<Book> it = cart.iterator();
		float total = 0;
		Book item = null;
		while (it.hasNext()) {
			item = it.next();
			total = total + item.getSum();
		}
		return total;
	}
}