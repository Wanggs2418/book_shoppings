package cn.edu.jlu.bookshopping.service;
import java.util.List;
import cn.edu.jlu.bookshopping.bean.Admin;
import cn.edu.jlu.bookshopping.bean.Book;
import cn.edu.jlu.bookshopping.repository.AdminRepository;
import cn.edu.jlu.bookshopping.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
	
	// 注入UserRepository
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private BookRepository bookRepository;
	
	//验证是否为管理员的账户名称，返回布尔类型
	public boolean validate(Admin admin) {
		Admin temp;
		temp=adminRepository.selectByUsername(admin.getLoginname());
		if(temp==null)
			return false;
		if(temp.getPassword().equals(admin.getPassword()))
			return true;
		else
			return false;
	}
	
	//进行书本的插入
	public int insertBook(Book book){
		return bookRepository.insertBook(book);
	}
	
	//找寻所有的书
	public List<Book> findAll(){
		return bookRepository.findAll();
	}
	
	//更新书籍对应的库存量
	public void update(Book book) {
		bookRepository.update(book);;
	}
	
	//删除相应的书籍
	public void delete(Integer id) {
		bookRepository.delete(id);
	}
}