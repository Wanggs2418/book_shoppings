package cn.edu.jlu.bookshopping.repository;
import java.util.List;
import cn.edu.jlu.bookshopping.bean.Admin;
import org.apache.ibatis.annotations.Select;


public interface AdminRepository {
	
	//找出指定的管理员信息
	@Select("select * from manager where loginname = #{loginname}")
	public Admin selectByUsername(String name);
	
	//将所有的管理员信息找出
	@Select("select * from manager")
	public List<Admin> findAll();
	
}
