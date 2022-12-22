package cn.edu.jlu.bookshopping.bean;

import java.io.Serializable;

public class Admin implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id ;
	private String loginname ;
	private String password;
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

	
}
