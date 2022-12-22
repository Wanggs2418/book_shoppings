package cn.edu.jlu.bookshopping.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import cn.edu.jlu.bookshopping.bean.Book;
import cn.edu.jlu.bookshopping.bean.ShoppingCart;
import cn.edu.jlu.bookshopping.bean.User;
import cn.edu.jlu.bookshopping.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	
	// 注入UserService
	@Resource
	private UserService userService;
	
	//程序主入口
		@RequestMapping("/login")
		public String login() {
			return "userlogin";
		}
		
		@RequestMapping("/logon")
		public String logon(User user,HttpSession session) {
			boolean isLogon;
			//用户验证方法,同时加入用户的id和moeny属性
			isLogon = userService.validate(user);
			//验证正确，则跳转至adminbook界面，失败则跳转至错误反馈页面
			if(isLogon) {
				session.setAttribute("user",user);
				//forword服务器端跳转，网址不会变
				return "forward:/user/index";
			}
			else
				return "logonerror";
		}
		
		@RequestMapping("/index")
		public String add(HttpSession session,Model model){
			if(session.getAttribute("user")==null)
				return "userlogin";
			List<Book> listbook=userService.findAll();
				model.addAttribute("listbook",listbook);
				return "userindex";
		}
		@RequestMapping("/addshopcart")
		public String addShopcart(HttpSession session,int id){
			ShoppingCart sc=null;
			sc=(ShoppingCart)session.getAttribute("shopcart");
			if(session.getAttribute("user")==null)
				return "userlogin";
			if(sc==null) {
				//购物车为空，则创建新的购物车对象
				sc=new ShoppingCart();
				session.setAttribute("shopcart", sc);
			}
				userService.addShopping(id, sc);
				return "usershopping";
		}
		
		@RequestMapping("/pay")
		public String pay(HttpSession session,Model model){
			if(session.getAttribute("user")==null)
				return "userlogin";
			ShoppingCart sc=null;
			sc=(ShoppingCart)session.getAttribute("shopcart");
			if(sc==null) {
				//购物车为空，则创建新的购物车对象
				return "error";
			}
			//用户信息和购物车信息
				User user=(User)session.getAttribute("user");
				//更新用户剩余金额
				float money = userService.pay(user, sc);
				
				model.addAttribute("money",money);
				session.removeAttribute("shopcart");
				return "userendpage";
		}
	
	
}
