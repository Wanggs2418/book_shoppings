package cn.edu.jlu.bookshopping.repository;
 
import java.util.List;
import cn.edu.jlu.bookshopping.bean.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface BookRepository {
	
	//查找指定书名
	@Select("select * from book where id = #{id}")
	public Book selectById(int id);
	
	//找出所有的书籍
	@Select("select * from book")
	public List<Book> findAll();
	
	//及时更新库存
	@Update("update book set stock_number=#{stock_number} where id=#{id}")
	public void update(Book book);
	
	//插入新书
	@Insert("insert into book(name,price,author,stock_number)"
			+"value (#{name},#{price},#{author},#{stock_number})")
	public int insertBook(Book book);
	
	//删除对应id的书籍
	@Delete("delete from book where id=#{id}")
	public void delete(final Integer id);
	
}
