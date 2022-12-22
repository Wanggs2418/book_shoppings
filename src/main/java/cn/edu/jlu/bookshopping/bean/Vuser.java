package cn.edu.jlu.bookshopping.bean;

import java.io.Serializable;

public class Vuser implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id ;
	private int grade;
	private String loginname ;
	private String password;
	private float money;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public float getMoney() {
		return money;
	}
	public int grade() {
		return grade;
	}
	
}
