package cn.edu.jlu.bookshopping.service;

import java.util.List;
import cn.edu.jlu.bookshopping.bean.User;
import cn.edu.jlu.bookshopping.bean.Book;
import cn.edu.jlu.bookshopping.bean.ShoppingCart;
import cn.edu.jlu.bookshopping.repository.UserRepository;
import cn.edu.jlu.bookshopping.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class UserService {
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	//验证的账户名称，返回布尔类型
		public boolean validate(User user) {
			User temp;
			temp=userRepository.selectByUsername(user.getLoginname());
			if(temp==null)
				return false;
			if(temp.getPassword().equals(user.getPassword())) {
				user.setId(temp.getId());
				user.setMoney(temp.getMoney());
				return true;
			}
			else
				return false;
		}
		//书籍加入购物车
	public boolean addShopping(int id,ShoppingCart sc){
		Book book=bookRepository.selectById(id);
		book.setStock_number(100);
		sc.addBook(book);
		return true;
	}
	
	//事务注解，支持rollback
	@Transactional
	public float pay(User user,ShoppingCart sc){
		float o_money=user.getMoney();
		float money = user.getMoney()-sc.getTotal();
		
		//剩余金额大于等于0时更新用于金额
		if (money>=0){
		user.setMoney(money);
		userRepository.update(user);
		//购物车所有的图书,减去数量<图书为<0>
				List<Book> lb = sc.getCart();
				
				for(Book book:lb) {
					Book temp=bookRepository.selectById(book.getId());
					temp.setStock_number(temp.getStock_number()-book.getStock_number());
					bookRepository.update(temp);
				}
				return money;
		}
		else {
			System.out.println("金额不足！！！");
			return o_money;
		}
	}
	
		//找寻所有的书
	public List<Book> findAll(){
			return bookRepository.findAll();
		}
	
}