package cn.edu.jlu.bookshopping.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import cn.edu.jlu.bookshopping.bean.Admin;
import cn.edu.jlu.bookshopping.bean.Book;
import cn.edu.jlu.bookshopping.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//@RestController
@Controller
@RequestMapping("/admin")
//映射（跳转）
public class AdminController {
	
	@Resource
	private AdminService adminService;
	
	//程序主入口
	@RequestMapping("/login")
	public String login() {
		return "adminlogin";
	}
	
	//表单中的属性返回至Admin对象
	@RequestMapping("/logon")
	public String logon(Admin admin,HttpSession session) {
		boolean isLogon;
		//调用adminservice（业务处理）中的用户验证方法
		isLogon = adminService.validate(admin);
		//验证正确，则跳转至adminbook界面，失败则跳转至错误反馈页面
		if(isLogon) {
			session.setAttribute("admin",admin);
			return "adminbook";
		}
		else
			return "logonerror";
	}
	
	//已经登录则直接跳转至添加页面，否则跳转至登录界面
	@RequestMapping("/add")
	public String add(HttpSession session){
		if(session.getAttribute("admin")==null)
			return "adminlogin";
		else
			return "adminadd";
	}
	
	//对插入的数据判断
	@RequestMapping("/addDB")
	public String addDB(HttpSession session,Book book){
		if(session.getAttribute("admin")==null)
			return "adminlogin";
		if(adminService.insertBook(book)>0)
			return "adminbook";
		else
			return "error";
	}

	@RequestMapping("/findAll")
	public String add(HttpSession session,Model model){
		if(session.getAttribute("admin")==null)
			return "adminlogin";
		List<Book> listbook=adminService.findAll();
			model.addAttribute("listbook",listbook);
			return "adminfind";
	}
	
}
